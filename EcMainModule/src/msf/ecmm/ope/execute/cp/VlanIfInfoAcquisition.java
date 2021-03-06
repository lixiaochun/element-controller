/*
 * Copyright(c) 2019 Nippon Telegraph and Telephone Corporation
 */

package msf.ecmm.ope.execute.cp;

import static msf.ecmm.common.CommonDefinitions.*;
import static msf.ecmm.ope.receiver.ReceiverDefinitions.*;

import java.util.HashMap;

import msf.ecmm.common.CommonDefinitions;
import msf.ecmm.common.LogFormatter;
import msf.ecmm.convert.RestMapper;
import msf.ecmm.db.DBAccessException;
import msf.ecmm.db.DBAccessManager;
import msf.ecmm.db.pojo.DummyVlanIfs;
import msf.ecmm.db.pojo.IRBInstanceInfo;
import msf.ecmm.db.pojo.Nodes;
import msf.ecmm.db.pojo.VlanIfs;
import msf.ecmm.ope.execute.Operation;
import msf.ecmm.ope.execute.OperationType;
import msf.ecmm.ope.receiver.pojo.AbstractResponseMessage;
import msf.ecmm.ope.receiver.pojo.AbstractRestMessage;
import msf.ecmm.ope.receiver.pojo.GetVlanInterface;

/**
 * VLANIF Information Acquisition.
 */
public class VlanIfInfoAcquisition extends Operation {

  /** In case input data check result is NG. */
  private static final String ERROR_CODE_400101 = "400101";
  /** In case the number of acquired results is zero. */
  private static final String ERROR_CODE_400201 = "400201";
  /** In case error has occurred in DB access. */
  private static final String ERROR_CODE_400401 = "400401";

  /**
   * Constructor.
   *
   * @param idt
   *          input data
   * @param ukm
   *          URI key information
   */
  public VlanIfInfoAcquisition(AbstractRestMessage idt, HashMap<String, String> ukm) {
    super(idt, ukm);
    super.setOperationType(OperationType.VlanIfInfoAcquisition);
  }

  @Override
  public AbstractResponseMessage execute() {
    logger.trace(CommonDefinitions.START);

    AbstractResponseMessage response = null;

    if (!checkInData()) {
      logger.warn(LogFormatter.out.format(LogFormatter.MSG_403041, "Input data wrong."));
      return makeFailedResponse(RESP_BADREQUEST_400, ERROR_CODE_400101);
    }

    String nodeId = getUriKeyMap().get(KEY_NODE_ID);
    String vlanIfId = getUriKeyMap().get(KEY_VLAN_IF_ID);

    GetVlanInterface getVlanIf = null;

    try (DBAccessManager session = new DBAccessManager()) {

      VlanIfs vlanIfsDb = session.searchVlanIfs(nodeId, vlanIfId);
      DummyVlanIfs dummyVlanIfsDb = session.searchDummyVlanIfsInfo(nodeId, vlanIfId);
      IRBInstanceInfo irbInstance = null;
      if (null != vlanIfsDb) {
        irbInstance = session.searchIrbInstanceInfo(nodeId, vlanIfsDb.getVlan_id());
      } else if (null != dummyVlanIfsDb) {
        irbInstance = session.searchIrbInstanceInfo(nodeId, dummyVlanIfsDb.getVlan_id());
      }

      Nodes nodes = session.searchNodes(nodeId, null);

      if (vlanIfsDb == null && dummyVlanIfsDb == null) {
        logger.warn(LogFormatter.out.format(LogFormatter.MSG_403041, "Not found data. [VlanIfs]"));
        return makeFailedResponse(RESP_NOTFOUND_404, ERROR_CODE_400201);
      }
      if (nodes == null) {
        logger.warn(LogFormatter.out.format(LogFormatter.MSG_403041, "Not found data. [nodes]"));
        return makeFailedResponse(RESP_NOTFOUND_404, ERROR_CODE_400201);
      }

      if (null != vlanIfsDb) {
        getVlanIf = RestMapper.toVlanIfsInfo(vlanIfsDb, nodes, irbInstance);
      } else if (null != dummyVlanIfsDb) {
        getVlanIf = RestMapper.toVlanIfsInfoFromDummyIfs(dummyVlanIfsDb, nodes, irbInstance);
      }

      response = makeSuccessResponse(RESP_OK_200, getVlanIf);

    } catch (DBAccessException dbae) {
      logger.warn(LogFormatter.out.format(LogFormatter.MSG_403041, "Access to DB was failed."), dbae);
      response = makeFailedResponse(RESP_INTERNALSERVERERROR_500, ERROR_CODE_400401);
    }

    logger.trace(CommonDefinitions.END);
    return response;
  }

  @Override
  protected boolean checkInData() {
    logger.trace(CommonDefinitions.START);

    boolean checkResult = true;

    if (getUriKeyMap() == null) {
      checkResult = false;
    } else {
      if (!getUriKeyMap().containsKey(KEY_NODE_ID) || getUriKeyMap().get(KEY_NODE_ID) == null) {
        checkResult = false;
      }
      if (!getUriKeyMap().containsKey(KEY_VLAN_IF_ID) || getUriKeyMap().get(KEY_VLAN_IF_ID) == null) {
        checkResult = false;
      }
    }

    logger.trace(CommonDefinitions.END);
    return checkResult;
  }

}

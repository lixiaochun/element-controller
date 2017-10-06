
package msf.ecmm.ope.execute.constitution.interfaces;

import static msf.ecmm.common.CommonDefinitions.*;
import static msf.ecmm.convert.LogicalPhysicalConverter.*;
import static msf.ecmm.ope.receiver.ReceiverDefinitions.*;

import java.util.HashMap;

import msf.ecmm.common.CommonDefinitions;
import msf.ecmm.common.LogFormatter;
import msf.ecmm.convert.RestMapper;
import msf.ecmm.db.DBAccessException;
import msf.ecmm.db.DBAccessManager;
import msf.ecmm.db.pojo.LagIfs;
import msf.ecmm.ope.execute.Operation;
import msf.ecmm.ope.execute.OperationType;
import msf.ecmm.ope.receiver.pojo.AbstractResponseMessage;
import msf.ecmm.ope.receiver.pojo.AbstractRestMessage;
import msf.ecmm.ope.receiver.pojo.GetLagInterface;

public class LagInfoAcquisition extends Operation {

	private static final String ERROR_CODE_250201 = "250201";

	public LagInfoAcquisition(AbstractRestMessage idt, HashMap<String, String> ukm) {
		super(idt, ukm);
		super.setOperationType(OperationType.LagInfoAcquisition);
	}

	@Override
	public AbstractResponseMessage execute() {

		logger.trace(CommonDefinitions.START);

		GetLagInterface getLagInterfaceRest = null;

		AbstractResponseMessage response = null;

		if (!checkInData()) {
			logger.warn(LogFormatter.out.format(LogFormatter.MSG_403041, "Input data wrong."));
			return makeFailedResponse(RESP_BADREQUEST_400, ERROR_CODE_250101);
		}

		try (DBAccessManager session = new DBAccessManager()) {

			int fabricType = toIntegerNodeType(getUriKeyMap().get(KEY_FABRIC_TYPE));

			LagIfs lagIfsDb = session.searchLagIfs(fabricType, getUriKeyMap().get(KEY_NODE_ID),
					getUriKeyMap().get(KEY_LAG_IF_ID));

			if (lagIfsDb == null) {
				logger.warn(LogFormatter.out.format(LogFormatter.MSG_403041, "Not found data. [LagIfs]"));
				return makeFailedResponse(RESP_NOTFOUND_404, ERROR_CODE_250201);
			}

			getLagInterfaceRest = RestMapper.toLagIfInfo(lagIfsDb);

			response = makeSuccessResponse(RESP_OK_200, getLagInterfaceRest);

		} catch (DBAccessException dbe) {
			logger.warn(LogFormatter.out.format(LogFormatter.MSG_403041, "Access to DB was failed."), dbe);
			response = makeFailedResponse(RESP_INTERNALSERVERERROR_500, ERROR_CODE_250401);
		}

		logger.trace(CommonDefinitions.END);

		return response;

	}

	@Override
	protected boolean checkInData() {

		logger.trace(CommonDefinitions.START);

		boolean result = true;

		if (getUriKeyMap() == null) {
			result = false;
		} else if (getUriKeyMap().get(KEY_FABRIC_TYPE) == null) {
			result = false;
		} else if (!getUriKeyMap().get(KEY_FABRIC_TYPE).equals("leafs")
				&& !getUriKeyMap().get(KEY_FABRIC_TYPE).equals("spines")) {
			result = false;
		} else if (getUriKeyMap().get(KEY_NODE_ID) == null) {
			result = false;
		} else if (getUriKeyMap().get(KEY_LAG_IF_ID) == null) {
			result = false;
		}

		logger.trace(CommonDefinitions.END);

		return result;
	}

}

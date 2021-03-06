/*
 * Copyright(c) 2019 Nippon Telegraph and Telephone Corporation
 */

package msf.ecmm.ope.receiver.pojo;

import java.util.ArrayList;

import msf.ecmm.ope.execute.OperationType;
import msf.ecmm.ope.receiver.pojo.parts.VlanIfsBulkUpdate;

/**
 * L2VLAN IF Batch Change.
 */
public class BulkUpdateL2VlanIf extends AbstractRestMessage {

  /** Unique parameter for each slice ID. */
  private String vrfId = null;

  private String vni = null;

  /** List information of the VLAN IF is to be controlled. */
  private ArrayList<VlanIfsBulkUpdate> vlanIfs = null;

  /** Remark Menu. */
  private String remarkMenu;

  /**
   * Getting Unique parameter for each slice ID.
   *
   * @return unique parameter for each slice ID
   */
  public String getVrfId() {
    return vrfId;
  }

  /**
   * Setting Unique parameter for each slice ID.
   *
   * @param vrfId
   *         unique parameter for each slice ID
   */
  public void setVrfId(String vrfId) {
    this.vrfId = vrfId;
  }

  /**
   * Getting parameter in case of IRB not supported.
   *
   * @return Unique parameter for each slide ID
   */
  public String getVni() {
    return vni;
  }

  /**
   * Setting parameter in case of IRB not supported.
   *
   * @param vni
   *          Unique parameter for each slide ID
   */
  public void setVni(String vni) {
    this.vni = vni;
  }

  /**
   * Getting list information of VLANIF to be controlled.
   *
   * @return List information of VLAN IF of which batch generation is to be controlled.
   */
  public ArrayList<VlanIfsBulkUpdate> getVlanIfs() {
    return vlanIfs;
  }

  /**
   * Setting List information of the VLAN IF is to be controlled.
   *
   * @param vlanIfs
   *         List information of the VLAN IF is to be controlled
   */
  public void setVlanIfs(ArrayList<VlanIfsBulkUpdate> vlanIfs) {
    this.vlanIfs = vlanIfs;
  }

  /**
   * Getting Remark Menu.
   *
   * @return remarkMenu
   */
  public String getRemarkMenu() {
    return remarkMenu;
  }

  /**
   * Setting remark's menu.
   *
   * @param remarkMenu
   *          Setting remarkMenu
   */
  public void setRemarkMenu(String remarkMenu) {
    this.remarkMenu = remarkMenu;
  }

  @Override
  public String toString() {
    return "BulkUpdateL2VlanIf [vrfId=" + vrfId + ", vni=" + vni + ", vlanIfs=" + vlanIfs + ", remarkMenu=" + remarkMenu
        + "]";
  }

 /**
   * Input Parameter Check.
   *
   * @param ope
   *          operation type
   * @throws CheckDataException
   *           input check error
   */
  public void check(OperationType ope) throws CheckDataException {

    if (vrfId == null && vni == null) {
      throw new CheckDataException();
    }

    if (vrfId != null && vni != null) {
      throw new CheckDataException();
    }

    if (vlanIfs != null) {
      for (VlanIfsBulkUpdate l2VlanIfs : vlanIfs) {
        l2VlanIfs.check(ope);
      }
    }

  }

}

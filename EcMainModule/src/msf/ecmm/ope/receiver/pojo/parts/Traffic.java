/*
 * Copyright(c) 2019 Nippon Telegraph and Telephone Corporation
 */

package msf.ecmm.ope.receiver.pojo.parts;

import java.util.ArrayList;

/**
 * Traffic Volume Information Per Unit Time
 */
public class Traffic {

  /**
   * Information for each Interface
   */
  private ArrayList<InterfaceInfoTraffic> interfaces = new ArrayList<InterfaceInfoTraffic>();

  /**
   * Getting information for each interface.
   *
   * @return information for each interface
   */
  public ArrayList<InterfaceInfoTraffic> getInterfaces() {
    return interfaces;
  }

  /**
   * Setting information for each interface.
   *
   * @param interfaces
   *             information for each interface
   */
  public void setInterfaces(ArrayList<InterfaceInfoTraffic> interfaces) {
    this.interfaces = interfaces;
  }

  @Override
  public String toString() {
    return "Traffic [interfaces=" + interfaces + "]";
  }
}

/*
 * Copyright(c) 2019 Nippon Telegraph and Telephone Corporation
 */

package msf.ecmm.emctrl.pojo.parts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Spin Extention-SNMP Configuration Information Class
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Snmp {

  /** IPv4 Address of SNMP Server */
  @XmlElement(name = "server-address")
  private String serverAddress = null;

  /** SNMP Community Name */
  private String community = null;

  /**
   * Generating new instance.
   */
  public Snmp() {
    super();
  }

  /**
   * Getting IPv4 address of SNMP server.
   *
   * @return IPv4 address of SNMP server
   */
  public String getServerAddress() {
    return serverAddress;
  }

  /**
   * Setting IPv4 address of SNMP server.
   *
   * @param serverAdddress
   *          IPv4 address of SNMP server
   */
  public void setServerAddress(String serverAddress) {
    this.serverAddress = serverAddress;
  }

  /**
   * Getting SNMP community name.
   *
   * @return SNMP community name
   */
  public String getCommunity() {
    return community;
  }

  /**
   * Setting SNMP community name.
   *
   * @param community
   *          SNMP community name
   */
  public void setCommunity(String community) {
    this.community = community;
  }

  /*
   * (Non-Javadoc)
   *
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Snmp [serverAddress=" + serverAddress + ", community=" + community + "]";
  }

}

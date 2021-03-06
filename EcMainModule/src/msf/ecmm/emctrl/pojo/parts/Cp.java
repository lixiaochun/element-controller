/*
 * Copyright(c) 2019 Nippon Telegraph and Telephone Corporation
 */

package msf.ecmm.emctrl.pojo.parts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * CP Configuration Information Class.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Cp {

  /** Attribute Data of CP. */
  @XmlAttribute
  private String operation = null;

  /** IF Name for CE. */
  private String name = null;

  /** VLAN ID. */
  @XmlElement(name = "vlan-id")
  private Long vlanId = null;

  /** Interface Mode (only for L2VLAN IF Batch Generation/Change). */
  @XmlElement(name = "port-mode")
  private String portMode = null;

  /** VNI (only for L2VLAN IF Batch Generation/Change). */
  private Long vni = null;

  /** Multicast Group (only for L2VLAN IF Batch Generation/Change). */
  @XmlElement(name = "multicast-group")
  private String multicastGroup = null;

  /** ESI Value (used in L2VLAN IF processing). */
  private String esi = null;

  /** &ltesi&gt Tag Attribute Configuration Field. */
  @XmlElement(name = "esi")
  private AttributeOperation esiAttr = null;

  /** SystemID (used in L2VLAN IF processing). */
  @XmlElement(name = "system-id")
  private String systemId = null;

  /** &ltsystem-id&gt Tag Attribute Configuration Field. */
  @XmlElement(name = "system-id")
  private AttributeOperation sysIdAttr = null;

  /** IP Address Information Granted by CP (only for L3VLAN IF Batch Generation). */
  @XmlElement(name = "ce-interface")
  private CeInterface ceInterface = null;

  /** clag-id used in EVPN. */
  @XmlElement(name = "clag-id")
  private Long clagId = null;

  /** Speed of base physical IF（including IF after breakout). */
  private String speed = null;

  /** QoS setting. */
  private Qos qos = null;

  /** IRB setting. */
  private Irb irb = null;

  /** Q-in-Q . */
  @XmlElement(name = "q-in-q")
  private String qInQ;

  /** VRRP setting information (used only for L3VLAN IF batch generaiton). */
  private Vrrp vrrp = null;

  /** BGP Connection Information (only for L3VLAN IF Batch Generation). */
  @XmlElement(name = "bgp")
  private L3SliceBgp l3SliceBgp = null;

  /** Static Connection Information (only for L3VLAN IF Batch Generation). */
  @XmlElement(name = "static")
  private L3SliceStatic l3SliceStatic = null;

  /** OSPF Connection Information (only for L3VLAN IF Batch Generation). */
  @XmlElement(name = "ospf")
  private L3SliceOspf l3SliceOspf = null;

  /**
   * Generating new instance.
   */
  public Cp() {
    super();
  }

  /**
   * Getting attribute data of CP.
   *
   * @return attribute data of the device
   */
  public String getOperation() {
    return operation;
  }

  /**
   * Setting attribute data of CP.
   *
   * @param operation
   *          attribute data of the device
   */
  public void setOperation(String operation) {
    this.operation = operation;
  }

  /**
   * Getting IF name for CE.
   *
   * @return IF name for CE
   */
  public String getName() {
    return name;
  }

  /**
   * Setting IF name for CE.
   *
   * @param name
   *          IF name for CE
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getting VLAN ID.
   *
   * @return VLAN ID
   */
  public Long getVlanId() {
    return vlanId;
  }

  /**
   * Setting VLAN ID.
   *
   * @param vlanId
   *          VLAN ID
   */
  public void setVlanId(Long vlanId) {
    this.vlanId = vlanId;
  }

  /**
   * Getting interface mode (only for L2VLAN IF batch generation/change).
   *
   * @return interface mode
   */
  public String getPortMode() {
    return portMode;
  }

  /**
   * Setting interface mode (only for L2VLAN IF batch generation/change).
   *
   * @param portMode
   *          interface mode
   */
  public void setPortMode(String portMode) {
    this.portMode = portMode;
  }

  /**
   * Getting VNI (only for L2VLAN IF batch generation/change).
   *
   * @return VNI
   */
  public Long getVni() {
    return vni;
  }

  /**
   * Setting VNI (only for L2VLAN IF generation/change).
   *
   * @param vni
   *          VNI
   */
  public void setVni(Long vni) {
    this.vni = vni;
  }

  /**
   * Getting multicast group (only for L2VLAN IF batch generation/change).
   *
   * @return multicast group
   */
  public String getMulticastGroup() {
    return multicastGroup;
  }

  /**
   * Setting multicast group (only for L2VLAN IF batch generation/change).
   *
   * @param multicastGroup
   *          multicast group
   */
  public void setMulticastGroup(String multicastGroup) {
    this.multicastGroup = multicastGroup;
  }

  /**
   * Getting IP address information granted by CP (only for L3VLAN IF batch generation).
   *
   * @return IP address information granted by CP
   */
  public CeInterface getCeInterface() {
    return ceInterface;
  }

  /**
   * Setting IP address information granted by CP (only for L3VLAN IF batch generation).
   *
   * @param ceInterface
   *          IP address information granted by CP
   */
  public void setCeInterface(CeInterface ceInterface) {
    this.ceInterface = ceInterface;
  }

  /**
   * Getting VRRP configuration information (only for L3VLAN IF batch generation).
   *
   * @return VRRP configuration information
   */
  public Vrrp getVrrp() {
    return vrrp;
  }

  /**
   * Setting VRRP configuration information (only for L3VLAN IF batch generation).
   *
   * @param vrrp
   *          VRRP configuration information
   */
  public void setVrrp(Vrrp vrrp) {
    this.vrrp = vrrp;
  }

  /**
   * Getting BGP connection information (only for L3VLAN IF batch generation).
   *
   * @return BGP connection information
   */
  public L3SliceBgp getL3SliceBgp() {
    return l3SliceBgp;
  }

  /**
   * Setting BGP connection information (only for L3VLAN IF batch generation).
   *
   * @param l3SliceBgp
   *          BGP connection information
   */
  public void setL3SliceBgp(L3SliceBgp l3SliceBgp) {
    this.l3SliceBgp = l3SliceBgp;
  }

  /**
   * Getting Static connection information (only for L3VLAN IF batch generation).
   *
   * @return Static connection information
   */
  public L3SliceStatic getL3SliceStatic() {
    return l3SliceStatic;
  }

  /**
   * Setting Static connection information (only for L3VLAN IF batch generation).
   *
   * @param l3SliceStatic
   *          Static connection information
   */
  public void setL3SliceStatic(L3SliceStatic l3SliceStatic) {
    this.l3SliceStatic = l3SliceStatic;
  }

  /**
   * Getting OSPF connection information (only for L3VLAN IF batch generation).
   *
   * @return OSPF connection information
   */
  public L3SliceOspf getL3SliceOspf() {
    return l3SliceOspf;
  }

  /**
   * Setting OSPF connection information (only for L3VLAN IF batch generation).
   *
   * @param l3SliceOspf
   *          OSPF connection information
   */
  public void setL3SliceOspf(L3SliceOspf l3SliceOspf) {
    this.l3SliceOspf = l3SliceOspf;
  }

  /**
   * Getting ESI value.
   *
   * @return esi
   */
  public String getEsi() {
    return esi;
  }

  /**
   * Setting ESI value.
   *
   * @param esi
   *          Setting esi
   */
  public void setEsi(String esi) {
    this.esi = esi;
  }

  /**
   * Getting the value of "operation" attribute of &ltesi&gt tag.
   *
   * @return esiAttr
   */
  public AttributeOperation getEsiAttr() {
    return esiAttr;
  }

  /**
   * Setting the value of "operation" attribute of &ltesi&gt tag.
   *
   * @param esiAttr
   *          Setting esiAttr
   */
  public void setEsiAttr(AttributeOperation esiAttr) {
    this.esiAttr = esiAttr;
  }

  /**
   * Getting SystemID.
   *
   * @return systemId
   */
  public String getSystemId() {
    return systemId;
  }

  /**
   * Setting SystemID.
   *
   * @param systemId
   *          Setting systemId
   */
  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

  /**
   * Getting CLAG-ID.
   *
   * @return clagId
   */
  public Long getClagId() {
    return clagId;
  }

  /**
   * Setting CLAG-ID.
   *
   * @param clagId
   *          Setting clagId
   */
  public void setClagId(Long clagId) {
    this.clagId = clagId;
  }

  /**
   * Getting speed of Base Physical IF.
   *
   * @return speed
   */
  public String getSpeed() {
    return speed;
  }

  /**
   * Setting speed of base physical IF.
   *
   * @param speed
   *          Setting speed
   */
  public void setSpeed(String speed) {
    this.speed = speed;
  }

  /**
   * Getting the value of "operation" attribute of &ltsystem-id&gt tag.
   *
   * @return sysIdAttr
   */
  public AttributeOperation getSysIdAttr() {
    return sysIdAttr;
  }

  /**
   * Setting the value of "operation" attribute of &ltsystem-id&gt tag.
   *
   * @param sysIdAttr
   *          Setting sysIdAttr
   */
  public void setSysIdAttr(AttributeOperation sysIdAttr) {
    this.sysIdAttr = sysIdAttr;
  }

  /**
   * Getting QoS configuration.
   *
   * @return qos
   */
  public Qos getQos() {
    return qos;
  }

  /**
   * Setting QoS configuration.
   *
   * @param qos
   *          Setting qos
   */
  public void setQos(Qos qos) {
    this.qos = qos;
  }

  /**
   * Setting IRB configuration.
   *
   * @param irb
   *          Setting irb
   */
  public void setIrb(Irb irb) {
    this.irb = irb;
  }

  /**
   * Getting IRB configuration.
   *
   * @return irb
   */
  public Irb getIrb() {
    return irb;
  }

  /**
   * Adding Q-in-Q.
   */
  public void addQInQ() {
    this.qInQ = new String("");
  }

  /**
   * Deleting Q-in-Q.
   */
  public void delQInQ() {
    this.qInQ = null;
  }

  @Override
  public String toString() {
    return "Cp [operation=" + operation + ", name=" + name + ", vlanId=" + vlanId + ", portMode=" + portMode + ", vni="
        + vni + ", multicastGroup=" + multicastGroup + ", esi=" + esi + ", esiAttr=" + esiAttr + ", systemId="
        + systemId + ", sysIdAttr=" + sysIdAttr + ", ceInterface=" + ceInterface + ", clagId=" + clagId + ", speed="
        + speed + ", qos=" + qos + ", irb=" + irb + ", qInQ=" + qInQ + ", vrrp=" + vrrp + ", l3SliceBgp=" + l3SliceBgp
        + ", l3SliceStatic=" + l3SliceStatic + ", l3SliceOspf=" + l3SliceOspf + "]";
  }

}

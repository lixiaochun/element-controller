/*
 * Copyright(c) 2019 Nippon Telegraph and Telephone Corporation
 */

package msf.ecmm.emctrl.pojo.parts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * breakoutIF Information.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "breakout-interface")
public class BreakoutIf {

  /** Attribute Data of breakout-interface. */
  @XmlAttribute
  private String operation = null;

  /** Partitioned Interface Name. */
  @XmlElement(name = "base-interface")
  private String baseIfName = null;

  /** IF Speed After Partition. */
  private String speed = null;

  /** The Number of Partitions. */
  @XmlElement(name = "breakout-num")
  private Integer breakoutNum = null;

  /**
   * Getting attribute data of breakout-interface.
   *
   * @return attribute data of device.
   */
  public String getOperation() {
    return operation;
  }

  /**
   * Setting attribute data of breakout-interface.
   *
   * @param operation
   *          attribute data of device.
   */
  public void setOperation(String operation) {
    this.operation = operation;
  }

  /**
   * Getting partitioned interface name.
   *
   * @return baseIfName
   */
  public String getBaseIfName() {
    return baseIfName;
  }

  /**
   * Setting partitioned interface.
   *
   * @param baseIfName
   *          set baseIfName
   */
  public void setBaseIfName(String baseIfName) {
    this.baseIfName = baseIfName;
  }

  /**
   * Getting IF speed after division.
   *
   * @return speed
   */
  public String getSpeed() {
    return speed;
  }

  /**
   * Setting IF speed after division.
   *
   * @param speed
   *          Setting speed
   */
  public void setSpeed(String speed) {
    this.speed = speed;
  }

  /**
   * Getting no. of divisions.
   *
   * @return breakoutNum
   */
  public Integer getBreakoutNum() {
    return breakoutNum;
  }

  /**
   * Setting no. of divisions.
   *
   * @param num
   *          Setting num
   */
  public void setBreakoutNum(int num) {
    this.breakoutNum = num;
  }

  /**
   * Stringizing instance.
   *
   */
  @Override
  public String toString() {
    return "BreakoutIf [baseIfName=" + baseIfName + ", speed=" + speed + ", breakoutNum=" + breakoutNum + "]";
  }

}

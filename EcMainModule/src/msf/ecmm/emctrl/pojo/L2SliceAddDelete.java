
package msf.ecmm.emctrl.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import msf.ecmm.emctrl.pojo.parts.DeviceLeaf;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "l2-slice")
public class L2SliceAddDelete extends AbstractMessage {

	private String name = null;

	@XmlElement(name = "device-leaf")
	private List<DeviceLeaf> deviceLeafList = null;

	public L2SliceAddDelete() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addForce() {
		this.force = new String("");
	}

	public void delForce() {
		this.force = null;
	}

	public List<DeviceLeaf> getDeviceLeafList() {
		return deviceLeafList;
	}

	public void setDeviceLeafList(List<DeviceLeaf> deviceLeafList) {
		this.deviceLeafList = deviceLeafList;
	}

	@Override
	public String toString() {
		return "L2SliceAddDelete [name=" + name + ", force=" + force + ", deviceLeafList=" + deviceLeafList + "]";
	}
}

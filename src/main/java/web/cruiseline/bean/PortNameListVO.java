package web.cruiseline.bean;

import java.io.Serializable;

public class PortNameListVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer portsOfCallListNo;
	private Integer cruiseLinesNo;
	private Integer portOfCallNo;
	private String portName;
	private Integer portOfCallSequence;
	
	@Override
	public String toString() {
		return "PortNameListVO [portsOfCallListNo=" + portsOfCallListNo + ", cruiseLinesNo=" + cruiseLinesNo
				+ ", portOfCallNo=" + portOfCallNo + ", portName=" + portName + ", portOfCallSequence="
				+ portOfCallSequence + "]";
	}
	public PortNameListVO() {
		super();
	}
	public PortNameListVO(Integer portsOfCallListNo, Integer cruiseLinesNo, Integer portOfCallNo, String portName,
			Integer portOfCallSequence) {
		super();
		this.portsOfCallListNo = portsOfCallListNo;
		this.cruiseLinesNo = cruiseLinesNo;
		this.portOfCallNo = portOfCallNo;
		this.portName = portName;
		this.portOfCallSequence = portOfCallSequence;
	}
	public Integer getPortsOfCallListNo() {
		return portsOfCallListNo;
	}
	public void setPortsOfCallListNo(Integer portsOfCallListNo) {
		this.portsOfCallListNo = portsOfCallListNo;
	}
	public Integer getCruiseLinesNo() {
		return cruiseLinesNo;
	}
	public void setCruiseLinesNo(Integer cruiseLinesNo) {
		this.cruiseLinesNo = cruiseLinesNo;
	}
	public Integer getPortOfCallNo() {
		return portOfCallNo;
	}
	public void setPortOfCallNo(Integer portOfCallNo) {
		this.portOfCallNo = portOfCallNo;
	}
	public String getPortName() {
		return portName;
	}
	public void setPortName(String portName) {
		this.portName = portName;
	}
	public Integer getPortOfCallSequence() {
		return portOfCallSequence;
	}
	public void setPortOfCallSequence(Integer portOfCallSequence) {
		this.portOfCallSequence = portOfCallSequence;
	}
	
	
}

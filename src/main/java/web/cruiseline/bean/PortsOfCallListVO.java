package web.cruiseline.bean;

import java.io.Serializable;

public class PortsOfCallListVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer portsOfCallListNo;
	private Integer cruiseLinesNo;
	private Integer portOfCallNo;
	private Integer portOfCallSequence;
	
	
	
	@Override
	public String toString() {
		return "PortsOfCallListVO [portsOfCallList_No=" + portsOfCallListNo + ", cruiseLinesNo=" + cruiseLinesNo
				+ ", portOfCallNo=" + portOfCallNo + ", portOfCallSequence=" + portOfCallSequence + "]";
	}
	public PortsOfCallListVO() {
		super();
	}
	public PortsOfCallListVO(Integer portsOfCallList_No, Integer cruiseLinesNo, Integer portOfCallNo,
			Integer portOfCallSequence) {
		super();
		this.portsOfCallListNo = portsOfCallList_No;
		this.cruiseLinesNo = cruiseLinesNo;
		this.portOfCallNo = portOfCallNo;
		this.portOfCallSequence = portOfCallSequence;
	}
	public Integer getPortsOfCallListNo() {
		return portsOfCallListNo;
	}
	public void setPortsOfCallListNo(Integer portsOfCallList_No) {
		this.portsOfCallListNo = portsOfCallList_No;
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
	public Integer getPortOfCallSequence() {
		return portOfCallSequence;
	}
	public void setPortOfCallSequence(Integer portOfCallSequence) {
		this.portOfCallSequence = portOfCallSequence;
	}
	
	
}

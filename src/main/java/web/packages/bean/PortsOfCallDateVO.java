package web.packages.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PortsOfCallDateVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer portsOfCallDateNo;
	private Integer packageNo;
	private Integer portOfCallNo;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	
	public PortsOfCallDateVO() {
		
	}
	
	public Integer getPortsOfCallDateNo() {
		return portsOfCallDateNo;
	}
	public void setPortsOfCallDateNo(Integer portsOfCallDateNo) {
		this.portsOfCallDateNo = portsOfCallDateNo;
	}
	public Integer getPackageNo() {
		return packageNo;
	}
	public void setPackageNo(Integer packageNo) {
		this.packageNo = packageNo;
	}
	public Integer getPortOfCallNo() {
		return portOfCallNo;
	}
	public void setPortOfCallNo(Integer portOfCallNo) {
		this.portOfCallNo = portOfCallNo;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public PortsOfCallDateVO(Integer portsOfCallDateNo, Integer packageNo, Integer portOfCallNo,
			LocalDateTime departureTime, LocalDateTime arrivalTime) {
		super();
		this.portsOfCallDateNo = portsOfCallDateNo;
		this.packageNo = packageNo;
		this.portOfCallNo = portOfCallNo;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
		
	}


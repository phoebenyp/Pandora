package web.packages.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PackageDetailVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer packageNo;
	private String packageName;
	private byte[] packageImages;
	private Integer shipNo;
	private Integer cruiseLineNo;
	private Integer duration;
	private LocalDate registrationStartTime;
	private LocalDate registrationDeadTime;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private Integer portsOfCallListNo;
	private Integer portOfCallNo;
	private String portName;
	private String shipName;
	
	public PackageDetailVO() {
		
	}
	
	
	public Integer getPackageNo() {
		return packageNo;
	}
	
	public void setPackageNo(Integer packageNo) {
		this.packageNo = packageNo;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public byte[] getPackageImages() {
		return packageImages;
	}
	public void setPackageImages(byte[] packageImages) {
		this.packageImages = packageImages;
	}
	public Integer getShipNo() {
		return shipNo;
	}
	public void setShipNo(Integer shipNo) {
		this.shipNo = shipNo;
	}
	public Integer getCruiseLineNo() {
		return cruiseLineNo;
	}
	public void setCruiseLineNo(Integer cruiseLineNo) {
		this.cruiseLineNo = cruiseLineNo;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public LocalDate getRegistrationStartTime() {
		return registrationStartTime;
	}
	public void setRegistrationStartTime(LocalDate registrationStartTime) {
		this.registrationStartTime = registrationStartTime;
	}
	public LocalDate getRegistrationDeadTime() {
		return registrationDeadTime;
	}
	public void setRegistrationDeadTime(LocalDate registrationDeadTime) {
		this.registrationDeadTime = registrationDeadTime;
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
	public Integer getPortsOfCallListNo() {
		return portsOfCallListNo;
	}
	public void setPortsOfCallListNo(Integer portsOfCallListNo) {
		this.portsOfCallListNo = portsOfCallListNo;
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
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public PackageDetailVO(Integer packageNo, String packageName, byte[] packageImages, Integer shipNo,
			Integer cruiseLineNo, Integer duration, LocalDate registrationStartTime, LocalDate registrationDeadTime,
			LocalDateTime departureTime, LocalDateTime arrivalTime, Integer portsOfCallListNo, Integer portOfCallNo,
			String portName, String shipName) {
		super();
		this.packageNo = packageNo;
		this.packageName = packageName;
		this.packageImages = packageImages;
		this.shipNo = shipNo;
		this.cruiseLineNo = cruiseLineNo;
		this.duration = duration;
		this.registrationStartTime = registrationStartTime;
		this.registrationDeadTime = registrationDeadTime;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.portsOfCallListNo = portsOfCallListNo;
		this.portOfCallNo = portOfCallNo;
		this.portName = portName;
		this.shipName = shipName;
	}
	
	
	
}

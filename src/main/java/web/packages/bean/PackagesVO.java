package web.packages.bean;


import java.io.Serializable;
import java.time.LocalDate;


public class PackagesVO implements Serializable {
	
	private Integer packageNo;
	private String packageName;
	private byte[] packageImages;
	private Integer shipNo;
	private Integer cruiseLineNo;
	private Integer duration;
	private LocalDate registrationStartTime;
	private LocalDate registrationDeadTime;
	private String Departure;
	private String Destination;
	private LocalDate Departure_Time;
	private LocalDate Arrival_Time;
	
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
	public String getDeparture() {
		return Departure;
	}
	public void setDeparture(String departure) {
		Departure = departure;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public LocalDate getDeparture_Time() {
		return Departure_Time;
	}
	public void setDeparture_Time(LocalDate departure_Time) {
		Departure_Time = departure_Time;
	}
	public LocalDate getArrival_Time() {
		return Arrival_Time;
	}
	public void setArrival_Time(LocalDate arrival_Time) {
		Arrival_Time = arrival_Time;
	}
	public PackagesVO(Integer packageNo, String packageName, byte[] packageImages, Integer shipNo, Integer cruiseLineNo,
			Integer duration, LocalDate registrationStartTime, LocalDate registrationDeadTime, String departure,
			String destination, LocalDate departure_Time, LocalDate arrival_Time) {
		super();
		this.packageNo = packageNo;
		this.packageName = packageName;
		this.packageImages = packageImages;
		this.shipNo = shipNo;
		this.cruiseLineNo = cruiseLineNo;
		this.duration = duration;
		this.registrationStartTime = registrationStartTime;
		this.registrationDeadTime = registrationDeadTime;
		Departure = departure;
		Destination = destination;
		Departure_Time = departure_Time;
		Arrival_Time = arrival_Time;
	}
	
	
	
		
	}
	
	
	


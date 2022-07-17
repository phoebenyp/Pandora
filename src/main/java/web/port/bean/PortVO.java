package web.port.bean;

import java.io.Serializable;

public class PortVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer portOfCallNo;
	private String portName;
	private Double portLatitude;
	private Double portLongitude;
	private String sightseeing;
	private Double sightseeingLatitude;
	private Double sightseeingLongitude;
	public PortVO() {
		
	}
	
	public PortVO(Integer portOfCallNo, String portName, Double portLatitude, Double portLongitude, String sightseeing,
			Double sightseeingLatitude, Double sightseeingLongitude) {
		super();
		this.portOfCallNo = portOfCallNo;
		this.portName = portName;
		this.portLatitude = portLatitude;
		this.portLongitude = portLongitude;
		this.sightseeing = sightseeing;
		this.sightseeingLatitude = sightseeingLatitude;
		this.sightseeingLongitude = sightseeingLongitude;
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
	public Double getPortLatitude() {
		return portLatitude;
	}
	public void setPortLatitude(Double portLatitude) {
		this.portLatitude = portLatitude;
	}
	public Double getPortLongitude() {
		return portLongitude;
	}
	public void setPortLongitude(Double portLongitude) {
		this.portLongitude = portLongitude;
	}
	public String getSightseeing() {
		return sightseeing;
	}
	public void setSightseeing(String sightseeing) {
		this.sightseeing = sightseeing;
	}
	public Double getSightseeingLatitude() {
		return sightseeingLatitude;
	}
	public void setSightseeingLatitude(Double sightseeingLatitude) {
		this.sightseeingLatitude = sightseeingLatitude;
	}
	public Double getSightseeingLongitude() {
		return sightseeingLongitude;
	}
	public void setSightseeingLongitude(Double sightseeingLongitude) {
		this.sightseeingLongitude = sightseeingLongitude;
	}
	
	
}

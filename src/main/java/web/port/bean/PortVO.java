package web.port.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class PortVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer portOfCallNo;
	private String portName;
	private java.math.BigDecimal portLatitude;
	private java.math.BigDecimal portLongitude;
	private String sightseeing;
	private java.math.BigDecimal sightseeingLatitude;
	private java.math.BigDecimal sightseeingLongitude;
	public PortVO() {
		
	}
	
	
	public PortVO(Integer portOfCallNo, String portName, BigDecimal portLatitude, BigDecimal portLongitude,
			String sightseeing, BigDecimal sightseeingLatitude, BigDecimal sightseeingLongitude) {
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
	public java.math.BigDecimal getPortLatitude() {
		return portLatitude;
	}
	public void setPortLatitude(java.math.BigDecimal portLatitude) {
		this.portLatitude = portLatitude;
	}
	public java.math.BigDecimal getPortLongitude() {
		return portLongitude;
	}
	public void setPortLongitude(java.math.BigDecimal portLongitude) {
		this.portLongitude = portLongitude;
	}
	public String getSightseeing() {
		return sightseeing;
	}
	public void setSightseeing(String sightseeing) {
		this.sightseeing = sightseeing;
	}
	public java.math.BigDecimal getSightseeingLatitude() {
		return sightseeingLatitude;
	}
	public void setSightseeingLatitude(java.math.BigDecimal sightseeingLatitude) {
		this.sightseeingLatitude = sightseeingLatitude;
	}
	public java.math.BigDecimal getSightseeingLongitude() {
		return sightseeingLongitude;
	}
	public void setSightseeingLongitude(java.math.BigDecimal sightseeingLongitude) {
		this.sightseeingLongitude = sightseeingLongitude;
	}
	
}

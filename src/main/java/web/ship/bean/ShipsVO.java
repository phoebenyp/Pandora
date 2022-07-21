package web.ship.bean;

import java.io.Serializable;

import javax.xml.crypto.Data;

public class ShipsVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer shipNo;
	private String shipName;
	private Data starStatus;
	private Data lastmaintenance_Time;
	
	
	public ShipsVO() {
		super();
	}
	public ShipsVO(Integer shipNo, String shipName, Data starStatus, Data lastmaintenance_Time) {
		super();
		this.shipNo = shipNo;
		this.shipName = shipName;
		this.starStatus = starStatus;
		this.lastmaintenance_Time = lastmaintenance_Time;
	}
	public Integer getShipNo() {
		return shipNo;
	}
	public void setShipNo(Integer shipNo) {
		this.shipNo = shipNo;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public Data getStarStatus() {
		return starStatus;
	}
	public void setStarStatus(Data starStatus) {
		this.starStatus = starStatus;
	}
	public Data getLastmaintenance_Time() {
		return lastmaintenance_Time;
	}
	public void setLastmaintenance_Time(Data lastmaintenance_Time) {
		this.lastmaintenance_Time = lastmaintenance_Time;
	}
	
	

}

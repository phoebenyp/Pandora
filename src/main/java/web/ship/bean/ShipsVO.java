package web.ship.bean;

import java.io.Serializable;
import java.sql.Date;

public class ShipsVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer shipNo;
	private String shipName;
	private Date starStatus;
	private Date lastmaintenanceTime;
	private Integer floorOfShip;
	private Integer shipStatusNo;
	
	
	public ShipsVO() {
		super();
	}
	public ShipsVO(Integer shipNo, String shipName, Date starStatus, Date lastmaintenanceTime, Integer floorOfShip,
			Integer shipStatusNo) {
		super();
		this.shipNo = shipNo;
		this.shipName = shipName;
		this.starStatus = starStatus;
		this.lastmaintenanceTime = lastmaintenanceTime;
		this.floorOfShip = floorOfShip;
		this.shipStatusNo = shipStatusNo;
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
	public Date getStarStatus() {
		return starStatus;
	}
	public void setStarStatus(Date starStatus) {
		this.starStatus = starStatus;
	}
	public Date getLastmaintenanceTime() {
		return lastmaintenanceTime;
	}
	public void setLastmaintenanceTime(Date lastmaintenanceTime) {
		this.lastmaintenanceTime = lastmaintenanceTime;
	}
	public Integer getFloorOfShip() {
		return floorOfShip;
	}
	public void setFloorOfShip(Integer floorOfShip) {
		this.floorOfShip = floorOfShip;
	}
	public Integer getShipStatusNo() {
		return shipStatusNo;
	}
	public void setShipStatusNo(Integer shipStatusNo) {
		this.shipStatusNo = shipStatusNo;
	}
	
	

}

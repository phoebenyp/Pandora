package web.ship.bean;

import java.io.Serializable;
import java.sql.Date;

public class ShipTotalVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer shipNo;
	private String shipName;
	private Date starStatus;
	private Date lastMaintenanceTime;
	private Integer total;
	private Integer roomTotal;
	private Integer floorOfShip;
	private String shipStatus;
	
	
	public ShipTotalVO() {
		super();
	}
	public ShipTotalVO(Integer shipNo, String shipName, Date starStatus, Date lastMaintenanceTime, Integer total,
			Integer roomTotal, Integer floorOfShip, String shipStatus) {
		super();
		this.shipNo = shipNo;
		this.shipName = shipName;
		this.starStatus = starStatus;
		this.lastMaintenanceTime = lastMaintenanceTime;
		this.total = total;
		this.roomTotal = roomTotal;
		this.floorOfShip = floorOfShip;
		this.shipStatus = shipStatus;
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
	public Date getLastMaintenanceTime() {
		return lastMaintenanceTime;
	}
	public void setLastMaintenanceTime(Date lastMaintenanceTime) {
		this.lastMaintenanceTime = lastMaintenanceTime;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getRoomTotal() {
		return roomTotal;
	}
	public void setRoomTotal(Integer roomTotal) {
		this.roomTotal = roomTotal;
	}
	public Integer getFloorOfShip() {
		return floorOfShip;
	}
	public void setFloorOfShip(Integer floorOfShip) {
		this.floorOfShip = floorOfShip;
	}
	public String getShipStatus() {
		return shipStatus;
	}
	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}
	
	
	
}

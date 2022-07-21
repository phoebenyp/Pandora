package web.ship.bean;

import java.io.Serializable;

public class ShipTotalVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer shipNo;
	private Integer roomTypeNo;
	private Integer maxCountOfRoomType;
	private Integer maxCapacity;
	
	
	public ShipTotalVO() {
		super();
	}
	public ShipTotalVO(Integer shipNo, Integer roomTypeNo, Integer maxCountOfRoomType, Integer maxCapacity) {
		super();
		this.shipNo = shipNo;
		this.roomTypeNo = roomTypeNo;
		this.maxCountOfRoomType = maxCountOfRoomType;
		this.maxCapacity = maxCapacity;
	}
	public Integer getShipNo() {
		return shipNo;
	}
	public void setShipNo(Integer shipNo) {
		this.shipNo = shipNo;
	}
	public Integer getRoomTypeNo() {
		return roomTypeNo;
	}
	public void setRoomTypeNo(Integer roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	public Integer getMaxCountOfRoomType() {
		return maxCountOfRoomType;
	}
	public void setMaxCountOfRoomType(Integer maxCountOfRoomType) {
		this.maxCountOfRoomType = maxCountOfRoomType;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	
	
}

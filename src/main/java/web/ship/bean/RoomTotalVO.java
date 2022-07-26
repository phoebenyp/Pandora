package web.ship.bean;

import java.io.Serializable;

public class RoomTotalVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer rTTCNo;
	private Integer shipNo;
	private Integer roomTypeNo;
	private String roomType;
	private Integer maxCountOfRoomType;
	
	
	@Override
	public String toString() {
		return "RoomTotal [rTTCNo=" + rTTCNo + ", shipNo=" + shipNo + ", roomTypeNo=" + roomTypeNo + ", roomType="
				+ roomType + ", maxCountOfRoomType=" + maxCountOfRoomType + "]";
	}
	
	public RoomTotalVO() {
		super();
	}
	public RoomTotalVO(Integer rTTCNo, Integer shipNo, Integer roomTypeNo, String roomType, Integer maxCountOfRoomType) {
		super();
		this.rTTCNo = rTTCNo;
		this.shipNo = shipNo;
		this.roomTypeNo = roomTypeNo;
		this.roomType = roomType;
		this.maxCountOfRoomType = maxCountOfRoomType;
	}
	public Integer getrTTCNo() {
		return rTTCNo;
	}
	public void setrTTCNo(Integer rTTCNo) {
		this.rTTCNo = rTTCNo;
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
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Integer getMaxCountOfRoomType() {
		return maxCountOfRoomType;
	}
	public void setMaxCountOfRoomType(Integer maxCountOfRoomType) {
		this.maxCountOfRoomType = maxCountOfRoomType;
	}
	
	
}

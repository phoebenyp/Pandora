package web.ship.bean;

import java.io.Serializable;

public class RoomTypeTotalCountVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer rTTCNo;
	private Integer shipNo;
	private Integer roomTypeNo;
	private Integer maxCountOfRoomType;
	
	
	public RoomTypeTotalCountVO() {
		super();
	}
	public RoomTypeTotalCountVO(Integer rTTCNo, Integer shipNo, Integer roomTypeNo, Integer maxCountOfRoomType) {
		super();
		this.rTTCNo = rTTCNo;
		this.shipNo = shipNo;
		this.roomTypeNo = roomTypeNo;
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
	public Integer getMaxCountOfRoomType() {
		return maxCountOfRoomType;
	}
	public void setMaxCountOfRoomType(Integer maxCountOfRoomType) {
		this.maxCountOfRoomType = maxCountOfRoomType;
	}
	
	

}

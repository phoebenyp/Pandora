package web.room.bean;

import java.io.Serializable;
import java.util.Arrays;

public class RoomTypeVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer roomTypeNo;
	private String roomType;
	private Integer roomPrice;
	private Integer maxCapacity;
	private byte[] roomPicture;
	
	@Override
	public String toString() {
		return "RoomTypeVO [roomTypeNo=" + roomTypeNo + ", roomType=" + roomType + ", roomPrice=" + roomPrice
				+ ", maxCapacity=" + maxCapacity + ", roomPicture=" + Arrays.toString(roomPicture) + "]";
	}
	public RoomTypeVO() {
		super();
	}
	public RoomTypeVO(Integer roomTypeNo, String roomType, Integer roomPrice, Integer maxCapacity, byte[] roomPicture) {
		super();
		this.roomTypeNo = roomTypeNo;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.maxCapacity = maxCapacity;
		this.roomPicture = roomPicture;
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
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public byte[] getRoomPicture() {
		return roomPicture;
	}
	public void setRoomPicture(byte[] roomPicture) {
		this.roomPicture = roomPicture;
	}
	
	
	
	
}

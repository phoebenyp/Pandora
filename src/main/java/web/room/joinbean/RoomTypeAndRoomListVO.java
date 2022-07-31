package web.room.joinbean;

import java.io.Serializable;

public class RoomTypeAndRoomListVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer shipNo;
	private Integer roomListNo;
	private Integer roomTypeNo;
	private String roomType;
	private String roomNo;
	private Integer roomPrice;
	private Integer maxCapacity;
	@Override
	public String toString() {
		return "RoomTypeAndRoomListVO [shipNo=" + shipNo + ", roomListNo=" + roomListNo + ", roomTypeNo=" + roomTypeNo
				+ ", roomType=" + roomType + ", roomNo=" + roomNo + ", roomPrice=" + roomPrice + ", maxCapacity="
				+ maxCapacity + "]";
	}
	/**
	 * @return the shipNo
	 */
	public Integer getShipNo() {
		return shipNo;
	}
	/**
	 * @param shipNo the shipNo to set
	 */
	public void setShipNo(Integer shipNo) {
		this.shipNo = shipNo;
	}
	/**
	 * @return the roomListNo
	 */
	public Integer getRoomListNo() {
		return roomListNo;
	}
	/**
	 * @param roomListNo the roomListNo to set
	 */
	public void setRoomListNo(Integer roomListNo) {
		this.roomListNo = roomListNo;
	}
	/**
	 * @return the roomTypeNo
	 */
	public Integer getRoomTypeNo() {
		return roomTypeNo;
	}
	/**
	 * @param roomTypeNo the roomTypeNo to set
	 */
	public void setRoomTypeNo(Integer roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}
	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}
	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	/**
	 * @return the roomNo
	 */
	public String getRoomNo() {
		return roomNo;
	}
	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	/**
	 * @return the roomPrice
	 */
	public Integer getRoomPrice() {
		return roomPrice;
	}
	/**
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	/**
	 * @return the maxCapacity
	 */
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	/**
	 * @param maxCapacity the maxCapacity to set
	 */
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	
}

package web.room.bean;

public class RoomTypeVO implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer roomTypeNo;
	private String roomType;
	private Integer roomPrice;
	private Integer maxCapacity;
	private byte[] roomPicture;
	
	public RoomTypeVO() {
		
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

	/**
	 * @return the roomPicture
	 */
	public byte[] getRoomPicture() {
		return roomPicture;
	}

	/**
	 * @param roomPicture the roomPicture to set
	 */
	public void setRoomPicture(byte[] roomPicture) {
		this.roomPicture = roomPicture;
	}
	
}

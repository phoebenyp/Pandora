package web.room.bean;

public class RoomListVO implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer roomListNo;
	private Integer	shipNo;
	private Integer roomTypeNo;
	private Integer roomNo;
	
	public RoomListVO() {
		
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
	 * @return the roomNo
	 */
	public Integer getRoomNo() {
		return roomNo;
	}

	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	
	
}

package web.room.joinbean;

import java.io.Serializable;

public class GetBookedRoomVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String bookedRoomNo;

	@Override
	public String toString() {
		return "GetBookedRoomVO [bookedRoomNo=" + bookedRoomNo + "]";
	}

	/**
	 * @return the bookedRoomNo
	 */
	public String getBookedRoomNo() {
		return bookedRoomNo;
	}

	/**
	 * @param bookedRoomNo the bookedRoomNo to set
	 */
	public void setBookedRoomNo(String bookedRoomNo) {
		this.bookedRoomNo = bookedRoomNo;
	}
	
	

}

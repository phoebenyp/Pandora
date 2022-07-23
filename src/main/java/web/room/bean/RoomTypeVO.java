package web.room.bean;

import java.io.Serializable;

public class RoomTypeVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer Room_Type_No;
	private String Room_Type;
	private Integer Room_Price;
	private Integer Max_Capacity;
	private byte[] Room_Picture;
	
	
	public RoomTypeVO() {
		super();
	}
	public RoomTypeVO(Integer room_Type_No, String room_Type, Integer room_Price, Integer max_Capacity,
			byte[] room_Picture) {
		super();
		Room_Type_No = room_Type_No;
		Room_Type = room_Type;
		Room_Price = room_Price;
		Max_Capacity = max_Capacity;
		Room_Picture = room_Picture;
	}
	public Integer getRoom_Type_No() {
		return Room_Type_No;
	}
	public void setRoom_Type_No(Integer room_Type_No) {
		Room_Type_No = room_Type_No;
	}
	public String getRoom_Type() {
		return Room_Type;
	}
	public void setRoom_Type(String room_Type) {
		Room_Type = room_Type;
	}
	public Integer getRoom_Price() {
		return Room_Price;
	}
	public void setRoom_Price(Integer room_Price) {
		Room_Price = room_Price;
	}
	public Integer getMax_Capacity() {
		return Max_Capacity;
	}
	public void setMax_Capacity(Integer max_Capacity) {
		Max_Capacity = max_Capacity;
	}
	public byte[] getRoom_Picture() {
		return Room_Picture;
	}
	public void setRoom_Picture(byte[] room_Picture) {
		Room_Picture = room_Picture;
	}
	
	
}

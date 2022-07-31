package web.roomPick.service;

import web.room.joinbean.RoomTypeAndRoomListVO;

public interface RoomPickService {

	RoomTypeAndRoomListVO getRoomInfo(int shipNo, String roomNo);
	// 傳入shipNo + roomNo 兩個參數--> 執行getRoomInfo方法
	// 得到RoomTypeAndRoomListVO這個結果
}

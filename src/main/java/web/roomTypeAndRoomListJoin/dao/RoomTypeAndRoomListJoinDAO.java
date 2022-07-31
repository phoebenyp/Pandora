package web.roomTypeAndRoomListJoin.dao;

import web.room.joinbean.RoomTypeAndRoomListVO;

public interface RoomTypeAndRoomListJoinDAO {

	RoomTypeAndRoomListVO findByShipNoAndRoomNo(int shipNo, String roomNo);
	
}

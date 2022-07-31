package web.roomPick.service.impl;

import web.room.joinbean.RoomTypeAndRoomListVO;
import web.roomPick.service.RoomPickService;
import web.roomTypeAndRoomListJoin.dao.RoomTypeAndRoomListJoinDAO;
import web.roomTypeAndRoomListJoin.dao.impl.RoomTypeAndRoomListJoinDAOImpl;

public class RoomPickServiceImpl implements RoomPickService{

	RoomTypeAndRoomListJoinDAO dao = new RoomTypeAndRoomListJoinDAOImpl();
	
	@Override
	public RoomTypeAndRoomListVO getRoomInfo(int shipNo, String roomNo) {
		
		RoomTypeAndRoomListVO foundInfo = dao.findByShipNoAndRoomNo(shipNo, roomNo);
		
		return foundInfo;
	}
}

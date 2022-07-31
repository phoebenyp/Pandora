package web.getBookedRoom.service;

import java.util.List;

import web.room.joinbean.GetBookedRoomVO;

public interface GetBookedRoomService {

	List<GetBookedRoomVO> getBookedRoom(int packageNo);
	
}

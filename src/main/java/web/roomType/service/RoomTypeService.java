package web.roomType.service;

import java.util.List;

import web.room.bean.RoomTypeVO;

public interface RoomTypeService {

	List<RoomTypeVO> getAll();
	
	RoomTypeVO getOneRoomType(Integer roomTypeNo);

	RoomTypeVO addRoomType(RoomTypeVO roomTypeVO);

	RoomTypeVO updateRoomType(RoomTypeVO roomTypeVO);	

}

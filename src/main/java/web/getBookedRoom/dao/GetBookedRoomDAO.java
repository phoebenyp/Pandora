package web.getBookedRoom.dao;

import java.util.List;

import web.room.joinbean.GetBookedRoomVO;

public interface GetBookedRoomDAO {
	
	List<GetBookedRoomVO> findByPackageNo (int packageNo);

}

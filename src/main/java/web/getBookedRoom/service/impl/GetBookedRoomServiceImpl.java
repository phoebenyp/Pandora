package web.getBookedRoom.service.impl;

import java.util.List;

import web.getBookedRoom.dao.GetBookedRoomDAO;
import web.getBookedRoom.dao.impl.GetBookedRoomDAOImpl;
import web.getBookedRoom.service.GetBookedRoomService;
import web.room.joinbean.GetBookedRoomVO;

public class GetBookedRoomServiceImpl implements GetBookedRoomService {

	GetBookedRoomDAO dao = new GetBookedRoomDAOImpl();

	@Override
	public List<GetBookedRoomVO> getBookedRoom(int packageNo) {

		List<GetBookedRoomVO> foundInfo = dao.findByPackageNo(packageNo);

		return foundInfo;
	}
}

package web.roomType.dao;

import java.util.List;

import web.room.bean.RoomTypeVO;

public interface RoomTypeDAO {
	
	void insert(RoomTypeVO roomTypeVO);

	void update(RoomTypeVO roomTypeVO);

	void delete(Integer roomTypeNo);

	RoomTypeVO findByPrimaryKey(Integer roomTypeNo);

	List<RoomTypeVO> getAll();
	
}

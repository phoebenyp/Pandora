package web.ship.dao;

import java.util.List;
import web.ship.bean.RoomTypeTotalCountVO;

public interface RoomTypeTotalCountDAO {
	RoomTypeTotalCountVO selectOnly(Integer shipNo,Integer roomTypeNo);
	
	void insertLast(Integer ShipNo);
	void insert(RoomTypeTotalCountVO roomTypeTotalCountVO);

	void update(RoomTypeTotalCountVO roomTypeTotalCountVO);

	void delete(Integer shipNo);
	
	List<RoomTypeTotalCountVO> selectNo(Integer shipNo) ;
}
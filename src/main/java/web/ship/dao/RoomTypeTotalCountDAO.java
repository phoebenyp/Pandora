package web.ship.dao;

import java.util.List;
import web.ship.bean.RoomTypeTotalCountVO;

public interface RoomTypeTotalCountDAO {
	
	void insertLast(Integer ShipNo);
	void insert(RoomTypeTotalCountVO roomTypeTotalCountVO);

	void update(RoomTypeTotalCountVO roomTypeTotalCountVO);

	void delete(Integer shipNo);
	
	List<RoomTypeTotalCountVO> selectNo(Integer shipNo) ;
}
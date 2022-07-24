package web.ship.dao;

import java.util.List;

import web.ship.bean.RoomTotalVO;

public interface RoomTotalDAO {
	
	RoomTotalVO selectLast();
	
	List<RoomTotalVO> getShipAll(Integer shipNo);

	RoomTotalVO getRTTC(Integer rTTCNo);

}
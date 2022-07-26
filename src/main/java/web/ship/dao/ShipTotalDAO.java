package web.ship.dao;

import java.util.List;

import web.ship.bean.ShipTotalVO;

public interface ShipTotalDAO {
	//列出所有房型數量資料
	List<ShipTotalVO> getAll();

}
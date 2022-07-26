package web.ship.dao;

import java.util.List;

import web.ship.bean.ShipStatusVO;

public interface ShipStatusDAO {
	//列出所有郵輪狀態資料
	List<ShipStatusVO> getAll();

}
package web.ship.dao;

import java.util.List;
import web.ship.bean.RoomTypeTotalCountVO;

public interface RoomTypeTotalCountDAO {
	//指定其中一艘郵輪的房型
	RoomTypeTotalCountVO selectOnly(Integer shipNo,Integer roomTypeNo);
	//搜尋在同一艘遊輪下的房型
	List<RoomTypeTotalCountVO> selectNo(Integer shipNo) ;
	//郵輪新增時，增設基本的房型數量
	void insertLast(Integer ShipNo);
	//新增房型數量資料
	void insert(RoomTypeTotalCountVO roomTypeTotalCountVO);
	//更新房型數量資料
	void update(RoomTypeTotalCountVO roomTypeTotalCountVO);
	//刪除房型數量資料
	void delete(Integer shipNo);
	
}
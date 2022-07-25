package web.ship.dao;

import java.util.List;

import web.ship.bean.RoomTotalVO;

public interface RoomTotalDAO {
	//指定其中的遊輪下的房型
	RoomTotalVO selectOnly(Integer shipNo,Integer roomTypeNo);
	//選擇最新新增房型數量資料
	RoomTotalVO selectLast();
	//列出所有房型數量資料
	List<RoomTotalVO> getShipAll(Integer shipNo);
	//搜尋指定郵輪房型資料
	RoomTotalVO getRTTC(Integer rTTCNo);

}
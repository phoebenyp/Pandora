package web.ship.dao;

import web.ship.bean.ShipsVO;

public interface ShipsDAO {
	//選擇最新新增的郵輪資料
	ShipsVO selectLast();
	//指定其中一艘郵輪
	ShipsVO findSpipNo(Integer shipNo);
	//新增郵輪
	void insert(ShipsVO shipsVO);
	//更新郵輪
	void update(ShipsVO shipsVO);
	//刪除郵輪
	void delete(Integer shipNo);

}
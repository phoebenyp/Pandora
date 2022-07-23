package web.ship.dao;

import web.ship.bean.ShipsVO;

public interface ShipsDAO {
	ShipsVO selectLast();
	
	ShipsVO findSpipNo(Integer shipNo);
	
	void insert(ShipsVO shipsVO);

	void update(ShipsVO shipsVO);

	void delete(Integer shipNo);

}
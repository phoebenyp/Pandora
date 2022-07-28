package web.cruiseline.dao;

import java.util.List;

import web.cruiseline.bean.CruiseLineVO;

public interface CruiseLineDAO {

	List<CruiseLineVO> getAll();

	CruiseLineVO selectNo(Integer cruiseLineNo);

	CruiseLineVO selectLast(Integer cruiseLineNo);

	void update(CruiseLineVO cruiseLineVO);

	void insert(CruiseLineVO cruiseLineVO);

	void delete(Integer cruiseLineNo);

}
package web.port.dao;

import java.util.List;

import web.port.bean.PortVO;


public interface PortDAO {
	void insert(PortVO portVO);

	void update(PortVO portVO);

	void delete(Integer portOfCallNo);

	PortVO findByPrimaryKey(Integer portOfCallNo);

	List<PortVO> getAll();

}

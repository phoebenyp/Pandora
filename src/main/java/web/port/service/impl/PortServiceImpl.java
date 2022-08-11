package web.port.service.impl;

import java.util.List;

import web.port.bean.PortVO;
import web.port.dao.PortDAO;
import web.port.dao.impl.PortDAOImpl;

public class PortServiceImpl {
	PortDAO daoPort = new PortDAOImpl();
	public List<PortVO> getAll() {
		List<PortVO> result = daoPort.getAll();
		return result;
	}
	public PortVO getPortOne(Integer port) {
		PortVO result = daoPort.findByPrimaryKey(port);
		return result;
	}
}

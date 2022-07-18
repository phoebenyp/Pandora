package web.port.service.impl;

import java.util.List;

import web.port.bean.PortVO;
import web.port.dao.PortDAO;
import web.port.dao.impl.PortDAOImpl;

public class PortServiceImpl {
	
	
	
	public List<PortVO> getAll() {
		PortDAO dao = new PortDAOImpl();
		List<PortVO> result = dao.getAll();
		return result;
		
	}

}

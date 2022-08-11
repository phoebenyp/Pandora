package web.sightseeing.service.impl;

import java.util.List;

import web.sightseeing.bean.SightseeingMarkVO;
import web.sightseeing.dao.impl.SightseeingMarkDAOImpl;

public class SightseeingMarkServiceImpl {
	private SightseeingMarkDAOImpl daoSM =new SightseeingMarkDAOImpl();
	
	public List<SightseeingMarkVO> getPic(Integer portOfCallNo){
		return daoSM.getPic(portOfCallNo);
	}

}

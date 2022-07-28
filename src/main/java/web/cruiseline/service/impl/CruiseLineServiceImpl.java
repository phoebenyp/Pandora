package web.cruiseline.service.impl;

import java.util.List;

import web.cruiseline.bean.CruiseLineVO;
import web.cruiseline.bean.PortNameListVO;
import web.cruiseline.bean.PortsOfCallListVO;
import web.cruiseline.dao.CruiseLineDAO;
import web.cruiseline.dao.PortNameListDAO;
import web.cruiseline.dao.impl.CruiseLineDAOImpl;
import web.cruiseline.dao.impl.PortNameListDAOImpl;
import web.cruiseline.dao.impl.PortsOfCallListDAOImpl;

public class CruiseLineServiceImpl {
	
	private CruiseLineDAO daoCruiseLine = new CruiseLineDAOImpl();
	private PortNameListDAO daoPortNameList = new PortNameListDAOImpl();
	private PortsOfCallListDAOImpl daoPortsOfCallList= new PortsOfCallListDAOImpl();
	
	
	public List<CruiseLineVO> getCruiseLineALL(){
		CruiseLineDAO dao = new CruiseLineDAOImpl();
		List<CruiseLineVO> result = dao.getAll();
		return result;
	}
	public CruiseLineVO selectCruiseNo(Integer cruiseLineNo) {
		return daoCruiseLine.selectNo(cruiseLineNo);
	}
	public List<PortNameListVO> getCruisePortAll(Integer portsOfCallListNo) {
		PortNameListDAO dao = new PortNameListDAOImpl();
		List<PortNameListVO> result = dao.getAll(portsOfCallListNo);
		return result;
	}
	
	public PortNameListVO selectPortNameListOne(Integer portsOfCallListNo,Integer portOfCallSequence) {
		return daoPortNameList.selectOne(portsOfCallListNo, portOfCallSequence);
	}
	public PortNameListVO selectPortNameListLast(Integer portsOfCallListNo) {
		return daoPortNameList.selectLast(portsOfCallListNo);
	}
	public PortNameListVO selectPortNameListLastSecond(Integer portsOfCallListNo) {
		return daoPortNameList.selectLastSecond(portsOfCallListNo);
	}
	public PortNameListVO selectPortNameListFirst(Integer portsOfCallListNo) {
		return daoPortNameList.selectFirst(portsOfCallListNo);
	}
	
	public PortsOfCallListVO insertPCL(Integer cruiseLinesNo,Integer portOfCallNo,Integer portOfCallSequence) {
		PortsOfCallListVO portsOfCallListVO = new PortsOfCallListVO();
		
		portsOfCallListVO.setCruiseLinesNo(cruiseLinesNo);
		portsOfCallListVO.setPortOfCallNo(portOfCallNo);
		portsOfCallListVO.setPortOfCallSequence(portOfCallSequence);
		
		daoPortsOfCallList.insert(portsOfCallListVO);
		return portsOfCallListVO;
	}
	
	public PortsOfCallListVO updatePCL(Integer cruiseLinesNo,Integer portOfCallNo,Integer portOfCallSequence,Integer portsOfCallListNo) {
		PortsOfCallListVO portsOfCallListVO = new PortsOfCallListVO();
		
		portsOfCallListVO.setCruiseLinesNo(cruiseLinesNo);
		portsOfCallListVO.setPortOfCallNo(portOfCallNo);
		portsOfCallListVO.setPortOfCallSequence(portOfCallSequence);
		portsOfCallListVO.setPortsOfCallListNo(portsOfCallListNo);
		
		daoPortsOfCallList.update(portsOfCallListVO);
		
		return portsOfCallListVO;
	}
	
	public void deletePCL(Integer portsOfCallListNo) {
		daoPortsOfCallList.delete(portsOfCallListNo);
	}
}

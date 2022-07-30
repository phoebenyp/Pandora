package web.cruiseline.service.impl;

import java.time.LocalDate;
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
	
	public void selectCNLAll(Integer cruiseLineNo) {
		daoPortNameList.selectPNL(cruiseLineNo);
	}
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
	public PortNameListVO selectPortNameListPNL(Integer portsOfCallListNo) {
		return daoPortNameList.selectPNL(portsOfCallListNo);
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
	public CruiseLineVO updateCL(String cruiseLines,byte[] cruiseLinePicture,LocalDate time,Integer cruiseLineNo){
		if(cruiseLinePicture.length != 0 && cruiseLinePicture != null) {
			CruiseLineVO cruiseLineVO =new CruiseLineVO();
			cruiseLineVO.setCruiseLines(cruiseLines);
			cruiseLineVO.setCruiseLinePicture(cruiseLinePicture);
			cruiseLineVO.setTime(time);
			cruiseLineVO.setCruiseLineNo(cruiseLineNo);
//			System.out.println("null");
			daoCruiseLine.update(cruiseLineVO);
			return cruiseLineVO;
		}else{
			CruiseLineVO cruiseLineVO =new CruiseLineVO();
			cruiseLineVO.setCruiseLines(cruiseLines);
			cruiseLineVO.setTime(time);
			cruiseLineVO.setCruiseLineNo(cruiseLineNo);
//			System.out.println("have");
			daoCruiseLine.updateUNPic(cruiseLineVO);
			return cruiseLineVO;
		}
	}
	public CruiseLineVO updateCLNames(Integer cruiseLineNo) {
		String cruiseLinesF = daoPortNameList.selectFirst(cruiseLineNo).getPortName();
		String cruiseLinesS = daoPortNameList.selectLastSecond(cruiseLineNo).getPortName();
		String cruiseLinesT = daoPortNameList.selectLast(cruiseLineNo).getPortName();
		String cruiseLinesA = cruiseLinesF+"-"+cruiseLinesS+"-"+cruiseLinesT;
		
		CruiseLineVO cruiseLineVO =new CruiseLineVO();
		cruiseLineVO.setCruiseLineNo(cruiseLineNo);
		cruiseLineVO.setCruiseLines(cruiseLinesA);
		
		daoCruiseLine.updateCLName(cruiseLineVO);
		
		return cruiseLineVO;
		
	}
	public CruiseLineVO insertCL(byte[] cruiseLinePicture,LocalDate time) {
		CruiseLineVO cruiseLineVO =new CruiseLineVO();
		cruiseLineVO.setCruiseLines("");
		cruiseLineVO.setCruiseLinePicture(cruiseLinePicture);
		cruiseLineVO.setTime(time);
		daoCruiseLine.insert(cruiseLineVO);
		
		return cruiseLineVO;
		
	}
	public void cruiseLineLast() {
		Integer cLLastInteger = daoCruiseLine.selectLast().getCruiseLineNo();
		insertPCL(cLLastInteger,1,1);
		insertPCL(cLLastInteger,2,2);
		insertPCL(cLLastInteger,3,3);
		insertPCL(cLLastInteger,1,4);
		updateCLNames(cLLastInteger);
	}
	public void deleteCruiseLineNo(Integer cruiseLineNo) {
		daoPortsOfCallList.deleteAll(cruiseLineNo);
		daoCruiseLine.delete(cruiseLineNo);
		
	}
}

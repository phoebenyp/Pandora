package web.ship.service.impl;

import java.sql.Date;
import java.util.List;

import web.ship.bean.RoomTotalVO;
import web.ship.bean.RoomTypeTotalCountVO;
import web.ship.bean.ShipTotalVO;
import web.ship.bean.ShipsVO;
import web.ship.dao.RoomTypeTotalCountDAO;
import web.ship.dao.ShipTotalDAO;
import web.ship.dao.impl.RoomTotalDAOImpl;
import web.ship.dao.impl.RoomTypeTotalCountDAOImpl;
import web.ship.dao.impl.ShipTotalDAOImpl;
import web.ship.dao.impl.ShipsDAOImpl;


public class ShipService {

	private ShipsDAOImpl daoShip = new ShipsDAOImpl();
	private RoomTypeTotalCountDAOImpl daoRTTC =new RoomTypeTotalCountDAOImpl();
	private RoomTotalDAOImpl daoRT = new RoomTotalDAOImpl();
	
	public ShipService() {
		super();
	}
	
	public ShipService(ShipsDAOImpl daoShip, RoomTypeTotalCountDAOImpl daoRTTC,RoomTotalDAOImpl daoRT) {
		super();
		this.daoShip = daoShip;
		this.daoRTTC = daoRTTC;
		this.daoRT = daoRT;
	}
	
	
	public ShipsVO selectLast() {//選擇最新新增的郵輪資料
		return daoShip.selectLast();
	}
	public RoomTotalVO selectRTLast() {//選擇最新新增房型數量資料
		return daoRT.selectLast();
	}
	public ShipsVO getOneShip(Integer shipNo) {//指定其中一艘郵輪
		return daoShip.findSpipNo(shipNo);
	}
	public RoomTotalVO getRTTC(Integer rTTCNo) {//指定其中一艘郵輪的房型
		return daoRT.getRTTC(rTTCNo);
	}
	
	public RoomTypeTotalCountVO selectOnly(Integer shipNo,Integer roomTypeNo){//指定其中一艘郵輪的房型
		RoomTypeTotalCountDAO dao = new RoomTypeTotalCountDAOImpl();
		RoomTypeTotalCountVO result =dao.selectOnly(shipNo, roomTypeNo);
		return result;
	}
	
	public List<RoomTypeTotalCountVO> selectNo(Integer shipNo){//搜尋在同一艘遊輪下的房型
		RoomTypeTotalCountDAO dao = new RoomTypeTotalCountDAOImpl();
		List<RoomTypeTotalCountVO> result =dao.selectNo(shipNo);
		return result;
	}
	public List<ShipTotalVO> getAll() {//列出所有郵輪
		ShipTotalDAO dao = new ShipTotalDAOImpl();
		List<ShipTotalVO> result = dao.getAll();
		return result;
		
	}
	public List<RoomTotalVO> getRTSAll(Integer shipNo){//列出所有房型數量資料
		RoomTotalDAOImpl dao =new RoomTotalDAOImpl();
		List<RoomTotalVO> result = dao.getShipAll(shipNo);
		return result;
	}
	
	//新增郵輪
	public ShipsVO addShip(String shipName,Date starStatus,Date lastmaintenanceTime,Integer floorOfShip,Integer shipStatusNo) {
		ShipsVO shipsVO=new ShipsVO();
		
		shipsVO.setShipName(shipName);
		shipsVO.setStarStatus(starStatus);
		shipsVO.setLastmaintenanceTime(lastmaintenanceTime);
		shipsVO.setFloorOfShip(floorOfShip);
		shipsVO.setShipStatusNo(shipStatusNo);
		daoShip.insert(shipsVO);
//		System.out.println(shipsVO);
		return shipsVO;
	}
	
	//更新郵輪
	public ShipsVO updateShip(String shipName,Date starStatus,Date lastmaintenanceTime,Integer floorOfShip,Integer shipStatusNo,Integer shipNo) {
		ShipsVO shipsVO=new ShipsVO();
		
		
		shipsVO.setShipName(shipName);
		shipsVO.setStarStatus(starStatus);
		shipsVO.setLastmaintenanceTime(lastmaintenanceTime);
		shipsVO.setFloorOfShip(floorOfShip);
		shipsVO.setShipStatusNo(shipStatusNo);
		shipsVO.setShipNo(shipNo);
		daoShip.update(shipsVO);
		
		return shipsVO;
	}
	public void deleteShip(Integer shipNo) {//刪除郵輪
		daoShip.delete(shipNo);
	}
	
	//新增房型數量資料
	public RoomTypeTotalCountVO addRTTC(Integer shipNo,Integer roomTypeNo,Integer maxCountOfRoomType) {
		RoomTypeTotalCountVO roomTypeTotalCountVO = new RoomTypeTotalCountVO();
		
		roomTypeTotalCountVO.setShipNo(shipNo);
		roomTypeTotalCountVO.setRoomTypeNo(roomTypeNo);
		roomTypeTotalCountVO.setMaxCountOfRoomType(maxCountOfRoomType);
		daoRTTC.insert(roomTypeTotalCountVO);
		
		return roomTypeTotalCountVO;
	}
	
	//郵輪新增時，增設基本的房型數量
	public void addRTTCLast(Integer shipNo) {
		
		daoRTTC.insertLast(shipNo);
		
	}
	
	//更新房型數量資料
	public RoomTypeTotalCountVO updateRTTC(Integer shipNo,Integer roomTypeNo,Integer maxCountOfRoomType,Integer rTTCNo) {
		RoomTypeTotalCountVO roomTypeTotalCountVO = new RoomTypeTotalCountVO();
		
		roomTypeTotalCountVO.setShipNo(shipNo);
		roomTypeTotalCountVO.setRoomTypeNo(roomTypeNo);
		roomTypeTotalCountVO.setMaxCountOfRoomType(maxCountOfRoomType);
		roomTypeTotalCountVO.setrTTCNo(rTTCNo);
		daoRTTC.update(roomTypeTotalCountVO);
		
		return roomTypeTotalCountVO;
	}
	
	//刪除房型數量資料
	public void deleteRTTC(Integer rTTCNo) {
		daoRTTC.delete(rTTCNo);
	}
}

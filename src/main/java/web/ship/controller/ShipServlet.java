package web.ship.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.ship.bean.RoomTotalVO;
import web.ship.bean.RoomTypeTotalCountVO;
import web.ship.bean.ShipsVO;
import web.ship.service.impl.ShipService;


@WebServlet("/ShipServlet")
public class ShipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		//抽出單艘船的資料
		if ("getOne_For_Update_Ship".equals(action)) { // 來自ships.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer shipNo = Integer.valueOf(request.getParameter("shipNo"));
//				System.out.println(request.getParameter("shipNo"));
				
				/***************************2.開始查詢資料****************************************/
				ShipService shipSvc = new ShipService();
				//抽出單艘船的資料
				ShipsVO shipsVO = shipSvc.getOneShip(shipNo);
//				System.out.println(shipsVO);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				request.setAttribute("shipsVO", shipsVO);         // 資料庫取出的shipsVO物件,存入req
				String url = "/shipUpdate.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url);// 成功轉交 shipUpdate.jsp
				successView.forward(request, response);
		}
			
			//新增郵輪資料
			if ("insert".equals(action)) { // 來自ships.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
String shipname = request.getParameter("shipname");
				if (shipname == null || shipname.trim().length() == 0) {
					errorMsgs.add("郵輪名稱:請勿空白");
				} 
				
				java.sql.Date shipstart = null;
				try {
shipstart = java.sql.Date.valueOf(request.getParameter("shipstart").trim());
				} catch (IllegalArgumentException e) {
					shipstart=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				java.sql.Date shipmain = null;
				try {
shipmain = java.sql.Date.valueOf(request.getParameter("shipmain").trim());
				} catch (IllegalArgumentException e) {
					shipmain=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入日期!");
				}
				
				Integer shipfloor = null;
				try {
shipfloor = Integer.parseInt(request.getParameter("shipfloor").trim());
				} catch (NumberFormatException e) {
					errorMsgs.add("郵輪樓層請輸入數字");
				}
				
				Integer shipstatusNo =null;
				try {	
shipstatusNo = Integer.parseInt(request.getParameter("shipstatusNo").trim());
				} catch (NumberFormatException e) {
					errorMsgs.add("郵輪房型請選擇");
				}
				
				
//				System.out.println("shipname="+shipname+"shipstart="+shipstart+"shipmain="+shipmain+"shipfloor="+shipfloor+"shipstatusNo="+shipstatusNo);
				
				
				
				
				
				
				ShipsVO shipsVO = new ShipsVO();
				shipsVO.setShipName(shipname);
				shipsVO.setStarStatus(shipstart);
				shipsVO.setLastmaintenanceTime(shipmain);
				shipsVO.setFloorOfShip(shipfloor);
				shipsVO.setShipStatusNo(shipstatusNo);
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
request.setAttribute("shipsVO", shipsVO); // 含有輸入格式錯誤的shipsVO物件,也存入req
					RequestDispatcher failureView = request
							.getRequestDispatcher("shipInsert.jsp");
					failureView.forward(request, response);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				ShipService shipSvc = new ShipService();
				shipsVO = shipSvc.addShip(shipname,shipstart,shipmain,shipfloor,shipstatusNo);
				Integer shipNo = shipSvc.selectLast().getShipNo();
				shipSvc.addRTTCLast(shipNo);
//				System.out.println("success");
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				//因為還要新增房型數量，所以要再經過一個頁面
				String url = "/ships.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url); // 新增成功後轉交ships.jsp
				successView.forward(request, response);				
		}
			
			
			//新增郵輪房型數量
			if ("insertRTTC".equals(action)) { // 來自shipInsertRTTC.jsp的請求  
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				request.setAttribute("errorMsgs", errorMsgs);

					/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
					
					Integer shipNo = null;
					try {
	shipNo = Integer.parseInt(request.getParameter("shipNo").trim());
					} catch (NumberFormatException e) {
						errorMsgs.add("郵輪編號請填數字");
					}
					
					Integer roomTypeNo =null;
					try {	
	roomTypeNo = Integer.parseInt(request.getParameter("roomTypeNo").trim());
					} catch (NumberFormatException e) {
						errorMsgs.add("請選擇房型");
					}
					Integer maxCountOfRoomType = null;
					try {
	maxCountOfRoomType = Integer.parseInt(request.getParameter("maxCountOfRoomType").trim());
					} catch (NumberFormatException e) {
						errorMsgs.add("房型數量請輸入數字");
					}
					
					
//					System.out.println("shipNo="+shipNo+"roomTypeNo="+roomTypeNo+"maxCountOfRoomType="+maxCountOfRoomType);
					
					
					
					
					
					
					RoomTypeTotalCountVO roomTypeTotalCountVO = new RoomTypeTotalCountVO();
					roomTypeTotalCountVO.setShipNo(shipNo);
					roomTypeTotalCountVO.setRoomTypeNo(roomTypeNo);
					roomTypeTotalCountVO.setMaxCountOfRoomType(maxCountOfRoomType);
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
	request.setAttribute("shipNo", shipNo); // 含有輸入格式錯誤的shipNo參數,也存入req
						RequestDispatcher failureView = request
								.getRequestDispatcher("/shipInsertRTTC.jsp");
						failureView.forward(request, response);
						return;
					}
					
					/***************************2.開始新增資料***************************************/
					ShipService shipSvc = new ShipService();
					RoomTypeTotalCountVO check=shipSvc.selectOnly(shipNo, roomTypeNo);
//					System.out.println(check);
//					System.out.println(check.getShipNo());
					if (check != null) {
						Integer abcInteger =check.getrTTCNo();
						//如果新增的是同艘郵輪且同房型時，將併入進去同筆資料中
						if (check.getRoomTypeNo()==roomTypeNo && check.getShipNo()==shipNo) {
							maxCountOfRoomType += check.getMaxCountOfRoomType();
							roomTypeTotalCountVO = shipSvc.updateRTTC(shipNo, roomTypeNo, maxCountOfRoomType,abcInteger);
							
							//新增shipNo和roomTypeNo參數進入request，以方便下一頁搜尋到指定郵輪
							request.setAttribute("shipNo", roomTypeTotalCountVO.getShipNo());
							request.setAttribute("roomTypeNo", roomTypeTotalCountVO.getRoomTypeNo());
							ShipsVO shipsVO = shipSvc.getOneShip(shipNo);
							request.setAttribute("shipsVO", shipsVO);
							String url = "/shipUpdate.jsp";
							RequestDispatcher successView = request.getRequestDispatcher(url); // 新增成功後轉交shipUpdate.jsp
							successView.forward(request, response);	
							return;
						}
					}
					
					
					
					
					//如果是同艘郵輪但不同房型，新增房型數量
					roomTypeTotalCountVO = shipSvc.addRTTC(shipNo, roomTypeNo, maxCountOfRoomType);
					ShipsVO shipsVO = shipSvc.getOneShip(shipNo);
//					System.out.println("success");
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					request.setAttribute("shipsVO", shipsVO);
					//要跳回到shipUpdate.jsp需經過一個頁面，再傳入action=getOne_For_Update_Ship
					String url = "/shipUpdate.jsp";
					RequestDispatcher successView = request.getRequestDispatcher(url); // 新增成功後轉交shipUpdate.jsp
					successView.forward(request, response);				
			}
			
			//更新郵輪資料
			if ("update".equals(action)) { // 來自shipUpdate.jsp的請求
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				request.setAttribute("errorMsgs", errorMsgs);
			
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					Integer shipNo = Integer.valueOf(request.getParameter("shipNo"));
								
					String shipname = request.getParameter("shipname");
					if (shipname == null || shipname.trim().length() == 0) {
						errorMsgs.add("郵輪名稱:請勿空白");
					} 
		
					java.sql.Date shipstart = null;
					try {
shipstart = java.sql.Date.valueOf(request.getParameter("shipstart"));
					} catch (IllegalArgumentException e) {
						shipstart=new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請輸入日期!");
					}
		
					java.sql.Date shipmain = null;
					try {
shipmain = java.sql.Date.valueOf(request.getParameter("shipmain"));
					} catch (IllegalArgumentException e) {
						shipmain=new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請輸入日期!");
					}
					
					Integer shipfloor = null;
					try {
shipfloor = Integer.parseInt(request.getParameter("shipfloor").trim());
					} catch (NumberFormatException e) {
						errorMsgs.add("郵輪樓層請輸入數字");
					}
					
					Integer shipstatusNo =null;
					try {	
shipstatusNo = Integer.parseInt(request.getParameter("shipstatusNo"));
					} catch (NumberFormatException e) {
						errorMsgs.add("郵輪狀態請選擇");
					}
					
					ShipsVO shipsVO = new ShipsVO();
					shipsVO.setShipNo(shipNo);
					shipsVO.setShipName(shipname);
					shipsVO.setStarStatus(shipstart);
					shipsVO.setLastmaintenanceTime(shipmain);
					shipsVO.setFloorOfShip(shipfloor);
					shipsVO.setShipStatusNo(shipstatusNo);
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
request.setAttribute("shipsVO", shipsVO); // 含有輸入格式錯誤的shipsVO物件,也存入req
					System.out.println(shipsVO.getShipNo());
						RequestDispatcher failureView = request
								.getRequestDispatcher("shipUpdate.jsp");
						failureView.forward(request, response);
						System.out.println("失敗");
						return; //程式中斷
					}
					
					/***************************2.開始修改資料*****************************************/
					ShipService shipSvc = new ShipService();
					shipsVO = shipSvc.updateShip( shipname, shipstart, shipmain,shipfloor, shipstatusNo,shipNo);
//					System.out.println(shipsVO);
					/***************************3.修改完成,準備轉交(Send the Success view)*************/
					request.setAttribute("shipsVO", shipsVO); // 資料庫update成功後,正確的的shipsVO物件,存入req
					String url = "/ships.jsp";
					RequestDispatcher successView = request.getRequestDispatcher(url); // 修改成功後,轉交ships.jsp
					successView.forward(request, response);
			}
			
			//更新房型數量資料
			if ("updateRTTC".equals(action)) { // 來自shipUpdateRTTC.jsp的請求
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				request.setAttribute("errorMsgs", errorMsgs);
			
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					Integer rTTCNo = Integer.valueOf(request.getParameter("rTTCNo"));
					Integer shipNo = null;
					try {
	shipNo = Integer.parseInt(request.getParameter("shipNo").trim());
					} catch (NumberFormatException e) {
						errorMsgs.add("請輸入郵輪編號");
					}
					
					Integer roomTypeNo =null;
					try {	
	roomTypeNo = Integer.parseInt(request.getParameter("roomTypeNo").trim());
					} catch (NumberFormatException e) {
						errorMsgs.add("請選擇房型");
					}
					Integer maxCountOfRoomType = null;
					try {
	maxCountOfRoomType = Integer.parseInt(request.getParameter("maxCountOfRoomType").trim());
					} catch (NumberFormatException e) {
						errorMsgs.add("房型數量請輸入數字");
					}
					
					
//					System.out.println("shipNo="+shipNo+"roomTypeNo="+roomTypeNo+"maxCountOfRoomType="+maxCountOfRoomType);
					
					
					RoomTypeTotalCountVO roomTypeTotalCountVO = new RoomTypeTotalCountVO();
					roomTypeTotalCountVO.setShipNo(shipNo);
					roomTypeTotalCountVO.setRoomTypeNo(roomTypeNo);
					roomTypeTotalCountVO.setMaxCountOfRoomType(maxCountOfRoomType);
					roomTypeTotalCountVO.setrTTCNo(rTTCNo);
					
					
					RoomTotalVO roomTotalVO = new RoomTotalVO();
					roomTotalVO.setrTTCNo(rTTCNo);
					roomTotalVO.setShipNo(shipNo);
					roomTotalVO.setRoomTypeNo(roomTypeNo);
					roomTotalVO.setMaxCountOfRoomType(maxCountOfRoomType);
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
						request.setAttribute("rTTCNo", rTTCNo); 
						//為了下一頁方便搜尋，傳入的是roomTotalVO物件
	request.setAttribute("roomTotalVO", roomTotalVO); // 含有輸入格式錯誤的roomTotalVO物件,也存入req
						RequestDispatcher failureView = request
								.getRequestDispatcher("/shipUpdateRTTC.jsp");
						failureView.forward(request, response);
						return;
					}
					
					/***************************2.開始新增資料***************************************/
					ShipService shipSvc = new ShipService();
					ShipsVO shipsVO = shipSvc.getOneShip(shipNo);
					request.setAttribute("shipsVO", shipsVO); // 資料庫update成功後,正確的的shipsVO物件,存入req
					roomTypeTotalCountVO = shipSvc.updateRTTC(shipNo, roomTypeNo, maxCountOfRoomType, rTTCNo);
//					System.out.println("success");
					/***************************3.新增完成,準備轉交(Send the Success view)***********/
					//要跳回到shipUpdate.jsp需經過一個頁面，再傳入action=getOne_For_Update_Ship
					//資料庫取出的rTTCNo參數,存入req
					request.setAttribute("rTTCNo", rTTCNo);
					request.setAttribute("shipsVO", shipsVO); // 資料庫update成功後,正確的的shipsVO物件,存入req
					String url = "shipUpdate.jsp";
					RequestDispatcher successView = request.getRequestDispatcher(url); // 新增成功後轉交shipUpdate.jsp
					successView.forward(request, response);	
			}
			
			//刪除郵輪資料
			if ("delete".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				request.setAttribute("errorMsgs", errorMsgs);
		
					/***************************1.接收請求參數***************************************/
					Integer shipNo = Integer.valueOf(request.getParameter("shipNo"));
					
					/***************************2.開始刪除資料***************************************/
					ShipService shipSvc = new ShipService();
					shipSvc.deleteShip(shipNo);
					
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
					String url = "ships.jsp";
					RequestDispatcher successView = request.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
					successView.forward(request, response);
			}
			
			
			//刪除郵輪房型數量資料
			if ("deleteRTTC".equals(action)) { // 來自listAllEmp.jsp

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				request.setAttribute("errorMsgs", errorMsgs);
		
					/***************************1.接收請求參數***************************************/
					Integer rTTCNo = Integer.valueOf(request.getParameter("rTTCNo"));
					Integer shipNo = Integer.valueOf(request.getParameter("shipNo"));
					/***************************2.開始刪除資料***************************************/
					ShipService shipSvc = new ShipService();
					shipSvc.deleteRTTC(rTTCNo);
					ShipsVO shipsVO = shipSvc.getOneShip(shipNo);
					/***************************3.刪除完成,準備轉交(Send the Success view)***********/
					//要跳回到shipUpdate.jsp需經過一個頁面，再傳入action=getOne_For_Update_Ship
					//資料庫取出的shipNo參數,存入req
					request.setAttribute("shipNo", shipNo);
					request.setAttribute("shipsVO", shipsVO); // 資料庫update成功後,正確的的shipsVO物件,存入req
					String url = "shipUpdate.jsp";
					RequestDispatcher successView = request.getRequestDispatcher(url);// 刪除成功後,轉交到刪除成功的網頁shipUpdate.jsp
					successView.forward(request, response);
			}
			
			//跳轉到新增郵輪房刑數量頁面
			if ("insertRTTCBefore".equals(action)) { // 來自shipUpdate.jsp的請求

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				request.setAttribute("errorMsgs", errorMsgs);
				
					/***************************1.接收請求參數****************************************/
					Integer shipNo = Integer.valueOf(request.getParameter("shipNo"));
//					System.out.println(request.getParameter("shipNo"));
					
					/***************************2.開始查詢資料****************************************/
//					ShipService shipSvc = new ShipService();
//					ShipsVO shipsVO = shipSvc.getOneShip(shipNo);
//					System.out.println(shipsVO);
									
					/***************************3.查詢完成,準備轉交(Send the Success view)************/
					request.setAttribute("shipNo", shipNo);         // 資料庫取出的shipNo物件,存入req
					String url = "/shipInsertRTTC.jsp";
					RequestDispatcher successView = request.getRequestDispatcher(url);// 成功轉交 shipInsertRTTC.jsp
					successView.forward(request, response);
			}
			
			//跳轉到更新郵輪房型數量頁面
			if ("updateRTTCBefore".equals(action)) { // 來自shipUpdate.jsp的請求

				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				request.setAttribute("errorMsgs", errorMsgs);
				
					/***************************1.接收請求參數****************************************/
					Integer rTTCNo = Integer.valueOf(request.getParameter("rTTCNo"));
//					System.out.println(request.getParameter("shipNo"));
					
					/***************************2.開始查詢資料****************************************/
					ShipService shipSvc = new ShipService();
					RoomTotalVO roomTotalVO = shipSvc.getRTTC(rTTCNo);
//					System.out.println(shipsVO);
									
					/***************************3.查詢完成,準備轉交(Send the Success view)************/
					request.setAttribute("roomTotalVO", roomTotalVO);         // 資料庫取出的roomTotalVO物件,存入req
					String url = "/shipUpdateRTTC.jsp";
					RequestDispatcher successView = request.getRequestDispatcher(url);// 成功轉交 shipUpdateRTTC.jsp
					successView.forward(request, response);
			}
		
	}

	
}

package web.ship.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		

		if ("getOne_For_Update_Ship".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer shipNo = Integer.valueOf(request.getParameter("shipNo"));
//				System.out.println(request.getParameter("shipNo"));
				
				/***************************2.開始查詢資料****************************************/
				ShipService shipSvc = new ShipService();
				ShipsVO shipsVO = shipSvc.getOneShip(shipNo);
//				System.out.println(shipsVO);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				request.setAttribute("shipsVO", shipsVO);         // 資料庫取出的empVO物件,存入req
				String url = "/shipUpdate.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(request, response);
		}
		
			if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
String shipname = request.getParameter("shipname");
				if (shipname == null || shipname.trim().length() == 0) {
					errorMsgs.add("郵輪名稱: 請勿空白");
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
					errorMsgs.add("郵輪樓層請填數字.");
				}
				
				Integer shipstatusNo =null;
				try {	
shipstatusNo = Integer.parseInt(request.getParameter("shipstatusNo").trim());
				} catch (NumberFormatException e) {
					errorMsgs.add("郵輪樓層請填數字.");
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
request.setAttribute("shipname", shipname); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = request
							.getRequestDispatcher("/shipInsert");
					failureView.forward(request, response);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				ShipService shipSvc = new ShipService();
				shipsVO = shipSvc.addShip(shipname,shipstart,shipmain,shipfloor,shipstatusNo);
//				System.out.println("success");
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/ships.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(request, response);				
		}
			if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
				
				List<String> errorMsgs = new LinkedList<String>();
				// Store this set in the request scope, in case we need to
				// send the ErrorPage view.
				request.setAttribute("errorMsgs", errorMsgs);
			
					/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
					Integer shipNo = Integer.valueOf(request.getParameter("shipNo"));
								
					String shipname = request.getParameter("shipname");
					if (shipname == null || shipname.trim().length() == 0) {
						errorMsgs.add("郵輪名稱: 請勿空白");
						System.out.println(1);
					} 
		
					java.sql.Date shipstart = null;
					try {
shipstart = java.sql.Date.valueOf(request.getParameter("shipstart"));
					} catch (IllegalArgumentException e) {
						shipstart=new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請輸入日期!");
						System.out.println(2);
					}
		
					java.sql.Date shipmain = null;
					try {
shipmain = java.sql.Date.valueOf(request.getParameter("shipmain"));
					} catch (IllegalArgumentException e) {
						shipmain=new java.sql.Date(System.currentTimeMillis());
						errorMsgs.add("請輸入日期!");
						System.out.println(3);
					}
					
					Integer shipfloor = null;
					try {
shipfloor = Integer.parseInt(request.getParameter("shipfloor"));
					} catch (NumberFormatException e) {
						errorMsgs.add("郵輪樓層請填數字.");
						System.out.println(4);
					}
					
					Integer shipstatusNo =null;
					try {	
shipstatusNo = Integer.parseInt(request.getParameter("shipstatusNo"));
					} catch (NumberFormatException e) {
						errorMsgs.add("郵輪樓層請填數字.");
						System.out.println(5);
					}
					
					ShipsVO shipsVO = new ShipsVO();
					shipsVO.setShipName(shipname);
					shipsVO.setStarStatus(shipstart);
					shipsVO.setLastmaintenanceTime(shipmain);
					shipsVO.setFloorOfShip(shipfloor);
					shipsVO.setShipStatusNo(shipstatusNo);
					// Send the use back to the form, if there were errors
					if (!errorMsgs.isEmpty()) {
request.setAttribute("shipsVO", shipsVO); // 含有輸入格式錯誤的empVO物件,也存入req
						RequestDispatcher failureView = request
								.getRequestDispatcher("/shipUpdate.jsp");
						failureView.forward(request, response);
						System.out.println("失敗");
						return; //程式中斷
					}
					
					/***************************2.開始修改資料*****************************************/
					ShipService shipSvc = new ShipService();
					shipsVO = shipSvc.updateShip( shipname, shipstart, shipmain,shipfloor, shipstatusNo,shipNo);
					System.out.println(shipsVO);
					/***************************3.修改完成,準備轉交(Send the Success view)*************/
					request.setAttribute("shipNo", shipNo); // 資料庫update成功後,正確的的empVO物件,存入req
					String url = "/ships.jsp";
					RequestDispatcher successView = request.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
					successView.forward(request, response);
			}
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
	}

	
}

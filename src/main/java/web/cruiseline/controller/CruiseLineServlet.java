package web.cruiseline.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.cruiseline.bean.CruiseLineVO;
import web.cruiseline.bean.PortNameListVO;
import web.cruiseline.bean.PortsOfCallListVO;
import web.cruiseline.service.impl.CruiseLineServiceImpl;
import web.emp.bean.EmpVO;
import web.emp.service.EmpService;
import web.emp.service.impl.EmpServiceImpl;
import web.ship.bean.ShipsVO;
import web.ship.service.impl.ShipService;

@WebServlet("/CruiseLineServlet")
public class CruiseLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("cruiseLineVOUpdate".equals(action)) {
			response.setContentType("image/jpeg");
			ServletOutputStream out;
			out = response.getOutputStream();
			Integer cruiseLineNo = Integer.valueOf(request.getParameter("cruiseLineNo"));
//			System.out.println(cruiseLineNo);
			CruiseLineServiceImpl clsSvc = new CruiseLineServiceImpl();
			CruiseLineVO cruiseLineVO = clsSvc.selectCruiseNo(cruiseLineNo);
			out.write(cruiseLineVO.getCruiseLinePicture());
		}

		if ("usesrImage".equals(action)) {
			response.setContentType("image/jpeg");
			ServletOutputStream out;
			out = response.getOutputStream();
			HttpSession session = request.getSession();
			EmpVO empVO = (EmpVO) (session.getAttribute("loginUser"));
			out.write(empVO.getEmpPictureId());
		}
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if ("selectCruiseNo".equals(action)) { // 來自ships.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer cruiseLineNo = Integer.valueOf(request.getParameter("cruiseLineNo"));
//				System.out.println(request.getParameter("shipNo"));
				
				/***************************2.開始查詢資料****************************************/
				CruiseLineServiceImpl cruiseLineSvc = new CruiseLineServiceImpl();
				//抽出單艘船的資料
				CruiseLineVO cruiseLineVO = cruiseLineSvc.selectCruiseNo(cruiseLineNo);
//				System.out.println(shipsVO);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				request.setAttribute("cruiseLineVO", cruiseLineVO);         // 資料庫取出的shipsVO物件,存入req
				String url = "/back-end/cruiseline/cruiselineUpdate.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url);// 成功轉交 shipUpdate.jsp
				successView.forward(request, response);
		}
		
		if ("updatePCLBefore".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
			
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer portsOfCallListNo = Integer.valueOf(request.getParameter("portsOfCallListNo"));
				Integer cruiseLineNo = Integer.valueOf(request.getParameter("cruiseLineNo"));
//				System.out.println(portsOfCallListNo);
				String cruiseLines =request.getParameter("cruiseLines");


				// Send the use back to the form, if there were errors
				
				/***************************2.開始修改資料*****************************************/
				CruiseLineServiceImpl clSvc = new CruiseLineServiceImpl();
				PortNameListVO portNameListVO = new PortNameListVO();
				portNameListVO = clSvc.selectPortNameListPNL(portsOfCallListNo);
				
				//抽出單艘船的資料
//				CruiseLineVO cruiseLineVO = clSvc.selectCruiseNo(cruiseLinesNo);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
				
				request.setAttribute("portNameListVO", portNameListVO);
				request.setAttribute("cruiseLines", cruiseLines);
				request.setAttribute("cruiseLineNo", cruiseLineNo);
                String url = "/back-end/cruiseline/cruiselinePNLUpdate.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(request, response);
		}
		if ("updatePCL".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
			
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer portsOfCallListNo = Integer.valueOf(request.getParameter("portsOfCallListNo").trim());
				System.out.println("portsOfCallListNo="+portsOfCallListNo);
				Integer cruiseLinesNo = Integer.valueOf(request.getParameter("cruiseLinesNo").trim());
				System.out.println(cruiseLinesNo);
				Integer portOfCallNo = Integer.valueOf(request.getParameter("portOfCallNo").trim());
				System.out.println(portOfCallNo);
				Integer portOfCallSequence = Integer.valueOf(request.getParameter("portOfCallSequence").trim());
				System.out.println(portOfCallSequence);

				// Send the use back to the form, if there were errors
				
				/***************************2.開始修改資料*****************************************/
				CruiseLineServiceImpl clSvc = new CruiseLineServiceImpl();
				PortsOfCallListVO portsOfCallListVO = clSvc.updatePCL(cruiseLinesNo, portOfCallNo, portOfCallSequence, portsOfCallListNo);
				CruiseLineVO cruiseLineVO = clSvc.selectCruiseNo(cruiseLinesNo);
				//抽出單艘船的資料
//				CruiseLineVO cruiseLineVO = clSvc.selectCruiseNo(cruiseLinesNo);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
				
				request.setAttribute("cruiseLineVO", cruiseLineVO);
                String url = "/back-end/cruiseline/cruiselineUpdate.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(request, response);
		}
			if ("insertPCL".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
			
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer portOfCallNo = Integer.valueOf(request.getParameter("portOfCallNo").trim());
				System.out.println("portOfCallNo="+portOfCallNo);
				Integer cruiseLineNo = Integer.valueOf(request.getParameter("cruiseLineNo").trim());
				System.out.println(cruiseLineNo);
				

				// Send the use back to the form, if there were errors
				
				/***************************2.開始修改資料*****************************************/
				CruiseLineServiceImpl clSvc = new CruiseLineServiceImpl();
				CruiseLineVO cruiseLineVO = clSvc.selectCruiseNo(cruiseLineNo);
				//抽出單艘船的資料
//				CruiseLineVO cruiseLineVO = clSvc.selectCruiseNo(cruiseLinesNo);
				Integer portOfCallSequence = clSvc.selectPortNameListLast(cruiseLineNo).getPortOfCallSequence() + 1;
				System.out.println(portOfCallSequence);
				PortsOfCallListVO portsOfCallListVO = clSvc.insertPCL(cruiseLineNo, portOfCallNo, portOfCallSequence);
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
				
				request.setAttribute("cruiseLineVO", cruiseLineVO);
                String url = "/back-end/cruiseline/cruiselineUpdate.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(request, response);
		}
		
		
	}

}

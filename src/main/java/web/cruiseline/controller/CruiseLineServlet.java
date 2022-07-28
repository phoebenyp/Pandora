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
		
		if ("updatePCL".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			request.setAttribute("errorMsgs", errorMsgs);
			
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer portsOfCallListNo = Integer.valueOf(request.getParameter("portsOfCallListNo"));
				Integer portOfCallNo = Integer.valueOf(request.getParameter("portOfCallNo"));
				Integer portOfCallSequence = Integer.valueOf(request.getParameter("portOfCallSequence"));
				Integer cruiseLinesNo = Integer.valueOf(request.getParameter("cruiseLinesNo"));
				System.out.println(portOfCallNo);
				PortsOfCallListVO portsOfCallListVO=new PortsOfCallListVO();
				portsOfCallListVO.setPortsOfCallListNo(portsOfCallListNo);
				portsOfCallListVO.setCruiseLinesNo(cruiseLinesNo);
				portsOfCallListVO.setPortOfCallNo(portOfCallNo);
				portsOfCallListVO.setPortOfCallSequence(portOfCallSequence);
//				portsOfCallListVO

				// Send the use back to the form, if there were errors
				
				/***************************2.開始修改資料*****************************************/
				CruiseLineServiceImpl clSvc = new CruiseLineServiceImpl();
				portsOfCallListVO = clSvc.updatePCL(cruiseLinesNo, portOfCallNo, portOfCallSequence, portsOfCallListNo);
				
				//抽出單艘船的資料
				CruiseLineVO cruiseLineVO = clSvc.selectCruiseNo(cruiseLinesNo);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/				
				
				request.setAttribute("cruiseLineVO", cruiseLineVO);
                String url = "/back-end/cruiseline/cruiselineUpdate.jsp";
				RequestDispatcher successView = request.getRequestDispatcher(url);   // 修改成功後,轉交回送出修改的來源網頁
				successView.forward(request, response);
		}
	}

}

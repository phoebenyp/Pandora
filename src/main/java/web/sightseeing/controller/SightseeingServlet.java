package web.sightseeing.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.cruiseline.bean.CruiseLineVO;
import web.cruiseline.service.impl.CruiseLineServiceImpl;

@WebServlet("/SightseeingServlet")
public class SightseeingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String action = request.getParameter("action");
//		
//		if("allCruiseLineNo".equals(action)) {
//			CruiseLineServiceImpl cSVC= new CruiseLineServiceImpl();
//			List<CruiseLineVO> result=cSVC.getCruiseLineALL();
//			List<String>  cruiseName = result.stream().map(vo -> vo.getCruiseLines()).collect(Collectors.toList());
//			List<Integer> cruiseNo = result.stream().map(vo -> vo.getCruiseLineNo()).collect(Collectors.toList());
//			
//			request.setAttribute("cruiseName", cruiseName);
//			request.setAttribute("cruiseNo", cruiseNo);
//			request.setAttribute("result", result);
//			RequestDispatcher successView = request.getRequestDispatcher("/front-end/sightseeing/sightseeing2.jsp"); // 成功轉交listEmps_ByCompositeQuery.jsp
//			successView.forward(request, response);
			Gson gson = new Gson();
			JsonObject respObj=new JsonObject();
			try {
				response.setContentType("application/json;charset=UTF-8");
				CruiseLineServiceImpl svc=new CruiseLineServiceImpl();
				List<CruiseLineVO> cruiseLineVO= svc.getCruiseLineALL();
//				respObj.add("cruiseLineVO", cruiseLineVO);
//				respObj.add("cruiseLineVO", cruiseLineVO);
				List<String>  cruiseName = cruiseLineVO.stream().map(vo -> vo.getCruiseLines()).collect(Collectors.toList());
				List<Integer> cruiseNo = cruiseLineVO.stream().map(vo -> vo.getCruiseLineNo()).collect(Collectors.toList());
				
				response.getWriter().print(cruiseName);
				response.getWriter().print(cruiseNo);
//				response.getWriter().print(cruiseLineVO);
			} catch (Exception e) {
				// TODO: handle exception
			}
//		}
	}

}

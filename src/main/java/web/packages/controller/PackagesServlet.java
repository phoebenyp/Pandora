package web.packages.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.emp.service.EmpService;
import web.emp.service.impl.EmpServiceImpl;
import web.packages.bean.PackagesVO;
import web.packages.service.PackagesService;
import web.packages.service.impl.PackagesServiceImpl;

@WebServlet("/PackagesServlet")
public class PackagesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println(action);
		if ("homePage".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			Map<String, String[]> map = req.getParameterMap();
			PackagesService packagesService = new PackagesServiceImpl();
			List<PackagesVO> packagesList = packagesService.getAll(map);

			req.setAttribute("packagesList", packagesList);
			RequestDispatcher successView = req.getRequestDispatcher("/front-end/package/homePage.jsp"); // 成功轉交listEmps_ByCompositeQuery.jsp
			successView.forward(req, resp);
		}
		if ("listPackagesByCompositeQuery".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			Map<String, String[]> map = req.getParameterMap();

			PackagesService packagesService = new PackagesServiceImpl();
			List<PackagesVO> packagesList = packagesService.getAll(map);
			List<String> departureDistinct = packagesList.stream().map(vo -> vo.getDeparture()).distinct()
					.collect(Collectors.toList());
			List<String> destinationDistint = packagesList.stream().map(vo -> vo.getDestination()).distinct()
					.collect(Collectors.toList());

			req.setAttribute("packagesList", packagesList);
			RequestDispatcher successView = req.getRequestDispatcher("/front-end/package/packagesSearch.jsp"); // 成功轉交listEmps_ByCompositeQuery.jsp
			successView.forward(req, resp);
		}

	}

}

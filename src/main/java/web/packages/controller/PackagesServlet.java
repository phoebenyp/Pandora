package web.packages.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import com.google.gson.Gson;
import com.google.protobuf.Timestamp;
import com.mysql.cj.x.protobuf.MysqlxCrud.UpdateOperation;

import web.emp.service.EmpService;
import web.emp.service.impl.EmpServiceImpl;
import web.packages.bean.PackagesVO;
import web.packages.service.PackagesService;
import web.packages.service.impl.PackagesServiceImpl;

@WebServlet("/PackagesServlet")
public class PackagesServlet extends HttpServlet {
	private Gson gson = new Gson();

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
			List<String> departureDistinct = packagesList.stream().map(vo -> vo.getDeparture()).distinct()
					.collect(Collectors.toList());
			List<String> destinationDistinct = packagesList.stream().map(vo -> vo.getDestination()).distinct()
					.collect(Collectors.toList());
			List<String> departureTimeDistinct = packagesList.stream()
					.map(vo -> vo.getDepartureTime().format(DateTimeFormatter.ofPattern("yyyy-MM"))).distinct()
					.collect(Collectors.toList());
			Integer count = packagesList.toArray().length;

			req.setAttribute("departureDistinct", departureDistinct);
			req.setAttribute("destinationDistinct", destinationDistinct);
			req.setAttribute("departureTimeDistinct", departureTimeDistinct);
			req.setAttribute("packagesList", packagesList);
			req.setAttribute("count", count);

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
			List<String> destinationDistinct = packagesList.stream().map(vo -> vo.getDestination()).distinct()
					.collect(Collectors.toList());
			List<String> departureTimeDistinct = packagesList.stream()
					.map(vo -> vo.getDepartureTime().format(DateTimeFormatter.ofPattern("yyyy-MM"))).distinct()
					.collect(Collectors.toList());
	
			Integer count = packagesList.toArray().length;
			System.out.println(packagesList);
			System.out.println(departureDistinct);
			System.out.println(departureTimeDistinct);

			req.setAttribute("departureDistinctB", departureDistinct);
			req.setAttribute("destinationDistinctB", destinationDistinct);
			req.setAttribute("departureTimeDistinctB", departureTimeDistinct);
			req.setAttribute("packagesListB", packagesList);
			req.setAttribute("count", count);
			System.out.println(count);
			RequestDispatcher successView = req.getRequestDispatcher("/front-end/package/packagesSearch.jsp"); // 成功轉交listEmps_ByCompositeQuery.jsp
			successView.forward(req, resp);
		}

		if ("updateOption".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			resp.setContentType("application/json;charset=utf-8");
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();

			Map<String, String[]> map = req.getParameterMap();
			PackagesService packagesService = new PackagesServiceImpl();
			List<PackagesVO> packagesList = packagesService.getAll(map);
			List<String> departureDistinct = packagesList.stream().map(vo -> vo.getDeparture()).distinct()
					.collect(Collectors.toList());
			List<String> destinationDistinct = packagesList.stream().map(vo -> vo.getDestination()).distinct()
					.collect(Collectors.toList());
			List<String> departureTimeDistinct = packagesList.stream()
					.map(vo -> vo.getDepartureTime().format(DateTimeFormatter.ofPattern("yyyy-MM"))).distinct()
					.collect(Collectors.toList());
			
			Map<String, List<String>> optionMap = new HashMap<>();
			optionMap.put("departureDistinct", departureDistinct);
			optionMap.put("destinationDistinct", destinationDistinct);
			optionMap.put("departureTimeDistinct", departureTimeDistinct);
		
			out.print(gson.toJson(optionMap));
			out.flush();

//			out.print(gson.toJson(departureDistinct));
//			System.out.println(gson.toJson(departureDistinct));
//			out.flush();
		}

	}

}

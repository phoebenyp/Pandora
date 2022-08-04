package web.packages.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.google.gson.JsonObject;
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
			List<String> packageNoList = packagesList.stream().map(vo -> vo.getPackageNo().toString())
					.collect(Collectors.toList());
			List<String> departureDistinct = packagesList.stream().map(vo -> vo.getDeparture()).distinct()
					.collect(Collectors.toList());
			List<String> destinationDistinct = packagesList.stream().map(vo -> vo.getDestination()).distinct()
					.collect(Collectors.toList());
			List<String> departureTimeDistinct = packagesList.stream()
					.map(vo -> vo.getDepartureTime().format(DateTimeFormatter.ofPattern("yyyy-MM"))).distinct()
					.collect(Collectors.toList());
			List<String> duration = packagesList.stream().map(vo -> vo.getDestination()).distinct()
					.collect(Collectors.toList());

			Integer count = packagesList.toArray().length;

			req.setAttribute("packageNoList", packageNoList);
			req.setAttribute("departureDistinct", departureDistinct);
			req.setAttribute("destinationDistinct", destinationDistinct);
			req.setAttribute("departureTimeDistinct", departureTimeDistinct);
			req.setAttribute("packagesList", packagesList);
			req.setAttribute("Duration", duration);
			req.setAttribute("count", count);
			System.out.println(departureDistinct);
			System.err.println(destinationDistinct);
			System.out.println(departureTimeDistinct);

//			System.out.println(duration);
			RequestDispatcher successView = req.getRequestDispatcher("/front-end/package/homePage.jsp"); // 成功轉交listEmps_ByCompositeQuery.jsp
			successView.forward(req, resp);
		}

//		if("clearBtn".equals(action)) {
//			String url = req.getContextPath() + ("/front-end/package/homePage.jsp");
//			
//			resp.sendRedirect("http://localhost:8080/PackagesServlet?action=homePage");
//		}

		if ("listPackagesByCompositeQuery".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			Map<String, String[]> map = req.getParameterMap();
			PackagesService packagesService = new PackagesServiceImpl();

			for (String i : map.keySet()) {
				System.out.println("我是KEY" + i + ":" + map.get(i));
				for (String j : map.get(i)) {
					System.out.println("我是Vaule:" + j);
				}
			}

			List<PackagesVO> packagesList = packagesService.getAll(map);
			List<String> packageNoList = packagesList.stream().map(vo -> vo.getPackageNo().toString())
					.collect(Collectors.toList());
			List<String> departureDistinct = packagesList.stream().map(vo -> vo.getDeparture()).distinct()
					.collect(Collectors.toList());
			List<String> destinationDistinct = packagesList.stream().map(vo -> vo.getDestination()).distinct()
					.collect(Collectors.toList());
			List<String> departureTimeDistinct = packagesList.stream()
					.map(vo -> vo.getDepartureTime().format(DateTimeFormatter.ofPattern("yyyy-MM"))).distinct()
					.collect(Collectors.toList());
			List<String> duration = packagesList.stream().map(vo -> vo.getDuration().toString()).distinct()
					.collect(Collectors.toList());

			Integer count = packagesList.toArray().length;

			System.out.println("Servlet:listPackagesByCompositeQuery");
			System.out.println(departureDistinct);
			System.out.println(departureTimeDistinct);
			System.out.println(duration);

			req.setAttribute("departureDistinct", departureDistinct);
			req.setAttribute("destinationDistinct", destinationDistinct);
			req.setAttribute("departureTimeDistinct", departureTimeDistinct);
			req.setAttribute("packagesList", packagesList);
			req.setAttribute("Duration", duration);
			req.setAttribute("count", count);
//			req.setAttribute("listPackagesByCompositeQuery",packagesService);

//			System.out.println(count);
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
			Map<String, List<String>> optionMap = new HashMap<>();
			if (packagesList.size() == 0) {
				List<String> data = new ArrayList<>();
				optionMap.put("size", data);
				packagesList = (List<PackagesVO>) req.getSession().getAttribute("lastQuery");
			} else {
				req.getSession().setAttribute("lastQuery", packagesList);
			}
			List<String> packageNoList = packagesList.stream().map(vo -> vo.getPackageNo().toString())
					.collect(Collectors.toList());
			List<String> departureDistinct = packagesList.stream().map(vo -> vo.getDeparture()).distinct()
					.collect(Collectors.toList());
			List<String> destinationDistinct = packagesList.stream().map(vo -> vo.getDestination()).distinct()
					.collect(Collectors.toList());
			List<String> departureTimeDistinct = packagesList.stream()
					.map(vo -> vo.getDepartureTime().format(DateTimeFormatter.ofPattern("yyyy-MM"))).distinct()
					.collect(Collectors.toList());
			List<String> duration = packagesList.stream().map(vo -> vo.getDuration().toString()).distinct()
					.collect(Collectors.toList());
			System.out.println("天數:"+duration);

			optionMap.put("packageNoList", packageNoList);
			optionMap.put("departureDistinct", departureDistinct);
			optionMap.put("destinationDistinct", destinationDistinct);
			optionMap.put("departureTimeDistinct", departureTimeDistinct);
								
			
			optionMap.put("Duration", duration);

			if (!optionMap.containsKey("size")) {
				List<String> data = new ArrayList<>();

				for (int i = 0; i < packagesList.size(); i++) {
					data.add(String.valueOf(i));

					optionMap.put("size", data);
				}

			}

			

			out.print(gson.toJson(optionMap));
			out.flush();

//			out.print(gson.toJson(departureDistinct));
//			System.out.println(gson.toJson(departureDistinct));
//			out.flush();
		}

	}

}

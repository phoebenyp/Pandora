package web.sightseeing.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import web.cruiseline.bean.PortNameListVO;
import web.cruiseline.service.impl.CruiseLineServiceImpl;

@WebServlet("/PortSelect")
public class PortSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	Gson gs = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");

		BufferedReader read = request.getReader();
		String json = read.readLine();
		// 不建議使用
		Map<Object, String> map = gs.fromJson(json, new TypeToken<Map<String, String>>() {
		}.getType());
		Integer cruiselineNo= Integer.valueOf(map.get("item").trim());
//		System.out.println(cruiselineNo);
		CruiseLineServiceImpl svc = new CruiseLineServiceImpl();
		List<PortNameListVO> result = svc.getCruisePortAll(cruiselineNo);
		List<Integer> portOfCallNo = result.stream().map(vo -> vo.getPortOfCallNo()).collect(Collectors.toList());
		List<String> portName = result.stream().map(vo -> vo.getPortName()).collect(Collectors.toList());
		response.getWriter().print(portName);
		response.getWriter().print(portOfCallNo);

	}

}

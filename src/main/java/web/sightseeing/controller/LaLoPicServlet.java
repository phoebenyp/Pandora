package web.sightseeing.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
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

import web.port.service.impl.PortServiceImpl;
import web.sightseeing.bean.SightseeingMarkVO;
import web.sightseeing.service.impl.SightseeingMarkServiceImpl;
@WebServlet("/LaLoPicServlet")
public class LaLoPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gs = new Gson();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");

		BufferedReader read = request.getReader();
		String json = read.readLine();
		// 不建議使用
		Map<Object, String> map = gs.fromJson(json, new TypeToken<Map<String, String>>() {
		}.getType());
		Integer portNo= Integer.valueOf(map.get("port"));
//		System.out.println(portNo);
		PortServiceImpl svc= new PortServiceImpl();
		BigDecimal la=(BigDecimal)(svc.getPortOne(portNo).getSightseeingLatitude());
		BigDecimal lo=(BigDecimal)(svc.getPortOne(portNo).getSightseeingLongitude());
		SightseeingMarkServiceImpl sMsvc=new SightseeingMarkServiceImpl();
		List<SightseeingMarkVO> getPic=sMsvc.getPic(portNo);
		List<String> sightseeingMarkPicture= getPic.stream().map(vo -> vo.getSightseeingMarkPicture()).collect(Collectors.toList());
		
		
		response.getWriter().print(la);
		response.getWriter().print(" ");
		response.getWriter().print(lo);
//		response.getWriter().print(" ");
//		response.getWriter().print(sightseeingMarkPicture);
		for(String str:sightseeingMarkPicture) {
//			System.out.println(str);
			response.getWriter().print(" ");
			response.getWriter().print(str);
		}
	}

}

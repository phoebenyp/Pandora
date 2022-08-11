package web.packages.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.cruiseline.bean.CruiseLineVO;
import web.packages.bean.PackagesVO;

@WebServlet("/PackageImageServlet")
public class PackageImageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String action = req.getParameter("action");
		
		if ("packageImages".equals(action)) {
			resp.setContentType("image/jpeg");
			ServletOutputStream out;
			out = resp.getOutputStream();
			
			PackagesVO packagesVO = (PackagesVO) (req.getAttribute("packageImage"));
			out.write(packagesVO.getPackageImages());
		}
		
		if ("cruiseImages".equals(action)) {
			resp.setContentType("image/jpeg");
			ServletOutputStream out;
			out = resp.getOutputStream();
			
			CruiseLineVO cruiseLineVO = (CruiseLineVO) (req.getAttribute("cruiseLinePicture"));
			out.write(cruiseLineVO.getCruiseLinePicture());
		}
			
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
}

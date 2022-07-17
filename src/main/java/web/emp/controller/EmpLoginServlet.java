package web.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import web.emp.bean.EmpVO;

import web.emp.service.EmpService;
import web.emp.service.impl.EmpServiceImpl;

@WebServlet("/EmpLoginServlet")
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getContextPath());

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("EMPLogin".equals(action)) {

			String email = req.getParameter("email");
			String password = req.getParameter("password");

			System.out.println("email:" + email);
			System.out.println("password:" + password);

			EmpVO slectEmpVO = new EmpVO();
			slectEmpVO.setEmail(email);
			slectEmpVO.setPassword(password);
			EmpService empService = new EmpServiceImpl();
			EmpVO empVO = empService.selectByEmailAndPassword(slectEmpVO);
			req.getSession().setAttribute("empVO", empVO);

			if (empVO != null) {
				String url = "/EMP_HomePage.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, resp);
			} else {
				req.setAttribute("errorMsg", "帳號密碼錯誤");
				RequestDispatcher failView = req.getRequestDispatcher("/EMP_login.jsp");
				failView.forward(req, resp);
			}
		}

		if ("EMPSignOut".equals(action)) {
			String url =req.getContextPath()+"/EMP_login.jsp";
			req.getSession().invalidate();
			resp.sendRedirect(url);

		}

	}

}

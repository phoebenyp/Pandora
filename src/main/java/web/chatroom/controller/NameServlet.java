package web.chatroom.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main/chat")
public class NameServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userName = req.getParameter("userName");
		if (userName.trim().isEmpty() || userName == null){
			req.setAttribute("userName", userName);		
			RequestDispatcher dispatcher = req.getRequestDispatcher("/front-end/customerService/customerService.jsp");
			dispatcher.forward(req, res);
			return;
		}else {
			req.setAttribute("userName", userName);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/front-end/customerService/customerServiceMes.jsp");
			dispatcher.forward(req, res);
		}
	}
}

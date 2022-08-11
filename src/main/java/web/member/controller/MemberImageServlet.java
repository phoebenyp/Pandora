package web.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.member.bean.MemberVO;
import web.member.service.MemberService;
import web.member.service.impl.MemberServiceImpl;


@WebServlet("/MemberImageServlet")
public class MemberImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberImageServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("memberImage".equals(action)) {
			response.setContentType("image/jpeg");
			ServletOutputStream out;
			out = response.getOutputStream();
			HttpSession session = request.getSession();
			MemberVO memberVO = (MemberVO) (session.getAttribute("loginMember"));
			out.write(memberVO.getMemberPictureId());
		}

		if ("memberVOUpdate".equals(action)) {
			response.setContentType("image/jpeg");
			ServletOutputStream out;
			out = response.getOutputStream();
			MemberService service = new MemberServiceImpl();
			System.out.println(request.getParameter("memberId"));
			MemberVO memberVO = service.getOneMember(Integer.valueOf(request.getParameter("memberId")));

			out.write(memberVO.getMemberPictureId());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

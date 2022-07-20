package web.emp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.cj.result.LocalDateTimeValueFactory;

import web.emp.bean.EmpVO;

import web.emp.service.EmpService;
import web.emp.service.impl.EmpServiceImpl;

@WebServlet("/EmpLoginServlet")
@MultipartConfig
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
			System.out.println(empService);
			EmpVO empVO = empService.selectByEmailAndPassword(slectEmpVO);
			
			System.out.println(empVO);
			req.getSession().setAttribute("empVO", empVO);
			
			

			if (empVO != null) {
				String url = "/EMP_HomePage.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, resp);
				return;
			} else {
				req.setAttribute("errorMsg", "帳號密碼錯誤");
				RequestDispatcher failView = req.getRequestDispatcher("/EMP_login.jsp");
				failView.forward(req, resp);
				return;
			}
		}

		if ("EMPSignOut".equals(action)) {
			String url = req.getContextPath() + "/EMP_login.jsp";
			req.getSession().invalidate();
			resp.sendRedirect(url);

		}

		if ("EMPAdd".equals(action)) {
			String url = req.getContextPath() + "/EMP_Register.jsp";
			List<String> errorMsgs = new LinkedList<String>();
//			 Store this set in the request scope, in case we need to
//			send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			Part fileEmpPictureId = req.getPart("empPictureId"); // Retrieves <input type="file" name="empPictureId">
			byte[] empPictureId = fileEmpPictureId.getInputStream().readAllBytes();

			String englishFirstName = req.getParameter("englishFirstName");
			String englishFirstNameReg = "[A-Za-z]{1,50}";
			if (englishFirstName == null || englishFirstName.trim().length() == 0) {
				errorMsgs.add("英文姓名: 請勿空白");
			} else if (!englishFirstName.trim().matches(englishFirstNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("英文姓名: 只能是英文字母");
			}

			String englishLastName = req.getParameter("englishLastName");
			String englishLastNameReg = "[A-Za-z]{1,50}";
			if (englishLastName == null || englishLastName.trim().length() == 0) {
				errorMsgs.add("英文姓氏: 請勿空白");
			} else if (!englishLastName.trim().matches(englishLastNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("英文姓氏: 只能是英文字母");
			}

			String jobLevels = req.getParameter("jobLevels");
			if (jobLevels == null || jobLevels.trim().length() == 0) {
				errorMsgs.add("職位請勿空白");
			}

			String gender = req.getParameter("gender");

			LocalDate empBirthday = java.sql.Date.valueOf(req.getParameter("empBirthday")).toLocalDate();

			if (empBirthday == null) {
				errorMsgs.add("請輸入日期");
			}
//			if(empBirthday==null || empBirthday.toLocaleString().trim().length() == 0) {
//				 errorMsgs.add("請輸入日期");
//			 }
//			try {
//				empBirthday = java.sql.Date.valueOf(req.getParameter("EMP_Birthady").trim());
//			} catch (IllegalArgumentException e) {
//				empBirthday = new java.sql.Date(System.currentTimeMillis());
//				errorMsgs.add("請輸入日期!");
//			}

			String passportNo = req.getParameter("passportNo");
			String passportNoReg = "^[0-9]{9}$";
			if (passportNo == null || passportNo.trim().length() == 0) {
				errorMsgs.add("護照號碼: 請勿空白");
			} else if (!passportNo.trim().matches(passportNoReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("護照號碼: 請輸入9碼的數字");
			}

			String email = req.getParameter("email");
			String emailReg = "^([a-zA-Z0-9_\\-.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
			if (email == null || email.trim().length() == 0) {
				errorMsgs.add("Email: 請勿空白");
			} else if (!email.trim().matches(emailReg)) {
				errorMsgs.add("Email: 格式輸入錯誤");
			}

			System.out.println(req.getParameter("startDate"));
			LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));

			if (startDate == null) {
				errorMsgs.add("請輸入日期!");
			}

			LocalDate resignationDate = null;

//			java.sql.Timestamp resignationDate = null;
//			resignationDate = java.sql.Timestamp.valueOf(req.getParameter("Resignation_Date").trim());
			String empAddress = req.getParameter("empAddress");
			if (empAddress == null || empAddress.trim().length() == 0) {
				errorMsgs.add("地址:請勿空白");
			}

			String password = "a1234";
			String status = "1";

			String empCellphoneNo = req.getParameter("empCellphoneNo");
			String empCellphoneNoReg = "^[0-9]{10}$";
			if (empCellphoneNo == null || empCellphoneNo.trim().length() == 0) {
				errorMsgs.add("地址:請勿空白");
			} else if (!empCellphoneNo.trim().matches(empCellphoneNoReg)) {
				errorMsgs.add("手機號碼:請輸入10碼的數字 ");
			}

			LocalDateTime lastModificationDate = LocalDateTime.now();
			LocalDateTime loginTime = null;

			EmpVO empVO = new EmpVO();
			empVO.setEmpPictureId(empPictureId);
			empVO.setEnglishLastName(englishLastName);
			empVO.setEnglishFirstName(englishFirstName);
			empVO.setJobLevels(jobLevels);
			empVO.setGender(gender);
			empVO.setEmpBirthday(empBirthday);
			empVO.setPassportNo(passportNo);
			empVO.setEmail(email);
			empVO.setStartDate(startDate);
			empVO.setResignationDate(resignationDate);
			empVO.setPassword(password);
			empVO.setEmpCellphoneNo(empCellphoneNo);
			empVO.setEmpAddress(empAddress);
			empVO.setStatus(status);
			empVO.setLastModificationDate(lastModificationDate);
			empVO.setLoginTime(loginTime);
//			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {

				req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
				
				RequestDispatcher failureView = req.getRequestDispatcher("/EMP_Register.jsp");
				failureView.forward(req, resp);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			EmpServiceImpl empSvc = new EmpServiceImpl();
			empVO = empSvc.addEmp(empVO);

		}

	}

}

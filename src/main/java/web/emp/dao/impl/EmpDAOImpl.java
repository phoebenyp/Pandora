package web.emp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.emp.bean.EmpVO;
import web.emp.dao.EmpDAO;

public class EmpDAOImpl implements EmpDAO {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO Employee(empPictureId,englishLastName,englishFirstName,jobLevels,gender,empBirthday,passportNo,"
			+ "email,startDate,resignationDate,password,empCellphoneNo,empAddress,status,lastModificationDate,loginTime)  "
			+ "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?,?)";
	private static final String GET_ALL_STMT = "SELECT (employeeId,empPictureId,englishLastName,englishFirstName,jobLevels,gender,empBirthday,passportNo,"
			+ "email,startDate,resignationDate,password,empCellphoneNo,empAddress,status,lastModificationDate,loginTime) "
			+ "FROM Pandora order by employeeId";
	private static final String GET_ONE_STMT = "SELECT (employeeId,empPictureId,englishLastName,englishFirstName,jobLevels,gender,empBirthday,passportNo,"
			+ "email,startDate,resignationDate,password,empCellphoneNo,empAddress,status,lastModificationDate,loginTime)"
			+ " FROM Pandora where employeeId = ?";
	private static final String DELETE = "DELETE FROM Pandora where employeeId = ?";
	private static final String UPDATE = "UPDATE Pandora set (empPictureId=?,englishLastName=?,englishFirstName=?,jobLevels=?,gender=?,empBirthday=?,passportNo=?,email=?,startDate=?,resignationDate=?,password=?,empCellphoneNo=?,empAddress=?,status=?,lastModificationDate=?,loginTime=?) where employeeId = ?";

	@Override
	public void insert(EmpVO empVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setBytes(1, empVO.getEmpPictureId());
			pstmt.setString(2, empVO.getEnglishLastName());
			pstmt.setString(3, empVO.getEnglishFirstName());
			pstmt.setString(4, empVO.getJobLevels());
			pstmt.setString(5, empVO.getGender());
			pstmt.setDate(6, Date.valueOf(empVO.getEmpBirthday()));
			pstmt.setString(7, empVO.getPassportNo());
			pstmt.setString(8, empVO.getEmail());
			pstmt.setTimestamp(9, Timestamp.valueOf(empVO.getStartDate()));
			pstmt.setTimestamp(10, Timestamp.valueOf(empVO.getResignationDate()));
			pstmt.setString(11, empVO.getPassword());
			pstmt.setInt(12, empVO.getEmpCellphoneNo());
			pstmt.setString(13, empVO.getEmpAddress());
			pstmt.setString(14, empVO.getStatus());
			pstmt.setTimestamp(15, Timestamp.valueOf(empVO.getLastModificationDate()));
			pstmt.setTimestamp(16, Timestamp.valueOf(empVO.getLoginTime()));
			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(EmpVO empVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setBytes(1, empVO.getEmpPictureId());
			pstmt.setString(2, empVO.getEnglishLastName());
			pstmt.setString(3, empVO.getEnglishFirstName());
			pstmt.setString(4, empVO.getJobLevels());
			pstmt.setString(5, empVO.getGender());
			pstmt.setDate(6, Date.valueOf(empVO.getEmpBirthday()));
			pstmt.setString(7, empVO.getPassportNo());
			pstmt.setString(8, empVO.getEmail());
			pstmt.setTimestamp(9, Timestamp.valueOf(empVO.getStartDate()));
			pstmt.setTimestamp(9, Timestamp.valueOf(empVO.getResignationDate()));
			pstmt.setString(10, empVO.getPassword());
			pstmt.setInt(11, empVO.getEmpCellphoneNo());
			pstmt.setString(12, empVO.getEmpAddress());
			pstmt.setString(13, empVO.getStatus());
			pstmt.setTimestamp(14, Timestamp.valueOf(empVO.getLastModificationDate()));
			pstmt.setTimestamp(15, Timestamp.valueOf(empVO.getLoginTime()));
			pstmt.setInt(16, empVO.getEmployeeId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer employeeId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, employeeId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public EmpVO findByPrimaryKey(Integer employeeId) {

		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, employeeId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				empVO = new EmpVO();
				empVO.setEmployeeId(rs.getInt("EmployeeId"));
				empVO.setEmpPictureId(rs.getBytes("empPictureId"));
				empVO.setEnglishLastName(rs.getString("englishLastName"));
				empVO.setEnglishFirstName(rs.getString("englishFirstName"));
				empVO.setJobLevels(rs.getString("jobLevels"));
				empVO.setGender(rs.getString("gender"));
				empVO.setEmpBirthday(rs.getDate("empBirthday").toLocalDate());
				empVO.setPassportNo(rs.getString("passportNo"));
				empVO.setEmail(rs.getString("email"));
				empVO.setStartDate(rs.getTimestamp("startDate").toLocalDateTime());
				empVO.setResignationDate(rs.getTimestamp("resignationDate").toLocalDateTime());
				empVO.setPassword(rs.getString("password"));
				empVO.setEmpCellphoneNo(rs.getInt("empCellphoneNo"));
				empVO.setEmpAddress(rs.getString("empAddress"));
				empVO.setStatus(rs.getString("status"));
				empVO.setLastModificationDate(rs.getTimestamp("lastModificationDate").toLocalDateTime());
				empVO.setLoginTime(rs.getTimestamp("loginTime").toLocalDateTime());

			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO empVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				empVO = new EmpVO();
				empVO.setEmployeeId(rs.getInt("EmployeeId"));
				empVO.setEmpPictureId(rs.getBytes("empPictureId"));
				empVO.setEnglishLastName(rs.getString("englishLastName"));
				empVO.setEnglishFirstName(rs.getString("englishFirstName"));
				empVO.setJobLevels(rs.getString("jobLevels"));
				empVO.setGender(rs.getString("gender"));
				empVO.setEmpBirthday(rs.getDate("empBirthday").toLocalDate());
				empVO.setPassportNo(rs.getString("passportNo"));
				empVO.setEmail(rs.getString("email"));
				empVO.setStartDate(rs.getTimestamp("startDate").toLocalDateTime());
				empVO.setResignationDate(rs.getTimestamp("resignationDate").toLocalDateTime());
				empVO.setPassword(rs.getString("password"));
				empVO.setEmpCellphoneNo(rs.getInt("empCellphoneNo"));
				empVO.setEmpAddress(rs.getString("empAddress"));
				empVO.setStatus(rs.getString("status"));
				empVO.setLastModificationDate(rs.getTimestamp("lastModificationDate").toLocalDateTime());
				empVO.setLoginTime(rs.getTimestamp("loginTime").toLocalDateTime());
				list.add(empVO);
				// Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public EmpVO selectByEmailAndPassword(EmpVO empVO) {

		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn
						.prepareStatement("select * from Employee where Email=? and Password=?");) {

			pstmt.setString(1, empVO.getEmail());
			pstmt.setString(2, empVO.getPassword()); // 1跟2 為第幾個問號
			System.out.println(empVO);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					EmpVO resultEmpVO = new EmpVO();
					resultEmpVO.setEmployeeId(rs.getInt("Employee_Id"));
					resultEmpVO.setEmpPictureId(rs.getBytes("EMP_Picture_Id"));
					resultEmpVO.setEnglishFirstName(rs.getString("English_First_Name"));
					resultEmpVO.setEnglishLastName(rs.getString("English_Last_Name"));
					resultEmpVO.setJobLevels(rs.getString("Job_Levels"));
					resultEmpVO.setGender(rs.getString("Gender"));
					resultEmpVO.setEmpBirthday(rs.getDate("EMP_Birthday").toLocalDate());
					resultEmpVO.setPassportNo(rs.getString("Passport_No"));
					resultEmpVO.setEmail(rs.getString("Email"));
					resultEmpVO.setStartDate(rs.getTimestamp("Start_Date").toLocalDateTime());
					if (rs.getTimestamp("Resignation_Date") != null) {
						resultEmpVO.setResignationDate(rs.getTimestamp("Resignation_Date").toLocalDateTime());
					}

					resultEmpVO.setPassword(rs.getNString("Password"));
					resultEmpVO.setEmpCellphoneNo(rs.getInt("EMP_Cellphone_No"));
					resultEmpVO.setEmpAddress(rs.getString("EMP_Address"));
					resultEmpVO.setStatus(rs.getString("Status"));
					resultEmpVO.setLastModificationDate(rs.getTimestamp("Last_Modification_Date").toLocalDateTime());
					resultEmpVO.setLoginTime(rs.getTimestamp("Login_Time").toLocalDateTime());

					return resultEmpVO;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}

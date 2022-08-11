package web.cruiseline.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.cruiseline.bean.CruiseLineVO;
import web.cruiseline.dao.CruiseLineDAO;

public class CruiseLineDAOImpl implements CruiseLineDAO {
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String SELECT_ALL ="SELECT Cruise_Line_No,Cruise_Lines,Cruise_Line_Picture,Time "
			+ "FROM Cruise_Line ORDER BY Cruise_Line_No ASC";
	private static final String SELECT_No ="SELECT Cruise_Line_No,Cruise_Lines,Cruise_Line_Picture,Time"
			+ " FROM Cruise_Line WHERE Cruise_Line_No = ?";
	private static final String SELECT_LAST ="SELECT Cruise_Line_No,Cruise_Lines,Cruise_Line_Picture,Time"
			+ " FROM Cruise_Line ORDER BY Cruise_Line_No DESC LIMIT 1";
	private static final String UPDATE = "UPDATE Cruise_Line SET Cruise_Lines = ? , Cruise_Line_Picture = ? , Time = ? "
			+ " WHERE Cruise_Line_No = ?";
	private static final String UPDATE_UNPIC = "UPDATE Cruise_Line SET Cruise_Lines = ? ,Time = ?"
			+ " WHERE Cruise_Line_No = ?";
	private static final String UPDATE_CLNAME = "UPDATE Cruise_Line SET Cruise_Lines = ? "
			+ " WHERE Cruise_Line_No = ?";
	private static final String INSERT = "INSERT INTO Cruise_Line(Cruise_Lines,Cruise_Line_Picture,Time)"
			+ " VALUES(? , ? , ?)";
	private static final String DELETE = "DELETE FROM Cruise_Line WHERE Cruise_Line_No = ? ";
	@Override
	public List<CruiseLineVO> getAll() {
		List<CruiseLineVO> list = new ArrayList<CruiseLineVO>();
		CruiseLineVO cruiseLineVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cruiseLineVO = new CruiseLineVO();
				cruiseLineVO.setCruiseLineNo(rs.getInt("Cruise_Line_No"));
				cruiseLineVO.setCruiseLines(rs.getString("Cruise_Lines"));
				cruiseLineVO.setCruiseLinePicture(rs.getBytes("Cruise_Line_Picture"));
				cruiseLineVO.setTime(rs.getDate("Time").toLocalDate());
				list.add(cruiseLineVO);
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public CruiseLineVO selectNo(Integer cruiseLineNo) {
		CruiseLineVO cruiseLineVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_No);
			pstmt.setInt(1, cruiseLineNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cruiseLineVO = new CruiseLineVO();
				cruiseLineVO.setCruiseLineNo(rs.getInt("Cruise_Line_No"));
				cruiseLineVO.setCruiseLines(rs.getString("Cruise_Lines"));
				cruiseLineVO.setCruiseLinePicture(rs.getBytes("Cruise_Line_Picture"));
				cruiseLineVO.setTime(rs.getDate("Time").toLocalDate());
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
		return cruiseLineVO;
	}
	@Override
	public CruiseLineVO selectLast() {
		CruiseLineVO cruiseLineVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_LAST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cruiseLineVO = new CruiseLineVO();
				cruiseLineVO.setCruiseLineNo(rs.getInt("Cruise_Line_No"));
				cruiseLineVO.setCruiseLines(rs.getString("Cruise_Lines"));
				cruiseLineVO.setCruiseLinePicture(rs.getBytes("Cruise_Line_Picture"));
				cruiseLineVO.setTime(rs.getDate("Time").toLocalDate());
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
		return cruiseLineVO;
	}
	@Override
	public void update(CruiseLineVO cruiseLineVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, cruiseLineVO.getCruiseLines());
			pstmt.setBytes(2, cruiseLineVO.getCruiseLinePicture());
			pstmt.setDate(3 ,Date.valueOf(cruiseLineVO.getTime()));
			pstmt.setInt(4, cruiseLineVO.getCruiseLineNo());
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
	public void updateUNPic(CruiseLineVO cruiseLineVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_UNPIC);
			pstmt.setString(1, cruiseLineVO.getCruiseLines());
			pstmt.setDate(2 ,Date.valueOf(cruiseLineVO.getTime()));
			pstmt.setInt(3, cruiseLineVO.getCruiseLineNo());
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
	public void updateCLName(CruiseLineVO cruiseLineVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_CLNAME);
			pstmt.setString(1, cruiseLineVO.getCruiseLines());
			pstmt.setInt(2, cruiseLineVO.getCruiseLineNo());
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
	public void insert(CruiseLineVO cruiseLineVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			pstmt.setString(1, cruiseLineVO.getCruiseLines());
			pstmt.setBytes(2, cruiseLineVO.getCruiseLinePicture());
			pstmt.setDate(3, Date.valueOf(cruiseLineVO.getTime()));
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
	public void delete(Integer cruiseLineNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, cruiseLineNo);
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

}

package web.ship.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.ship.bean.RoomTypeTotalCountVO;
import web.ship.dao.RoomTypeTotalCountDAO;

public class RoomTypeTotalCountDAOImpl implements RoomTypeTotalCountDAO {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String SELECT_NO ="SELECT Room_Type_No,Max_Count_of_Room_Type "
			+ "FROM Room_Type_Total_Count where Ship_No = ?";
	private static final String INSERT_STMT = "INSERT INTO Room_Type_Total_Count(Ship_No,Room_Type_No,Max_Count_of_Room_Type)"
			+ "VALUES ( ?, ?, ?)";
	private static final String INSERT_LAST = "INSERT INTO Room_Type_Total_Count(Ship_No)"
			+ "VALUES ( ?)";
	private static final String DELETE = "DELETE FROM Room_Type_Total_Count where RTTC_No = ?";
	private static final String UPDATE = "UPDATE Room_Type_Total_Count set Ship_No=?,Room_Type_No=?,Max_Count_of_Room_Type=? where RTTC_No = ?";
	
	@Override
	public List<RoomTypeTotalCountVO> selectNo(Integer shipNo) {
		List<RoomTypeTotalCountVO> list =new ArrayList<RoomTypeTotalCountVO>();
		RoomTypeTotalCountVO roomTypeTotalCountVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_NO);

			pstmt.setInt(1, shipNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				roomTypeTotalCountVO = new RoomTypeTotalCountVO();
				pstmt.setInt(1, roomTypeTotalCountVO.getrTTCNo());
				pstmt.setInt(2, roomTypeTotalCountVO.getShipNo());
				pstmt.setInt(3, roomTypeTotalCountVO.getRoomTypeNo());
				pstmt.setInt(4, roomTypeTotalCountVO.getMaxCountOfRoomType());

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
	public void insertLast(Integer ShipNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_LAST);
			pstmt.setInt(1, ShipNo);
			
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
	public void insert(RoomTypeTotalCountVO roomTypeTotalCountVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, roomTypeTotalCountVO.getShipNo());
			pstmt.setInt(2, roomTypeTotalCountVO.getRoomTypeNo());
			pstmt.setInt(3, roomTypeTotalCountVO.getMaxCountOfRoomType());
			
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
	public void update(RoomTypeTotalCountVO roomTypeTotalCountVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setInt(1, roomTypeTotalCountVO.getShipNo());
			pstmt.setInt(2, roomTypeTotalCountVO.getRoomTypeNo());
			pstmt.setInt(3, roomTypeTotalCountVO.getMaxCountOfRoomType());
			pstmt.setInt(4, roomTypeTotalCountVO.getrTTCNo());
			
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
	public void delete(Integer shipNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, shipNo);
			
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

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

import web.ship.bean.RoomTotalVO;
import web.ship.dao.RoomTotalDAO;

public class RoomTotalDAOImpl implements RoomTotalDAO {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String SELECT_ONLY ="SELECT  RTTC_No,Ship_No,Room_Type_No,Room_Type,Max_Count_of_Room_Type"
			+ " FROM Room_Total WHERE (Ship_No= ? ) AND (Room_Type_No = ? )";
	private static final String SELECT_RTTC ="SELECT  RTTC_No,Ship_No,Room_Type_No,Room_Type,Max_Count_of_Room_Type"
			+ " FROM Room_Total WHERE RTTC_No= ?";
	private static final String SELECT_RTTC_LAST ="SELECT  RTTC_No,Ship_No,Room_Type_No,Room_Type,Max_Count_of_Room_Type"
			+ " FROM Room_Total ORDER BY RTTC_No DESC LIMIT 1";
	private static final String SELECT_SHIP_ALL ="SELECT  RTTC_No,Ship_No,Room_Type_No,Room_Type,Max_Count_of_Room_Type"
			+ " FROM Room_Total WHERE Ship_No = ? ORDER BY RTTC_No ,Ship_No ASC";
	
	//指定其中的遊輪下的房型
	@Override
	public RoomTotalVO selectOnly(Integer shipNo,Integer roomTypeNo) {

		RoomTotalVO roomTotalVO = new RoomTotalVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONLY);
			
			pstmt.setInt(1, shipNo);
			pstmt.setInt(2, roomTypeNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				roomTotalVO = new RoomTotalVO();
				roomTotalVO.setrTTCNo(rs.getInt("RTTC_No"));
				roomTotalVO.setShipNo(rs.getInt("Ship_No"));
				roomTotalVO.setRoomTypeNo(rs.getInt("Room_Type_No"));
				roomTotalVO.setRoomType(rs.getString("Room_Type"));
				roomTotalVO.setMaxCountOfRoomType(rs.getInt("Max_Count_of_Room_Type"));
				
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return roomTotalVO;
	}
	
	//選擇最新新增房型數量資料
	@Override
	public RoomTotalVO selectLast() {

		RoomTotalVO roomTotalVO = new RoomTotalVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_RTTC_LAST);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				roomTotalVO = new RoomTotalVO();
				roomTotalVO.setrTTCNo(rs.getInt("RTTC_No"));
				roomTotalVO.setShipNo(rs.getInt("Ship_No"));
				roomTotalVO.setRoomTypeNo(rs.getInt("Room_Type_No"));
				roomTotalVO.setRoomType(rs.getString("Room_Type"));
				roomTotalVO.setMaxCountOfRoomType(rs.getInt("Max_Count_of_Room_Type"));
				
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return roomTotalVO;
	}
	
	//列出所有房型數量資料
	@Override
	public List<RoomTotalVO> getShipAll(Integer shipNo) {
		List<RoomTotalVO> list = new ArrayList<RoomTotalVO>();
		RoomTotalVO roomTotalVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_SHIP_ALL);
			pstmt.setInt(1, shipNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				roomTotalVO = new RoomTotalVO();
				roomTotalVO.setrTTCNo(rs.getInt("RTTC_No"));
				roomTotalVO.setShipNo(rs.getInt("Ship_No"));
				roomTotalVO.setRoomTypeNo(rs.getInt("Room_Type_No"));
				roomTotalVO.setRoomType(rs.getString("Room_Type"));
				roomTotalVO.setMaxCountOfRoomType(rs.getInt("Max_Count_of_Room_Type"));
//				pstmt.setInt(1, roomTotalVO.getrTTCNo());
//				pstmt.setInt(2, roomTotalVO.getShipNo());
//				pstmt.setInt(3, roomTotalVO.getRoomTypeNo());
//				pstmt.setString(4, roomTotalVO.getRoomType());
//				pstmt.setInt(5, roomTotalVO.getMaxCountOfRoomType());
				list.add(roomTotalVO);
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
	
	//搜尋指定郵輪房型資料
	@Override
	public RoomTotalVO getRTTC(Integer rTTCNo) {
		RoomTotalVO roomTotalVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_RTTC);
			pstmt.setInt(1, rTTCNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				roomTotalVO = new RoomTotalVO();
				roomTotalVO.setrTTCNo(rs.getInt("RTTC_No"));
				roomTotalVO.setShipNo(rs.getInt("Ship_No"));
				roomTotalVO.setRoomTypeNo(rs.getInt("Room_Type_No"));
				roomTotalVO.setRoomType(rs.getString("Room_Type"));
				roomTotalVO.setMaxCountOfRoomType(rs.getInt("Max_Count_of_Room_Type"));
				
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
		return roomTotalVO;
	}
	
	
}

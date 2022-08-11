package web.ship.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.ship.bean.ShipsVO;
import web.ship.dao.ShipsDAO;

public class ShipsDAOImpl implements ShipsDAO {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String SELECT_ONE ="SELECT Ship_No,Ship_Name,Star_Status,Last_maintenance_Time,Floor_of_Ship,Ship_Status_No FROM Ships WHERE Ship_No = ?";
	private static final String INSERT_STMT = "INSERT INTO Ships(Ship_Name,Star_Status,Last_maintenance_Time,Floor_of_Ship,Ship_Status_No)"
			+ " VALUES (?, ?, ?, ?, ?)";
	private static final String DELETE = "DELETE FROM Ships where Ship_No = ?";
	private static final String UPDATE = "UPDATE Ships set Ship_Name=?,Star_Status=?,Last_maintenance_Time=?,Floor_of_Ship=?,Ship_Status_No=? where Ship_No = ?";
	private static final String SELECT_LAST ="SELECT Ship_No,Ship_Name,Star_Status,Last_maintenance_Time,Floor_of_Ship,Ship_Status_No FROM Pandora.Ships ORDER BY Ship_No DESC LIMIT 1";
	@Override
	public ShipsVO selectLast() {//選擇最新新增的郵輪資料
		ShipsVO shipsVO = new ShipsVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_LAST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shipsVO = new ShipsVO();
				shipsVO.setShipNo(rs.getInt("Ship_No"));
				shipsVO.setShipName(rs.getString("Ship_Name"));
				shipsVO.setStarStatus(rs.getDate("Star_Status"));
				shipsVO.setLastmaintenanceTime(rs.getDate("Last_maintenance_Time"));
				shipsVO.setFloorOfShip(rs.getInt("Floor_of_Ship"));
				shipsVO.setShipStatusNo(rs.getInt("Ship_Status_No"));
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
		return shipsVO;
	}
	@Override
	public ShipsVO findSpipNo(Integer shipNo) {//指定其中一艘郵輪
		ShipsVO shipsVO = new ShipsVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE);
			pstmt.setInt(1, shipNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shipsVO = new ShipsVO();
				shipsVO.setShipNo(rs.getInt("Ship_No"));
				shipsVO.setShipName(rs.getString("Ship_Name"));
				shipsVO.setStarStatus(rs.getDate("Star_Status"));
				shipsVO.setLastmaintenanceTime(rs.getDate("Last_maintenance_Time"));
				shipsVO.setFloorOfShip(rs.getInt("Floor_of_Ship"));
				shipsVO.setShipStatusNo(rs.getInt("Ship_Status_No"));
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
		return shipsVO;
	}
	@Override
	public void insert(ShipsVO shipsVO) {//新增郵輪
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, shipsVO.getShipName());
			pstmt.setDate(2, shipsVO.getStarStatus());
			pstmt.setDate(3, shipsVO.getLastmaintenanceTime());
			pstmt.setInt(4, shipsVO.getFloorOfShip());
			pstmt.setInt(5, shipsVO.getShipStatusNo());
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
	public void update(ShipsVO shipsVO) {//更新郵輪
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, shipsVO.getShipName());
			pstmt.setDate(2, shipsVO.getStarStatus());
			pstmt.setDate(3, shipsVO.getLastmaintenanceTime());
			pstmt.setInt(4, shipsVO.getFloorOfShip());
			pstmt.setInt(5, shipsVO.getShipStatusNo());
			pstmt.setInt(6, shipsVO.getShipNo());
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

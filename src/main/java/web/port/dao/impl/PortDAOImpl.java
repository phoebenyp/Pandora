package web.port.dao.impl;

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

import web.port.bean.PortVO;
import web.port.dao.PortDAO;

public class PortDAOImpl implements PortDAO {
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO Employee(portName,portLatitude,portLongitude,sightseeing,sightseeingLatitude,sightseeingLongitude)"
			+ "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?,?, ?, ?,?)";
//	private static final String GET_ALL_STMT = "SELECT (portOfCallNo,portName,portLatitude,portLongitude,sightseeing,sightseeingLatitude,sightseeingLongitude) "
//			+ "FROM Port order by portOfCallNo";
//	private static final String GET_ALL_STMT = "SELECT (Port_of_Call_No,Port_Name,Port_Latitude,Port_Longitude,Sightseeing,Sightseeing_Latitude,Sightseeing_Longitude) "
//			+ "FROM Port order by Port_of_Call_No";
	private static final String GET_ALL_STMT = "SELECT * "
			+ "FROM Port";
	private static final String GET_ONE_STMT = "SELECT (portOfCallNo,portName,portLatitude,portLongitude,sightseeing,sightseeingLatitude,sightseeingLongitude)"
			+ " FROM Pandora where portOfCallNo = ?";
	private static final String DELETE = "DELETE FROM Pandora where portOfCallNo = ?";
	private static final String UPDATE = "UPDATE Pandora set (portName=?,portLatitude=?,portLongitude=?,sightseeing=?,sightseeingLatitude=?,sightseeingLongitude=?) where portOfCallNo = ?";
		
	@Override
	public void insert(PortVO portVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, portVO.getPortOfCallNo());
			pstmt.setBigDecimal(2, portVO.getPortLatitude());
			pstmt.setBigDecimal(3, portVO.getPortLongitude());
			pstmt.setString(4, portVO.getSightseeing());
			pstmt.setBigDecimal(5, portVO.getSightseeingLatitude());
			pstmt.setBigDecimal(6, portVO.getPortLongitude());
			
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
	public void update(PortVO portVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setInt(1, portVO.getPortOfCallNo());
			pstmt.setBigDecimal(2, portVO.getPortLatitude());
			pstmt.setBigDecimal(3, portVO.getPortLongitude());
			pstmt.setString(4, portVO.getSightseeing());
			pstmt.setBigDecimal(5, portVO.getSightseeingLatitude());
			pstmt.setBigDecimal(6, portVO.getPortLongitude());
			
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
	public void delete(Integer portOfCallNo) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, portOfCallNo);
			
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
	public PortVO findByPrimaryKey(Integer portOfCallNo) {

		PortVO portVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, portOfCallNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				portVO = new PortVO();
				pstmt.setInt(1, portVO.getPortOfCallNo());
				pstmt.setBigDecimal(2, portVO.getPortLatitude());
				pstmt.setBigDecimal(3, portVO.getPortLongitude());
				pstmt.setString(4, portVO.getSightseeing());
				pstmt.setBigDecimal(5, portVO.getSightseeingLatitude());
				pstmt.setBigDecimal(6, portVO.getPortLongitude());

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
		return portVO;
	}
	
	@Override
	public List<PortVO> getAll() {
		List<PortVO> list = new ArrayList<PortVO>();
		PortVO portVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				portVO = new PortVO();
				portVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				portVO.setPortName(rs.getString("Port_Name"));
				portVO.setPortLatitude(rs.getBigDecimal("Port_Latitude"));
				portVO.setPortLongitude( rs.getBigDecimal("Port_Longitude"));
				portVO.setSightseeing(rs.getString("Sightseeing"));
				portVO.setSightseeingLatitude(rs.getBigDecimal("Sightseeing_Latitude"));
				portVO.setSightseeingLongitude( rs.getBigDecimal("Sightseeing_Longitude"));
				list.add(portVO);
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
	
}

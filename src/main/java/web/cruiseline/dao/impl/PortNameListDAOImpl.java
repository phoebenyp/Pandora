package web.cruiseline.dao.impl;

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

import web.cruiseline.bean.PortNameListVO;
import web.cruiseline.dao.PortNameListDAO;

public class PortNameListDAOImpl implements PortNameListDAO {
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String SELECT_ALL ="SELECT Ports_of_Call_List_No,Cruise_Lines_No,Port_of_Call_No,Port_Name,Port_of_Call_Sequence "
			+ "FROM port_name_list WHERE Cruise_Lines_No= ? ORDER BY Port_of_Call_Sequence ASC";
	private static final String SELECT_ONE ="SELECT Ports_of_Call_List_No,Cruise_Lines_No,Port_of_Call_No,Port_Name,Port_of_Call_Sequence FROM port_name_list "
			+ "WHERE Cruise_Lines_No= ? AND Port_of_Call_Sequence = ? ORDER BY Cruise_Lines_No,Port_of_Call_Sequence ASC";
	private static final String SELECT_LAST ="SELECT Ports_of_Call_List_No,Cruise_Lines_No,Port_of_Call_No,Port_Name,Port_of_Call_Sequence FROM port_name_list "
			+ "WHERE Cruise_Lines_No= ? ORDER BY Port_of_Call_Sequence DESC LIMIT 1";
	private static final String SELECT_LAST_SECOND ="SELECT Ports_of_Call_List_No,Cruise_Lines_No,Port_of_Call_No,Port_Name,Port_of_Call_Sequence FROM port_name_list "
			+ "WHERE Cruise_Lines_No= ? ORDER BY Port_of_Call_Sequence DESC LIMIT 1,1";
	private static final String SELECT_FIRST ="SELECT Ports_of_Call_List_No,Cruise_Lines_No,Port_of_Call_No,Port_Name,Port_of_Call_Sequence FROM port_name_list "
			+ "WHERE Cruise_Lines_No= ? ORDER BY Port_of_Call_Sequence ASC LIMIT 1";
	
	@Override
	public List<PortNameListVO> getAll(Integer portsOfCallListNo) {
		List<PortNameListVO> list = new ArrayList<PortNameListVO>();
		PortNameListVO portNameListVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL);
			pstmt.setInt(1, portsOfCallListNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				portNameListVO = new PortNameListVO();
				portNameListVO.setPortsOfCallListNo(rs.getInt("Ports_of_Call_List_No"));
				portNameListVO.setCruiseLinesNo(rs.getInt("Cruise_Lines_No"));
				portNameListVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				portNameListVO.setPortName(rs.getString("Port_Name"));
				portNameListVO.setPortOfCallSequence(rs.getInt("Port_of_Call_Sequence"));
				list.add(portNameListVO);
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
	public PortNameListVO selectOne(Integer portsOfCallListNo,Integer portOfCallSequence) {
		PortNameListVO portNameListVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ONE);
			pstmt.setInt(1, portsOfCallListNo);
			pstmt.setInt(2, portOfCallSequence);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				portNameListVO = new PortNameListVO();
				portNameListVO.setPortsOfCallListNo(rs.getInt("Ports_of_Call_List_No"));
				portNameListVO.setCruiseLinesNo(rs.getInt("Cruise_Lines_No"));
				portNameListVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				portNameListVO.setPortName(rs.getString("Port_Name"));
				portNameListVO.setPortOfCallSequence(rs.getInt("Port_of_Call_Sequence"));
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
		return portNameListVO;
	}
	
	@Override
	public PortNameListVO selectLast(Integer portsOfCallListNo) {
		PortNameListVO portNameListVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_LAST);
			pstmt.setInt(1, portsOfCallListNo);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				portNameListVO = new PortNameListVO();
				portNameListVO.setPortsOfCallListNo(rs.getInt("Ports_of_Call_List_No"));
				portNameListVO.setCruiseLinesNo(rs.getInt("Cruise_Lines_No"));
				portNameListVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				portNameListVO.setPortName(rs.getString("Port_Name"));
				portNameListVO.setPortOfCallSequence(rs.getInt("Port_of_Call_Sequence"));
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
		return portNameListVO;
	}
	
	@Override
	public PortNameListVO selectLastSecond(Integer portsOfCallListNo) {
		PortNameListVO portNameListVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_LAST_SECOND);
			pstmt.setInt(1, portsOfCallListNo);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				portNameListVO = new PortNameListVO();
				portNameListVO.setPortsOfCallListNo(rs.getInt("Ports_of_Call_List_No"));
				portNameListVO.setCruiseLinesNo(rs.getInt("Cruise_Lines_No"));
				portNameListVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				portNameListVO.setPortName(rs.getString("Port_Name"));
				portNameListVO.setPortOfCallSequence(rs.getInt("Port_of_Call_Sequence"));
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
		return portNameListVO;
	}
	
	@Override
	public PortNameListVO selectFirst(Integer portsOfCallListNo) {
		PortNameListVO portNameListVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_FIRST);
			pstmt.setInt(1, portsOfCallListNo);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				portNameListVO = new PortNameListVO();
				portNameListVO.setPortsOfCallListNo(rs.getInt("Ports_of_Call_List_No"));
				portNameListVO.setCruiseLinesNo(rs.getInt("Cruise_Lines_No"));
				portNameListVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				portNameListVO.setPortName(rs.getString("Port_Name"));
				portNameListVO.setPortOfCallSequence(rs.getInt("Port_of_Call_Sequence"));
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
		return portNameListVO;
	}
}

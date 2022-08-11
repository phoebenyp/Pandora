package web.cruiseline.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.cruiseline.bean.PortsOfCallListVO;
import web.cruiseline.dao.PortsOfCallListDAO;

public class PortsOfCallListDAOImpl implements PortsOfCallListDAO {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT="INSERT INTO Ports_of_Call_List(Cruise_Lines_No,Port_of_Call_No,Port_of_Call_Sequence) values (?,?,?)";
	private static final String UPDATE="UPDATE Ports_of_Call_List SET Cruise_Lines_No = ?,Port_of_Call_No = ?,Port_of_Call_Sequence = ? where Ports_of_Call_List_No = ?";
	private static final String DELETE="DELETE FROM Ports_of_Call_List WHERE Ports_of_Call_List_No = ?";
	private static final String DELETE_ALL="DELETE FROM Ports_of_Call_List WHERE Cruise_Lines_No = ?";
	@Override
	public void insert(PortsOfCallListVO portsOfCallListVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, portsOfCallListVO.getCruiseLinesNo());
			pstmt.setInt(2, portsOfCallListVO.getPortOfCallNo());
			pstmt.setInt(3, portsOfCallListVO.getPortOfCallSequence());
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
	public void update(PortsOfCallListVO portsOfCallListVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setInt(1, portsOfCallListVO.getCruiseLinesNo());
			pstmt.setInt(2, portsOfCallListVO.getPortOfCallNo());
			pstmt.setInt(3, portsOfCallListVO.getPortOfCallSequence());
			pstmt.setInt(4 ,portsOfCallListVO.getPortsOfCallListNo());
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
	public void delete(Integer portsOfCallListNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, portsOfCallListNo);
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
	public void deleteAll(Integer cruise_Lines_No) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_ALL);
			pstmt.setInt(1, cruise_Lines_No);
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

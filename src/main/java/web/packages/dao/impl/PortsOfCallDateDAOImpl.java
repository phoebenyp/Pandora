package web.packages.dao.impl;

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

import web.packages.bean.PackagesVO;
import web.packages.bean.PortsOfCallDateVO;
import web.packages.dao.PortsOfCallDateDAO;

public class PortsOfCallDateDAOImpl implements PortsOfCallDateDAO {

	private static DataSource ds = null;

	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String getAllportsOfCallDate ="SELECT * FROM Ports_of_Call_Date";
	@Override
	public List<PortsOfCallDateVO> getAll() {

		List<PortsOfCallDateVO> list = new ArrayList<PortsOfCallDateVO>();
		PortsOfCallDateVO portsOfCallDateVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
			try {
			 con = ds.getConnection();
			 pstmt = con.prepareStatement(getAllportsOfCallDate);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				portsOfCallDateVO = new PortsOfCallDateVO();
				portsOfCallDateVO.setPortsOfCallDateNo(rs.getInt("Ports_of_Call_date_No"));
				portsOfCallDateVO.setPackageNo(rs.getInt("Package_No"));
				portsOfCallDateVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				portsOfCallDateVO.setDepartureTime(rs.getTimestamp("Departure_Time").toLocalDateTime());
				portsOfCallDateVO.setArrivalTime(rs.getTimestamp("Arrival_Time").toLocalDateTime());
				
				list.add(portsOfCallDateVO);
				
			}
								
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
package web.packages.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import web.cruiseline.bean.PortsOfCallListVO;
import web.packages.dao.PortsOfCallListDAO2;
import web.port.bean.PortVO;

public class PortsOfCallListDAOImpl2 implements PortsOfCallListDAO2 {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String getAllPortsOfCallList = " SELECt * FROM Ports_of_Call_List  WHERE Cruise_Lines_No=? ORDER BY Port_of_Call_Sequence";
	private static final String getPortsMap = "  SELECt Port_of_Call_No,Port_Name FROM Port ";

	@Override
	public List<PortsOfCallListVO> getByCruiseLineNo(Integer cruiseLineNo) {

		List<PortsOfCallListVO> list = new ArrayList<PortsOfCallListVO>();
		PortsOfCallListVO portsOfCallListVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(getAllPortsOfCallList);
			pstmt.setInt(1,cruiseLineNo);
			rs = pstmt.executeQuery();
           
			while (rs.next()) {
				portsOfCallListVO = new PortsOfCallListVO();
				portsOfCallListVO.setPortsOfCallListNo(rs.getInt("Ports_of_Call_List_No"));
				portsOfCallListVO.setCruiseLinesNo(rs.getInt("Cruise_Lines_No"));
				portsOfCallListVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				portsOfCallListVO.setPortOfCallSequence(rs.getInt("Port_of_Call_Sequence"));

				list.add(portsOfCallListVO);

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

	@Override
	public Map<Integer, String> getPortMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(getPortsMap);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				PortVO portVO = new PortVO();
				portVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				portVO.setPortName(rs.getString("Port_Name"));
	
				map.put(portVO.getPortOfCallNo(),portVO.getPortName());
//				map.put(rs.getInt("Port_of_Call_No"),rs.getString("Port_Name"));
			
			}
		}
		catch (SQLException se) {
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
		return map;
	}


}

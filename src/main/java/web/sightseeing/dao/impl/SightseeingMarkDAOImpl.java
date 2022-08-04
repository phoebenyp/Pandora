package web.sightseeing.dao.impl;

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

import web.sightseeing.bean.SightseeingMarkVO;

public class SightseeingMarkDAOImpl {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private String GET_PIC = "SELECT Sightseeing_Mark_No,Port_of_Call_No,Sightseeing_Mark_Picture FROM Pandora.Sightseeing_Mark WHERE Port_of_Call_No = ?;";

	
	public List<SightseeingMarkVO> getPic(Integer portOfCallNo) {
		List<SightseeingMarkVO> list = new ArrayList<SightseeingMarkVO>();
		SightseeingMarkVO sightseeingMarkVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_PIC);
			pstmt.setInt(1, portOfCallNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				sightseeingMarkVO = new SightseeingMarkVO();
				sightseeingMarkVO.setSightseeingMarkNo(rs.getInt("Sightseeing_Mark_No"));
				sightseeingMarkVO.setPortOfCallNo(rs.getInt("Port_of_Call_No"));
				sightseeingMarkVO.setSightseeingMarkPicture(rs.getString("Sightseeing_Mark_Picture"));
				list.add(sightseeingMarkVO);
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
}

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

import web.ship.bean.ShipStatusVO;
import web.ship.dao.ShipStatusDAO;

public class ShipStatusDAOImpl implements ShipStatusDAO {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String SELECT_ALL ="SELECT Ship_Status_No,Ship_Status FROM Ship_Status";
	@Override
	public List<ShipStatusVO> getAll() {
		List<ShipStatusVO> list = new ArrayList<ShipStatusVO>();
		ShipStatusVO shipStatusVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				shipStatusVO = new ShipStatusVO();
				shipStatusVO.setShipStatusNo(rs.getInt("Ship_Status_No"));;
				shipStatusVO.setShipStatus(rs.getString("Ship_Status"));;
				list.add(shipStatusVO);
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

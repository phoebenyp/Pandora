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

import web.ship.bean.ShipTotalVO;
import web.ship.dao.ShipTotalDAO;

public class ShipTotalDAOImpl implements ShipTotalDAO {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String GET_ALL_STMT = "SELECT Ship_No,Ship_Name,Star_Status,Last_maintenance_Time,Room_Total,Total,Floor_of_Ship,Ship_Status"
			+ " FROM Ship_Total";
	@Override
	public List<ShipTotalVO> getAll() {//列出所有房型數量資料
		List<ShipTotalVO> list = new ArrayList<ShipTotalVO>();
		ShipTotalVO shipTotalVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				shipTotalVO = new ShipTotalVO();
				shipTotalVO.setShipNo(rs.getInt("Ship_No"));
				shipTotalVO.setShipName(rs.getString("Ship_Name"));
				shipTotalVO.setStarStatus(rs.getDate("Star_Status"));
				shipTotalVO.setLastMaintenanceTime(rs.getDate("Last_maintenance_Time"));
				shipTotalVO.setRoomTotal(rs.getInt("Room_Total"));
				shipTotalVO.setTotal(rs.getInt("Total"));
				shipTotalVO.setFloorOfShip(rs.getInt("Floor_of_Ship"));
				shipTotalVO.setShipStatus(rs.getString("Ship_Status"));
				list.add(shipTotalVO);
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
package web.getBookedRoom.dao.impl;

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

import web.getBookedRoom.dao.GetBookedRoomDAO;
import web.room.joinbean.GetBookedRoomVO;

public class GetBookedRoomDAOImpl implements GetBookedRoomDAO {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String FINDBOOKEDROOM = "select Room_No from Order_Detail od join Packages p on od.Package_No = p.package_No join Room_List rl on od.Room_List_No = rl.Room_List_No where od.package_No = ?";

	@Override
	public List<GetBookedRoomVO> findByPackageNo(int packageNo) {

		List<GetBookedRoomVO> list = new ArrayList<GetBookedRoomVO>();
		GetBookedRoomVO bookedRoomNo = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(FINDBOOKEDROOM);
			pstmt.setInt(1, packageNo);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bookedRoomNo = new GetBookedRoomVO();
				bookedRoomNo.setBookedRoomNo(rs.getString("Room_No"));
				list.add(bookedRoomNo);

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

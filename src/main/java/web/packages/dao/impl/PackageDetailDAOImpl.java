package web.packages.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import web.packages.bean.PackageDetailVO;
import web.packages.bean.PackagesVO;
import web.packages.dao.PackageDetailDAO;
import web.util.packages_CompositeQuery;

public class PackageDetailDAOImpl implements PackageDetailDAO {

	private static DataSource ds = null;	
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Pandora");
			
		}catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String GET_ONE_STMT = "SELECT * FROM package_detail WHERE Package_No=? order by Arrival_Time";
	
	@Override
	public List<PackageDetailVO> findByPackageNo(Integer packageNo) {
		System.out.println("我是形成編號"+packageNo);
		List<PackageDetailVO> packageDetailVOList = new ArrayList<>();
		PackageDetailVO packageDetailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = ds.getConnection();		        
			pstmt = con.prepareStatement(GET_ONE_STMT);
			System.out.println(GET_ONE_STMT);
			pstmt.setInt(1, packageNo);
			rs = pstmt.executeQuery();
			
				while (rs.next()) {
					packageDetailVO = new PackageDetailVO();
					packageDetailVO.setPackageNo(rs.getInt("Package_No"));
					packageDetailVO.setPackageName(rs.getString("Package_Name"));
					packageDetailVO.setPackageImages(rs.getBytes("Package_images"));
					packageDetailVO.setShipNo(rs.getInt("Ship_No"));
					packageDetailVO.setCruiseLineNo(rs.getInt("Cruise_Lines_No"));
					packageDetailVO.setDuration(rs.getInt("Duration"));
					packageDetailVO.setRegistrationStartTime(rs.getDate("Registration_Start_Time").toLocalDate());
					packageDetailVO.setRegistrationDeadTime(rs.getDate("Registration_Dead_Time").toLocalDate());
					packageDetailVO.setPortName(rs.getString("Port_Name"));
					packageDetailVO.setPortOfCallNo(rs.getInt("Port_Of_Call_No"));
					packageDetailVO.setPortsOfCallListNo(rs.getInt("Ports_Of_Call_List_No"));
					if(rs.getTimestamp("Departure_Time")!=null) {
						packageDetailVO.setDepartureTime(rs.getTimestamp("Departure_Time").toLocalDateTime());
					}
					
					if(rs.getTimestamp("Arrival_Time")!=null) {
						packageDetailVO.setArrivalTime(rs.getTimestamp("Arrival_Time").toLocalDateTime());
					}
					
					packageDetailVOList.add(packageDetailVO);
					
				}
			System.out.println("我是SIZE"+packageDetailVOList.size());
			System.out.println("我是VO"+packageDetailVO);
			}catch (SQLException se) {
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
		
		
		return packageDetailVOList;

	}




}

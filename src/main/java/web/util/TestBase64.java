package web.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class TestBase64 {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/Pandora?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "password";
	
	
	private static final String SQL = "UPDATE Sightseeing_Mark SET Sightseeing_Mark_Picture = ? "
			+ "WHERE Sightseeing_Mark_No = ? ";
	public static void main(String[] args) {
		String base64_prefix="data:image/png;base64,";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(SQL);
			// 1. setBlob (JDBC 4.0 / JDK 6)
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing1.png"));
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing2.png"));
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing3.png"));
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing5.png"));
			pstmt.setInt(2, 4);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing6.png"));
			pstmt.setInt(2, 5);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing7.png"));
			pstmt.setInt(2, 6);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing8.png"));
			pstmt.setInt(2, 7);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing9.png"));
			pstmt.setInt(2, 8);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing10.png"));
			pstmt.setInt(2, 9);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing11.png"));
			pstmt.setInt(2, 10);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing12.png"));
			pstmt.setInt(2, 11);
			pstmt.executeUpdate();
			pstmt.setString(1, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing13.png"));
			pstmt.setInt(2, 12);
			pstmt.executeUpdate();
			System.out.println("新增成功");

		} catch (Exception ce) {
			System.out.println(ce);
		}  finally {
			// 依建立順序關閉資源 (越晚建立越早關閉)
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					System.out.println(se);
				}
			}
		}
	}
	
	 /**
     * 將本地圖片轉成 base64 字串
     * @param filePath 本地檔案的位置
     * @return
     */
    public static String LocalImgToBase64(String filePath) {
        System.out.println("filePath:" + filePath);
        if (filePath == null) {
            return null;
        }
        File file = new File(filePath);
        ByteArrayOutputStream out = null;
        try {
            FileInputStream in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] b = new byte[2048];
            int i = 0;
            while ((i = in.read(b)) != -1) {
                out.write(b, 0, b.length);
            }
            out.close();
            in.close();
            // java.util.Base64.getEncoder().encodeToString ==》對位元組陣列Base64編碼
            return Base64.getEncoder().encodeToString(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    } 
//    public String local_change(String file){
//        //字首
//        String base64_prefix="data:image/png;base64,";
//        //base64字串/Pandora/src/main/webapp/images/cruiseline1.jpg
//        String base64_str = LocalImgToBase64(file);
//        //圖片完整的編碼
//        String base64_file=base64_prefix+base64_str;
//        //列印
//        System.out.println("本地圖片base完整字串:"+"\n"+base64_file);
//        return base64_file;
//    }
    

}

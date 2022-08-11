package web.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

public class TestAddBase64 {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/Pandora?serverTimezone=Asia/Taipei";
	public static final String USER = "root";
	public static final String PASSWORD = "password";
	private static final String INSERT = "INSERT INTO Sightseeing_Mark(Port_of_Call_No,Sightseeing_Mark_Picture) VALUES (?,?)";
	public static void main(String[] args) {
		String base64_prefix="data:image/png;base64,";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, 1);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing4.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 1);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing14.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 1);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing15.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 2);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing16.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 2);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing17.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 2);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing18.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 3);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing19.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 3);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing20.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 3);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing21.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 4);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing22.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 4);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing23.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 4);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing24.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 4);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing25.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 3);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing26.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 2);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing27.png"));
			pstmt.executeUpdate();
			pstmt.setInt(1, 1);
			pstmt.setString(2, base64_prefix+LocalImgToBase64("src/main/webapp/images/sightseeing28.png"));
			pstmt.executeUpdate();
			System.out.println("新增完成");
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
}

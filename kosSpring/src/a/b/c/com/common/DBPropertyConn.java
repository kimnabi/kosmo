package a.b.c.com.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;


public abstract class DBPropertyConn {

	// Connection 연결하는 함수 만들기 
	public static Connection getConnection() {
		
		String path = "C:\\00.KOSMO129\\30.web\\el_kos_spring_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosSpring\\WEB-INF\\classes";
		///kosSpring/src/db.properties
		Connection conn = null;
		
		try {
			
			FileReader fr = new FileReader(path + "/" + "db.properties");
			Properties prop = new Properties();			
			prop.load(fr);
			
			// DataSource 정보 : 데이터베이스 연결 정보
			String JDBC_DRIVER = prop.getProperty("driver");
			String JDBC_URL = prop.getProperty("url");
			String JDBC_USER = prop.getProperty("username");
			String JDBC_PASSWORD = prop.getProperty("password");
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);	
			
		}catch(Exception e) {
			System.out.println("데이터베이스 연결에 문제가 있서요 >>> : " + e.getMessage());
		}
				
		return conn;		
	}
	
	// select
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs) {
		try{
			if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}			
	}
		
	// insert, update, delete 
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		try{
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}			
	}	
}

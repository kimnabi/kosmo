package a.b.c.com.common;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import org.sqlite.SQLiteConnection;



public class SQLitelTest {
	
	//
	public static void main(String[] args) {
		//데이타베이스연결
		Connection conn = null;
		//mysql 데이타베이스 객체 로딩하기( 동적로딩)
		try {
			//Class.forName("com.mysql.cj.jdbc");
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String paw ="admin1234";
			String mySqlUrl ="jdbc:mysql://localhost:3306/member";
			//mysql 연결정보를
			conn=DriverManager.getConnection(mySqlUrl, user, paw);
			String sql ="SELECT * FROM remember";
			
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 ResultSet rs=pstmt.executeQuery();
			 ResultSetMetaData rsmd= rs.getMetaData();
			 
			 System.out.printf("%s \t %s \t %s \t %s \t %s \\t %s \t %s \n",rsmd.getColumnName(1),rsmd.getColumnName(2),rsmd.getColumnName(3), rsmd.getColumnName(4), rsmd.getColumnName(5), rsmd.getColumnName(6), rsmd.getColumnName(7));
			 while(rs.next()) {
				 //mid, mpw, mname, memail, mtel, mloc, mdate
				 String mid =rs.getString("mid"); 
				 String mpw =rs.getString("mpw"); 
				 String mname =rs.getString("mname"); 
				 String memail =rs.getString("memail"); 
				 String mtel =rs.getString("mtel"); 
				 String mloc =rs.getString("mloc"); 
				 String mdate =rs.getString("mdate"); 
				 //출력
				 System.out.printf("%s %s %s %s %s %s %s \n",mid, mpw, mname, memail, mtel, mloc, mdate);
			 }
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}

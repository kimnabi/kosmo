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



public class MySqlTest2 {
	
	//
	public static void main(String[] args) {
		//데이타베이스연결
		Connection conn = null;
		//	mysql 데이베이스 드라이버 클래스 만 ( 동적로딩):의존성 주입
		try {
			//Class.forName("com.mysql.cj.jdbc");
			Class.forName("com.mysql.jdbc.Driver");
			String user = "my_user";
			String paw ="1234";
			String mySqlUrl ="jdbc:mysql://localhost:3306/example?useSSL=false&amp;autoReconnection=true";
			//mysql 연결정보를
			conn=DriverManager.getConnection(mySqlUrl, user, paw);
			String sql ="SELECT * FROM items";
			
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 ResultSet rs=pstmt.executeQuery();
			 ResultSetMetaData rsmd= rs.getMetaData();
			 
			 System.out.printf("%s \t %s \t %s \t \n",rsmd.getColumnName(1),rsmd.getColumnName(2),rsmd.getColumnName(3));
			 while(rs.next()) {
				  //item_id ,name,price
				 String itemId =rs.getString("item_id"); 
				 String name =rs.getString("name"); 
				 String price =rs.getString("price"); 
				 
				 //출력
				 System.out.printf("%s %s %s \n",itemId, name,price);
			 }
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn != null)
				        conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}

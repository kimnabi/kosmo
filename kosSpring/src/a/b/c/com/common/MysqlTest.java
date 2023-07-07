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



public class MysqlTest {
	
	//
	public static void main(String[] args) {
		//데이타베이스연결
		Connection conn = null;
		//sqllite 데이타베이스 객체 로딩하기( 동적로딩) 의존성 주입
		try {
			Class.forName("org.sqlite.JDBC");
			// sqlLite 파일 위치
			String SqlfileURl ="C:\\00.KOSMO129\\22.SqlLite\\test.sqlite";
			
			conn=DriverManager.getConnection("jdbc:sqlite:" +SqlfileURl);
			String sql ="SELECT item_id,name,price FROM items";
			
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 ResultSet rs=pstmt.executeQuery();
			 
			 while(rs.next()) {
				 
				 String name =rs.getString("name"); 
				 String price =rs.getString("price"); 
				 //출력
				 System.out.println(name+":"+price);
			 }
		} catch (ClassNotFoundException | SQLException e) {
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

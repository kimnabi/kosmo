package a.b.c.com.common;


import java.sql.Connection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


public class MongoTest {
	
	//
	public static void main(String[] args) {
		//데이타베이스연결
		Connection conn = null;
		//mysql 데이타베이스 객체 생성
	
			//Class.forName("com.mysql.cj.jdbc");
			//date 클래스 deprecation 불구하고   계속 사용함- calender 클래스
			String ip = "localhost";
			int port = 27017;
			MongoClient client = new MongoClient(new ServerAddress(ip,port));
			//conn=DriverManager.getConnection(mySqlUrl, user, paw);
			
			@SuppressWarnings("deprecation")
			DB db =client.getDB("local");
	        DBCollection db2 =  db.getCollection("person");
	         db2.find();
	         DBCursor cur =db2.find();
	         while(cur.hasNext()) {
	        	 
	        	 DBObject obj=cur.next();
	        	 System.out.println(obj);
	         }
		
		
		
	}
}

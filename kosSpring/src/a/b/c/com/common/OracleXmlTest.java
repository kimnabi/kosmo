package a.b.c.com.common;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;



public class OracleXmlTest {
	
	public static boolean xmlParse(String fileName, String xmlVal){
		boolean bool = false;
		String path = "C:\\00.KOSMO129\\30.web\\el_kos_spring_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosSpring\\kos_rss";
		FileWriter fw = null;
		try {
				if(xmlVal != null && xmlVal.length() >0) {
					//파일을 저장하기위해
					
					fw = new FileWriter(path+"/"+fileName);
					fw.write(xmlVal);
					bool =true;
					fw.close();
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bool = false;
		}
		return bool;
	}

	public static String getDBtoXml(String tableName) {
		//디비연결
		Connection conn =DBPropertyConn.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="SELECT * FROM "+tableName;
		int colCount =0;
		StringBuffer strBuffer = new StringBuffer();
		try {
			pstmt =conn.prepareStatement(sql);
			//데이타를 받아온다
			rs = pstmt.executeQuery();
			ResultSetMetaData rsMd =rs.getMetaData();
			colCount = rsMd.getColumnCount();
			//xml 템플릿를 만든다
			strBuffer.append("\n");	
			strBuffer.append("<" +  tableName.toUpperCase() + ">");		
			strBuffer.append("\n");
			while(rs.next()) {
				strBuffer.append("\n");
				for(int i =0; i< colCount;i++) {
					strBuffer.append(	"<"+rsMd.getColumnName(i+1)+">"+rs.getString(i+1)+"<"+rsMd.getColumnName(i+1)+">");// 컬럼 헤더 정보 제외
					strBuffer.append("\n\t");
				}
		    } //end while 
			strBuffer.append("<" +  tableName.toUpperCase() + ">");
			strBuffer.append("\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBPropertyConn.conClose(conn,pstmt,rs);
		}
		return strBuffer.toString();
	}
	public static void main(String[] args) {
		try{					
			Scanner sc = new Scanner(System.in);
			System.out.println("테이블 이름을 KEY-IN 하시오 >>> : ");
			String tableName = sc.next();
			
			OracleXmlTest ot_1 = new OracleXmlTest();
			if(tableName.length() > 0){		
				String str = ot_1.getDBtoXml(tableName);
				if(str != null && str.length() >0) {
					//파일을 저장하기위해
					
				}
				System.out.println( str);
			}else{	
				System.out.println("java OracleXmlTest 테이블이름 ");
			}				
		}catch(Exception e){
			System.out.println("e.getMessage() >>> : " + e.getMessage());
		}	
	}
}

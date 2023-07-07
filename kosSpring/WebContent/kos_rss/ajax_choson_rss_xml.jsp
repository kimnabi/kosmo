<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.io.BufferedReader" %>
<%@ page import = "java.io.InputStreamReader" %>
<%@ page import = "java.net.URL" %>
<%@ page import = "java.io.File" %>
<%@ page import = "java.io.FileWriter" %>

<!-- 
RSS(Really Simple Syndication) ?
RSS : 초간편 배포
새로운 읽을거리가 자주 갱신되는 블러그나 뉴스에서 주로 사용하는 XML 기반의 콘텐츠 배급 포맷
RSS를 사용해서 뉴스나 블러그의 관심있는 읽을거리만 모아서 볼 수 있는 장점이 있다.
사이트 연동도 가능한다.

http://rssplus.chosun.com
https://myhome.chosun.com/rss/www_section_rss.xml
 -->
<%	
	String strLine = "";
	try {
		String strUrl = "https://myhome.chosun.com/rss/www_section_rss.xml";
		
		BufferedReader br = new BufferedReader(
			new InputStreamReader((new URL(strUrl))
			.openConnection().getInputStream(),"UTF-8"));

		//http://localhost:8088/kosSpring/kos_rss/ajax_choson_rss_xml.jsp
		//String filePath = "C:\\00.KOSMO129\\30.web\\el_web_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosServlet\\kos_rss";
		String filePath = "C:\\00.KOSMO129\\30.web\\el_kos_spring_work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\kosSpring\\kos_rss";
		String fileName = "ajax_chosun_rss.xml";
		File xmlFile = new File(filePath +"/"+ fileName);

		FileWriter fw = new FileWriter(xmlFile);
		while ((strLine = br.readLine()) != null){
			System.out.println(strLine);
			fw.write(strLine);
		}
						
		fw.flush();
		fw.close();
		
	} catch(Exception e) {		
		throw e;
	}
%>    

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
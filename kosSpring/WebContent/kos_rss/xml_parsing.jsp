<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page import="java.net.*"%>
<%
	String strHtml = "";
	String strLine = "";
	//https://www.mockaroo.com/
		//url 읽어오기
		String strUrl = "http://localhost:8088/kosSpring/kos_rss/test.xml";
		// URL 객체 생성
		URL url = new URL(strUrl);
		try {	
			// URLConnection 생성
			URLConnection urlConn = url.openConnection();
					
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
	
			while ((strLine = br.readLine()) != null){
				strHtml += strLine;
			}
			br.close();
		} catch(Exception e) {
			throw e;
		}
		
		System.out.println(strHtml);
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		var xmlText, xmlParser, xmlDoc;
		
		xmlText = '<%= strHtml %>';
		alert(xmlText);
		
		xmlParser = new DOMParser();
		xmlDoc = xmlParser.parseFromString(xmlText, "text/xml");
		alert(xmlDoc);
		
		$("#parseText").click(function(){
			document.getElementById("text").innerHTML = 			
				xmlDoc.getElementsByTagName("name")[0].childNodes[0].nodeValue 
				+ "의 수도는 " + 
				xmlDoc.getElementsByTagName("capital")[0].childNodes[0].nodeValue + " 입니다.";
		});
		
		$("#parseFind").click(function(){
			var name = $(xmlDoc).find('name').text();
			var capital = $(xmlDoc).find('capital').text();
			alert(name + " 의 수도는 " + capital + " 입니다.");
		});
	});
</script>
</head>
<body>
	<button id="parseFind">find() 함수로 파싱하기 </button> 
</body>
</html>
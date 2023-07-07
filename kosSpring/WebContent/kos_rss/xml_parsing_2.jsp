<%@page import="java.net.URLConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ page import = "java.io.BufferedReader" %>
<%@ page import = "java.io.InputStreamReader" %>
<%@ page import = "java.net.URL" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XML Parser</title> 
<%
	String strHtml = "";
	String strLine = "";

		//url 읽어오기
		String strUrl = "http://localhost:8088/kosSpring/kos_rss/test.xml";
		// URL 객체 생성
		URL url = new URL(strUrl);
			
		// URLConnection 생성
		URLConnection urlConn = url.openConnection();
				
		///BufferedReader br = new BufferedReader(new InputStreamReader(urlConn));

	//	while ((strLine = br.readLine()) != null){
	//		strHtml += strLine;
	//	}
		
	//	System.out.println(strHtml);
%>		
<style type="text/css"></style>


<script> 
	function parseText() { 
		
		var xmlText, xmlParser, xmlDoc; 
		
		// xmlText 자바스크립트 변수
		// xmlTest 자바스크립트 변수에 문자열을 대입하는 것
		// "<country><name>korea</name><capital>seoul</capital></country>"
		// 평문 : Plain Text
		xmlText = "<country>"
				+ "<name>korea</name>" 
				+ "<capital>seoul</capital>"			
				+ "</country>" 	
				
		// 자바스크립트에서 DOMParser 객체를 인스턴스 함				
		xmlParser = new DOMParser(); 

		// .parseFromString() 함수에서 자바스크립트 변수에 담겨 있는 문자열을 xml 파일 형식으로 파싱을 한다. 
		// xmlDoc 자바스크립트 변수에 xml 형식의 문서가 대입된다. : 여기서 부터 xml 문서이다.				
		xmlDoc = xmlParser.parseFromString(xmlText, "text/xml"); 
		
		console.log("xmlDoc.nodeName >>> : " + xmlDoc.nodeName);
		console.log("xmlDoc.nodeType >>> : " + xmlDoc.nodeType);
		console.log("xmlDoc.documentElement.nodeName >>> : " + xmlDoc.documentElement.nodeName);
		console.log("xmlDoc.documentElement.nodeType >>> : " + xmlDoc.documentElement.nodeType);
		
		x = xmlDoc.documentElement.childNodes;
		console.log("x >>> : " + x );
		xlen = x.length;
		console.log("xlen >>> : " + xlen );
		
		for (i=0; i < xlen; i++){
			console.log("x["+i+"].nodeName >>> : " + x[i].nodeName);
			console.log("x["+i+"].nodeType >>> : " + x[i].nodeType);
			console.log("x["+i+"].childNodes[0].nodeName >>> : " + x[i].childNodes[0].nodeName);
			console.log("x["+i+"].childNodes[0].nodeType >>> : " + x[i].childNodes[0].nodeType);
		}
		
		// 자바스크립트 함수와 xml 파서 함수를 사용해서 xml에서 데이터를 추출한다. 
		document.getElementById("text").innerHTML = 			
			xmlDoc.getElementsByTagName("name")[0].childNodes[0].nodeValue + "의 수도는 " + 
			xmlDoc.getElementsByTagName("capital")[0].childNodes[0].nodeValue + " 입니다."; 
		
	} 
</script> 
</head> 
<body> 
<h3>문자열 파싱</h3> 
<hr>
<button onclick="parseText()">파싱하기!</button> 
<p id="text"></p> 
</body> 
</html>





















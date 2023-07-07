<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네이버로그인</title>
</head>
<body>
<%
	String clientId = "SwZSbJws2tpfzsj1jJUO";//애플리케이션 클라이언트 아이디값";
	String clientSecret = "mMdDmeILcL";//애플리케이션 클라이언트 시크릿값";
	
	String code = request.getParameter("code"); // 로그인 인증 요청 API 호출에 성공하고 리턴받은 인증코드값 (authorization code)
	String state = request.getParameter("state"); //
	
	String redirectURI = URLEncoder.encode("http://localhost:8088/kosSpring/naverCallback.k", "UTF-8");
	
	String 	apiURL;
			apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
			apiURL += "client_id=" + clientId;
			apiURL += "&client_secret=" + clientSecret;
			apiURL += "&redirect_uri=" + redirectURI;
			apiURL += "&code=" + code;
			apiURL += "&state=" + state;
	String access_token = "";
	String refresh_token = "";
	
	System.out.println("apiURL >>> : " + apiURL);
  	
	try {
    	
		URL url = new URL(apiURL);
    	HttpURLConnection con = (HttpURLConnection)url.openConnection();
    	con.setRequestMethod("GET");
    	
    	int responseCode = con.getResponseCode();

    	//네이버 로그인API에 성공한 후
    	if(responseCode==200) { // 정상 호출
    		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
      		// 전달받은 데이타를 읽는다
    		String inputLine = "";
       	 	StringBuffer res = new StringBuffer();
       		
       	 	while ((inputLine = br.readLine()) != null) {
          		res.append(inputLine);
        	}
        	br.close();
        	//json 형 데이타를 변환시킨다
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject  =(JSONObject) jsonParser.parse(res.toString());
			//엑세스토큰를 얻어온다
			access_token = (String)jsonObject.get("access_token");
			System.out.println("access_token >>> : " + access_token);
			request.setAttribute("access_token", access_token);
	        //callback.jsp -> control로 넘어간다
			RequestDispatcher rd = request.getRequestDispatcher("/naverlogin.k");
			rd.forward(request, response);
    	} 
  	} catch (Exception e) {
    	System.out.println(e);
  	}
%>
</body>
</html>
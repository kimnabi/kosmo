<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@page import="a.b.c.com.kos.mem.vo.KosMemberVO"%>  
<%@page import="java.util.List"%> 


    
<% request.setCharacterEncoding("UTF-8"); %>
<%
	//Logger logger = LogManager.getLogger(this.getClass());
	//logger.info("kosmoMainPage.jsp 진입 >>> : ");		
%> 
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN PAGE</title>
<meta name="viewport" content="width=device-width, initial-scale=1"> 

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link rel="stylesheet" href="/kosSpring/include/css/mainstyle.css">
<link rel="stylesheet" href="/kosSpring/css/main.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<style type="text/css">
	
	.m {
		text-align: center;
	}
	
	table{
		margin : auto;
		border-collapse: separate;
		border-spacing: 20px 40px;
	}
	
	img {
		width:200px;
		height:250px;
	}
	
	a {
	  	text-decoration-line: none;
		/*   text-decoration-line: underline; */
		/*   text-decoration-line: overline; */
		/*   text-decoration-line: line-through; */
		/*   text-decoration-line: underline line-through overline; */
	}		
	
	<!--
		슬라이드 메뉴 
	-->
	#header { width: 100%; height: 52px; background: #447e65; position: relative; overflow: hidden; }
	#mask { width: 100%; height: 100%; position: fixed; top: 0; left: 0; background: #000; -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=50)"; filter: alpha(opacity=50); zoom: 1; opacity: 0.5; z-index: 9998; display: none; }
	.logo { font-size: 25px; color: #fff; position: absolute; top: 5px; left: 15px; }
	.btn_menu_open { background: none; border: 0; font-size: 15px; color: #fff; position: absolute; top: 15px; right: 15px; cursor: pointer; }
	.slide_menu { width: 80%; height: 100%; max-width: 360px; background: #fff; position: fixed; top: 0; right: 0; overflow-y: scroll; z-index: 9999; display: none; }
	.slide_menu .menu_close { width: 100%; height: 52px; background: #447e65; position: relative; }
	.slide_menu .btn_menu_close { background: none; border: 0; font-size: 15px; color: #fff; position: absolute; top: 15px; right: 15px; cursor: pointer; }
	.slide_menu .menu_list li { padding: 15px; border-bottom:1px solid #ccc; list-style: none; }
	.slide_menu .menu_list li a { font-size: 15px; color: #333; }
	</style>
</head>
<body>

<div id="btnarea">
<%
	String mid = "";
	Object obj = request.getAttribute("listLogin");
	
	if (obj !=null) {
		List<KosMemberVO> list = (List<KosMemberVO>)obj;
		int nCnt = list.size();			
		if (nCnt == 1) {
			mid = list.get(0).getMid();	
		}	
%>
         <h3  align="right">  
		<span style="color:red"><%= mid %><span style="color:black">님 로그인 중 </span></span><span style="color:blue"><a href="logout.k" class="sitebtn">로그아웃</a>
		</span><span><a href="javascript:alert('준비중입니다.');" onfocus="this.blur()" class="sitebtn">마이페이지</a></span>
		<span><a href="javascript:alert('준비중입니다.');" onfocus="this.blur()" class="sitebtn">글쓰기</a></span>
		</h3>
<%
	}
%>
						
		</div>
	<div id="contents">
  		<h1>KOSMO 129기</h1>      
	</div>
<!-- 하단바 -->
<footer id="footerarea">
	<div class="wrapper">
		<div>
			[하단바]
			<br>아이콘 제작자 :
			<a href="http://www.freepik.com/" title="Freepik">Freepik</a>
			from
			<a href="https://www.flaticon.com/kr/" title="Flaticon"> www.flaticon.com</a>
		</div>
	</div>
</footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@page import="a.b.c.com.kos.mem.vo.KosMemberVO"%>  
<%@page import="java.util.List"%> 
<%
	String mid = "";
	Object obj = request.getAttribute("listLogin");
	
	if (obj !=null) {
		List<KosMemberVO> list = (List<KosMemberVO>)obj;
		int nCnt = list.size();			
		if (nCnt == 1) {
			mid = list.get(0).getMid();	
		}	
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
			alert("query 블록 진입")
			$("#memID").attr('placeholder', '아이디 ');
			$("#memPassword").attr('placeholder', '비밀번호 ');
//			var params = "mid="+encodeURIComponent($("#mid").val()) +"&mpw="+encodeURIComponent($("#mpw").val());
			$("#loginBtn").click(function(){
				console.log("loginBtn >>> : ");
				$("#memID").val(encodeURIComponent($("#memID").val())); 
				$('#loginForm').attr({
					'action':"loginCheck.k",
					'method':'POST',
					'enctype':'application/x-www-form-urlencoded; charset=euc-kr'
				}).submit();
			});		
		});
</script>
</head>
<body>
<div class="container">
  <jsp:include page="/common/header.jsp"/> 
  <div class="panel panel-default">
    <div class="panel-heading">로그인화면</div>
    <div class="panel-body">
      <form id="loginForm" >
          <h3  align="right">  
		<span style="color:red"><%= mid %><span style="color:black">님 로그인 중 </span></span><span style="color:blue"><a href="logout.k" class="sitebtn">로그아웃</a>
		</span>
		</h3>
      </form> 
    </div>
   	<!-- 실패 메세지를 출력(modal) -->
	<div id="myMessage" class="modal fade" role="dialog" >
	  <div class="modal-dialog">	
	    <!-- Modal content-->
	    <div id="messageType" class="modal-content panel-info">
	      <div class="modal-header panel-heading">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">${msgType}</h4>
	      </div>
	      <div class="modal-body">
	        <p>${msg}</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>	
	  </div>
	</div>   
    <div class="panel-footer">copyright</div>
  </div>
</div>

</body>
</html>
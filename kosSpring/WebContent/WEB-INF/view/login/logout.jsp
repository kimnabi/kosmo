<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGOUT</title>
<style type="text/css">
	h3 {
		 text-align: center;
	}	
</style>
</head>
<body>
<h3>Login Session Testing :: LOGOUT SUCCESS</h3>
<h3>3초 후 index.jsp 페이지로 이동 </h2>
<hr>
<script>
    alert("logout.jsp 블록 진입")
	setTimeout("location.href='http://localhost:8088/kosSpring/index.jsp'", 3000);
</script>
</body>
</html>
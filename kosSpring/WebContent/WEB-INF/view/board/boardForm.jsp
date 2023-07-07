<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD : 게시판 : 글쓰기 </title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	alert("자바스크립트 블럭 진입 >>> : ");
	
	$(document).ready(function(){
		alert("jQuery ready()함수 블럭 진입 >>> : ");
		
		$(document).on("click", "#bBtn", function(){
			console.log("kbBtn >>> : ");
			
			$('#boardForm').attr({
				'action':'${cpath}/boardInsert.k',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
		});
	});	
</script>

</head>
<body>
<h3>boardForm.jsp</h3>
<hr>
<form name="boardForm" id="boardForm">
<table border="1" align="center"   class="table" style="width: 50%; margin: auto;">
	<tr>
		<td colspan="2" align="center">게시판 글쓰기</td>				
	</tr>
	<tr>
		<td>글번호</td>
		<td><input type="text" name="bnum" id="bnum" size="20" readonly></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="bsubject" id="bsubject" size="53"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="bname" id="bname" size="53"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="bpw" id="bpw" size="20"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
		<textarea name="bcontent" id="bcontent" cols="50" rows="10"></textarea>
	</td>
	</tr>
	<tr>
		<td>사진</td>
		<td>
		<input type="file" name="bfile" id="bfile">
	</td>
	</tr>
	<tr>
		<td colspan="2" align="right">				
		<input type="button"   class="btn btn-primary" value="글쓰기" id="bBtn">		
	</td>				
	</tr>
</table>
</form>
</body>
</html>
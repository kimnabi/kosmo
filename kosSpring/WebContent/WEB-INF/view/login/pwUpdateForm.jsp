<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW UPDATE</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
$(document).ready(function(){
	alert(">>> : ");
	
	
	// 폼태그 데이터 콘트롤러에 보내기 
	$(document).on("click", "#btn", function(){
		alert("pwbtn 버튼 블럭 진입 >>> : ");			
		console.log("pwbtn >>> : ");	
						
		$('#tempwUpdate').attr({
			'action':'tempwUpdate.k',
			'method':'GET',
			'enctype':'application/x-www-form-urlencoded'
		}).submit();
	});		
});
</script>
</head>
<body>
PW UPDATE
<hr>
<form  name="tempwUpdate" id="tempwUpdate"  >
<table border="1">
<tr>
<td>임시비밀번호</td>
<input type="hidden" name="mid" id="mid" style="width:200px;" value="${mid}"/>
<td><input type="text" name="ppw" id="ppw" style="width:200px;" value="${ppw}"/></td>
</tr>
<tr>
<td>새비밀번호</td>
<td><input type="text" name="mpw" id="mpw" style="width:200px;"></td>
</tr>
<tr>
<td>새비밀번호  확인</td>
<td><input type="text" name="mpw_r" id="mpw_r" style="width:200px;"></td>
</tr>
<tr>
<td  colspan="2" align="center">
<button type="button" id="btn" style="background-color: yellow;">다음</button>
</td>
</tr>
</table> 
</form>
</body>
</html>
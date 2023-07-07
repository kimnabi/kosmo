<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<%
	//네이버 로그인 =============================================================================================	
	String clientId = "SwZSbJws2tpfzsj1jJUO";//애플리케이션 클라이언트 아이디값";	
	String redirectURI = URLEncoder.encode("http://localhost:8088/kosSpring/naverCallback.k", "UTF-8");
	
	SecureRandom random = new SecureRandom();	
	String state = new BigInteger(130, random).toString();// 사이트 간 요청 위조(cross-site request forgery) 공격을 방지하기 위해 애플리케이션에서 생성한 상태 토큰값
	
	String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		   apiURL += "&client_id=" + clientId;
		   apiURL += "&redirect_uri=" + redirectURI;
		   apiURL += "&state=" + state;
	System.out.println("apiURL >>> : " + apiURL);		   
	session.setAttribute("state", state); //세션에 추가 해서 상태유지
	
	//네이버 로그인 ==============================================================================================
%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN FORM</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 카카오 로그인 api  -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

	//카카오 로그인 ===================================================================================
	//window.Kakao.init(''); // 사용하려는 앱의 JavaScript 키 입력
	Kakao.init('4486dd13d660c0375ab6fdffcbc5173f'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	function kakaoLoginApi(){
		alert("kakaoLoginApi >>> : ");
		window.Kakao.Auth.login({
			success: function(authObj){
				// console.log( "authObj >>> : " + JSON.stringify(authObj));	
				window.Kakao.API.request({
					url: '/v2/user/me',
					success : function(res) {
						console.log( "res  >>> : " + JSON.stringify(res));                   
	                    let k_type = "01";    
                        let k_id = res.id;
                        let k_email = res.kakao_account.email;
                        // let k_gender = res.kakao_account.gender;
                        let k_nickname = res.properties.nickname;
                        let urlV = '/kosSpring/kakaoLogin.k';
						var data = {snstype: k_type,snsid:k_id,snsemail:k_email}
						$.ajax({
							type : 'POST',
							url : urlV,
							data : data,
							dataType:'json',
							success : function(data){
								console.log("아이디"+data.memPassword)
								alert("success블록 진입");
								if(data.JavaData == "YES"){
									alert("로그인되었습니다.");
									location.href = '/kosSpring/loginCheck.k?memID='+data.memID+"&memPassword="+encodeURIComponent(data.memPassword);
								}else if(data.JavaData == "register"){
									location.href = '/kosSpring/memForm.k?snstype='+k_type+"&snsemail=sdaddsa@sa.net&snsid="+"1111";
								}else{
									alert("로그인에 실패했습니다");
								}
								
							},
							error: function(xhr, status, error){
								alert("로그인에 실패했습니다."+error);
							}
						}); //end  ajax
									
					}
				});				
			}
		});
	}
	
	function kakaoLogin(k_id, k_email,k_nickname) {
		alert("kakaoLogin >>> : " + k_id + " : " + k_email+":"+k_nickname);
		
		// Ajax 호출해서 로직 만들기 대신 자바스크립트 location 이용해보기  
		// 학생들은 코딩할 때는 Ajax 로 하기 
		location.href="/kosSpring/kakaoLogin.k?snstype=01&snsid="+k_id+"&snsemail="+k_email+"&k_nickname="+k_nickname;
	}
	//카카오 로그인 ===================================================================================
</script>
<script type="text/javascript">


	$(document).ready(function(){
		
		$("#mid").attr('placeholder', '아이디 ');
		$("#mpw").attr('placeholder', '비밀번호 ');
//		var params = "mid="+encodeURIComponent($("#mid").val()) +"&mpw="+encodeURIComponent($("#mpw").val());
		$("#loginBtn").click(function(){
			console.log("loginBtn >>> : ");
			$("#mid").val(encodeURIComponent($("#mid").val())); 
			$('#loginForm').attr({
				'action':"loginCheck.k",
				'method':'POST',
				'enctype':'application/x-www-form-urlencoded; charset=euc-kr'
			}).submit();
		});		
	});
</script>
<style type="text/css">
	
	.div1{
		background: cyan;
		border: 1px solid red;
		width: 300px;
		height: 300px;
		margin: 100px auto;	
	}
		
</style>
</head>
<body>
<div class="div1">
<h1 align="center">Login Test</h1>
<hr>
<form name="loginForm" id="loginForm">
<table border="1" align="center">
<tr>
<td><input type="text" name="mid" id="mid" style="width:200px;"></td>
</tr>
<tr>
<td><input type="password" name="mpw" id="mpw" style="width:200px;"></td>
</tr>
<tr>
<td>
<button type="button" id="loginBtn" style="width:208px; background-color: yellow;">로그인</button>
</td>
</tr>
<tr>
<td align="right">
<a href="idFindForm.k"><font size="2">아이디찾기</font></a> | 
<a href="pwFindForm.k"><font size="2">비밀번호찾기<font></a>
</td>
</tr>
<tr>
<td>
<a href="#" onclick="javascript:kakaoLoginApi();return false;">
<img height="30" width="208" src="/kosSpring/img/img_sns/o.jpg"/></a>
</td>
<tr>
<tr>
<td>
<a href="<%= apiURL %>">
<img height="30" width="208" src="/kosSpring/img/img_sns/naver.PNG"/>
</a>
</td>
</tr>
</table> 
</form>
</div>
</body>
</html>
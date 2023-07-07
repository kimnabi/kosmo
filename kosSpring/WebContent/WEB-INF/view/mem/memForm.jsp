<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String snsid = (String) request.getAttribute("snsid");
String snsemail = (String) request.getAttribute("snsemail");
//String[] emailStr = snsemail.split("@");
String snsType= "01";
pageContext.setAttribute("snsid", snsid);
pageContext.setAttribute("snsemail", snsemail);
pageContext.setAttribute("snsType", snsType);
//pageContext.setAttribute("emailStr", emailStr);
%>
<c:set var="cpath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Form</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 디바이스에 최적화된 크기로 출력됨 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0
     	maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
 -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- 
<script  src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
-->
<script src="js/jquery-latest.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	alert("자바스크립트 블럭  진입 >>> : ");
	function id_overlap_check() {
		let idCheckURL = "kosIdCheck.k";
		let reqType = "GET";
		let dataParam = { mid: $("#mid").val(), };
		
			$.ajax({
				url: idCheckURL,
				type: reqType,								
				data: dataParam,
				success: whenSuccess,
				error: whenError
			});
	}
	
	
	
	function whenSuccess(resData){	
		
		alert("resData >>> : " + resData);
		 if (resData == "fail") {
	          alert("이미 존재하는 아이디 입니다.");
	          id_overlap_input.focus();
	          return;
	        } else {
	          alert("사용가능한 아이디 입니다.");
	          $('.username_input').attr("check_result", "success");
	          $('#id_check_sucess').show();
	          $('.id_overlap_button').hide();
	          return;
	        }
	}
	function whenError(e){
		alert("e >>> : " + e.responseText);
	}
	$(document).ready(function(){	
		alert("jQuery ready() 함수 진입 >>> : ");
		
		// 회원번호 				
		// 이름 
		
		// 아이디 중복체크 Ajax 비동기 방식  시작  ================================================= 			

			$('.username_input').change(function () {
	      	$('#id_check_sucess').hide();
	      	$('.id_overlap_button').show();
	      	$('.username_input').prop("check_result", "fail");
	      	
	      	alert("kidbtn >>> : ");
	
			let idCheckURL = "kosIdCheck.k";
			let reqType = "GET";
			let dataParam = { mid: $("#mid").val(), };
			
				$.ajax({
					url: idCheckURL,
					type: reqType,								
					data: dataParam,
					success: whenSuccess,
					error: whenError
				});
			});
	
		
		
		// 비밀번호 체크 
		$("#pwCheck").click(function(){
			console.log("pwCheck 함수 진입");
			var pw = $("#mpw").val();
			var pw_r = $("#mpw_r").val();
			alert("pw >>> : " + pw);
			alert("pw_r >>> : " + pw_r);
			if(pw == pw_r) {
				alert("비밀번호가 같습니다.");		
				$("#mgender").focus();						
				return true;
			} else {
				alert("비밀번호가 다릅니다.");
				$("#mpw").val('');
				$("#mpw_r").val('');			
				$("#mpw").focus();							
				return false;
			}
		});
		
		// 성별
		//var radioValue= $('input:radio[name="mgender_0"]:checked').val();
		//$('#mgenderValue').val(radioValue);
		// 생년월일
		$("#mbirth").on("input", function(){
			var m = $("#mbirth");//태어난 연도 4자리숫자(1990)
			if (m.val().length > m.maxlength){ //입력 된 숫자가 최대4자리 보다 많을때 
				m.value = m.value.slice(0, m.maxlength); //4자리 수로 짤라서 입력함 
			}
			
		});		
        // 월 
        $("#mbirth1").append("<option value=''>월--- </option>");
        for(var i = 1; i <= 12; i++){
        	if (i < 10){ i = '0'+i;}
            $("#mbirth1").append("<option value='"+ i +"'>"+ i + "</option>");
        }
        // 일 
        $("#mbirth2").append("<option value=''>일 ---</option>");
        for(var i = 1; i <= 31; i++){
        	if (i < 10){ i = '0'+i;}
            $("#mbirth2").append("<option value='"+ i +"'>"+ i + "</option>");
        }

		
		// 핸드폰	
		
		// 전화번호
		$("#mbirth").on("input", function(){
			var m = $("#mbirth");
			
			if (m.val().length > m.maxlength){
				m.valu = m.value.slice(0, m.maxlength);
			}
		});		
		// 이메일 
		$('#memail2').change(function(){	
		$("#memail2 option:selected").each(function () {
			if($(this).val()== '1'){ //직접입력일 경우 
					var aa = $("#memail1").val();					
					$("#memail1").val(''); //값 초기화 
					$("#memail1").attr("readonly",false); //활성화 				
			}else{ //직접입력이 아닐경우 
					$("#memail1").val($(this).text()); //선택값 입력 
					$("#memail1").attr("readonly",true); //비활성화 
			}}); 
		}); 	
		
		// 우편번호
		$("#mzonecode").prop('readonly', true);
		$("#mroadaddr").prop('readonly', true);
		$("#mgibunaddr").prop('readonly', true);		
		$("#zonecode").click(function(){
			console.log("zonecode >>> : ");
			new daum.Postcode({
				oncomplete: function(data) {
				    $("#mzonecode").val(data.zonecode); //5자리 새우편번호 사용
				    $("#mroadaddr").val(data.roadAddress); //도로명 주소
				    $("#mjibunaddr").val(data.jibunAddress); //지번주소			
				}
			}).open();
		});
		
		// 취미		
		
		// 소개글 
		
		// 사진 
		
		// 폼태그 데이터 콘트롤러에 보내기 
		$(document).on("click", "#btn", function(){
			alert("btn 버튼 블럭 진입 >>> : ");			
			console.log("btn >>> : ");	
			   let radioValue= $('input:radio[name="mgender_0"]:checked').val();
				$('#mgenderValue').val(radioValue);					
			    Validation();
			    
		});		
	});		
	
	 function Validation() {
	        // 변수에 저장
	      //  let mnum=$("#mnum").val();
	        let confirm = true;
	        let mid=$("#mid").val();
	        let mname=$("#mname").val();
	        let mpw=$("#mpw").val();
	        let mpw_r=$("#mpw_r").val();
	        let mbirth=$("#mbirth").val();
	        let mgender=$("#mgender").val();
	      //  let mtel=$("#mtel").val();
	      
	        let memail0=$("#memail").val();  //memail.concat("@").concat(memail1)
	        let memail1=$("#memail1").val();
	        let memail = memail0.concat("@",memail1)//memail.concat("@").concat(memail1)
	        let mzonecode =$("#zonecode").val();
	        var hobby = document.getElementsByName("mhobby")
//	        var me = document.getElementById("me")

	        //회원번호 유효성체크는  자바코드에서 채번모듈로 생성하기때문에
	        
	       // if(mnum.length <4){
	       //        alert("아이디를 4글자 이상 입력하세요.")
	       //     mnum.focus();
	       //     return false;
	       //   }
	        //아이디 영어 대소문자 확인
	       // else if(!checkEngNumber(mnum)){
	        //    alert("영문 대소문자, 숫자만 입력하세요.")
	      //      mnum.focus();
	       //     return false;
	      //  }
	        //이름 확인 = 한글과 영어만 가능하도록
	        if(mname == ""){
	            alert("이름을 입력하세요.")
	             $("#mname").focus();
	            confirm = false;
	            return false;
	        }

	        else if(!checkKorEng(mname)){
	            alert("한글, 영어만 입력하세요.")
	            $("#mname").focus();
	            confirm = false;
	            return false;
	        }
	        if(mid == ""){
	            alert("아이디을 입력하세요.")
	             $("#mid").focus();
	            confirm = false;
	            return false;
	        }
	        //비밀번호 확인
	        if(mpw.length <4){
	            alert("비밀번호를 4글자 이상 입력하세요.")
	            $("#mpw").focus();
	            confirm = false;
	            return false;
	        }
	        //비밀번호 영어 대소문자 확인
	        else if(!checkEngNumber(mpw)){
	            alert("영문 대소문자, 숫자만 입력하세요.")
	            $("#mpw").focus();
	            confirm = false;
	            return false;
	        }
	        //비밀번호와 아이디 비교
	        else if(mpw == mnum){
	            alert("아이디와 동일한 비밀번호를 사용할 수 없습니다.")
	            mpw.focus();
	            confirm = false;
	            return false;
	        }

	        //비밀번호 확인
	        if(mpw_r !== mpw){
	            alert("비밀번호와 동일하지 않습니다.")
	            $('#mpw_r').focus();
	            confirm = false;
	            return false;
	        }

	        //메일주소 확인
	        if(memail.length == 0){
	            alert("메일주소를 입력하세요.")
	            $('#memail').focus();
	            confirm = false;
	            return false;
	        }

	        else if( memail.indexOf(".") == -1 && memail.indexOf("@") >=1){
	            alert("잘못된 이메일 형식입니다.")
	            //memail.focus();
	            $('#memail').focus();
	            confirm = false;
	            return false;
	        }

	    

	        //생일 확인
	        if(mbirth == ""){
	            alert("년도를 입력하세요.")
	            $("#mbirth").focus();
	            confirm = false;
	            return false;
	        }
	        //성별 확인
	        if(mgender == ""){
	            alert("년도를 입력하세요.")
	            $('#mgender').focus();
	            confirm = false;
	            return false;
	        }

	        else if(!(mbirth >=1900 && mbirth <= 2050)){
	            alert("년도를 정확하게 입력해주세요.")
	            $('#mbirth').focus();
	            confirm = false;
	            return false;
	        }

	        //관심분야 확인
	        if(!checkedHobby(hobby)){
	            alert("관심분야를 체크하세요.")
	            $("#hobby").focus();
	            confirm = false;
	            return false;
	        }

	        //자기소개 확인
	        if(minfo == ""){
	          alert("소개글 를 입력해주세요.")
		      $("#minfo").focus();
	          confirm = false;
		      return false;
	        }
	        if(minfo.length <= 10){
	            alert("자기소개는 최소 10글자를 입력해주세요.")
	            $("#minfo").focus();
	            return false;
	        }
	        if(mzonecode == ""){
	          alert("우편번호를  입력해주세요.")
		      $("#mzonecode").focus();
	          confirm = false;
		      return false;
	        }
	        var imgFile = $('#mphoto').val();
	        var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf)$/;
	        var maxSize = 10 * 1024 * 1024;
	        var fileSize;

	        if(imgFile == "") {
	        	alert("첨부파일은 필수!");
	        	 $('#mphoto').focus();
	        	 confirm = false;
	        	return false;
	        }

	        if(imgFile != "" && imgFile != null) {
	        	fileSize = $("#file").files[0].size;
	            
	            if(!imgFile.match(fileForm)) {
	            	alert("이미지 파일만 업로드 가능");
	            	 confirm = false;
	                return;
	            } else if(fileSize = maxSize) {
	            	alert("파일 사이즈는 10MB까지 가능");
	            	 confirm = false;
	                return;
	            }
	       }
	        console.log("FORM========="+confirm);
	     if( confirm == true){
				$('#memForm').attr({
					'action':'memInsert.k',
					'method':'POST',
					'enctype':'multipart/form-data'
				}).submit();
	     } //end confirm
	   }
	    // 문자열이 영어, 숫자인지 확인하는 메서드 
	    function checkEngNumber(value){
	        var count = 0;

	        for(var i=0; i<value.length; i++){
	            if((value.charCodeAt(i)>=65 && value.charCodeAt(i)<=90) || (value.charCodeAt(i)>=97 && value.charCodeAt(i)<=122) || (value.charCodeAt(i)>=48 && value.charCodeAt(i)<=57)){
	                count += 1;
	            }
	        }

	        //카운트 수와 문자의 길이가 같다면 true
	        if(count === (value.length)){
	            return true;
	        } else{
	            return false;
	        }
	    } // checkEngNumber(value)

	    //영어, 한글인지(가~힣) 확인
	    function checkKorEng(value){
	        var count = 0;

	        for(var i=0; i<value.length; i++){
	            console.log(value.charCodeAt(i));
	            if((value.charCodeAt(i)>=65 && value.charCodeAt(i)<=90) || (value.charCodeAt(i)>=97 && value.charCodeAt(i)<=122) || (value.charCodeAt(i)>=44032 && value.charCodeAt(i)<=55203)){
	                count += 1;
	            }
	        }

	        if(count === (value.length)){
	            return true;
	        } else{
	            return false;
	        }
	    }

	    //관심분야 체크 확인
	    function checkedHobby(arr){
	        for(var i=0; i<arr.length; i++){
	            if(arr[i].checked == true){
	                return true;
	            }
	        }
	        return false;
	    } //end checkedHobby
</script>

<style type="text/css">
/*
	div {
			margin: 50px 0px 0px 100px;
		}
	.mem{ text-align: center;}
	*/
div {
	margin: 0 auto;
	border: 1px solid #6d82f3;
	display: table;
}

td, th {
	padding: 5px;
}

h3 {
	text-align: center;
}

table, th, td {
	border: 1px solid black;
}

.tooltiptext:after, .tooltiptext:before {
	top: 100%;
	left: 20%;
	border: solid transparent;
	content: "";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
}

.tooltiptext:after {
	border-color: rgba(255, 255, 255, 0);
	border-top-color: #fff;
	border-width: 13px;
	margin-left: -20px;
}

.tooltiptext:before {
	border-color: rgba(204, 204, 204, 0);
	border-top-color: #ccc;
	border-width: 13px;
	margin-left: -20px;
	margin-top: 2px;
}

.tooltip {
	position: relative;
	display: inline-block;
}

.tooltip .tooltiptext {
	visibility: hidden;
	width: 260px;
	background-color: white;
	color: #cc5200;
	text-align: left;
	border-radius: 6px;
	padding: 5px 0;
	font-size: 14px;
	border: 2px solid #ccc;
	radius: 8px;
	/* Position the tooltip */
	position: absolute;
	bottom: 140%;
	left: -10%;
	z-index: 50;
}

.tooltip:hover .tooltiptext {
	visibility: visible;
}

.hr_dash {
	border: 1px dashed #ccc;
}

#header {
	text-align: center;
}
font-family
:
 
'
Jua
'
,
sans-serif
;
</style>
</head>
<body>
	<h3>
		<font size="4" style="color: Blue;">SPRING MYBATIS 회원가입</font>
	</h3>
	<hr>
	<div>
		<form name="memForm" id="memForm">
			<input type="hidden" name="snstype" id="snstype"  value="${snsType }"/> <input
				type="hidden" name="snsid" id="snsid" value="${snsid }" />
				 <input type="hidden"
name="snsemail" id="snsemail"  value="${ snsemail}"/>
			<table>
				<tr>
					<td colspan="2" align="center"><font size="4"
						style="color: Blue;">KOSMO 129기</font> <img
						src="${cpath}/img/img_mandu/ase.gif" width="25" height="25"
						alt="image"></td>
				</tr>
				<tr>
					<td>회원번호</td>
					<td><input type="text" name="mnum" id="mnum" readonly /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="mname" id="mname" /></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="mid" id="mid" placeholder="아이디체크"
						class="username_input" name="username" check_result="fail"
						required style="width: 100px" value="<%=snsid%>" />
						<button type="button" name="midbtn" id="midbtn"
							class="id_overlap_button" onclick="id_overlap_check()">아이디중복확인</button>
						<img id="id_check_sucess" style="display: none;"></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<div class="tooltip" margin="0px 0px 0px 0px">
							<span class="tooltiptext"
								style="font-size: 14px; font-family: 'Jua';"> <span
								style="font-size: 16px">&nbsp;&nbsp; 해당 조건을 만족시켜 주십시오.</span>
								<hr class="hr_dash"> &nbsp;&nbsp;<img
								src="${cpath}/img/notice.png" width="18px" height="17px">
								영문자 사용(공백사용 X)<br /> &nbsp;&nbsp;<img
								src="${cpath}/img/notice.png" width="18px" height="17px">
								특수문자 사용(공백사용X)<br /> &nbsp;&nbsp;<img
								src="${cpath}/img/notice.png" width="18px" height="17px">
								숫자 사용<br /> &nbsp;&nbsp;<img src="${cpath}/img/notice.png"
								width="18px" height="17px"> 8글자 이상<br />
							<br />
							</span> <input type="text" class="imf" name="mpw" id="mpw"
								placeholder="비밀번호 8자리" style="width: 100px" maxlength="8" />
						</div>
						<br /> <!-- 
		<input type="password" name="mpw" id="mpw" style="width:100px" /><br/>
	 --> <input type="password" name="mpw_r" id="mpw_r"
						placeholder="비밀번호확인" style="width: 100px" /> <input type="button"
						value="비밀번호확인" id="pwCheck" /><br />
					</td>
				</tr>
				<tr>
					<td>성별</td>

					<td><input type="hidden" name="mgender" id="mgenderValue" />
						<input type="radio" name="mgender_0" id="mgender_f" value="F"
						checked /> 여자 <input type="radio" name="mgender_0" id="mgender_m"
						value="M" /> 남자</td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="mbirth" id=mbirth
						placeholder="년(4자)" maxlength="4" style="width: 50px" />
						 <select name="mbirth1" id="mbirth1" style="width: 50px"></select> 
						 <select name="mbirth2"
						id="mbirth2"  style="width: 50px"></select></td>
				</tr>
				<tr>
					<td>핸드폰</td>
					<td><select name="mhp" id="mhp">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
					</select> - <input type="text" name="mhp1" id="mhp1" size="2" /> - <input
						type="text" name="mhp2" id="mhp2" size="2" /></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><select name="mtel" id="mtel">
							<option value="02">02</option>
							<option value="031">031</option>
							<option value="041">041</option>
							<option value="051">051</option>
							<option value="061">061</option>
					</select> - <input type="text" name="mtel1" id="mtel1" size="2" /> - <input
						type="text" name="mtel2" id="mtel2" size="2" /></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="memail" id=memail
						style="width: 100px" value="" /> @ <input
						type="text" name="memail1" id=memail1 style="width: 100px"
						placeholder="직접입력" value="" /> 
						<c:if test="${!empty emailStr}">
						<select
						name="memail2" id="memail2"
						style="width: 100px; margin-right: 10px" i  disabled>
							<option value="1" selected>직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.net">daum.net</option>
					</select>
					</c:if>
					<c:if test="${empty emailStr}">
						<select
						name="memail2" id="memail2"
						style="width: 100px; margin-right: 10px" i>
							<option value="1" selected>직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.net">daum.net</option>
					</select>
					</c:if>
					</td>
				</tr>
				<tr>
					<td class="mem">주소</td>
					<td><input type="text" name="mzonecode" id="mzonecode"
						placeholder="우편번호" style="width: 50px"> <input
						type="button" name="zonecode" id="zonecode" value="우편번호 찾기"><br>
						<input type="text" name="mroadaddr" id="mroadaddr"
						placeholder="도로명주소" style="width: 250px"><br> <input
						type="text" name="mroaddetail" id="mroaddetail"
						placeholder="도로명주소 상세주소" style="width: 250px"><br> <input
						type="text" name="mjibunaddr" id="mjibunaddr" placeholder="지번주소"
						style="width: 250px"></td>
				</tr>
				<tr>
					<td>취미</td>
					<td><input type="checkbox" name="mhobby" value="mh1" />알고리즘 <input
						type="checkbox" name="mhobby" value="mh2" />코딩 <input
						type="checkbox" name="mhobby" value="mh3" />분석설계<br> <input
						type="checkbox" name="mhobby" value="mh4" />데이터베이스 <input
						type="checkbox" name="mhobby" value="mh5" />스크립트</td>
				</tr>
				<tr>
					<td>소개글</td>
					<td><textarea name="minfo" id="minfo" rows="5" cols="50">내 소개글					
	</textarea></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="mphoto" /><br></td>
				</tr>
				<tr>
					<td colspan="2">
						<button type="button" id="btn">보내기</button>
						<button type="reset">다시</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
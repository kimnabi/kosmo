<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Terra Test Member Form</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 디바이스에 최적화된 크기로 출력됨 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0
     	maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">


<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">     	
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script  src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> 

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>     	


<script>
    function previewImage(event) {
      var reader = new FileReader();
      reader.onload = function() {
        var output = document.getElementById('preview');
        output.src = reader.result;
      };
      reader.readAsDataURL(event.target.files[0]);
    }
  </script>
  
  <script type="text/javascript">
  	alert("자바스크립트 블럭 집입 >>> :");
  	
  	$(document).ready(function(){
  		alert("jQuery ready() 함수 진입 >>> :");
  		
  	// 아이디 중복체크 Ajax 비동기 방식  시작  ================================================= 				
		$(document).on("click", "#midbtn", function(){
			alert("midbtn >>> : ");
			alert($("#mid").val());
			let idCheckURL = "tMemIdcheck.a";
			let reqType = "GET";
			let dataParam = { mid:	 $("#mid").val(), };
			
			$.ajax({
				url: idCheckURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess,
				error: whenError
			});
			
			function whenSuccess(resData){	
				alert("resData >>> : " + resData);
				if ("ID_YES" == resData){
					alert("아이디 사용가능 : ID_YES.");														
					$("#mkid").css('background-color','yellow');	
					$("#mid").attr("readonly", true);
					$("#mpw").focus();	
				}else if ("ID_NO" == resData){
					alert("이미 아이디 사용중 : ID_NO.");
					$("#mid").val('');
					$("#mid").focus();
				}			
			}
			function whenError(e){
				console.log("e >>> : " + e.responseText);
			}
		});
  	
  	
		// 입사일
		$("#hiredate").datepicker({	                      
			dateFormat: "yyyymmdd",             
			changeMonth: true           
		});
		
		
        // 월 
        $("#miredate1").append("<option value=''>월--- </option>");
        for(var i = 1; i <= 12; i++){
        	if (i < 10){ i = '0'+i;}
            $("#miredate1").append("<option value='"+ i +"'>"+ i + "</option>");
        }
        // 일 
        $("#miredate2").append("<option value=''>일 ---</option>");
        for(var i = 1; i <= 31; i++){
        	if (i < 10){ i = '0'+i;}
            $("#miredate2").append("<option value='"+ i +"'>"+ i + "</option>");
        }
        
        
     // 우편번호
		$("#mzipcode").prop('readonly', true);
		$("#mroadaddr").prop('readonly', true);
		$("#mjibun").prop('readonly', true);		
		$("#zonecode").click(function(){
			console.log("zonecode >>> : ");
			new daum.Postcode({
				oncomplete: function(data) {
				    $("#mzipcode").val(data.zonecode); //5자리 새우편번호 사용
				    $("#mroadaddr").val(data.roadAddress); //도로명 주소
				    $("#mjibun").val(data.jibunAddress); //지번주소			
				}
			}).open();
		});
		
		// 이메일 
		$('#memail2').change(function(){	
		$("#memail2 option:selected").each(function () {
			if($(this).val()== '1'){ //직접입력일 경우 
					//var aa = $("#memail1").val();					
					$("#memail1").val(''); //값 초기화 
					$("#memail1").prop("disabled",false); //활성화 				
			}else{ //직접입력이 아닐경우 
					$("#memail1").val($(this).text()); //선택값 입력 
					$("#memail1").prop("disabled",true); //비활성화 
			}}); 
		}); 
		
		// 폼태그 데이터 콘트롤러에 보내기 
		$(document).on("click", "#btn", function(){
			alert("btn 버튼 블럭 진입 >>> : ");			
			console.log("btn >>> : ");	
							
			$('#memForm').attr({
				'action':'tMemInsertForm.a',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
		});
		
		
  	});
  	
  	
  </script>
  
  <script>
			function previewImage(event) {
				var reader = new FileReader();
				reader.onload = function () {
					var preview = document.getElementById('preview');
					preview.src = reader.result;
				}
				reader.readAsDataURL(event.target.files[0]);
			}
		</script>

		<style type="text/css">
			
			div {		 
				margin: 0 auto; 		
				border:1px solid ;
				display:table;
				background-color: #C5E0B4;
				border-radius: 100px; /* 모서리를 둥글게 만듦 */
			}	

			td, th {
				padding: 5px;
			}

			h3 {
				text-align: center;
			}	

			table {
				border-collapse: collapse;
				border-radius: 10px;
			}
			
			table, th, td {
				padding: 10px;
				border: 1px solid #E2F0D9;  
				text-align: center;		
			}

			.tooltip .tooltiptext {
				visibility: hidden;
				width: 260px;
				background-color: white;
				color: #cc5200;
				text-align: left;
				border-radius: 6px;
				padding: 5px 0;
				font-size:14px;
				border: 2px solid #ccc;
					
			
				/* Position the tooltip */
				position: absolute;
				bottom: 140%;
				left: -10%;
				z-index: 50;
			}

			#preview {
				width: 200px;
				height: 200px;
				object-fit: cover;
				border-radius: 50%;
				overflow: hidden;
			}

			button{
				border-radius: 10px; /* 모서리를 둥글게 만듦 */
			}

			placeholder{
				text-align: center;	
			}

		</style>

	</head>

	<body>
	<form name="memForm" id="memForm">
		<h3><font size="4" style="color: green;">TERRA회원가입</font></h3>
		<div>
			<table>

				<tr>
					<td colspan="2" align="center">
						<label for="photo">사원 등록</label>
					</td>
				</tr>
				<tr>
					<td>
						<img id="preview" src="#" alt="이미지 등록">
				
						<input type="file" accept="image/*" onchange="previewImage(event)" id="photo">
					</td>
				</tr>
	
				<tr>
					<td>
						<input type="text" name="mid" id="mid" placeholder="ID INSERT" style="width:150px" />
						<input type="button" name="midbtn" id="midbtn" value="아이디중복확인"  />
					</td>
				</tr>
	
				<tr>
					<td>
						<div class="tooltip" margin="0px 0px 0px 0px">
						<span class="tooltiptext" style="font-size:14px; font-family:'Jua';">
								<span style="font-size:16px">&nbsp;&nbsp; 해당 조건을 만족시켜 주십시오.</span>
								<hr class="hr_dash">
								&nbsp;&nbsp;<img src="/kosSpring/img/notice.png" width="18px" height="17px"> 영문자 사용(공백사용 X)<br/>
								&nbsp;&nbsp;<img src="/kosSpring/img/notice.png" width="18px" height="17px"> 특수문자 사용(공백사용X)<br/>
								&nbsp;&nbsp;<img src="/kosSpring/img/notice.png" width="18px" height="17px"> 숫자 사용<br/>
								&nbsp;&nbsp;<img src="/kosSpring/img/notice.png" width="18px" height="17px"> 8글자 이상<br/><br/>
							</span>
							<input type="text" class="imf" name="mpw" id="mpw" placeholder="PASSWORD" style="width:100px" maxlength="8"/>
						</div>
					</td>
				</tr>
	
				<tr>
					<td>		
						<input type="text" name="memail" id=memail style="width:100px"  placeholder="EMAIL INSERT"/>
						@ <input type="text" name="memail1" id=memail1 style="width:100px" placeholder="직접입력" />
						<select name="memail2" id="memail2" style="width:100px;margin-right:10px">
								<option value="1" selected>직접입력</option>
								   <option value="naver.com">naver.com</option>	       	   
								  <option value="gmail.com">gmail.com</option>
								  <option value="daum.net">daum.net</option>	       	   
							</select>
					</td>
				</tr>
				
				<tr>이름
					<td><input type="text" name="mname" id="mname" placeholder="NAME"/></td>
					</tr>
				<tr>
	
				<tr>
						<td>생년월일	
							<input type="text" name="mbirth" id="mbirth" 
								   placeholder="mbirth(8자리)" maxlength="8" style="width:100px"/>
						</td>
				</tr>
				
				<tr>
					<td>핸드폰 번호
						<select name="mhp" id="mhp"  placeholder="직위선택">
							   <option value="010">010</option>
							   <option value="011">011</option>
							   <option value="016">016</option>
							   <option value="017">017</option>		        	
						</select>
						- <input type="text" name="mhp1" id="mhp1" maxlength="4" size="2" />
						- <input type="text" name="mhp2" id="mhp2" maxlength="4" size="2"/>
					</td>
				</tr>
	
				<tr>
					<td>
						H.ADRESS
						<input type="text" name="mzipcode" id="mzipcode" placeholder="우편번호" style="width:50px">
						<input type="button" name="zonecode" id="zonecode" value="우편번호 찾기"><br>	 	
						<input type="text" name="mroadaddr" id="mroadaddr" placeholder="도로명주소" style="width:250px"><br>	 	
						<input type="text" name="mroaddetail" id="mroaddetail" placeholder="도로명주소 상세주소" style="width:250px"><br>	 	
						<input type="text" name="mjibun" id="mjibun" placeholder="지번주소" style="width:250px">
					</td>
				</tr>	 
	
				<tr>
					<td> 성별
						<input type="radio" name="mgender" id="mgender_m" style="background-color: #92D050" value="M" checked />남자 
						<input type="radio" name="mgender" id="mgender_f" style="background-color: #92D050" value="F" />여자
				 	</td>
				</tr>

				<tr>
					<td> 상급자 번호
						<input type="text" name="mgrno" id="mgrno" placeholder="상급자입력" style="width:250px">
						<select name="mgrno" id="mgrno"  placeholder="상급자입력">
							   <option value="상급자1">상급자1</option>
							   <option value="상급자2">상급자2</option>
							   <option value="상급자3">상급자3</option>
							   <option value="상급자4">상급자4</option>
							   <option value="상급자2">상급자5</option>		        	
						</select>
				 	</td>
				</tr>
				
				<tr>	 
					<td> 부서번호
						<select name="mdeptno" id="mdeptno"  placeholder="부서선택">
							   <option value="관리">관리부</option>
							   <option value="기획">기획부</option>
							   <option value="영업">영업부</option>
							   <option value="생산">생산부</option>
							   <option value="안전관리">안전관리</option>		        	
						</select>
					   </td>
				</tr>
				
				<tr>	 
					<td> 직위
					<select name="mposition" id="mposition"  placeholder="직위선택">
							   <option value="대표이사">대표이사</option>
							   <option value="이사">이사</option>
							   <option value="부장">부장</option>
							   <option value="대리">대리</option>	
							   <option value="사원">사원</option>	        	
						</select>
				</tr>	
				
				<tr>	 
					<td> 직무
						<select name="mjob" id="mjob"  placeholder="직무선택">
								   <option value="직무1">직무1</option>
								   <option value="직무2">직무2</option>
								   <option value="직무3">직무3</option>
								   <option value="직무4">직무4</option>	        	
						</select>
					 </td>
				</tr>	


				<tr>	 
					<td> 직책
						<select name="mduty" id="mduty"  placeholder="직책선택">
								    <option value="없음">없음</option>
								   <option value="팀장">팀장</option>
								   <option value="파트장">파트장</option>        	
						</select>
					</td>
				</tr>	

				<tr>
					<td>		입사일
						<input type="text" name="hiredate" id="hiredate" style="width:100px"/>
					</td>
				</tr>

				<tr>
					<td> 사내번호
						<input type="text" name="mtel" id="mtel" maxlength="3" size="2"/>
						- <input type="text" name="mtel1" id="mtel1" maxlength="4" size="2"/>
						- <select name="mtel2" id="mtel2"  placeholder="MTEL NUMBER">
							   <option value="5000">5000</option>
							   <option value="5001">5001</option>
							   <option value="5002">5002</option>
							   <option value="5003">5003</option>
							   <option value="5004">5004</option>
							   <option value="5005">5005</option>		        	
						</select>
					</td>
				</tr>

				<tr>
					<td colspan="2" align="center"> 			
						<button type="button" id="btn" style="background-color: #92D050">SIGN IN</button>
					</td>				
				</tr>

			</table>


		</div>
	</form>
  </body>
</html>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="org.apache.log4j.LogManager"%>

<%@page import="a.b.c.com.kos.board.vo.KosBoardLikeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ page import="a.b.c.com.kos.board.vo.KosBoardVO" %> 
<%@ page import="a.b.c.com.common.CodeUtil" %> 
<%@ page import="java.util.List" %> 

<% request.setCharacterEncoding("UTF-8");%> 
<%	
	Logger logger = LogManager.getLogger(this.getClass());
	Object obj = request.getAttribute("listS");
	Object obj0 = request.getAttribute("listLike");
	if (obj == null) return;
//	if (obj0 == null) return;
		KosBoardLikeVO _kblvo = null;

	if (obj0 != null) {
		List<KosBoardLikeVO> list0 = (List<KosBoardLikeVO>)obj0;	
		int nCnt0 = list0.size();
		if (nCnt0 == 1){
			_kblvo = list0.get(0);
		}	
		
	}else{
		_kblvo = new KosBoardLikeVO();
		_kblvo.setLike_cnt_1("0");
		_kblvo.setLike_cnt_2("0");
	}

	List<KosBoardVO> list = (List<KosBoardVO>)obj;	
	int nCnt = list.size();
	
	KosBoardVO _kbvo = null;
	if (nCnt == 1){
		_kbvo = list.get(0);
	}	
	logger.info("_kblvo >>>"+_kblvo.toString());
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){	
		
		//  pwBtn : 비밀번호 확인 
		$(document).on("click", "#pwBtn", function(){
			let input_kbpw = prompt('비밀번호를 입려하세요', 'aaa');			
			
			if (input_kbpw.length > 0){
				console.log(input_kbpw);
				
				let pwcheckURL = "boardPwCheck.h";
				let reqType = "POST";
				let dataParam = {
					kbnum: $("#kbnum").val(),
					kbpw: input_kbpw,
				};
				//dataParam = $("#boardUpdateForm").serialize();
				console.log("dataParam >>> : " + dataParam);
				
				$.ajax({
					url: pwcheckURL,
					type: reqType,								
					data: dataParam,	            
					success: whenSuccess,
					error: whenError
				});
				
				function whenSuccess(resData){	
					console.log("resData >>> : " + resData);					
					if ("ID_YES" == resData){					
						alert("비밀번호 GOOD.");												
						$("#updateBtn").css('background-color','yellow');	
						if($("#updateBtn").prop("disabled")==true){
							  $("#updateBtn").attr("disabled", false);
						}
					}else if ("ID_NO" == resDataFlag){
						alert("비밀번호 BAD.");
						return;
					};				
				}
				function whenError(e){
					console.log("e >>> : " + e.responseText);
				}
			}						
		});
	
	
		// like_1 버튼 
		$(document).on("click", "#like_1", function(e){
			alert("like_1 버튼 클릭 >>> : ");
			
			let boardLikeURL = "${cpath}/like_cnt_1.k";
			let reqType = "GET";
			let dataParam = {
				like_cnt_1: $(this).val(),
				//mnum: $("mnum").val("M202305230001"),
				//bnum: $("bnum").val("B0002"),
				mnum: $("mnum").val(),
				bnum: $("bnum").val(),
			};		
			dataParam = $("#boardUpdateForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: boardLikeURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess				
			});
			
			function whenSuccess(resData){
				alert("resData >>> : " + resData);
				console.log("resData >>> : " + resData);			
				$("#disp_cnt_recom").text(resData).val();				
				$("#goLike").text(resData);				
			}	
			
		});
		
		// like_2 버튼 
		$(document).on("click", "#like_2", function(e){
			alert("like_2 버튼 클릭 >>> : ");
			
			let boardLikeURL = "${cpath}/like_cnt_2.k";
			let reqType = "GET";
			let dataParam = {
				like_cnt_1: $(this).val(),
			//	mnum: $("mnum").val("M202211090004"),
				//bnum: $("bnum").val("B0002"),
				mnum: $("mnum").val(),
				bnum: $("bnum").val(),
			};		
			dataParam = $("#boardUpdateForm").serialize();
			console.log("dataParam >>> : " + dataParam);
			
			$.ajax({
				url: boardLikeURL,
				type: reqType,								
				data: dataParam,	            
				success: whenSuccess				
			});
			
			function whenSuccess(resData){
				alert("resData >>> : " + resData);
				console.log("resData >>> : " + resData);			
				$("#disp_cnt_stop").text(resData).val();				
			}	
			
		});
	
		// like_3 버튼 
		$(document).on("click", "#like_3", function(e){
			alert("like_3 버튼 클릭 >>> : 준비 중 입니다.");			
		});
	
		//  insertBtn
		$(document).on("click", "#insertBtn", function(){
			location.href="boardForm.k";
		});
		
		// selectBtn
		$(document).on("click", "#selectAllBtn", function(){		
			$("#boardUpdateForm").attr({"method":"GET", "action":"boardSelectAll.k"}).submit();		
		});
		
		//  updateBtn
		$(document).on("click", "#updateBtn", function(){
			alert("updateBtn");
			$("#boardUpdateForm").attr({ "method":"GET", "action":"#boardUpdate.k"}).submit();
		});
		
	});		
		
</script>
<style type="text/css">
	
	div {		 
		margin: 0 auto; 		
		border:1px solid #6d82f3;
		display:table;
	}			

	table, hd, h3 {
		text-align: center;
		border: 1px;
	}
	
	table {
	   width: 100%;
	   border: 1px solid #444;
	   border-collapse: collapse;
  	}
	
	th, td {
	   border: 1px solid #444;
	   padding: 10px;
	}
	
	.td_1 {
		font-size: 12px;
		color: black;		
	}
	
	.td_2 {
		font-size: 12px;
		color: black;
		text-align:right;
	}
</style>
</head>
<body>
<h3>게시글 내용</h3>
<hr>
<div>
<form name="boardUpdateForm" id="boardUpdateForm">
<table>
<tr>
<td>제목</td>
<td colspan="4" style="text-align:left;width:400;">
	<font size="4" style="color:black;"><%= _kbvo.getBsubject() %></font>
	<input type="hidden" name="bnum" id="bnum" value="<%= _kbvo.getBnum() %>" />
	<input type="hidden" name="mnum" id="mnum" value="<%= _kbvo.getMnum() %>" />
</td>
<td  class="td_2"> 추천 : <span id="goLike"><%= _kblvo.getLike_cnt_1() %></span>&nbsp; 조회 <%= _kbvo.getBhit() %> &nbsp; 작성일자 : <%= _kbvo.getUpdatedate() %></td>
</tr>
<tr>
	<td>작성자</td>
	<td><%=  _kbvo.getBname() %></td>
	<td>카테고리</td><td class="td_1"><%= "업체 후기" %></td>
	<td>상세</td><td class="td_1"><%= "충청북도 청주시 흥덕구 > 카페/식당" %></td>
</tr>
<tr>
	<td colspan="6" style="text-align:left"> 
		<img src="${cpath}/fileupload/board/<%= _kbvo.getBfile() %>" border="1" width="100" height="100" alt="image"><br>
		<img src="${cpath}/fileupload/board/<%= _kbvo.getBfile() %>" border="1" width="200" height="100" alt="image"><br>
	</td>
</tr>
<tr>
	<td colspan="6" style="text-align:left">
		<textarea name="kbcontent" id="kbcontent" rows="5" cols="100"><%= _kbvo.getBcontent() %>					
		</textarea>
	</td>
</tr>
<tr>
<td colspan="6" style="text-align:center">
<button type="button" class="like_1" name="like_1" id="like_1">추천
<p>
	<img src='${cpath}/img/img_board/heart.png' style='width:12px; margin:3px 3px 0 0;'>
	<span id="disp_cnt_recom"><%= _kblvo.getLike_cnt_1() %></span>
</p>
</button>
<button type="button" class="like_2" name="like_2" id="like_2">반대
<p>
<img src='${cpath}/img/img_board/thumb_rev.png' style='width:12px; margin:3px 3px 0 0;'>
<span id="disp_cnt_stop"><%= _kblvo.getLike_cnt_2()%></span>
</p>
</button>
<button type="button" class="like_3" name="like_3" id="like_3">신고
<p>
<img src='${cpath}/img/img_board/alarm.png' style='width:18px; margin-top:1px; '>
</p>
</button>
</td>
</tr>
<tr>
<td colspan="6" align="center"> 
<button type="button" id="insertBtn">글쓰기</button>
<button type="button" id="selectAllBtn">글목록</button>
</td>				
</tr>
</table>
</form>
</div>
<!-- 댓글 처리 하는 루틴  --> 
<jsp:include page="/rboardForm.k">
	<jsp:param value="<%=_kbvo.getBnum()%>" name="bnum"/>
</jsp:include>	
</body>
</html>

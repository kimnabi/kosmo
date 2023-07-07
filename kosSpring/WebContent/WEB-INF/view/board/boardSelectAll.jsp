<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<%@ page import="a.b.c.com.kos.board.vo.KosBoardVO" %> 
<%@ page import="a.b.c.com.kos.board.vo.KosBoardPasingVO" %> 
<%@ page import="a.b.c.com.common.CodeUtil" %> 
<%@ page import="java.util.List" %> 

<%@ page import=" org.apache.log4j.LogManager" %>
<%@ page import="org.apache.log4j.Logger" %>

<% request.setCharacterEncoding("UTF-8");%> 
<%	
	Logger logger = LogManager.getLogger(this.getClass());
	logger.info("kosBoardSelectAll.jsp 페이지 >>> : ");
	
	//페이징 변수 세팅
	int pageSize = 0;
	int groupSize = 0;
	int curPage = 0;
	int totalCount = 0;

	Object objPaging = request.getAttribute("pagingKBVO");
	KosBoardPasingVO pagingKBVO = (KosBoardPasingVO)objPaging;
	
	Object obj = request.getAttribute("listAll");
	List<KosBoardVO> list = (List<KosBoardVO>)obj;
	
	int nCnt = list.size();
	String nCntS = ":::: 전체 조회 건수  " + nCnt + " 건";	
%>     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<script type="text/javascript" src="${cpath}/js/common.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
	alert("자바스크립트 블럭 진입 >>> : ");
	
	$(document).ready(function(){
		alert("jQuery ready() 함수 블럭 진입 >>> : ");
		
		// chkAll 체크박스 체크 확인하기
		$(document).on("click", "#chkAll", function(){				
			
			if($(this).prop('checked')){			 			
				$('.bnum').prop('checked',false);			
			}
		});
		
		// bnum 체크박스 체크 확인하기
		$(document).on("click", "#bnum", function(){				
			
			if($(this).prop('checked')){			 			
				$('.bnum').prop('checked',false);
				$(this).prop('checked',true);
			}
		});
		
		//  I
		$(document).on("click", "#insertBtn", function(){
			location.href="boardForm.k";
		});
		

				
		//  S
		$(document).on("click", "#selectBtn", function(){	
			if ($('.bnum:checked').length == 0){
				alert("글번호 하나를 선택하세요!!");
				return;
			}
			$("#boardList").attr({ "method":"GET","action":"boardSelect.k"}).submit();
		});		
		
		//  글 내용보기 
		$(document).on("click", "#contentsBtn", function(){	
			if ($('.bnum:checked').length == 0){
				alert("글번호 하나1111를 선택하세요!!");
				return;
			}
				$("#boardList").attr(
						{ "method":"GET","action": "boardSelectContents.k"}).submit();
		});		
			
		
		//  U
		$(document).on("click", "#deletetBtn", function(){	
			if ($('.bnum:checked').length == 0){
				alert("삭제할 글번호 하나를 선택하세요!!");
				return;
			}
			$("#boardList").attr({ "method":"GET","action":"boardDelete.k"}).submit();
		});		
		//  D
		$(document).on("click", "#deletetBtn", function(){	
			if ($('.bnum:checked').length == 0){
				alert("삭제할 글번호 하나를 선택하세요!!");
				return;
			}
			$("#boardList").attr({ "method":"GET","action":"boardDelete.k"}).submit();
		});		
	});	

</script>
<style type="text/css">
	/*
	div {		 
		margin: 0 auto; 		
		border:1px solid #6d82f3;
		display:table;
	}			
	*/
	td, th {
		 /*padding: 5px;*/
		 text-align: center;
	}

	h3 {
		text-align: center;
	}	
	/*
	table, th, td {
  		border: 1px solid black;
  		text-align: center;
	}
	*/
	
</style>
</head>
<body>
<div class="container">
<jsp:include page="/common/header.jsp"/> 
<form name="boardList" id="boardList">
<table class="table table-bordered table-sm">
<thead>
<tr>
	<td colspan="7" style="text-align:center">
		<h3>게시판</h3>
		<%= nCntS %>
	</td>
</tr>
<tr>
	<th>
		<input type="checkbox" class="chkAll" name="chkAll" id="chkAll">
	</th>	
	<th>글번호</th>	
	<th>글제목</th>
	<th>이름</th>	
	<th>사진</th>
	<th>날짜</th>
	<th>조회수</th>
</tr>
</thead>
<%

for(int i=0; i<nCnt; i++){		
	KosBoardVO _kbvo = list.get(i);	
	
	// 페이징 세팅
	pageSize = pagingKBVO.getPerPageNum();
	groupSize = Integer.parseInt(pagingKBVO.getGroupSize());
	curPage = pagingKBVO.getCurPage();
	totalCount = pagingKBVO.getTotalCount();
%>
<tbody>
<tr>
	<td style="width:5%">
		<input type="checkbox" id="bnum" name="bnum" class="bnum" value=<%= _kbvo.getBnum() %> >
	</td>			
	<td style="width:10%"><%= _kbvo.getBnum() %> </td>
	<td style="text-align:left;"><%= _kbvo.getBsubject() %> </td>
	<td style="width:10%"><%= _kbvo.getBname() %> </td>	
	<td style="width:10%"><img src="${cpath}/fileupload/board/<%= _kbvo.getBfile() %> " border="1" width="25" height="25" alt="image"></td>
	<td style="width:10%"><%= _kbvo.getUpdatedate() %></td>
	<td style="width:8%"><%= _kbvo.getBhit() %></td>				
</tr>	
<%
}//end of for
%>
<tr>
	<td colspan="7">
		<jsp:include page="boardPaging.jsp" flush="true">
			<jsp:param name="url" value="boardSelectAll.k"/>
			<jsp:param name="str" value=""/>
			<jsp:param name="pageSize" value="<%=pageSize%>"/>
			<jsp:param name="groupSize" value="<%=groupSize%>"/>
			<jsp:param name="curPage" value="<%=pagingKBVO.getCurPage()%>"/>
			<jsp:param name="totalCount" value="<%=totalCount%>"/>
		</jsp:include>
	</td>
</tr>							
<tr>
	<td colspan="7" style="text-align:right;">				
		<button type="button" class="btn btn-danger" id="insertBtn">글쓰기</button>
		<button type="button" class="btn btn-primary" id="selectAllBtn">글목록</button>
		<button type="button" class="btn btn-success btn-sm" id="contentsBtn">글내용보기</button>		
		<button type="button" class="btn btn-warning btn-sm" id="selectBtn">글수정</button>		
		<button type="button" class="btn btn-dark" id="deletetBtn">글삭제</button> 									
	</td>
</tr>	
</tbody>	
</table>
</form>	
</div>
</body>
</html>
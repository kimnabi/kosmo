<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<td colspan="10" align="center">
						<h3>회원정보</h3> 
						<span style="color:blue; font-weight:bold">조회건수 ::: ${Cnt} 건</span>
					</td>
				</tr>
				<tr>
					<th>회원번호</th>
					<th>제목</th>
					<th>아이디</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(listAll) > 0 }">
						<c:forEach items="${listAll }" var="bList">
							<tr>
								<th scope="row">${bList.IDX }</th>
								<td>${bList.TITLE }</td>
								<td>${bList.CREA_ID }</td>
								<td>${bList.CREA_DATE }</td>
								<td>${bList.HIT_CNT }</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5">조회된 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>

</body>
</html>

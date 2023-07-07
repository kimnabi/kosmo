<%@ page import="a.b.c.com.kos.product.vo.KosProductPasingVO"%>
<%@ page import="a.b.c.com.kos.product.vo.KosmoProductVO"%>
<%@ page import="java.util.List"%>

<%@ page import="a.b.c.com.common.NumUtil"%>

<%@ page import=" org.apache.log4j.LogManager"%>
<%@ page import="org.apache.log4j.Logger"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	Logger logger = LogManager.getLogger(this.getClass());
logger.info("kosmoProductSelectAll.jsp 페이지 >>> : ");


//Object objPaging = request.getAttribute("pagingKPVO");

//KosProductPasingVO pagingKPVO = (KosProductPasingVO)objPaging;

%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<title>상품 상세 정보</title>
<script type="text/javascript">

document.getElementBy.addEventListener( 'click', function () {
    // check for and report errors here
    for( var index = 0; index < document.forms.length; index++ ) {
        document.forms[index].submit();
    };

} );
	function addToCart(cartForm){
		//확인 : true, 취소 : false
	 alert(cartForm.addForm.value)
	//	 e.preventDefault();
		if (confirm("상품을 장바구니에 추가하시겠습니까?")) { //확인
			form = document.getElementsByName("addForm");
			form.submit();
		} else { //취소
			document.addForm.reset();
		}
	//   return true;
	}
</script>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 정보</h1>
		</div>
	</div>

	<c:forEach items="${listAll.itemSetList}" var="itemSet" varStatus="stat">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<img src="/kosSpring/fileupload/product/${itemSet.kpfile}"
					style="width: 60%;height:250px;" />
			</div>
			<div class="col-md-8">
				<h3>${itemSet.kpname}</h3>
				<p>${itemSet.kpdesc}</p>
				<p>
					<b>상품코드 : </b> <span class="badge badge-danger">${itemSet.kpnum}</span>
				</p>
				<p>
					<b>제조사</b> :${itemSet.kpcompany} 
				</p>
				<h4>${itemSet.kpprice}원</h4>
				<p>
				<form id="addForm" name="addForm" method="post"
					action="kosmoProductSelect.k?kpnum=${itemSet.kpnum}">
					<a href="#" class="btn btn-info" onclick="addToCart('this')"> 상품 주문
						&raquo;</a> <a href="cart.jsp" class="btn btn-warning">장바구니&raquo;</a>
					<a href="products.jsp" class="btn btn-secondary">상품 목록&raquo;</a>
				</form>
			</div>
		</c:forEach>
		</div>
	</div>
</body>
</html>
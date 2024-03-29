<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="a.b.c.com.kos.product.vo.KosmoProductVO" %> 
<%@ page import="java.util.List" %>  
    
<% request.setCharacterEncoding("UTF-8");%> 
<%

	Object obj = request.getAttribute("listS");
	List<KosmoProductVO> list = (List)obj;
	
	String kpprice = "";
	KosmoProductVO _kpvo = null;
	if (list.size() == 1) {
		_kpvo = list.get(0);
		kpprice = _kpvo.getKpprice();
	} 
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/kosSpring/js/common.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">

	$(document).ready(function(){

		let kpprice = '<%= kpprice %>';
		kpprice = comma(kpprice);
		console.log(kpprice);
		$('#kpprice').val(kpprice);
		
		$(document).on('change', '#kpcnt', function(){
			alert('kpcnt >>> : ')
			let cntS = $('#kpcnt').val();
			alert("cntS >>> : " + cntS);			
			let kppriceSum = comma_replace(kpprice) * cntS;			
			$('#kppricesum').val(comma(kppriceSum));
		});
		
		$(document).on('click', '#cartBtn', function(){
			alert('cartBtn >>> : ');
			
			let kpcntV = $('#kpcnt').val();
			alert("kpcntV >>> : " + kpcntV);
			let priceSum = $('#kppricesum').val();
			alert("priceSum >>> : " + priceSum);
			
			if (kpcntV == 0 && priceSum == 0){
				alert("상품을 수량을 선택하시오 !!!");
				return;
			}
			
			$('#productSelectForm').attr({"action":"kosmoCartInsert.k", "method":"GET"}).submit();
		});
		
		$(document).on('click', '#stockBtn', function(){
			alert('stockBtn >>> : ');
		});
		
		$(document).on('click', '#orderBtn', function(){
			alert('orderBtn >>> : ');
			
			let kpcntV = $('#kpcnt').val();
			alert("kpcntV >>> : " + kpcntV);
			let priceSum = $('#kppricesum').val();
			alert("priceSum >>> : " + priceSum);
			
			if (kpcntV == 0 && priceSum == 0){
				alert("상품을 수량을 선택하시오 !!!");
				return;
			}
			
			$('#productSelectForm').attr({"action":"kosmoOrderInsertForm.k", "method":"GET"}).submit();
		});
	});	

</script>
<style type="text/css">

	table {		
	    margin: 20px auto;	     
	}

	table, td, th {
	    border-collapse : collapse;
	    border : 1px solid black;
	};
</style>
</head>
<body>
<h3>kosmoProductSelect.jsp</h3>
<hr>
<div>
<form name="productSelectForm" id="productSelectForm">
<table>
<tr>
<td rowspan="7" align="center" vertical-algin="middle" style="width:200px;">
<img src="/kosSpring/fileupload/product/<%= _kpvo.getKpfile() %>" width="130" height="130">
</td>
<td align="center" colspan="2" >
<input 	type="text" name="kpname" id="kpname" value="<%= _kpvo.getKpname() %>" 
		style="width:300px;text-align:center;" readonly />	
</td>
</tr>
<tr>
<td align="right" colspan="2">
<input 	type="text" name="kpprice" id="kpprice" value="<%= kpprice %>" 
		style="width:280px;text-align:right;" readonly />&nbsp;원
</td>
</tr>
<tr>
<td><label align="left">수량 :</label></td>
<td align="right">  
	<select name="kpcnt" id="kpcnt" style="width:200px;">
		<option value="0">수량</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
	</select>
</td>
</tr>
<tr>
<td><label align="left">총 합계 :</label> </td>
<td align="right">
<input 	type="text" name="kppricesum" id="kppricesum" value="0" 
		style="width:170px;text-align:right;" readonly />&nbsp;원
</td>
</tr>
<tr>
<td algin="center" colspan="2">
<input type="hidden" name="kpfile" id="kpfile" value="<%= _kpvo.getKpfile() %>" >
<input type="hidden" name="kpid" id="kpid" value="<%= _kpvo.getKpid() %>" >
<input type="hidden" name="kpnum" id="kpnum" value="<%= _kpvo.getKpnum() %>" >
<input type="hidden" name="kmnum" id="kmnum" value="<%=  1234 %>" >
<input type="button" id="cartBtn" value="장바구니" style="width:150px;">
<input type="button" id="stockBtn" value="재고확인" style="width:155px;">
</td>
</tr>
<tr>
<td algin="center" colspan="2">
<input type="button" id="orderBtn" value="구매하기" style="width:310px;" >
</td>
</tr>
</table>
</form>
</div>
</body>
</html>

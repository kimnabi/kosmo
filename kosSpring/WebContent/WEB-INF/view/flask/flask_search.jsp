<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
    //form input 태그에서 아규먼트를 입력받아 ajax의 파라메터로 넘긴다
	//클라이언트 ajax 에서 파이션서버로 아규먼트를 넘겨서 요청한다
	function test(){
	    var text_data = $('#item_id').val();
	     let urlStr = 'http://127.0.0.1:5000/hello/'+text_data,
	    $.ajax({
	            type : 'GET',                                 
	            url : urlStr,
//	            url : 'http://127.0.0.1:5000/hello/'+text_data, //디버깅 에러찾기 어렵다
	            
	            dataType : 'text',
	            success : function(result){
	                    alert("result = "+ result);
	                    $('#res').html(result);
	            },
	            error : function(xtr,status,error){
	                    alert(xtr +":"+status+":"+error);
	                    $('#res').html("잘못된 데이타로 요청실패합니다");
	            }
	    });
	}

</script>
</head>
<body>
<p>find item</p>
<input type = "text" name="item_id" id="item_id"/>
<input type = "button" value = "send" onclick="test()"/>
<h1 id ="res"></h1>
</body>
</html>
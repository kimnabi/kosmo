<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
    //form input 태그에서 아규먼트를 입력받아 ajax의 파라메터로 넘긴다
	//클라이언트 ajax 에서 파이션서버로 아규먼트를 넘겨서 요청한다
    $("#btn").click(function(){
    	 var text_data = $('#city_id').val();
	     let urlStr = 'http://127.0.0.1:5000/'+text_data;
	    $.ajax({
	            type : 'GET',                                 
	            url : urlStr,
//	            url : 'http://127.0.0.1:5000/hello/'+text_data, //디버깅 에러찾기 어렵다
	            
	            dataType : 'json',
	            success : function(result){
	                    alert("result = "+ result);
	                 //html태그문자열 더한다
	               	 var listHtml= "<table border='1'>";
	               			listHtml+=  "<tr>";
	    	                listHtml+="<td>country_code</td>";
	    	                listHtml+= "<td>coordinate</td>";
	    	                listHtml+= "<td>temp</td>";         
	    	                listHtml+=  "<td>pressure</td>";
	    	                listHtml+=  "<td>humidity</td>";
	    	                listHtml+= "</tr>";
	    	                listHtml+= "<tr>";
	    	                listHtml+= "<td>"+result['sys']['country']+"</td>";
	    	                listHtml+= "<td>"+"위도"+result['coord']['lon'] + "  경도"+result['coord']['lat']+"</td>";
	    	                listHtml+= "<td>"+k2c(result['main']['temp']).toFixed(1)+ "°C" + "</td>";
	    	                listHtml+= "<td>"+result['main']['pressure']+"</td>";
	    	                listHtml+=  "<td>"+result['main']['humidity']+"</td>";
	    	                listHtml+=  "</tr>"

	    	                listHtml+= "</table>";
	    	              //html태그문자열 를 html 태그로 변환해서 추가한다
	                    $('#res').html(listHtml);
	            },
	            error : function(xtr,status,error){
	                    alert(xtr +":"+status+":"+error);
	                    $('#res').html("잘못된 데이타로 요청실패합니다");
	            }
    	}); //end ajax JQ  function
    });  //end click JQ  function
    $("#city_id").keydown(function(e){
    	if (e.keyCode === 13) {
		    	    e.preventDefault();
		    	    // do something
		    	    var text_data = $('#city_id').val();
			     let urlStr = 'http://127.0.0.1:5000/'+text_data;
			    $.ajax({
			            type : 'GET',                                 
			            url : urlStr,
		//	            url : 'http://127.0.0.1:5000/hello/'+text_data, //디버깅 에러찾기 어렵다
			            
			            dataType : 'json',
			            success : function(result){
			                    alert("result = "+ result);
			                 //html태그문자열 더한다
			               	 var listHtml= "<table border='1'>";
			               			listHtml+=  "<tr>";
			    	                listHtml+="<td>country_code</td>";
			    	                listHtml+= "<td>coordinate</td>";
			    	                listHtml+= "<td>temp</td>";         
			    	                listHtml+=  "<td>pressure</td>";
			    	                listHtml+=  "<td>humidity</td>";
			    	                listHtml+= "</tr>";
			    	                listHtml+= "<tr>";
			    	                listHtml+= "<td>"+result['sys']['country']+"</td>";
			    	                listHtml+= "<td>"+"위도"+result['coord']['lon'] + "  경도"+result['coord']['lat']+"</td>";
			    	                listHtml+= "<td>"+k2c(result['main']['temp']).toFixed(1)+ "°C" + "</td>";
			    	                listHtml+= "<td>"+result['main']['pressure']+"</td>";
			    	                listHtml+=  "<td>"+result['main']['humidity']+"</td>";
			    	                listHtml+=  "</tr>"
		
			    	                listHtml+= "</table>";
			    	              //html태그문자열 를 html 태그로 변환해서 추가한다
			                    $('#res').html(listHtml);
			            },
			            error : function(xtr,status,error){
			                    alert(xtr +":"+status+":"+error);
			                    $('#res').html("잘못된 데이타로 요청실패합니다");
			            }
		    	}); //end ajax JQ  function
    	   }// end if
    }); //end keydown JQ  function
}); //end ready JQ  function

//json 파일 파싱하기
function parseHtml(jsonObject) {
    var country = jsonObject.sys.country;
    var lon = jsonObject.coord.lon;
    var lat = jsonObject.coord.lat;
    var weather = jsonObject.weather.main;
    
    listHtml+= "<td>"+result['sys']['country']+"</td>";
    listHtml+= "<td>"+"위도"+result['coord']['lon'] + "  경도"+result['coord']['lat']+"</td>";
    listHtml+= "<td>"+k2c(result['main']['temp']).toFixed(1)+ "°C" + "</td>";
    listHtml+= "<td>"+result['main']['pressure']+"</td>";
    listHtml+=  "<td>"+result['main']['humidity']+"</td>";
    var output = "국가 : " + country + "<td>";
           output	+= "위도 : " + lon +", 경도"+lat+"<td>";
    			// "풍속 : " + wind + "<td>";
    			 //"날씨 : " + weather + "<br>";
    

    $('#res').html(output);
}
    
	function k2c(k) {
		return k - 273.15;
	}

</script>
</head>
<body>
<p>find city</p>
<input type = "text" name="city_id" id="city_id"/>
<input type = "button" id="btn" value = "send" />
<div id ="res"></div>


</body>
</html>
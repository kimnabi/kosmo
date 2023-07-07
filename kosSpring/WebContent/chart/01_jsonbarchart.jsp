<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	//구글 시각화 API를 로딩하는 메소드
	google.charts.load('current', {
		packages : [ 'corechart' ]
	});


	var jsonUrl = "/kosSpring/chart/json_barchart.json";
   
    
	$(document).ready(function() {
		alert("테스트");
     $("#btn").on("click",function(){
    	 alert("click테스트");
    	 
    	    $.ajax({
    	    	url : jsonUrl,
    	       	type: "POST",         
    	       	dataType: "text",
    	       	success: whenSuccess
    		});
    	 //draw();
     });
	});
	function whenSuccess(data) {
		//var JsonData = JSON.parse(data)
		var queryObject = "";
    	var queryObjectLen = "";
		   queryObject = eval('[' + JSON.stringify(data,null, 2) + ']');
  alert(queryObject)
          //  queryObjectLen = queryObject.dustlist.length;
		//   var arr2D = new Array(4).fill(new Array(4).fill(0));
        	
        //	for(var i=0; i<arr2D.length; i++) {
    		//	for(var term=0; term<arr2D[i].length; term++){
    	//			 arr[i][term]= JsonData[i].YYYY;
    		//		 arr[i][term]= JsonData[i].COSTS;
    	//			 arr[i][term]= JsonData[i].SALES;
        //	    }
      //  	}
	var str ="[";
	str +="['년도', '매출액', '비용'],";
	var num =0;

	queryObject.forEach(function(data, idx){
	    console.log(data+"|:::"+idx);
		str +="['";
		str  += data[idx].YYYY;
		str +="' , ";
		str += data[idx].SALES;
		str +="' , ";
		str += data[idx].COSTS;
		str +=" ]";
		
		num ++;
		if(num<queryObject.length){
			str +=",";
		}		
		str += "]";
	    console.log( data[0].YYYY);
	});
		
	
		   // 묶은 세로 막대형 차트 1
        function columnChart1() {
         
        	// 버튼 클릭 시 ajax를 사용하여 서버로부터 json 배열 객체를 가져왔다고 가정함
        	
            const arr = [];
            arr.push(['년도', '매출액', '비용']);
            arr.push(str);
            // 실 데이터를 가진 데이터테이블 객체를 반환하는 메소드
            var dataTable = google.visualization.arrayToDataTable(arr);
            
            // 옵션객체 준비
            var options = {
                        title: '회사 실적',
                        legend: { position: 'none' },
                        hAxis: { title: '년도',
								titleTextStyle: {color: 'red'}}
                       };
            
            var chart = new google.visualization.ColumnChart(document.getElementById('column_chart_div1'));
           	chart.draw(dataTable, options);
            
         } // drawColumnChart1()의 끝
         
         columnChart1();
      }
	
</script>
<body>

	<button type="button" id="btn">버튼</button>
	<div id="column_chart_div1" style="width: 900px; height: 500px;"></div>
</body>
</body>
</html>
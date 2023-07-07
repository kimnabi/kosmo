<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<style type="text/css">
table {
	font-size: 12px;
}

#tempc, #temp1, #temp2, #temp3, #temp4, #temp5 {
	font-size: 15px;
	font-style: oblique;
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						alert("JQeury 블록진입")
						const weater_icon = {
							'01' : 'http://www.weather.go.kr/images/icon/NW/NB01.png', //맑음    			
							'02' : 'http://www.weather.go.kr/images/icon/NW/NB02.png', //구름조금
							'03' : 'http://www.weather.go.kr/images/icon/NW/NB03.png', //구름
							'04' : 'http://www.weather.go.kr/images/icon/NW/NB03.png', //구름
							'09' : 'http://www.weather.go.kr/images/icon/NW/NB20.png', //비조금
							'10' : 'http://www.weather.go.kr/images/icon/NW/NB08.png', //비
							'11' : 'http://www.weather.go.kr/images/icon/NW/NB14.png', //뇌우
							'13' : 'http://www.weather.go.kr/images/icon/NW/NB11.png', //눈
							'50' : 'http://www.weather.go.kr/images/icon/NW/NB15.png' //안개
						};
						const uvic = {
							0 : "낮음",
							1 : "낮음",
							2 : "낮음",
							3 : "보통",
							4 : "보통",
							5 : "보통",
							6 : "보통",
							7 : "높음",
							8 : "높음",
							9 : "높음",
							10 : "매우높음"
						}
						
						$
								.ajax({
									url : "https://api.openweathermap.org/data/2.5/onecall?lat=37.48348&lon=126.87509&appid=55f5f90b442bd976fb95e41222268e35",
									type : "GET",
									dataType : "json",
									success : function(data) {
										alert(data)

										//let timec =$('#timec');
										let udtc = data.current.dt;
										let utime = unix_timestamp_curr(udtc);
										$('#timec').text(utime);
										//timec.innerText = unix_timestamp_curr(udtc);

										//let tempc = document.querySelector('#tempc');
										//tempc.innerText = (data.current.temp).toFixed(1) + "°C";
										$('#tempc').text(
												k2c((data.current.temp))
														.toFixed(1)
														+ "°C");
										//console.log("dsad"+$('#tempc').val( k2c((data.current.temp).toFixed(1)) + "°C"))
										//let fill_tempc = document.querySelector('#fill_tempc');
										//fill_tempc.innerText = (data.current.feels_like).toFixed(1) + "°C";
										$('#fill_tempc').text(
												k2c((data.current.feels_like))
														.toFixed(1)
														+ "°C");

										//let descc = document.querySelector('#descc');
										//descc.innerText = data.current.weather[0].main;
										$('#descc').text(
												data.current.weather[0].main);

										//	let iconc = document.querySelector('#iconc');
										let iconselect = (data.current.weather[0].icon)
												.substr(0, 2);
										//	iconc.innerHTML = '<img src='+ weater_icon[iconselect] +' width="50px" height="50px">';
										$('#iconc')
												.html(
														'<img src='+ weater_icon[iconselect] +' width="50px" height="50px">')
										//let humidity = document.querySelector('#humidity');
										//humidity.innerText = data.current.humidity + "%";
										$('#humidity').text(
												data.current.humidity + "%");

										//let description = document.querySelector('#description');
										//description.innerText = data.current.weather[0].description;
										$('#description')
												.text(
														data.current.weather[0].description);

										var temp = parseInt(data.current.uvi)
										if (temp > 10) {
											// alert(parseInt(data.current.uvi) > 10)
											$('#uvic').text('위험');
										} else {
											$('#uvic').text(uvic[temp]);
										}
										//var $data = $(data).find("hourly");
										var $data = data.hourly;
										//var $data = JSON.parse(data.hourly);
										console.log(typeof $data);
										//alert("sdadsa"+$data)
										//시간별 날씨
										for (var i = 1; i < 6; i++) {
											$.each($data, function(i, item){
											//기온
										//	alert("============================"+i)
											$('#temp'
													+ i + '').text(  
													k2c((item.temp))
															.toFixed(1)
															+ "°C");

											//체감
											
											$('#fill_temp'
													+ i + '').text(
													k2c((item.feels_like))
															.toFixed(1)
															+ "°C");
											
											//let weather =$(item).find("weather");
											//let weather =item.weather
											//아이콘
											var icon = item.weather[0].icon;
											$('#icon' + i+ '')
											.html('<img src='+  weater_icon[icon.substr(0,2)] +' width="50px" height="50px">')

											//날씨설명
											$('#desc' + i
													+ '')
											.text(item.main);
											//UV지수
											var tmp = parseInt(item.uvi)
											if (tmp > 10) {
												// alert(parseInt(data.current.uvi) > 10)
												$('#uvi' + i + '').text('위험');
											} else {
												$('#uvi' + i + '').text(
														uvic[tmp]);
											}

											//시간
											//$('#time' + i+ '').text(unix_timestamp($(item).find("dt").text()))
										});//end each
										}// end for
									} //end sucess
								});//end ajax
					}); // end jQeury 

	//유닉스 시간을 이용한다면 숫자 타입의 1489113000 - date 타입 변환
	function unix_timestamp_curr(t) {
		var date = new Date(t * 1000);
		//var year = date.getFullYear()
		var month = date.getMonth() + 1;
		var day = date.getDate()
		var hour = date.getHours();
		//var minute = "0" + date.getMinutes();
		//var second = "0" + date.getSeconds();
		return month + "월 " + day + "일 " + hour + "시";
	}
	function k2c(k) {
		return k - 273.15;
	}
	//unix 시간 변경
	function unix_timestamp(t){
		var date = new Date(t*1000);
		//var year = date.getFullYear()
		//var month = date.getMonth()+1;
		//var day = date.getDate()
		var hour = date.getHours();
		//var minute = "0" + date.getMinutes();
		//var second = "0" + date.getSeconds();
		return hour + "시";
	}
</script>
</head>

<body>
	<table width="100%">
		<tr>
			<td colspan="3" align="center">
				<div>
					<span id="tempc"></span><br> <span id="iconc"></span><br>
					<span id="descc"></span><br> <span id="timec"></span><br>
				</div>
			</td>
			<td colspan="2" align="center">
				<div>
					체감:<span id="fill_tempc"></span><br> 습도:<span id="humidity"></span><br>
					UV지수:<span id="uvic"></span><br> <span id="description"></span>
				</div>
			</td>
		</tr>

		<tr>
			<%
				for (int i = 1; i < 6; i++) {
			%>
			<td width="20%" align="center">
				<div>
					<span id="temp<%=i%>"></span><br> <span id="icon<%=i%>"></span><br>
					<span id="desc<%=i%>"></span><br> UV지수 : <span id="uvi<%=i%>"></span><br>
					체감 : <span id="fill_temp<%=i%>"></span><br> <span
						id="time<%=i%>"></span>
				</div>
			</td>
			<%
				}
			%>
		</tr>
	</table>
</body>
</html>
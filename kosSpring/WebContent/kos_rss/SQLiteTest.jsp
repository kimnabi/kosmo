<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery CDN 불러오기  -------------------------------------------->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		
		$(function(){
			// http://localhost:8088/kosServlet/kos_rss/choson_rss_xml.jsp
			let urlV = "ajax_chosun_rss.xml";
			let dtV = "xml";
			$.ajax({
				url: urlV,
				dataType: dtV,
				success: function(data){
					
					alert("data >>> : " + data);
					console.log("data >>> : " + data);
					/* <item>
								<title>
								<![CDATA[ 이태원 코로나 제주까지 상륙, 하루만에 뚫린 '코로나 청정' ]]>
								</title>
								<link>
								<![CDATA[ https://news.chosun.com/site/data/html_dir/2020/05/10/2020051000094.html ]]>
								</link>
								<description>
								<![CDATA[ 제주도의 ‘코로나 청정지역’이 하루만에 깨졌다.<br>제주도는 이달 5일 서울 용산구 이태원 킹클럽에 다녀온 여성 A(30)씨가 9일 오후 9시쯤 코로나 확진 판정을 받으면서 제주지역 14번째 확진자가 됐다고 밝혔다. <br><br> 제주도는 8일 오후 제주지역 5번 확진자인 20대 여성이 완치 판정을 받고 퇴원하면서 제주지역에 코로나 확진자 13명이... ]]>
								</description>
								<dc:date>2020-05-10T08:18:32+09:00</dc:date>
								<author>
								<![CDATA[ ]]>
								</author>
								<pubDate>Sun, 10 May 2020 08:18:32 +0900</pubDate>
						</item>
					*/
					var $items = $(data).find("item");
					alert("$items >>> : " + $items);
					// item 노드를 찾는다
					if ($items.length > 0) {
						
					// item 노드 중 10개 item 만 구한다
						$items = $items.slice(0, 10);
					    console.log(">>>>>>>>"+$items)	
					//    $.each($items, function(i, item_data){
					//    	console.log(item_data)
					//    });
					    // html 태그를 만든다 <a href="$link" target="_blank" title="$title" />
						var $ulTag = $("<ul />");
												
						$.each($items, function(i, item_data){
							// item 자식노드 중 title 노드를 찾아서 값를 읽어온다
							var $title = $(item_data).find('title').text();
							// item 자식노드 중 link 노드를 찾아서 값를 읽어온다
							var $link = $(item_data).find('link').text();
							
							var $aTag = $("<a />").attr({
								"href":$link,
								"target":"_blank"
							}).text($title);
							
							var $liTag = $("<li />").append($aTag);
							
							$ulTag.append($liTag);
						});
						//만든  html 태그를  DIV태그에 붙인다
						$('.wrap').append($ulTag);
					}
				},
				error: function(e){
					alert(e.responseText);
				}
			});
		});
	});

</script>
</head>
<body>
<h3>조선닷컴 오늘의 주요뉴스 RSS 읽기</h3>
<hr>
<div class="wrap"></div>
</body>
</html>
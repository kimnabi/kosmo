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
	//웹소켓 연결 한다
	$('#btnConnect').click(function(event){
		alert(event.data)
		//채팅 서버 주소
		let url = "ws://localhost:8088/kosSpring/chatserver";
		let ws //전역변수로
		
		let usr =$('#user').val().trim();
		//유저이름이 있을때
		if(usr != null&& usr.length>0){
			// 웹 소켓연결
			 	ws = new WebSocket(url);

			// 연결 성공시 callback
			 ws.onopen = function (evt) {
			   		console.log('서버 연결 성공');
			   		print2($('#user').val(), '입장했습니다.');
			   		ws.send('1#' + $('#user').val() + ':');
			   		$('#btnConnect').prop('disabled',true) 
			   		$('#btnDisconnect').prop('disabled',false) //활성화
			   		//대화 입력 테크 활성화 
			   		$('#msg').prop('disabled',false)
				};
				//메시지 받아서와서 클라이언트에 메시지 뿌려준다
				ws.onmessage = function (evt) {
				//	print1('', evt.data);
				alert(evt.data)
					let index = evt.data.indexOf(":");
					let no = evt.data.substring(0, 1); 
					let user = evt.data.substring(2, index);
				//	let user = evt.data.substring(2, index);
					let txt = evt.data.substring(index + 1);
					
			   				
					if (no == '1') {
						print2(user);
					} else if (no == '2') {
						print1(user, txt);
					} else if (no == '3') {
						print3(user);
					}
				//	$('#list').scrollTop($('#list').prop('scrollHeight'));
				};
		}
		
			//서버에 메세지 전달
		$('#msg').keydown(function(event){
			//입력값이엔터 일때
			if (event.keyCode == 13) {
				//$('#btnConnect').click();
				console.log( $(this).val());
				ws.send('2#' + $('#user').val() + ':' + $(this).val()); //서버에게 메세지 전달 : 
				print1($('#user').val(),  $(this).val()) // 메세지 보여주기
			}
		});
			
		//종료 이벤트발생	
		$('#btnDisconnect').click(function(event){
	
				console.log( "click");
		 		$('#btnConnect').prop('disabled',false) // 연결버튼 활성화
		   		$('#btnDisconnect').prop('disabled',true) //비활성화
				ws.send('3#' + $('#user').val() + ':' + $(this).val()); //서버에게 종료메세지 전달 : 
				print3($('#user').val()) // 메세지 보여주기
			
		});
		//<div id="list"></div>
	})
		// 메세지 전송 및 아이디
	function print1(user, txt) {
			let temp = '';
			temp += '<div style="margin-bottom:3px;">';
			temp += '[' + user + '] ';
			temp += txt;
			temp += ' <span style="font-size:11px;color:#777;">' + new Date().toLocaleTimeString() + '</span>';
			temp += '</div>';
					
			$('#list').append(temp);
		}
	// 접속상태를 출력한다
	function print2(user) {
			let temp = '';
			temp += '<div style="margin-bottom:3px;">';
			temp += "" + user + " 이(가) 접속했습니다." ;
			temp += ' <span style="font-size:11px;color:#777;">' + new Date().toLocaleTimeString() + '</span>';
			temp += '</div>';
					
			$('#list').append(temp);
		}
	// client 접속 종료 메세지 전달 출력
	function print3(user) {
		let temp = '';
		temp += '<div style="margin-bottom:3px;">';
		temp += "'" + user + "' 이(가) 종료했습니다." ;
		temp += ' <span style="font-size:11px;color:#777;">' + new Date().toLocaleTimeString() + '</span>';
		temp += '</div>';
				
		$('#list').append(temp);
	}
}); // end $ ready

</script>
<style type="text/css">

	.container {
		width: 500px;
	}
	
	#list {
		height: 300px;
		padding: 15px;
		overflow: auto;
	}

</style>
</head>
<body>
	<div class="container">
		<h1 class="page-header">Chat</h1>		
		
		<table class="table table-bordered">
			<tr>
				<td><input type="text" name="user" id="user" class="form-control" placeholder="유저명"></td>
				<td>
					<button type="button" class="btn btn-default" id="btnConnect">연결</button>
					<button type="button" class="btn btn-default" id="btnDisconnect" disabled>종료</button>
				</td>
			</tr>
			<tr>
				<td colspan="2"><div id="list"></div></td>
			</tr>
			<tr>
				<td colspan="2"><input type="text" name="msg" id="msg" placeholder="대화 내용을 입력하세요." class="form-control" disabled></td>
			</tr>
		</table>
		
	</div>
</body>
</html>
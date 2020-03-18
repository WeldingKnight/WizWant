$(document).ready(function() {
	let sock = new SockJS("./webSocket");
	//웸소켓을 지정한 url로 연결한다.
	let ws = Stomp.over(sock);
	ws.connect({}, frame=>{
		ws.subscribe("/user/chat/errors", message=>{
			alert("메시지 전송 오류 " + message.body)
		});
		
		ws.subscribe("/user/chat/reply", message=>{
			$("#data").append(message.body + "<br>")
		});
	}, error=>{
		$("#data").append("STOMP error " + error);
	});
	$("#sendBtn").click(function() {
		sendMessage();
	});
	function sendMessage() {
		/*소켓으로 보내겠다.  */
		ws.send("/app/chat",  /*{userId:session.userId}*/{},$("#message").val());
	}
	function disconnect() {
	    if(ws != null){
	        ws.disconnect();
	    }
	    $("#data").append("연결 끊김");
	}
});




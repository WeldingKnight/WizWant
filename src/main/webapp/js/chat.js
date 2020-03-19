let sock = new SockJS("./webSocket");
//웸소켓을 지정한 url로 연결한다.
let ws = Stomp.over(sock);
ws.connect({}, frame=>{
	ws.subscribe("/chat/errors", message=>{
		alert("메시지 전송 오류 " + message.body);
	});

	ws.subscribe("/chat/roomId", message=>{
		let data = JSON.parse(message.body);
//		console.log(data);
		
		$("#data").append(data.writer + " : " + data.body + "<br>");
		
	});
}, error=>{
	$("#data").append("STOMP error " + error);
});
$("#sendBtn").click(function() {
	sendMessage();
});
function sendMessage() {
	/*소켓으로 보내겠다.  */
	let writer = document.frm.userId.value;
	let body = document.frm.message.value;
//	console.log(body)
	ws.send("/app/chat",  {},JSON.stringify({'body':body, 'writer':writer}));
	return false;
}
function disconnect() {
	if(ws != null){
		ws.disconnect();
	}
	$("#data").append("연결 끊김");
}




<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="./js/jquery-2.2.4.min.js"></script>
<script src="./js/sockjs.min.js"></script>
<script src="./js/stomp.min.js"></script>
<script src="./js/chat.js"></script>

<title>ChatRoom</title>
</head>
<body>
	<form name="frm" method="post" onsubmit="return sendMessage()">
		<input type="hidden" name="userId" value="${ sessionScope.loginuser.id }">
    	<input type="text" name="message" />
    	<input type="submit" id="sendBtn" value="전송" />
	</form> 
    <div id="data"></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/delete.css">
<script src="./js/jquery-2.2.4.min.js"></script>
<script src="./js/jquery-ui.min.js"></script>
<script src="./js/jquery.easing.1.3.js"></script>
<script src="./js/delete.js"></script>
<title>È¸¿øÅ»Åð</title>
</head>
<body id="delete_body">
	<div id="delete_wrap">
		<h1 style="font-size: 80px; color: dodgerblue;">
			<a href="wiz_want.do">WIZ*WANT</a>
		</h1>

		<h1 style="font-size: 30px; color: dodgerblue;">È¸¿øÅ»Åð</h1>
		<form action="delete.do" id="delete_form" method="post">
			<table id="delete_table">

				<tr>
					<td>¾ÆÀÌµð</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;" type="text" readonly value="${sessionScope.loginuser.id}"
						id="id" name="id" accesskey="L" maxlength="41"  >
						
				</tr>
				<tr>
					<td>ºñ¹Ð¹øÈ£</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;"
						type="text" id="password" name="password" accesskey="L" maxlength="41"  >
						<input type="hidden" id="login_pw" name="login_pw" value="${sessionScope.loginuser.password}">
						<div class="check_font" id="delete_pw"></div></td>
				</tr>
			
			
				<tr>
					<td><input id="delete_user" type="submit" alt="È¸¿øÅ»Åð"
						value="È¸¿øÅ»Åð" />
					</td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>
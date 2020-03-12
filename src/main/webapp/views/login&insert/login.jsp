<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/login.css">
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body id="login_body">
	<div id="login_wrap">
		<h1 style="font-size: 80px; color: white;"><a href="wiz_want.do">WIZ*WANT</a></h1>

		<h1 style="font-size: 50px; color: white;">로그인</h1>

				<form name="login_form" method="post" action="login.do" id="login_form">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							
							<td><input type="text" class="login_input" name="id" value="${userVO.id}" placeholder="아이디" /></td>
						</tr>
						<tr>
					
							<td><input type="password" class="login_input" name="password"value="${userVO.password}" placeholder="PASSWORD" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							  <input  type="submit" class="login_input"  value="로그인" />
							 </td>
						</tr>

					</table>
				</form>
	</div>
</body>
</html>
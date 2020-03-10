<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/login.css">
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div id="login_wrap">
		<h1 style="font-size: 80px; color: dodgerblue;">WIZ*WANT</h1>

		<h1 style="font-size: 50px; color: dodgerblue;">로그인<h1>

				<form name="login_form" method="POST" action="login.do" id="login_form">
					<table border="1" cellpadding="0" cellspacing="0">
						<tr>
							<td >아이디</td>
							<td><input type="text" name="id" value="${userVO.id}" /></td>
						</tr>
						<tr>
							<td >비밀번호</td>
							<td><input type="password" name="password"
								value="${userVO.password}" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							  <input type="submit" value="로그인" />
							 </td>
						</tr>

					</table>
				</form>
	</div>
</body>
</html>
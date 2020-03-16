<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원탈퇴</title>
</head>
<body>
	<div>
		<h1 style="font-size: 80px; color: dodgerblue;">
			<a href="wiz_want.do">WIZ*WANT</a>
		</h1>

		<h1 style="font-size: 30px; color: dodgerblue;">회원탈퇴</h1>
		<form action="delete.do" id="delete_form" method="post">
			<table id="delete_table">

				<tr>
					<td>아이디</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;" type="text"
						id="id" name="id" accesskey="L" maxlength="41" >
						<div class="check_font" id="insert_idchk"></div></td>
				</tr>
				<tr>
					<td>비밀번호</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;"
						type="password" id="password" name="password" accesskey="L" maxlength="41" >
						<div class="check_font" id="insert_pw"></div></td>
				</tr>
			
			
				<tr>
					<td><input id="delete_user" type="submit" alt="회원탈퇴"
						value="회원탈퇴" />
					</td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>
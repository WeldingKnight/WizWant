<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel="stylesheet" href="./css/insert.css">
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body id="insert_body">
	<div id="insert_wrap">
		<h1 style="font-size: 80px; color: dodgerblue;"><a href="wiz_want.do">WIZ*WANT</a></h1>

		<h1 style="font-size: 30px; color: dodgerblue;">회원가입</h1>

		<form action="insert.do" id="insert_form" method="post">
			<table id="insert_table">

				<tr>
					<td>아이디</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;" type="text"
						id="id" name="id" accesskey="L" maxlength="41" ></td>
				</tr>
				<tr>
					<td>비밀번호</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;"
						type="password" id="password" name="password" accesskey="L" maxlength="41" ></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;"
						type="password" id="pwdchk" name="pwdchk" accesskey="L"
						maxlength="41" ></td>
				</tr>
				<tr>
					<td>이름</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;" type="text"
						id="name" name="name" accesskey="L" maxlength="41" ></td>
				</tr>
				<tr>
					<td>본인 확인 이메일</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;" type="email"
						id="email" name="email" accesskey="L" maxlength="41"></td>
				</tr>
				<tr>
					<td>성별</td>
				</tr>
				<tr>
					<td><select name="sex" id="sex"
						style="width: 300px; height: 30px; font-size: 20px;">
							<option value="none">성별</option>
							<option value="남">남</option>
							<option value="여">여</option>
					</select></td>
				</tr>
				<tr>
					<td>생년월일</td>
				</tr>
				<tr>
					<td>
						<input style="width: 300px; height: 30px; font-size: 20px;" type="text" id="birth" name="birth" accesskey="L" maxlength="41">
					</td>
				</tr>
				<tr>
					<td>주소</td>
				</tr>
				<tr>
					<td>
						<input style="width: 300px; height: 30px; font-size: 20px;" type="text" id="address" name="address" accesskey="L" maxlength="41" >
					</td>
				</tr>
				<tr>
					<td><input id="insert_input" type="submit" alt="회원가입"
						value="회원가입" />
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ��Ż��</title>
</head>
<body>
	<div>
		<h1 style="font-size: 80px; color: dodgerblue;">
			<a href="wiz_want.do">WIZ*WANT</a>
		</h1>

		<h1 style="font-size: 30px; color: dodgerblue;">ȸ��Ż��</h1>
		<form action="delete.do" id="delete_form" method="post">
			<table id="delete_table">

				<tr>
					<td>���̵�</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;" type="text"
						id="id" name="id" accesskey="L" maxlength="41" >
						<div class="check_font" id="insert_idchk"></div></td>
				</tr>
				<tr>
					<td>��й�ȣ</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;"
						type="password" id="password" name="password" accesskey="L" maxlength="41" >
						<div class="check_font" id="insert_pw"></div></td>
				</tr>
			
			
				<tr>
					<td><input id="delete_user" type="submit" alt="ȸ��Ż��"
						value="ȸ��Ż��" />
					</td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>
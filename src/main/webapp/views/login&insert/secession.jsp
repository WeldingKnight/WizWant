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
		<form action="insert.do" id="insert_form" method="post">
			<table id="insert_table">

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
					<td>��й�ȣ Ȯ��</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;"
						type="password" id="pwdchk" name="pwdchk" accesskey="L"
						maxlength="41" >
						<div class="check_font" id="insert_pwcConfirm"></div>
						</td>
				</tr>
				<tr>
					<td>�̸�</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;" type="text"
						id="name" name="name" accesskey="L" maxlength="41" ></td>
				</tr>
				<tr>
					<td>���� Ȯ�� �̸���</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;" type="email"
						id="email" name="email" accesskey="L" maxlength="41"></td>
				</tr>
				<tr>
					<td>��ȭ��ȣ</td>
				</tr>
				<tr>
					<td><input
						style="width: 300px; height: 30px; font-size: 30px;" type="tel"
						id="tel" name="tel" accesskey="L" maxlength="41"></td>
				</tr>
				<tr>
					<td>����</td>
				</tr>
				<tr>
					<td><select name="sex" id="sex"
						style="width: 300px; height: 30px; font-size: 20px;">
							<option value="no">����</option>
							<option value="��">��</option>
							<option value="��">��</option>
					</select></td>
				</tr>
				<tr>
					<td>�������</td>
				</tr>
				<tr>
					<td>
						<input style="width: 300px; height: 30px; font-size: 20px;" type="text" id="birth" name="birth" accesskey="L" maxlength="41" placeholder="�������8�ڸ��� �Է��ϼ���.">
					</td>
				</tr>
				<tr>
					<td>�ּ�</td>
				</tr>
				<tr>
					<td>
						<input style="width: 300px; height: 30px; font-size: 20px;" type="text" id="address" name="address" accesskey="L" maxlength="41" >
					</td>
				</tr>
				<tr>
					<td><input id="insert_input" type="submit" alt="ȸ������"
						value="ȸ������" />
					</td>
				</tr>
			</table>
		</form>

	</div>

</body>
</html>
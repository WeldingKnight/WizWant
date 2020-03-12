<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="../header_footer/header.jsp"></jsp:include>
<div id="update_wrap">
	<h1 class="mypage_title">회원정보수정</h1>

	<form action="./wiz_want_main.do" id="update_form">
		<table id="update_table">
			<tr>
				<td>아이디</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 30px;"
					type="text" id="id" name="id" maxlength="41" value="${sessionScope.loginuser.id}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 30px;"
					type="password" id="pwd" name="pwd" maxlength="41"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 30px;"
					type="password" id="pwdchk" name="pwdchk" maxlength="41"></td>
			</tr>
			<tr>
				<td>이름</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 30px;"
					type="text" id="name" name="name" maxlength="41" value="${sessionScope.loginuser.name}"></td>
			</tr>
			<tr>
				<td>성별</td>
			</tr>
			<tr>
				<td>성별 입력했던거</td>
			</tr>
			<tr>
				<td>생년월일</td>
			</tr>
			<tr>
				<td><input style="width: 90px; height: 30px; font-size: 20px;"
					type="text" id="birth_y" name="birth" maxlength="41">&nbsp;
					<select style="width: 90px; height: 30px; font-size: 20px;"
					name="birth_m" id="birth_m">
						<script>
							for (i = 0; i <= 12; i++) {
								if (i == 0) {
									document.write("<option>月</option>");
								} else {
									document
											.write("<option>" + i + "</option>");
								}
							}
						</script>
				</select>&nbsp; <input style="width: 90px; height: 30px; font-size: 20px;"
					type="text" id="birth_d" name="birth_d" maxlength="41"></td>
			</tr>
			<tr>
				<td>주소</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 20px;"
					type="text" id="adress" name="adress" maxlength="41"
					value="입력했던 주소"></td>
			</tr>
			<tr>
				<td><input
					style="width: 150px; height: 50px; font-size: 20px; background-color: dodgerblue; color: white;"
					type="submit" title="수정완료" alt="수정완료" value="수정완료"
					background-color="skyblue" id="insert"> <input
					style="width: 150px; height: 50px; font-size: 20px; background-color: dodgerblue; color: white;"
					type="reset" title="취소" alt="취소" value="취소"
					background-color="skyblue" id="insert"></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../header_footer/footer.jsp"></jsp:include>
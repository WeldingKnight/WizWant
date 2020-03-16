<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="../header_footer/header.jsp"></jsp:include>
<div id="update_wrap">
	<h1 class="mypage_title">회원정보수정</h1>

	<form action="./update.do" id="update_form" method="post">
		<table id="update_table">
			<tr>
				<td>아이디</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 30px;"
					type="text" id="id" name="id" maxlength="41"
					value="${sessionScope.loginuser.id}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 30px;"
					type="password" id="password" name="password" maxlength="41"></td>
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
					type="text" id="name" name="name" maxlength="41"
					value="${sessionScope.loginuser.name}"></td>
			</tr>
			<tr>
				<td>본인확인 이메일</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 20px;"
					type="text" id="email" name="email" accesskey="L" maxlength="41"
					value="${sessionScope.loginuser.email}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 30px;"
					type="tel" id="tel" name="tel" accesskey="L" maxlength="41" value="${sessionScope.loginuser.tel}"></td>
			</tr>
			<tr>
				<td>성별</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 30px;"
					type="text" id="sex" name="sex" maxlength="41"
					value="${sessionScope.loginuser.sex}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>생년월일</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 20px;"
					type="text" id="birth" name="birth" accesskey="L" maxlength="41"
					value="${sessionScope.loginuser.birth}"></td>
			</tr>
			<tr>
				<td>주소</td>
			</tr>
			<tr>
				<td><input style="width: 300px; height: 30px; font-size: 20px;"
					type="text" id="address" name="address" maxlength="41"
					value="${sessionScope.loginuser.address}"></td>
			</tr>
			<tr>
				<td><input
					style="width: 150px; height: 50px; font-size: 20px; background-color: dodgerblue; color: white;"
					type="submit" title="수정완료" alt="수정완료" value="수정완료"
					background-color="skyblue" id="insert"> <input
					style="width: 150px; height: 50px; font-size: 20px; background-color: dodgerblue; color: white;"
					type="reset" title="취소" alt="취소" value="취소"
					background-color="skyblue" id="insert">
					<a href="./delet.do"></a></td>
					
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../header_footer/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page import="com.shopping.MVC_reshop.qna.QnaVO" %>
<%@ page import="com.shopping.MVC_reshop.qna.QnaDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!-- header -->
<%@ include file="../header_footer/header.jsp"%>
<!-- //header -->

<!-- 스크립트릿 -->
	<%
		//스크립트릿 =>자바코드 작성
	request.setCharacterEncoding("UTF-8");
	%> 
<!-- //스크립트릿 -->

	<center>
	<h1>QNA 등록</h1>
	<hr>
		<form method='post' action='insertQna.do'>
			<table border='1' cellpadding='0' cellspacing='0'>
				<tr>
					<td bgcolor="orange" width="70">제목 :</td>
					<td align="left"><input type='text' name='qna_title' size='38'></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">작성자 :</td>
					<td> ${sessionScope.loginuser.id}</td>
					<input type='hidden' name='user_id' value='${sessionScope.loginuser.id}'/>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">종류:</td>
					<td>
						<select name="qna_kind">
							<option value="주문결제">주문결제</option>
							<option value="배송문의">배송문의</option>
							<option value="반품환불">반품환불</option>
							<option value="상품문의">상품문의</option>
						</select>
					</td>
				</tr>
				<tr>
					<td bgcolor='orange' width='70'>내용 :</td>
					<td align='left'><textarea name='qna_content' rows='10' cols='40'></textarea></td>
				</tr>
				<tr>
					<td colspan='2' align='center'>
						<input type='submit' value='글등록'/>
					</td>
				</tr>
				<tr>
					<td colspan='2' align='center'>
						<input type='reset' value='다시쓰기'/>
					</td>
				</tr>
			</table>
		</form>
		<a href='getQnaList.do'>게시판 돌아가기</a>
	</center>
<%@ include file="../header_footer/footer.jsp"%>
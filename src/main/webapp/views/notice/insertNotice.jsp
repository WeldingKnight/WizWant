<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page import="com.shopping.MVC_reshop.notice.NoticeVO" %>
<%@ page import="com.shopping.MVC_reshop.notice.NoticeDAO" %>
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
	<h1>공지사항 등록</h1>
	<hr>
		<form method='post' action='insertNotice.do'>
			<table border='1' cellpadding='0' cellspacing='0' width="748">
				<tr>
					<td bgcolor="orange" width="70">제목 :</td>
					<td align="left"><input type='text' name='notice_title' size='38' style="width:95%; border: 0; outline: none; padding: 7px;"></td>
				</tr>
				<tr>
					<td bgcolor='orange' width='70'>내용 :</td>
					<td align='left'><textarea name='notice_content' rows='10' cols='40' style="width:95%; border: 0; outline: none; padding: 7px;"></textarea></td>
				</tr>
				<tr>
					<td colspan='2' align='center'>
						<input type='submit' value='공지등록'/>
					</td>
				</tr>
				<tr>
					<td colspan='2' align='center'>
						<input type='reset' value='다시쓰기'/>
					</td>
				</tr>
			</table>
		</form>
		<a href='getNoticeList.do'>게시판 돌아가기</a>
	</center>
<%@ include file="../header_footer/footer.jsp"%>
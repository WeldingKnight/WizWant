<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import="com.shopping.MVC_reshop.notice.NoticeVO"%>
<%@ page import="com.shopping.MVC_reshop.notice.NoticeDAO"%>
<%@ page import="java.util.List"%>

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
	<h1>공지사항 수정</h1>
	<hr>
	<form action="updateNotice.do" method="POST">
		
		<table border='1' cellpadding='0' cellspacing='0' width='748'>
		
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input name="notice_title" type="text" style="width:95%; border: 0; outline: none; padding: 7px;"
					value="${notice.notice_title}" ></td>
						<input name="notice_id"  type="hidden" value="${notice.notice_id}"  />
			</tr>
			<tr>
				<td bgcolor="orange">내용</td>
				<td align='center'><textarea name="notice_content" rows="10" cols="40" style="width:95%; border: 0; outline: none; padding: 7px;">${notice.notice_content}</textarea></td>
			</tr>
			<tr>
				<td bgcolor="orange">등록일</td>
				<td align="left"><fmt:formatDate
						value="${notice.notice_timestamp}" pattern="yy-MM-dd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type='submit' value='수정'/>
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<a href='getInsertNotice.do'>글 등록</a>&nbsp;&nbsp;&nbsp; <a
		href='deleteNotice.do?qna_id=${notice.notice_id}'>글 삭제</a>&nbsp;&nbsp;&nbsp;
	<a href='getNoticeList.do'>전체 게시판</a>
</center>

<%@ include file="../header_footer/footer.jsp"%>
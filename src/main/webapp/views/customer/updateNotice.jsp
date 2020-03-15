<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page import="com.shopping.MVC_reshop.notice.NoticeVO" %>
<%@ page import="com.shopping.MVC_reshop.notice.NoticeDAO" %>
<%@ page import="java.util.List" %>

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
   <h1>글 상세 보기</h1>
   <hr>
   <form action="updateNotice.do" method="POST">
      <input name="seq" type="hidden" value="${not.not_id}"/>
      <table border='1' cellpadding='0' cellspacing='0'>
         <tr>
            <td bgcolor="orange" width="70">제목 </td>
            <td align="left"><input name="title" type="text" value="${not.not_title}"></td>
         </tr>
         <tr>
            <td bgcolor="orange">작성자 </td>
            <td align="left">${not.user_id}</td>
         </tr>
         <tr>
         	<td bgcolor="orange" width="70">종류:</td>
			<td>
				<select name="not_kind">
					<option value="공지">공지</option>
					<option value="이벤트">이벤트</option>
					<option value="안내">안내</option>
				</select>
			</td>
         </tr>
         <tr>
         	<td bgcolor="orange">내용</td>
         	<td align='center'><textarea name="content" rows="10" cols="40">${not.not_content}</textarea></td>
         </tr>
         <tr>
            <td bgcolor="orange">등록일</td>
            <td align="left"><fmt:formatDate value="${not.not_timestamp}"  pattern="yy-MM-dd"/></td>
         </tr>
         <tr>
            <td bgcolor="orange">조회수</td>
            <td align="left">${not.not_views}</td>
         </tr>
         <tr>
            <td colspan="2" align="center">
            	<input type='submit' value='글수정'/>
            </td>
         </tr>
      </table>
   </form>
   <hr>
   <a href='getInsertNotice.do'>글 등록</a>&nbsp;&nbsp;&nbsp;
   <a href='deleteNotice.do?qna_id=${not.not_id}'>글 삭제</a>&nbsp;&nbsp;&nbsp;
   <a href='getNoticeList.do'>전체 게시판</a>
   </center>
  
<%@ include file="../header_footer/footer.jsp"%>
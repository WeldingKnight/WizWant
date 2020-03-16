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
   <form action="getUpdateNotice.do" method="POST">
      <input name="notice_id" type="hidden" value="${notice.notice_id}" readonly/>
      <table border='1' cellpadding='0' cellspacing='0'>
         <tr>
            <td bgcolor="orange" width="70">제목 </td>
            <td align="left"><input name="title" type="text" value="${notice.notice_title}" readonly></td>
         </tr>
         <tr>
            <td bgcolor="orange">작성자 </td>
            <td align="left">${notice.notice_id}</td>
         </tr>
         <tr>
         	<td bgcolor="orange">내용</td>
         	<td align='center'><p name="content" rows="10" cols="40">${notice.notice_content}</p></td>
         </tr>
         <tr>
            <td bgcolor="orange">등록일</td>
            <td align="left"><fmt:formatDate value="${notice.notice_timestamp}"  pattern="yy-MM-dd"/></td>
         </tr>
         <c:if test='${sessionScope.loginuser.id==notice.notice_id}'>
         <tr>
            <td colspan="2" align="center">
            	<input type='submit' value='글수정'/>
            </td>
         </tr>
         </c:if>
      </table>
   </form>
   <hr>
   <a href='getInsertNotice.do'>새글 등록</a>&nbsp;&nbsp;&nbsp;
   <c:choose>
	 <c:when test="${sessionScope.loginuser.id==notice.notice_id}">
	 	<a href='deleteNotice.do?not_id=${notice.notice_id}'>글 삭제</a>&nbsp;&nbsp;&nbsp;
	 	<a href='getNoticeList.do'>전체 게시판</a>		
	 </c:when>
	 <c:otherwise>
	 	<a href='getNoticeList.do'>전체 게시판</a>
     </c:otherwise>
   </c:choose>      
   </center>
<%@ include file="../header_footer/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page import="com.shopping.MVC_reshop.qna.QnaVO" %>
<%@ page import="com.shopping.MVC_reshop.qna.QnaDAO" %>
<%@ page import="java.util.List" %>
<!-- header -->
<%@ include file="../header_footer/header.jsp"%>
<!-- //header -->

<!-- 스크립트릿 -->
	<%
		//스크립트릿 =>자바코드 작성
	request.setCharacterEncoding("UTF-8");
	
	%>
<%@ include file="tabmenu.jsp"%>

<!-- //스크립트릿 -->    
   <center>
   <h1>글 상세 보기</h1>
   <hr>
   <form action="getUpdateQna.do" method="POST">
      <table border='1' cellpadding='0' cellspacing='0' width='748'>
         <tr>
            <td bgcolor="orange" align='center' width="70">제목 </td>
            <td align="left">${qna.qna_title}</td>
            <td bgcolor="orange" align='center' width="70">작성자 </td>
            <td align="left" colspan='5'>${qna.user_id}</td>
         </tr>
         <tr>
         	<td bgcolor="orange" align='center'>글번호 </td>
         	<td>${qna.qna_id}</td>
         	<input name="qna_id" type="hidden" value="${qna.qna_id}" >
            <td bgcolor="orange" align='center'>등록일</td>
            <td align="left"><fmt:formatDate value="${qna.qna_timestamp}"  pattern="yy-MM-dd"/></td>
         </tr>
         <tr>
         	<td bgcolor="orange" align='center'>종류</td>
         	<td align="left">${qna.qna_kind}</td>
         	<td bgcolor="orange" align='center'>조회수</td>
            <td align="left">${qna.qna_views}</td>
         </tr>
         <tr>
         	<td bgcolor="orange" align='center'>내용</td>
         	<td align='left' colspan="5"><p rows="50" cols="40">${qna.qna_content}</p></td>
         </tr>
         <c:if test="${rep.reply_id != null}">
         <tr>
         	<td bgcolor="orange" align='center'>관리자<br>답변</td>
         	<td align='left' colspan="4">
	         	<p name="content" rows="50" cols="40">${rep.reply_content}</p>
         	</td>
         </tr>
   		 </c:if>
   		 <c:if test="${!empty rep.reply_content && sessionScope.loginuser.role == 0 }">
	   		 <tr>
	   		    <td align="center" colspan="5">
	         		<a href='deleteReply.do?qna_id=${rep.qna_id}&reply_id=${rep.reply_id}'>답변 삭제</a>
	         	</td>
	         </tr>
   		 </c:if>
         <c:if test='${sessionScope.loginuser.id==qna.user_id}'>
         <tr>
            <td colspan="5" align="center">
            	<input type='submit' value='글수정'/>
            </td>
         </tr>
         </c:if>
      </table>
   </form>
   <c:if test="${rep.reply_id eq null && sessionScope.loginuser.role==0}">
   	<form action="insertReply.do" method="post">
   		<table border='1' cellpadding='0' cellspacing='0'>
			<input type='hidden' name='reply_user' value='${sessionScope.loginuser.id}'/>
			<input name="qna_id" type="hidden" value="${qna.qna_id}"/>
			<tr>
				<td bgcolor='orange' width='70' align='center'>답변</td>
				<td align='left'><textarea name='reply_content' rows='5' cols='82'></textarea></td>
				<td colspan='2' align='center'>
					<input type='submit' value='답변등록'>
				</td>
			</tr>
		</table>
   	</form>
   </c:if>
   <hr>
   <a href='getInsertQna.do'>새글 등록</a>&nbsp;&nbsp;&nbsp;
   <c:if test="${sessionScope.loginuser.id==qna.user_id || sessionScope.loginuser.role==0}">
	 <a href='deleteQna.do?qna_id=${qna.qna_id}'>글 삭제</a>&nbsp;&nbsp;
   </c:if>
   <a href='getQnaList.do'>전체 게시판</a>      
   </center>
<%@ include file="../header_footer/footer.jsp"%>
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
<!-- //스크립트릿 -->    
   <center>
   <h1>글 상세 보기</h1>
   <hr>
   <form action="getUpdateQna.do" method="POST">
      <input name="qna_id" type="hidden" value="${qna.qna_id}" readonly/>
      <table border='1' cellpadding='0' cellspacing='0'>
         <tr>
            <td bgcolor="orange" width="70">제목 </td>
            <td align="left"><input name="title" type="text" value="${qna.qna_title}" readonly></td>
         </tr>
         <tr>
         	<td bgcolor="orange">종류</td>
         	<td align="left">${qna.qna_kind}</td>
         </tr>
         <tr>
            <td bgcolor="orange">작성자 </td>
            <td align="left">${qna.user_id}</td>
         </tr>
         <tr>
         	<td bgcolor="orange">내용</td>
         	<td align='center'><p name="content" rows="10" cols="40">${qna.qna_content}</p></td>
         </tr>
         <tr>
            <td bgcolor="orange">등록일</td>
            <td align="left"><fmt:formatDate value="${qna.qna_timestamp}"  pattern="yy-MM-dd"/></td>
         </tr>
         <tr>
            <td bgcolor="orange">조회수</td>
            <td align="left">${qna.qna_views}</td>
         </tr>
         <tr>
            <td colspan="2" align="center">
            	<input type='submit' value='글수정'/>
            </td>
         </tr>
      </table>
   </form>
   <hr>
   <a href='insertQna.jsp'>새글 등록</a>&nbsp;&nbsp;&nbsp;
   <c:choose>
	 <c:when test="${sessionScope.loginuser==(qna.user_id || 'admin' )}">
	 	<a href='deleteQna.do?qna_id=${qna.qna_id}'>글 삭제</a>&nbsp;&nbsp;&nbsp;		
	 </c:when>
	 <!--<c:set var="name" value="홍길동" /> 
     <c:if test="${name eq '홍길동'}">
	   <c:out value="${str}" />
	 </c:if>-->
	 <c:otherwise>
     </c:otherwise>
   </c:choose>      
   <a href='getQnaList.do'>전체 게시판</a>
   </center>
<%@ include file="../header_footer/footer.jsp"%>
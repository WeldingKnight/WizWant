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
   <form action="updateQna.do" method="POST">
      <input name="seq" type="hidden" value="${qna.qna_id}"/>
      <table border='1' cellpadding='0' cellspacing='0'>
         <tr>
            <td bgcolor="orange" width="70">제목 </td>
            <td align="left"><input name="title" type="text" value="${qna.qna_title}"></td>
         </tr>
         <tr>
            <td bgcolor="orange">작성자 </td>
            <td align="left">${qna.user_id}</td>
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
         	<td bgcolor="orange">내용</td>
         	<td align='center'><textarea name="content" rows="10" cols="40">${qna.qna_content}</textarea></td>
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
   <a href='getInsertQna.do'>글 등록</a>&nbsp;&nbsp;&nbsp;
   <a href='deleteQna.do?qna_id=${qna.qna_id}'>글 삭제</a>&nbsp;&nbsp;&nbsp;
   <a href='getQnaList.do'>전체 게시판</a>
   </center>
  
<%@ include file="../header_footer/footer.jsp"%>
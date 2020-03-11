<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
</head>
<body>
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
         	<td bgcolor="orange">내용</td>
         	<td align='center'><textarea name="content" rows="10" cols="40">${qna.qna_content}</textarea></td>
         </tr>
         <tr>
            <td bgcolor="orange">등록일</td>
            <td align="left"><fmt:formatDate value="${qna.qna_timestamp}"  pattern="yy-MM-dd"/></td>
         </tr>
         <tr>
            <td bgcolor="orange">조회수</td>
            <td align="left">${qna.cnt}</td>
         </tr>
         <tr>
            <td colspan="2" align="center">
            	<input type='submit' value='글수정'/>
            </td>
         </tr>
      </table>
   </form>
   <hr>
   <a href='insertQna.jsp'>글 등록</a>&nbsp;&nbsp;&nbsp;
   <a href='deleteQna.do?qna_id=${qna.qna_id}'>글 삭제</a>&nbsp;&nbsp;&nbsp;
   <a href='getQnaList.do'>전체 게시판</a>
   </center>
</body>
</html>
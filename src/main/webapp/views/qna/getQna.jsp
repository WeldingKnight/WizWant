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
   <a href="logout.do">로그아웃</a>
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
         	<td align='center'><textarea name="content" rows="10" cols="40">${qna.content}</textarea></td>
         </tr>
         <tr>
            <td bgcolor="orange">등록일</td>
            <td align="left">${qna.qna_timestamp}</td>
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
   <a href='insertBoard.jsp'>글 등록</a>&nbsp;&nbsp;&nbsp;
   <a href='deleteBoard.do?seq=${board.seq}'>글 삭제</a>&nbsp;&nbsp;&nbsp;
   <a href='getBoardList.do'>전체 게시판</a>
   </center>
</body>
</html>
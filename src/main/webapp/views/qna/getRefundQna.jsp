<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page import="com.shopping.MVC_reshop.qna.QnaVO" %>
<%@ page import="com.shopping.MVC_reshop.qna.QnaDAO" %>
<%@ page import="java.util.List" %>

<%
	//스크립트릿 =>자바코드 작성
request.setCharacterEncoding("UTF-8");

String searchField =""; // 제목 or 작성 or 내용 
String searchText=""; // 검색 키워드
String sort = ""; // 종류
QnaDAO qnaDAO = new QnaDAO();

if(request.getParameter("searchCondition") != null && request.getParameter("searchKeyword") != null){
	searchField = request.getParameter("searchCondition");
	searchText = request.getParameter("searchKeyword");
}
	
	List<QnaVO> qnaList = qnaDAO.getQnaList(searchField, searchText);
	request.setAttribute("qnaList", qnaList);
%>
<%@ include file="../header_footer/header.jsp"%>

<script>
document.addEventListener("DOMContentLoaded", function(){
	document.getElementById("4").setAttribute("class","hover-img");
	document.getElementById("4h").setAttribute("class","active");
});

</script>

 <div class="wrap">
 		<!-- 탭 메뉴 -->
      		<%@ include file="tabmenu.jsp" %>
        <!-- //탭 메뉴 -->
        <!-- content -->
		<center>
			<c:choose>
				<c:when test="${empty sessionScope.loginuser}">
					<h3>고객센터 QNA 게시판에 오신것을 환영합니다.</h3>
				</c:when>
				<c:otherwise>
					 <h3 align="center">${sessionScope.loginuser.id}님 QNA 게시판에 오신것을 환영합니다.</h3> 
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sortList.size() eq 0}"><h4>게시글이 없습니다.</h4></c:when>
				<c:otherwise><h4>총 Q&A : ${sortList.size()} 건</h4></c:otherwise>
			</c:choose>
				<form method='get' action='getQnaList.do'>
					<table border='1' cellpadding='0' cellspacing='0' width='750'>
						<tr>
							<td align='right'>
								<select name='searchCondition'>
									<option value='qna_title'>제목
									<option value='qna_content'>내용
									<option value='user_id'>작성자
								</select>
								<input name='searchKeyword' type='text' />
								<input type="submit" value="검색">
							</td>
						</tr>
					</table>
				</form>
			<table border='1' cellpadding='0' cellspacing='0' width='750'>
				<tr>
					<th bgcolor="orange" width='50'>번호</th>
					<th bgcolor="orange" width='100'>종류</th>
					<th bgcolor="orange" width='300'>제목</th>
					<th bgcolor="orange" width='100'>작성자</th>
					<th bgcolor="orange" width='100'>등록일</th>
					<th bgcolor="orange" width='100'>조회수</th>
				</tr>
			<c:forEach items="${sortList}" var="sort">
				<tr>
					<td align="center">${sort.qna_id}</td>
					<td align="center">${sort.qna_kind}</td>
					<td align="center"><a href="getQna.do?qna_id=${sort.qna_id}">${sort.qna_title}</a></td>
					<td align="center">${sort.user_id}</td>
					<td align="center"><fmt:formatDate value="${sort.qna_timestamp}"  pattern="yy-MM-dd"/></td>
					<td align="center">${sort.qna_views}</td>
				</tr>
			</c:forEach>
			</table>
			<br>
			<a href="getInsertQna.do">새글 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="getQnaList.do">전체글 목록 보기</a>
		</center>
		<!-- //content -->
 </div>
<%@ include file="../header_footer/footer.jsp"%>
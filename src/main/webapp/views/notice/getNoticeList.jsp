<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page import="com.shopping.MVC_reshop.notice.NoticeVO" %>
<%@ page import="com.shopping.MVC_reshop.notice.NoticeDAO" %>
<%@ page import="java.util.List" %>

<%
	//스크립트릿 =>자바코드 작성
request.setCharacterEncoding("UTF-8");

String searchField =""; // 제목 or 작성 or 내용 
String searchText=""; // 제목 or 작성 or 내용 

if(request.getParameter("searchCondition") != null && request.getParameter("searchKeyword") != null){
	searchField = request.getParameter("searchCondition");
	searchText = request.getParameter("searchKeyword");
	request.setAttribute("searchword", searchText);
}

NoticeDAO noticeDAO = new NoticeDAO();
//메소드 호출
   List<NoticeVO> noticeList = noticeDAO.getNoticeList(searchField, searchText);
   request.setAttribute("noticeList", noticeList);
   
   int totalList = noticeList.size(); // 총게시글 얻어오기
   request.setAttribute("totalList", totalList);
%>    
<%@ include file="../header_footer/header.jsp"%>
<script>
document.addEventListener("DOMContentLoaded", function(){
	document.getElementById("6").setAttribute("class","hover-img");
	document.getElementById("6h").setAttribute("class","active");
});
</script>
 <div class="wrap">
 		<!-- 탭 메뉴 -->
 			<%@ include file="noticeTab.jsp"%>
        <!-- //탭 메뉴 -->
        <!-- content -->
		<center>
			<c:choose>
				<c:when test="${empty sessionScope.loginuser}">
					<h3>공지사항 게시판에 오신것을 환영합니다.</h3>
				</c:when>
				<c:otherwise>
					 <h3 align="center">${sessionScope.loginuser.id}님 공지사항 게시판에 오신것을 환영합니다.</h3> 
				</c:otherwise>
			</c:choose>                         
			<h4>총 공지사항 : ${totalList}  건</h4>
			<form method='get' action='getNoticeList.do'>
				<table border='1' cellpadding='0' cellspacing='0' width='750'>
					<tr>
						<td align='right'>
							<select name='searchCondition'>
								<option value='notice_title'>제목
								<option value='notice_content'>내용
								<option value='notice_id'>작성자
							</select>
							<input name='searchKeyword' type='text' value='<%=searchText%>' />
							<input type="submit" value="검색">
						</td>
					</tr>
				</table>
			</form>
			<table border='1' cellpadding='0' cellspacing='0' width='750'>
				<tr>
					<th bgcolor="orange" width='70'>번호</th>
					<th bgcolor="orange" width='500'>제목</th>
					<th bgcolor="orange" width='180'>등록일</th>
				</tr>
				<c:forEach items="${noticeList}" var="notice">
					<tr>
						<td align="center">${notice.notice_id}</td>
						<td align="center"><a href="getNotice.do?notice_id=${notice.notice_id}">${notice.notice_title}</a></td>
						<td align="center"><fmt:formatDate value="${notice.notice_timestamp}"  pattern="yy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<c:if test="${sessionScope.loginuser.id == 'admin' && sessionScope.loginuser.role==0}">
			<a href="getInsertNotice.do">새글 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<a href="getNoticeList.do">전체글 목록 보기</a>
		</center>
		<!-- //content -->
 </div>
<%@ include file="../header_footer/footer.jsp"%>
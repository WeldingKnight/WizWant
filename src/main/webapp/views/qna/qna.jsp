<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ page import="com.shopping.MVC_reshop.qna.QnaVO" %>
<%@ page import="com.shopping.MVC_reshop.qna.QnaDAO" %>
<%@ page import="java.util.List" %>

<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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

QnaDAO qnaDAO = new QnaDAO();
//메소드 호출
   List<QnaVO> qnaList = qnaDAO.getQnaList(searchField, searchText);
   request.setAttribute("qnaList", qnaList);
   
   int totalList = qnaList.size(); // 총게시글 얻어오기
%>    
<%@ include file="../header_footer/header.jsp"%>

 <div class="wrap">
 		<!-- 탭 메뉴 -->
        <div class="tab">
            <div class="tab_cate">
                <div class="cate one active">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/allqna.jpg" class="active" onclick="changeImg(this);"alt="전체 Q&A">
                        <img src="./img/customer_img/allqnahover.jpg" class="hover-img" alt="전체 Q&A">
                    </a>
                </div>
                <div class="cate two">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/fin.jpg" class="active" onclick="changeImg(this);" alt="주문/결제">
                        <img src="./img/customer_img/finhover.jpg" class="hover-img" alt="주문/결제">
                    </a>
                </div>
                <div class="cate three">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/delivery.jpg" class="active"onclick="changeImg(this);" alt="배송문의">
                        <img src="./img/customer_img/deliveryhover.jpg" class="hover-img" alt="배송문의">
                    </a>
                </div>
                <div class="cate four">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/refund.jpg" class="active" onclick="changeImg(this);"alt="반품/교환/환불">
                        <img src="./img/customer_img/refundhover.jpg" class="hover-img" alt="반품/교환/환불">
                    </a>
                </div>
                <div class="cate five">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/product.jpg" class="active" onclick="changeImg(this);" alt="상품문의">
                        <img src="./img/customer_img/producthover.jpg" class="hover-img" alt="상품문의">
                    </a>
                </div>
                <div class="cate six">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/notice.jpg" class="active" onclick="changeImg(this);"alt="공지사항">
                        <img src="./img/customer_img/noticehover.jpg" class="hover-img" alt="공지사항">
                    </a>
                </div>
            </div>
        </div>
        <!-- //탭 메뉴 -->
        <!-- content -->
		<center>                         
			<h3 align="center">test님 게시판에 오신것을 환영합니다.&nbsp;&nbsp;&nbsp;</h3>
			<h4>총 게시글 : ${totalList}건</h4>
			<form method='get' action='customer.do'>
				<table border='1' cellpadding='0' cellspacing='0' width='700'>
					<tr>
						<td align='right'>
							<select name='searchCondition'>
								<option value='qna_title'>제목
								<option value='qna_content'>내용
								<option value='user_id'>작성자
							</select>
							<input name='searchKeyword' type='text' value='<%=searchText%>' />
							<input type="submit" value="검색">
						</td>
					</tr>
				</table>
			</form>
			<table border='1' cellpadding='0' cellspacing='0' width='700'>
				<tr>
					<th bgcolor="orange" width='100'>번호</th>
					<th bgcolor="orange" width='200'>제목</th>
					<th bgcolor="orange" width='150'>작성자</th>
					<th bgcolor="orange" width='150'>등록일</th>
				</tr>
				<c:forEach items="${qnaList}" var="qna">
					<tr>
						<td align="center">${qna.qna_id}</td>
						<td align="left"><a href="#">${qna.qna_title}</a></td>
						<td align="center">${qna.user_id}</td>
						<td align="center">${qna.qna_timestamp}</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<a href="insertQna.jsp">새글 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="customer.do">전체글 목록 보기</a>
		</center>
		<!-- //content -->
 </div>
<%@ include file="../header_footer/footer.jsp"%>
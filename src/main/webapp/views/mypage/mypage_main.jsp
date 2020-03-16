<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="../header_footer/header.jsp"></jsp:include>
<h1 class="mypage_title">마이페이지</h1>

<div class="menu_img">
	<a href="update.do"><img src="./img/mypage_img/회원정보수정.png"><p>회원정보수정</p></a>
</div>

<div class="menu_img">
	<a href="bookmark.do"><img src="./img/mypage_img/찜목록.png"><p>찜목록</p></a>
</div>

<div class="menu_img">
	<a href="orders.do"><img src="./img/mypage_img/주문내역.png"><p>주문내역</p></a>
</div>

<div class="menu_img_last">
	<a href="product_sale.do"><img src="./img/mypage_img/상품등록.png"><p>상품등록</p></a>
</div>

<jsp:include page="../header_footer/footer.jsp"></jsp:include>

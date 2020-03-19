<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<link href="../../css/mypage.css" rel="stylesheet" type="text/css">
<jsp:include page="../header_footer/header.jsp"></jsp:include>
<h1 class="mypage_title">장바구니</h1>

<c:forEach items="${cartList}" var="cartsList">
	<a href=".do=?" class="bookmark_link">
		<div class="bookmark">
			<div class="bookmark_img">
				<img alt="" src="../img/product_img/${cartsList.goods_image}">이미지
			</div>
			<table class="bookmark_table">
				<tr>
					<td class="bookmark_td">
						<div>상품 번호 :</div>
						<div>상품 이름 :</div>
						<div>상품 설명 :</div>
						<div>상품 가격 :</div>
						<div>판매자 :</div>
					</td>
					<td><div>${cartsList.goods_id}</div>
						<div>${cartsList.goods_name}</div>
						<div>${cartsList.goods_detail}</div>
						<div>${cartsList.goods_price}</div>
						<div>${cartsList.seller_id}</div></td>
				</tr>
				<tr>
					<td><a href="cart.do?delete_id=${cartsList.goods_id}">글 삭제</a></td>
				</tr>
			</table>
		</div>
	</a>
</c:forEach>
<div class="clear"></div>

<jsp:include page="../header_footer/footer.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<link href="../../css/mypage.css" rel="stylesheet" type="text/css">
<jsp:include page="../header_footer/header.jsp"></jsp:include>
<h1 class="mypage_title">장바구니</h1>

<c:forEach items="${cartList}" var="cartskList">
	<a href=".do=?" class="bookmark_link">
		<div class="bookmark">
			<div class="bookmark_img">
				<img alt="" src="">이미지
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
					<td><div>${cartskList.goods_id}</div>
						<div>${cartskList.goods_name}</div>
						<div>${cartskList.goods_detail}</div>
						<div>${cartskList.goods_price}</div>
						<div>${cartskList.seller_id}</div></td>
				</tr>
				<tr>
					<td><a href="bookmark.do?delete_id=${cartskList.goods_id}">글 삭제</a></td>
				</tr>
			</table>
		</div>
	</a>
</c:forEach>
<div class="clear"></div>

<jsp:include page="../header_footer/footer.jsp"></jsp:include>

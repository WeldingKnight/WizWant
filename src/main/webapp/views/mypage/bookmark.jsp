<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<link href="../../css/mypage.css" rel="stylesheet" type="text/css">
<jsp:include page="../header_footer/header.jsp"></jsp:include>
<h1 class="mypage_title">찜목록</h1>

<c:forEach items="${bookmarkList}" var="bookmarkList">
	<a href="product_detail.do?goods_id=${bookmarkList.goods_id}" class="bookmark_link">
		<div class="bookmark">
			<div class="bookmark_img">
				<img alt="" src="img/product_img/${bookmarkList.goods_image}">
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
					<td><div>${bookmarkList.goods_id}</div>
						<div>${bookmarkList.goods_name}</div>
						<div>${bookmarkList.goods_detail}</div>
						<div>${bookmarkList.goods_price}</div>
						<div>${bookmarkList.seller_id}</div></td>
				</tr>
				<tr>
					<td><a href="bookmark.do?delete_id=${bookmarkList.goods_id}">글 삭제</a></td>
				</tr>
			</table>
		</div>
	</a>
</c:forEach>
<div class="clear"></div>

<jsp:include page="../header_footer/footer.jsp"></jsp:include>

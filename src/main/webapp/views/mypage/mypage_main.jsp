<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="../header_footer/header.jsp"></jsp:include>
<h1 class="mypage_title">마이페이지</h1>
<table id="mypage_menu">
	<tr>
		<td>
			<div>
				<a href="update.do"><img src="./img/mypage_img/회원정보수정.png"></a>
			</div>
		</td>
		<td>
			<div>
				<a href="bookmark.do"><img src="./img/mypage_img/찜목록.png"></a>
			</div>
		</td>
		<td>
			<div>
				<a href="orders.do"><img src="./img/mypage_img/주문내역.png"></a>
			</div>
		</td>
		<td>
			<div>
				<a href="product_sale.do"><img src="./img/mypage_img/상품등록.png"></a>
			</div>
		</td>
	</tr>
</table>
<jsp:include page="../header_footer/footer.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="../../css/mypage.css" rel="stylesheet" type="text/css">
</head>
<jsp:include page="../header_footer/header.jsp"></jsp:include>
<body>
	<h1>마이페이지</h1>
	<nav>
		<div>
			<ul>
				<li><a href="update.do">회원정보수정</a></li>
				<li><a href="bookmark.do">찜목록</a></li>
				<li><a href="orders.do">주문내역</a></li>
			</ul>
		</div>
	</nav>
	<table id="mypage_menu">
		<tr>
			<td>
				<div>
					<a href="update.do"><img src="http://placehold.it/200x100">회원정보수정</a>
				</div>
			</td>
			<td>
				<div>
					<a href="bookmark.do"><img src="http://placehold.it/200x100">찜목록</a>
				</div>
			</td>
			<td>
				<div>
					<a href="orders.do"><img src="http://placehold.it/200x100">주문내역</a>
				</div>
			</td>
		</tr>
	</table>
</body>
<jsp:include page="../header_footer/footer.jsp"></jsp:include>
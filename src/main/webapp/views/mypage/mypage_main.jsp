<%@ page language="java" contentType="text/jsp; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE jsp>
<jsp>
<head>
<meta charset="EUC-KR">
<title></title>
</head>
<body>
	<h1>마이페이지</h1>
	<nav>
		<div>
			<ul>
				<li><a href="./mypage/update.jsp">회원정보수정</a></li>
				<li><a href="./mypage/bookmark.jsp">찜목록</a></li>
				<li><a href="./mypage/orders.jsp">주문내역</a></li>
			</ul>
		</div>
	</nav>

	<table id="mypage_menu">
		<tr>
			<td>
				<div>
					<a href="./mypage/update.jsp"><img src="http://placehold.it/200x100">회원정보수정</a>
				</div>
			</td>
			<td>
				<div>
					<a href="./mypage/bookmark.jsp"><img src="http://placehold.it/200x100">찜목록</a>
				</div>
			</td>
			<td>
				<div>
					<a href="./mypage/orders.jsp"><img src="http://placehold.it/200x100">주문내역</a>
				</div>
			</td>
		</tr>
	</table>
</body>
</jsp>
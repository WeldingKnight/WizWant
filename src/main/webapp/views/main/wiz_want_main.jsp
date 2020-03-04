<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>


<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">


<style>
	#header_body{
	
		margin: 0 auto;
    	text-align: center;	
	}
	
	#header_box{
		width:1200px;	
		border: 1px solid red;

	}
	
	.header_menu{
		border: 1px solid blue;
	}

</style>

<title>WIZ*WANT(우리가 원하는 것)</title>
</head>
<body>

	<jsp:include page="../header_footer/header.jsp"></jsp:include>-
	<div>
		<h2>메인페이지</h2>
		<a href="login.do">로그인</a>
		<a href="insert.do">회원가입</a>
		<a href="mypage.do">마이페이지</a>
	</div>

	<jsp:include page="../header_footer/footer.jsp"></jsp:include>
</html>
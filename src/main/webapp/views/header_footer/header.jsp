<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html style="background-image: ">
<%
	request.setCharacterEncoding("UTF-8");
	String categoryId =  request.getParameter("Classification");
	request.setAttribute("categoryId", categoryId);
%>
<head>

<meta charset="UTF-8">
<!--사이트  css 링크 부분 -->


<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/main_page.css">
<link rel="stylesheet" href="./css/product.css">
<link rel="stylesheet" href="./css/product_detail.css">
<link rel="stylesheet" href="./css/product_sale.css">
<link rel="stylesheet" href="./css/customer.css">
<link rel="stylesheet" href="./css/mypage.css">
<link rel="stylesheet" href="./css/notice.css">

<!-- ------------------------------------------------------- -->
<!-- 사이트 jquery 스크립트 부분 -->

<script src="./js/jquery-2.2.4.min.js"></script>
<script src="./js/jquery-ui.min.js"></script>
<script src="./js/jquery.easing.1.3.js"></script>
<script src="./js/main_page.js"></script>
<script src="./js/product.js"></script>
<script src="./js/product_detail.js"></script>
<script src="./js/customer.js"></script>
<script src="./js/notice.js"></script>
</head>
<body id="header_body"  onload="takeId('${categoryId}')">
	<div id="full_box">
		<header id="main_header">
			<h1 id="header_name">
				<a href="wiz_want.do">WIZ*WANT</a>
			</h1>
			<div id="header_menu_cover">
				<div id="header_menu">

					<div class="header_menu_box">
						<a href="product.do?Classification=${'digital'}"><img
							src="./img/main_img/digital_img.png" alt="디지털이미지">디지털</a>
					</div>
					<div class="header_menu_box">
						<a href="product.do?Classification=${'tel'}"><img
							src="./img/main_img/tel_img.svg" alt="통신이미지">통신</a>
					</div>
					<div class="header_menu_box">
						<a href="product.do?Classification=${'clothing'}"><img
							src="./img/main_img/clothing_img.svg" alt="패션의류이미지">패션*의류</a>
					</div>
					<div class="header_menu_box">
						<a href="product.do?Classification=${'grocery'}"><img
							src="./img/main_img/other.svg" alt="잡화이미지">잡화</a>
					</div>
				</div>

			</div>
			<div id="header_a_tag">

				<c:choose>
					<c:when test="${empty sessionScope.loginuser}">
						<a href="login.do">로그인</a>
						<a href="insert.do">회원가입</a>
					</c:when>
					<c:otherwise>
						 ${sessionScope.loginuser.id}님 
						<a href="logout.do">로그아웃</a>
						<a href="mypage.do">마이페이지</a>
					</c:otherwise>
				</c:choose>
				<a href="getQnaList.do">고객센터</a>
			</div>
		</header>
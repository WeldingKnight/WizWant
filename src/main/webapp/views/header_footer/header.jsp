<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link rel="stylesheet" href="./css/header.css">
<!-- 헤더 css -->
<link rel="stylesheet" href="./css/main_page.css">
<link rel="stylesheet" href="./css/product.css">
<link rel="stylesheet" href="./css/product_detail.css">
<script src="./js/jquery-2.2.4.min.js"></script>
<script src="./js/product.js"></script>
<script src="./js/product_detail.js"></script>
</head>
<body id="header_body">
	<div id="full_box">
		<header id="main_header">
			<h1 id="header_name">WIZ*WANT</h1>
			<div id="header_menu_cover">
				<div id="header_menu">
				
					<div class="header_menu_box">
						<a href="product.do?Classification=${'digital'}" ><img src="./img/main_img/digital_img.png"
							alt="디지털이미지" ></a>
					</div>
					<div class="header_menu_box">
						<a href="product.do?Classification=${'tel'}"><img src="./img/main_img/tel_img.svg"
							alt="통신이미지"></a>
					</div>
					<div class="header_menu_box">
						<a href="product.do?Classification=${'clothing'}"><img
							src="./img/main_img/clothing_img.svg" alt="패션의류이미지"></a>
					</div>
					<div class="header_menu_box">
						<a href="product.do?Classification=${'grocery'}"><img src="./img/main_img/digital_img.png"
							alt="잡화이미지"></a>
					</div>
				</div>
				<div id="header_a_tag">
					<a href="login.do">로그인</a> <a href="insert.do">회원가입</a> <a
						href="mypage.do">마이페이지</a>
				</div>
			</div>
		</header>
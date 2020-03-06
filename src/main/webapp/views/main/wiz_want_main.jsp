<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header_footer/header.jsp"%>




<div id="main_div">
	<h2>메인페이지</h2>

	<!-- 슬라이드 부분 -->
	<div id="main_slider">
		<div class="main_slideshow-container">

			<div class="mainSlides">
				<div class="main_numbertext">1 / 3</div>
				<img class="main_slide_img" src="./img/main_img/nako.gif"
					style="width: 100%">
				<div class="main_text">Caption One</div>
			</div>

			<div class="mainSlides">
				<div class="main_numbertext">2 / 3</div>
				<img class="main_slide_img" src="./img/main_img/izone.jpg"
					style="width: 100%">
				<div class="main_text">Caption Two</div>
			</div>

			<div class="mainSlides">
				<div class="main_numbertext">3 / 3</div>
				<img class="main_slide_img" src="http://placehold.it/200x100"
					style="width: 100%">
				<div class="main_text">Caption Three</div>
			</div>

		</div>
		<br>

		<div style="text-align: center">
			<span class="main_dot"></span> <span class="main_dot"></span> <span
				class="main_dot"></span>
		</div>
	</div>
	<!-- //슬라이드 부분 -->
	
	<!-- 중고거래사이트 링크부분 -->
	<aside id="main_link">
		<div class="main_link_img">
			<img src="./img/main_img/jungonara.png">
		</div>
		<div class="main_link_img">
			<img src="./img/main_img/auction.png">
		</div>
		<div class="main_link_img">
			<img src="./img/main_img/ebay.jpg">
		</div>
		<div class="main_link_img">
			<img src="./img/main_img/gmarket.png">
		</div>
	</aside>
	
	<!-- //중고거래사이트 링크부분 -->
	
	
	<div id="main_pitem">
		<!-- pitem: popular item -->

		<div class="main_pitem_each"></div>
		<div class="main_pitem_each"></div>
		<div class="main_pitem_each"></div>
		<div class="main_pitem_each"></div>
	</div>
	<div id="chat"></div>


</div>

<%@ include file="../header_footer/footer.jsp"%>
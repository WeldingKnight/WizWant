<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header_footer/header.jsp"%>




<div id="main_div">
	<!-- 슬라이드 부분 -->
	<div id="main_slider_div">
		<div class="main_slideshow-container">

			<div class="mainSlides">
				<div class="main_numbertext">1 / 3</div>
				<img class="main_slide_img" src="./img/main_img/slide1.jpg">
			</div>

			<div class="mainSlides">
				<div class="main_numbertext">2 / 3</div>
				<img class="main_slide_img" src="./img/main_img/slide2.jpg">
			</div>

			<div class="mainSlides">
				<div class="main_numbertext">3 / 3</div>
				<img class="main_slide_img" src="./img/main_img/slide3.jpg">
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
			<a href="https://cafe.naver.com/joonggonara" target="blank"> <img
				src="./img/main_img/jungonara.png" alt="중고나라 이미지">
			</a>
		</div>
		<div class="main_link_img">
			<a href="http://corners.auction.co.kr/corner/usedmarket.aspx"
				target="blank"> <img src="./img/main_img/auction.png"
				alt="옥션 중고장터 이미지">
			</a>
		</div>
		<div class="main_link_img">
			<a href="https://www.ebay.com/sch/i.html?_nkw=my%20beay"
				target="blank"> <img src="./img/main_img/ebay.png" alt="ebay이미지">
			</a>
		</div>
		<div class="main_link_img">
			<a href="http://category.gmarket.co.kr/listview/L100000051.aspx"
				target="blank"> <img src="./img/main_img/gmarket.png"
				alt="gmarket 이미지">
			</a>
		</div>
	</aside>

	<!-- //중고거래사이트 링크부분 -->


	<div id="main_pitem">
		<!-- pitem: popular item -->
		<h3>현재 조회수 상위 제품</h3>
		<c:forEach items="${productviewslist}" var="productVO">
			<div class="main_pitem_each">
				<a href="product_detail.do?goods_id=${productVO.goods_id}"> <img class="main_pitem_each_img" src="product_image/${productVO.goods_image}"></a>
				<div id="main_pitem_wrap">
					<div class="main_pitem_each_goods_info">${productVO.goods_name}</div>
					<div class="main_pitem_each_goods_info">${productVO.goods_price}</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div id="chat"></div>


</div>

<%@ include file="../header_footer/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="../header_footer/header.jsp"></jsp:include>
<%
request.setCharacterEncoding("UTF-8");

%>
    <h2 align="center">상품 페이지</h2>
<nav id="detail_navMenu">
    <ul>
        <li id="detail_sort1"><a href="product.do">대분류 ></a>
            <ul id="detail_category">
                <li id="detail_digital"><a href="#">디지털</a></li>
                <li id="detail_mobile"><a href="#">통신</a></li>
                <li id="detail_clothes"><a href="#">의류</a></li>
                <li id="detail_fashion"><a href="#">패션잡화</a></li>
            </ul>
        </li>
        <li id="detail_sort2"><a href="#">중분류 ></a>
            <ul class="detail_digital">
            </ul>
            <ul class="detail_mobile">
            </ul>
            <ul class="detail_clothes">
            </ul>
            <ul class="detail_fashion">
            </ul>
        </li>
        <li id="detail_sort3"><a href="#">소분류 ></a>
            <ul class="detail_digital0">
            </ul>
            <ul class="detail_digital1">
            </ul>
            <ul class="detail_digital2">
            </ul>
            <ul class="detail_mobile0">
            </ul>
            <ul class="detail_mobile1">
            </ul>
            <ul class="detail_mobile2">
            </ul>
            <ul class="detail_clothes0">
            </ul>
            <ul class="detail_clothes1">
            </ul>
            <ul class="detail_fashion0">
            </ul>
            <ul class="detail_fashion1">
            </ul>
            <ul class="detail_fashion2">
            </ul>
        </li>
        <li id="detail_sort4"><a href="#">거래 가능지역 ></a>
            <ul class="detail_local">
            </ul>
        </li>
        <li id="detail_sort5"><a href="#">가격대</a>
            <ul  class="detail_price">
            </ul>
        </li>
    </ul>
</nav>


<section align="center">
	<div id="detail_rap">
		<c:forEach items="${productList}" var="product">
			<div class="detail_content">
				<a href="product_detail.do?goods_id=${product.goods_id}"><img src="${product.goods_image}"></a>
				<div class="detail_product">
				    <div id="detail_productName">${product.productname}</div>
				    <div id="detail_productPrice">${product.goods_name}</div>
				</div>
				<div class="detail_seller">
			        <div id="detail_sellerId">${product.seller_id}</div>
			        <div id="detail_sellerReliability">유저점수</div>
			    </div>
		    </div>
		</c:forEach>
		<div class="detail_content">
        <img src="./img/product_img/Yerin.jpg">
        <div class="detail_product">
            <div id="detail_productName">제품명</div>
            <div id="detail_productPrice">가격</div>
        </div>
        <div class="detail_seller">
            <div id="detail_sellerId">판매자아이디</div>
            <div id="detail_sellerReliability">판매자신뢰도</div>
        </div>
        </div>
        <div class="detail_content">
        <img src="./img/product_img/Yerin1.jpg">
        <div class="detail_product">
            <div id="detail_productName">제품명</div>
            <div id="detail_productPrice">가격</div>
        </div>
        <div class="detail_seller">
            <div id="detail_sellerId">판매자아이디</div>
            <div id="detail_sellerReliability">판매자신뢰도</div>
        </div>
        </div>
        <div class="detail_content">
        <img src="./img/product_img/Yerin2.jpg">
        <div class="detail_product">
            <div id="detail_productName">제품명</div>
            <div id="detail_productPrice">가격</div>
        </div>
        <div class="detail_seller">
            <div id="detail_sellerId">판매자아이디</div>
            <div id="detail_sellerReliability">판매자신뢰도</div>
        </div>
        </div>
        <div class="detail_content">
        <img src="./img/product_img/Yerin3.jpg">
        <div class="detail_product">
            <div id="detail_productName">제품명</div>
            <div id="detail_productPrice">가격</div>
        </div>
        <div class="detail_seller">
            <div id="detail_sellerId">판매자아이디</div>
            <div id="detail_sellerReliability">판매자신뢰도</div>
        </div>
        </div>
    </div>
</section>

<jsp:include page="../header_footer/footer.jsp"></jsp:include>
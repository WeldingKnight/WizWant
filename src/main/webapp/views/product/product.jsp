<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../header_footer/header.jsp"></jsp:include>
<div onload="takeId('${categoryId}')">
    <h2 align="center">상품 페이지</h2>
<nav id="detail_navMenu">
    <ul>
        <li id="detail_sort1"><a href="product.do?Classification=">대분류 ></a>
            <ul id="detail_category">
                <li id="detail_digital"><a href="product.do?Classification=digital">디지털</a></li>
                <li id="detail_mobile"><a href="product.do?Classification=tel">통신</a></li>
                <li id="detail_clothes"><a href="product.do?Classification=clothing">의류</a></li>
                <li id="detail_fashion"><a href="product.do?Classification=grocery">패션잡화</a></li>
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


<section id="product_section">
	<div id="detail_rap">
    </div>
</section>
</div>
<jsp:include page="../header_footer/footer.jsp"></jsp:include>
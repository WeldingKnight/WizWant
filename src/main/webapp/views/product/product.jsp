<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="../header_footer/header.jsp"></jsp:include>
    <h2 align="center">상품 페이지</h2>
<nav id="detail_navMenu">
    <ul>
        <li id="detail_sort1"><a href="#">대분류 ></a>
            <ul id="detail_category">
                <li id="detail_digital"><a href="#">디지털</a></li>
                <li id="detail_mobile"><a href="#">통신</a></li>
                <li id="detail_clothes"><a href="#">의류</a></li>
                <li id="detail_fashion"><a href="#">패션잡화</a></li>
            </ul>
        </li>
        <li id="detail_sort2"><a href="#">중분류 ></a>
            <ul class="detail_digital">
                <li class="detail_desktop"><a href="#">데스크탑</a></li>
                <li class="detail_laptop"><a href="#">노트북</a></li>
                <li class="detail_tablet"><a href="#">태블릿</a></li>
            </ul>
            <ul class="detail_mobile">
                <li class="detail_smart"><a href="#">스마트폰</a></li>
                <li class="detail_interface"><a href="#">주변기기</a></li>
                <li class="detail_feature"><a href="#">피처폰</a></li>
            </ul>
            <ul class="detail_clothes">
                <li class="detail_male"><a href="#">남성</a></li>
                <li class="detail_female"><a href="#">여성</a></li>
            </ul>
            <ul class="detail_fashion">
                <li class="detail_watch"><a href="#">시계</a></li>
                <li class="detail_shoes"><a href="#">신발</a></li>
                <li class="detail_except"><a href="#">그 외</a></li>
            </ul>
        </li>
        <li id="detail_sort3"><a href="#">소분류 ></a>
            <ul class="detail_desktop">
                <li class="detail_assemble"><a href="#">조립</a></li>
                <li class="detail_brandSLA"><a href="#">브랜드(삼성,LG,애플)</a></li>
                <li class="detail_brand"><a href="#">브랜드(기타)</a></li>
            </ul>
            <ul class="detail_laptop">
                <li class="detail_apple"><a href="#">애플</a></li>
                <li class="detail_SL"><a href="#">삼성,LG</a></li>
                <li class="detail_except"><a href="#">기타</a></li>
            </ul>
            <ul class="detail_tablet">
                <li class="detail_apple"><a href="#">애플</a></li>
                <li class="detail_SL"><a href="#">삼성,LG</a></li>
                <li class="detail_except"><a href="#">기타</a></li>
            </ul>
            <ul class="detail_smart">
                <li class="detail_apple"><a href="#">애플</a></li>
                <li class="detail_SL"><a href="#">삼성,LG</a></li>
                <li class="detail_except"><a href="#">기타</a></li>
            </ul>
            <ul class="detail_interface">
                <li class="detail_apple"><a href="#">애플</a></li>
                <li class="detail_SL"><a href="#">삼성,LG</a></li>
                <li class="detail_except"><a href="#">기타</a></li>
            </ul>
            <ul class="detail_feature">
                <li class="detail_SL"><a href="#">삼성,LG</a></li>
                <li class="detail_except"><a href="#">기타</a></li>
            </ul>
            <ul class="detail_male">
                <li class="detail_top"><a href="#">상의</a></li>
                <li class="detail_bottoms"><a href="#">하의</a></li>
                <li class="detail_except"><a href="#">그 외</a></li>
            </ul>
            <ul class="detail_female">
                <li class="detail_top"><a href="#">상의</a></li>
                <li class="detail_bottoms"><a href="#">하의</a></li>
                <li class="detail_except"><a href="#">그 외</a></li>
            </ul>
            <ul class="detail_watch">
                <li class="detail_MF"><a href="#">남, 여</a></li>
                <li class="detail_brand"><a href="#">브랜드 별</a></li>
                <li class="detail_nomal"><a href="#">일반</a></li>
            </ul>
            <ul class="detail_shoes">
                <li class="detail_MF"><a href="#">남, 여</a></li>
                <li class="detail_brand"><a href="#">브랜드 별</a></li>
                <li class="detail_nomal"><a href="#">일반</a></li>
            </ul>
            <ul class="detail_except">
                <li class="detail_MF"><a href="#">남, 여</a></li>
                <li class="detail_brand"><a href="#">브랜드 별</a></li>
                <li class="detail_nomal"><a href="#">일반</a></li>
            </ul>
        </li>
        <li id="detail_sort4"><a href="#">거래 가능지역 ></a>
            <ul>
                <li><a href="#">서울</a></li>
                <li><a href="#">경기/인천</a></li>
                <li><a href="#">부산/울산</a></li>
                <li><a href="#">대구/경북</a></li>
                <li><a href="#">대전/세종</a></li>
                <li><a href="#">광주/전라</a></li>
            </ul>
        </li>
        <li id="detail_sort5"><a href="#">가격대</a>
            <ul>
                <li><a href="#">10이하</a></li>
                <li><a href="#">10-20</a></li>
                <li><a href="#">20-30</a></li>
                <li><a href="#">30-40</a></li>
                <li><a href="#">40-50</a></li>
                <li><a href="#">50-60</a></li>
                <li><a href="#">60-70</a></li>
                <li><a href="#">70-80</a></li>
                <li><a href="#">80-90</a></li>
                <li><a href="#">90-100</a></li>
                <li><a href="#">100이상</a></li>
            </ul>
        </li>
    </ul>
</nav>

<section align="center">
	<div id="detail_rap">
		<c:forEach items="${productList}" var="product">
			<div class="detail_content">
				<a href="getBoard.do?seq=${product.productid}"><img src="${product.image}"></a>
				<div class="detail_product">
				    <div id="detail_productName">${product.productname}</div>
				    <div id="detail_productPrice">${product.price}</div>
				</div>
				<div class="detail_seller">
			        <div id="detail_sellerId">${product.sellerid}</div>
			        <div id="detail_sellerReliability">${product.score}</div>
			    </div>
		    </div>
		</c:forEach>
    </div>
</section>

<jsp:include page="../header_footer/footer.jsp"></jsp:include>
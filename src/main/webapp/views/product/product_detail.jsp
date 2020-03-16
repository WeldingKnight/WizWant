<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="../header_footer/header.jsp"></jsp:include>
<title>제품 상세 페이지</title>
	<section align="center" class="detail_main">
	<form action="updateBoard.do" method="POST">
    <h1>제품 상세 페이지</h1>
    <img src="http://placehold.it/450x450">
    <input name="goods_id" type="hidden" value="${product.goods_id}"/>
    <table align="center" border="1">
        <tr>
            <td class="detail_prductname">${product.goods_name}</td>
            <td class="detail_prductprice">${product.goods_price}</td>
        </tr>
        <tr>
            <td class="detail_sellerId">${product.seller_id}</td>
            <td id="sort1" class="detail_sellerReliability" style="background-color:green;"><input id="detail_sellerReliability" value="" type="hidden"><span class="detail_seller">판매자신뢰도</span><span class="detail_sellerCnt" style="display:none;">판매이력 : 50번</span></td>
        </tr>
    </table>
    </form>
</section>
<jsp:include page="../header_footer/footer.jsp"></jsp:include>
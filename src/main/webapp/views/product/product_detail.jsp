<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../header_footer/header.jsp"></jsp:include>
<%
	request.setCharacterEncoding("UTF-8");
	String userId =  request.getParameter("userId");
	request.setAttribute("userId", userId);
%>
<title>제품 상세 페이지</title>
	<section align="center" class="detail_main">
    <h1>제품 상세 페이지</h1>
    <input type="hidden" name="goods_id" value="${product.goods_id}">
    <input type="hidden" name="product" value="${product}">
    <img src="img/product_img/${product.goods_image}">
    <table align="center" border="1">
    	<tr>
    		<th>상품 제목</th>
    		<th>상품 가격</th>
    	</tr>
        <tr>
            <td class="detail_productname">${product.goods_name}</td>
            <td class="detail_productprice">${product.goods_price}</td>
        </tr>
        <tr>
    		<th colspan="2">상품 설명</th>
    	</tr>
        <tr>
        	<td colspan="2" class="detail_productdetail">${product.goods_detail}</td>
        </tr>
        <tr>
    		<th>판매자 아이디</th>
    		<th>판매자 신용도</th>
    	</tr>
        <tr>
            <td class="detail_sellerId">${product.seller_id}</td>
            <td id="sort1" class="detail_sellerReliability" style="background-color:green;"><input id="detail_sellerReliability" value="" type="hidden"><span class="detail_seller">판매자신뢰도</span><span class="detail_sellerCnt" style="display:none;">판매이력 : 50번</span></td>
        </tr>
        <tr id="detail_productbutton">
        	<td colspan="2">
        		<a href="orders.do">장바구니</a>&nbsp;&nbsp;&nbsp;&nbsp;
        		<a href="orders.do">찜 목록</a>
			</td>
        </tr>	
        
        <c:set var="id" value="${userId}"/>
        <c:if test="${id == product.seller_id || id =='admin'}">
		<tr>
        	<td colspan="2">
        		<a href="deleteProduct.do?goods_id=${product.goods_id}">글 삭제</a>&nbsp;&nbsp;&nbsp;&nbsp;
        		<a href="updateProduct.do?goods_id=${product.goods_id}">글 수정</a>	
			</td>
        </tr>
        </c:if>
        
    </table>
</section>
<jsp:include page="../header_footer/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 페이지</title>
</head>
<link rel="stylesheet" href="../../css/product_detail.css">
<script src="../../js/jquery-2.2.4.min.js"></script>
<script src="../../js/product_detail.js"></script>
<body>
	<section align="center" class="detail_main">
    <h1>제품 상세 페이지</h1>
    <img src="http://placehold.it/450x450">
    <table align="center" border="1">
        <tr>
            <td class="detail_prductname">제품명</td>
            <td class="detail_prductprice">가격</td>
        </tr>
        <tr>
            <td class="detail_sellerId">판매자ID</td>
            <td id="sort1" class="detail_sellerReliability" style="background-color:green;"><span class="detail_seller">판매자신뢰도</span><span class="detail_sellerCnt" style="display:none;">판매이력 : 50번</span></td>
        </tr>
    </table>
</section>
</body>
</html>
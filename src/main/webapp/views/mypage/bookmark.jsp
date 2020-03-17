<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<link href="../../css/mypage.css" rel="stylesheet" type="text/css">
<jsp:include page="../header_footer/header.jsp"></jsp:include>
<h1 class="mypage_title">찜목록</h1>

<c:forEach items="${bookmarkList}" var="bookmarkList">
	<div>${bookmarkList.goods_id}</div>
	<div>${bookmarkList.goods_name}</div>
	<div>${bookmarkList.goods_detail}</div>
	<div>${bookmarkList.goods_price}</div>
	<div>${bookmarkList.seller_id}</div>
	<div>${bookmarkList.bookmark_id}</div>
	<div>${bookmarkList.user_id}</div>
</c:forEach>

<jsp:include page="../header_footer/footer.jsp"></jsp:include>

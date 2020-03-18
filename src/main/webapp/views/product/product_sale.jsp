
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header_footer/header.jsp"%>
<%@ page import="com.shopping.MVC_reshop.product.*" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    <div id="product_sale_wrap">
    <h2 align="center">상품 등록 페이지</h2>
    
        <form id="product_sale" action="product_sale.do" method="post">
            <table id="product_sale_table">
                <tr id="product_sale_contents" >
                    <td >상품 분류</td>
                    <td>상품 이미지</td>
                    <td>상품 가격</td>
                    <td>상품명</td>
                </tr>
                <tr id="product_sale_enrollment">
                    <td name="select_machine" id="detail_category"> 
	                    <select id="goods_kind_b" name="goods_kind_b" onChange="showSub(this.options[this.selectedIndex].value);">
	                    	<option key="default-empty" hidden></option>
	                        <option value="digital" id="digital">디지털</option>
	                        <option value="tel" id="tel">모바일</option>
	                        <option value="clothing" id="clothing">의류</option>
	                        <option value="grocery" id="grocery">잡화</option>
	                    </select>   
	        
	                    <select id ="detail_mid1" style="display: none;" onChange="showSub2(this.options[this.selectedIndex].value);">
	                    	<option key="default-empty" hidden></option>
	                        <option value="1">데스크탑</option>
	                        <option value="2">노트북</option>
	                        <option value="2">태블릿</option>
	                    </select>    
	        
	                    <select id="detail_sm1" name="goods_kind_s" style="display: none; ">

	                    </select>   
	        			
	        			<select id="detail_sm2" name="goods_kind_s" style="display: none;">

	                    </select>   
	        			
	                    <select id ="detail_mid2" style="display: none;">
	                        <option>스마트폰</option>
	                        <option>주변기기</option>
	                        <option>피처폰</option>
	                    </select> 
	        
	                    <select id="detail_sm3" name="goods_kind_s" style="display: none;">

	                    </select> 
	        
	                    <select id ="detail_mid3" style="display: none;">
	                       	<option>남성</option>
	                        <option>여성</option>
	                    </select> 
	        
	                    <select id="detail_sm4" name="goods_kind_s" style="display: none;">

	                    </select> 
	                    
	                    <select id ="detail_mid4" style="display: none;">
	                        <option>시계</option>
	                        <option>신발</option>
	                        <option>그 외</option>
	                    </select> 
	                    
	                    <select id="detail_sm5" name="goods_kind_s" style="display: none;">

	                    </select>
                	</td>
                    <td><input type="file" name="goods_image"  id="goods_image" alt="${product.image}" src="./img/product_img/${product.image}"></td>
                    <td><input type="text" id="goods_price" name="goods_price"></td>
                    <td><input type="text" id="goods_name" name="goods_name"></td>
                    
                </tr>
             
                <tr id="product_sale_contents">
                    <td>판매 지역</td>
                    <td>판매 수량</td>
                    <td>추가 설명</td>
                    <td>판매자 ID</td>
                </tr>

                <tr id="product_sale_enrollment">
                    <td>
                    	<select id ="seller_area" name="seller_area">
	                       	<option value="seoul">서울</option>
	                        <option value="kyin">경기/인천</option>
	                        <option value="buul">부산/울산</option>
	                        <option value="deke">대구/경북</option>
	                        <option value="dese">대전/세종</option>
	                        <option value="kangzen">광주/전라</option>
	                        <option value="kangze">강원/제주</option>
	                    </select>
                    </td>
                    
                    <td><input type="number" id="goods_quantity" name="goods_quantity"></td>
                    <td><textarea rows="10" cols="60" style="resize: none;"  id="goods_detail" name="goods_detail"></textarea></td>
                    <td>${loginuser.id}<input type='hidden' id="seller_id" name="seller_id"  value="${loginuser.id}" /></td>
                </tr>
                <tr id="product_sale_button">
                    <td colspan="4">
                        <input id="product_sale_input" type="submit" alt="상품등록" value="상품등록" />
                    </td>
                </tr>
                
            </table>
        </form>
    </div>

<%@ include file="../header_footer/footer.jsp"%>
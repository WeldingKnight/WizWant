<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header_footer/header.jsp"%>
<%@ page import="com.shopping.MVC_reshop.product.*" %>
<%@ page import="java.util.List" %>

    <div id="product_sale_wrap">
    <h2 align="center">상품 등록 페이지</h2>
    
        <form id="product_sale" action="product_sale.do" method="post"  enctype="Multipart/form-data" >
            <table id="product_sale_table">
                <tr id="product_sale_contents" >
                    <td >상품 분류</td>
                    <td>상품 이미지</td>
                    <td>상품 가격</td>
                    <td>상품명</td>
                </tr>
                <tr id="product_sale_enrollment">
                    <td name="select_machine" id="detail_category"> 
	                    <select id="ssmain" name="main" onChange="showSub(this.options[this.selectedIndex].value);">
	                        <option value="1" name="digital" id="digital">디지털</option>
	                        <option value="2" name="tel" id="tel">모바일</option>
	                        <option value="3" name="clothing" id="clothing">의류</option>
	                        <option value="4" name="grocery" id="grocery">잡화</option>
	                    </select>   
	        
	                    <select name="SUB1" style="display: ;">
	                        
	                        <option value=" ">데스크탑</option>
	                        <option value=" ">노트북</option>
	                        <option value=" ">태블릿</option>
	                    </select>    
	        
	                    <select name="SUB2" style="display: ;">
	                        <option name="goods_kind_s" value=" ">조립</option>
	                        <option name="goods_kind_s" value=" ">브랜드(삼성,LG,애플)</option>
	                        <option name="goods_kind_s" value=" ">브랜드(기타)</option>
	                    </select>   
	        
	                    <select name="SUB3" style="display: none;">
	                        <option name="goods_kind_b" value=" ">스마트폰</option>
	                        <option name="goods_kind_b" value=" ">주변기기</option>
	                        <option name="goods_kind_b" value=" ">피처폰</option>
	                    </select> 
	        
	                    <select name="SUB4" style="display: none;">
	                        <option name="goods_kind_s" value=" ">애플</option>
	                        <option name="goods_kind_s" value=" ">삼성,LG</option>
	                        <option name="goods_kind_s" value=" ">기타 브랜드</option>
	                    </select> 
	        
	                    <select name="SUB5" style="display: none;">
	                        <option name="goods_kind_b" value=" ">남성</option>
	                        <option name="goods_kind_b" value=" ">여성</option>
	                    </select> 
	        
	                    <select name="SUB6" style="display: none;">
	                        <option name="goods_kind_s" value=" ">상의</option>
	                        <option name="goods_kind_s" value=" ">하의</option>
	                        <option name="goods_kind_s" value=" ">그 외</option>
	                    </select> 
	                    
	                    <select name="SUB7" style="display: none;">
	                        <option name="goods_kind_b" value=" ">시계</option>
	                        <option name="goods_kind_b" value=" ">신발</option>
	                        <option name="goods_kind_b" value=" ">그 외</option>
	                    </select> 
	                    
	                    <select name="SUB8" style="display: none;">
	                        <option name="goods_kind_s" value=" ">남</option>
	                        <option name="goods_kind_s" value=" ">여</option>
	                        <option name="goods_kind_s" value=" ">브랜드 별</option>
	                    </select>
                	</td>
                    <td><input type="file" name="goods_image"  id="goods_image" src="./img/product_img/default.jpg"></td>
                    <td><input type="text" id="goods_price" name="goods_price"></td>
                    <td><input type="text" id="goods_name" name="goods_name"></td>
                    
                </tr>
             
                <tr id="product_sale_contents">
                    <td>판매기한</td>
                    <td>판매 수량</td>
                    <td>추가 설명</td>
                    <td>판매자 ID</td>
                </tr>

                <tr id="product_sale_enrollment">
                    <td><input  id="sell_date"type="date"></td>
                    <td><input type="number" id="goods_quantity" name="goods_quantity"></td>
                    <td><textarea rows="10" cols="60" style="resize: none;"  id="goods_detail"name="goods_detail"></textarea></td>
                    <td>${loginuser.id}<input type='hidden' id="seller_id" name="seller_id"  value="${loginuser.id}" /></td>
                </tr>
                <tr id="product_sale_button">
                    <td>
                        <input id="product_sale_input" type="submit" alt="상품등록" value="상품등록" />
                    </td>
                </tr>
                
            </table>
        </form>
    </div>

<%@ include file="../header_footer/footer.jsp"%>
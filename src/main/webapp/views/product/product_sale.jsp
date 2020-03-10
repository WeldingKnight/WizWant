<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header_footer/header.jsp"%>
<%@ page import="com.shopping.MVC_reshop.product.*" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <div id="product_sale_wrap">
    <h2 align="center">상품 등록 페이지</h2>
        <form id="product_sale">
            <table id="product_sale_table">
                <tr id="product_sale_contents" >
                    <td >상품 분류</td>
                    <td>상품 이미지</td>
                    <td>상품 가격</td>
                    <td>상품명</td>
                </tr>
                <tr id="product_sale_enrollment">
                    <td>
                        <label><input type="checkbox" name="디지털" value="디지털">디지털</label>
                        <label> <input type="checkbox" name="패션"  value="패션">통신</label>
                        <br>
                        <label> <input type="checkbox" name="패션"  value="패션">의류</label>&nbsp;&nbsp;&nbsp;
                        <label> <input type="checkbox" name="패션"  value="패션">잡화</label>
                    </td>
                    <td><input type="image"   value="이미지 등록"></td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                    
                </tr>
             
                <tr id="product_sale_contents">
                    <td>판매기한</td>
                    <td>판매 수량</td>
                    <td>추가 설명</td>
                    <td>${userId}</td>
                </tr>

                <tr id="product_sale_enrollment">
                    <td><input type="date"></td>
                    <td><input type="number"></td>
                    <td><textarea rows="10" cols="60" style="resize: none;"></textarea></td>
                    <td><input type="text" readonly></td>
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
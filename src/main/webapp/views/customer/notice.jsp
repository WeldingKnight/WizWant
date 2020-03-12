<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header_footer/header.jsp"%>

 <div class="wrap">
 		<!-- 탭 메뉴 -->
        <div class="tab">
            <div class="tab_cate">
                <div class="cate one">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/allqna.jpg" class="active" onclick="changeImg(this);"alt="전체 Q&A">
                        <img src="./img/customer_img/allqnahover.jpg" class="hover-img" alt="전체 Q&A">
                    </a>
                </div>
                <div class="cate two">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/fin.jpg" class="active" onclick="changeImg(this);" alt="주문/결제">
                        <img src="./img/customer_img/finhover.jpg" class="hover-img" alt="주문/결제">
                    </a>
                </div>
                <div class="cate three">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/delivery.jpg" class="active"onclick="changeImg(this);" alt="배송문의">
                        <img src="./img/customer_img/deliveryhover.jpg" class="hover-img" alt="배송문의">
                    </a>
                </div>
                <div class="cate four">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/refund.jpg" class="active" onclick="changeImg(this);"alt="반품/교환/환불">
                        <img src="./img/customer_img/refundhover.jpg" class="hover-img" alt="반품/교환/환불">
                    </a>
                </div>
                <div class="cate five">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/product.jpg" class="active" onclick="changeImg(this);" alt="상품문의">
                        <img src="./img/customer_img/producthover.jpg" class="hover-img" alt="상품문의">
                    </a>
                </div>
                <div class="cate six">
                    <a href="#" class="relative">
                        <img src="./img/customer_img/notice.jpg" class="active" onclick="changeImg(this);"alt="공지사항">
                        <img src="./img/customer_img/noticehover.jpg" class="hover-img" alt="공지사항">
                    </a>
                </div>
            </div>
        </div>
        <!-- 탭 메뉴 -->                         
        <div class="content">
            <div class="faq">
                <div class="faq_title">
                    1
                </div>
                <div class="faq_item">
                    1-1
                </div>
                <div class="faq_title">
                    2
                </div>
                <div class="faq_item">
                    2-2
                </div>
                <div class="faq_title">
                    3
                </div>
                <div class="faq_item">
                    3-3
                </div>
                <div class="faq_title">
                    4
                </div>
                <div class="faq_item">
                    4-4
                </div>
                <div class="faq_title">
                    5
                </div>
                <div class="faq_item">
                    5-5
                </div>
            </div>
        </div>
    </div>
<%@ include file="../header_footer/footer.jsp"%>
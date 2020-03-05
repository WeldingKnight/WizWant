<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header_footer/header.jsp"%>

 <div class="wrap">
 		<!-- 탭 메뉴 -->
        <div class="tab">
            <div class="tab_cate">
                <div class="cate one active">
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
                    상품에 대한 질문입니다.
                </div>
                <div class="faq_item">
                    상품이 이상합니다. 왜 상품이 왓죠? 오나홀 포장 부탁드립니다.
                </div>
                <div class="faq_title">
                    판매에 대한 질문입니다.
                </div>
                <div class="faq_item">
                    판매 어떻게 합니까 희수상!!!.
                </div>
                <div class="faq_title">
                    환불에 대한 질문입니다.
                </div>
                <div class="faq_item">
                    환불이 이상합니다. 왜 환불하는데 수수료떼죠? 이서훈!
                </div>
                <div class="faq_title">
                    결제에 대한 질문입니다.
                </div>
                <div class="faq_item">
                    결제를 신청하는데 왜 100만메소로 결제가 안된다는 거죠? 메이플 무시하나요?
                </div>
                <div class="faq_title">
                    배송에 대한 질문입니다.
                </div>
                <div class="faq_item">
                    배송이 이상합니다. 왠 외국인이 뤽배송이란 사람이 왔어요.
                </div>
            </div>
        </div>
    </div>
<%@ include file="../header_footer/footer.jsp"%>
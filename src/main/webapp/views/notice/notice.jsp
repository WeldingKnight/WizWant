<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header_footer/header.jsp"%>

 <div class="wrap">
 		<!-- 탭 메뉴 -->
        <div class="tab">
            <div class="tab_cate">
                <div class="cate one">
                    <a href="getQnaList.do" class="relative">
                        <img src="./img/customer_img/allqna.jpg" class="active" onclick="changeImg(this);"alt="전체 Q&A">
                        <img src="./img/customer_img/allqnahover.jpg" class="hover-img" alt="전체 Q&A">
                    </a>
                </div>
                <div class="cate two">
                    <a href="getQnaList.do" class="relative">
                        <img src="./img/customer_img/fin.jpg" class="active" onclick="changeImg(this);" alt="주문/결제">
                        <img src="./img/customer_img/finhover.jpg" class="hover-img" alt="주문/결제">
                    </a>
                </div>
                <div class="cate three">
                    <a href="getQnaList.do" class="relative">
                        <img src="./img/customer_img/delivery.jpg" class="active"onclick="changeImg(this);" alt="배송문의">
                        <img src="./img/customer_img/deliveryhover.jpg" class="hover-img" alt="배송문의">
                    </a>
                </div>
                <div class="cate four">
                    <a href="getQnaList.do" class="relative">
                        <img src="./img/customer_img/refund.jpg" class="active" onclick="changeImg(this);"alt="반품/교환/환불">
                        <img src="./img/customer_img/refundhover.jpg" class="hover-img" alt="반품/교환/환불">
                    </a>
                </div>
                <div class="cate five">
                    <a href="getQnaList.do" class="relative">
                        <img src="./img/customer_img/product.jpg" class="active" onclick="changeImg(this);" alt="상품문의">
                        <img src="./img/customer_img/producthover.jpg" class="hover-img" alt="상품문의">
                    </a>
                </div>
                <div class="cate six">
                    <a href="notice.do" class="relative">
                        <img src="./img/customer_img/notice.jpg" class="active" onclick="changeImg(this);"alt="공지사항">
                        <img src="./img/customer_img/noticehover.jpg" class="hover-img" alt="공지사항">
                    </a>
                </div>
            </div>
        </div>
        <!-- 탭 메뉴 -->                         
        <div class="content">
            <div class="not">
                <div class="not_title">
                    [공지] 개인정보처리방침 및 위치기반서비스 이용약관 개정 공지
                </div>
                <div class="not_item">
                    [공지] 개인정보처리방침 및 위치기반서비스 이용약관 개정 공지
                </div>
                <div class="not_title">
                    [공지] 위즈원트 이용약관 개정 공지 (2020년 2월 1일 시행)
                </div>
                <div class="not_item">
                    [공지] 위즈원트 이용약관 개정 공지 (2020년 2월 1일 시행)
                </div>
                <div class="not_title">
                    [이벤트] 돌아온 초성퀴즈! 맞추면 카톡 이모티콘 Dream☆ 
                </div>
                <div class="not_item">
                    [이벤트] 돌아온 초성퀴즈! 맞추면 카톡 이모티콘 Dream☆
                </div>
                <div class="not_title">
                    [안내] 현직 경찰회원님이 전하는 '장물 사기 거래' 예방팁
                </div>
                <div class="not_item">
                    [안내] 현직 경찰회원님이 전하는 '장물 사기 거래' 예방팁
                </div>
                <div class="not_title">
                    [공지] 2020 인터넷 지킴이 캠페인. 스마트폰 속 개인정보 확인하고 지키세요!
                </div>
                <div class="not_item">
                    [공지] 2020 인터넷 지킴이 캠페인. 스마트폰 속 개인정보 확인하고 지키세요!
                </div>
            </div>
        </div>
    </div>
<%@ include file="../header_footer/footer.jsp"%>
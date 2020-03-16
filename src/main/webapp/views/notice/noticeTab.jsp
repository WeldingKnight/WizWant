<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
     <div class="tab">
         <div class="tab_cate">
             <div class="cate one active">
                 <a href="getQnaList.do" class="relative">
                     <img src="./img/customer_img/allqna.jpg" id="1" class="active" alt="전체 Q&A">
                     <img src="./img/customer_img/allqnahover.jpg" id="1h" class="hover-img" alt="전체 Q&A">
                 </a>
             </div>
             <div class="cate two">
                 <a href="getSortList.do?sort=주문결제" class="relative">
                     <img src="./img/customer_img/fin.jpg" id="2" class="active" alt="주문/결제">
                     <img src="./img/customer_img/finhover.jpg" id="2h" class="hover-img" alt="주문/결제">
                 </a>
             </div>
             <div class="cate three">
                 <a href="getSortList.do?sort=배송문의" class="relative">
                     <img src="./img/customer_img/delivery.jpg" id="3" class="active" alt="배송문의">
                     <img src="./img/customer_img/deliveryhover.jpg" id="3h" class="hover-img" alt="배송문의">
                 </a>
             </div>
             <div class="cate four">
                 <a href="getSortList.do?sort=환불문의" class="relative">
                     <img src="./img/customer_img/refund.jpg" id="4" class="active" alt="반품/교환/환불">
                     <img src="./img/customer_img/refundhover.jpg" id="4h" class="hover-img" alt="반품/교환/환불">
                 </a>
             </div>
             <div class="cate five">
                 <a href="getSortList.do?sort=상품문의" class="relative">
                     <img src="./img/customer_img/product.jpg" id="5" class="active" alt="상품문의">
                     <img src="./img/customer_img/producthover.jpg" id="5h" class="hover-img" alt="상품문의">
                 </a>
             </div>
             <div class="cate six">
                 <a href="getNoticeList.do" class="relative">
                     <img src="./img/customer_img/notice.jpg" id="6" class="active 6" alt="공지사항">
                     <img src="./img/customer_img/noticehover.jpg" id="6h" class="hover-img" alt="공지사항">
                 </a>
             </div>
         </div>
     </div>
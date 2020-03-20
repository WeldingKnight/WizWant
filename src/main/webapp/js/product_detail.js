$(function() {
	$('.detail_sellerReliability').hover(function() {
		$(".detail_seller").css("display", "none");
		$(".detail_sellerCnt").css("display", "block");
	}, function() {
		$(".detail_seller").css("display", "block");
		$(".detail_sellerCnt").css("display", "none");
	});

});


$(function() {
	$("#product_sale_button").click(function() {
		alert("파일 오류방지를 위해서 다시한번 업로드 해주시길 바랍니다.")
	});
});

function insert_cart_check() {
	alert("상품이 장바구니에 추가되었습니다.");
};
function insert_bookmark_check() {
	alert("상품이 찜목록에 추가되었습니다.");
};
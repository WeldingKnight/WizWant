$(function() {
	$('.detail_sellerReliability').hover(function() {
		$(".detail_seller").css("display", "none");
		$(".detail_sellerCnt").css("display", "block");
	}, function() {
		$(".detail_seller").css("display", "block");
		$(".detail_sellerCnt").css("display", "none");
	});

});
$("#product_sale_button").click(function() {
	alert("제가 조빱이라 같은 사진 두번올려야 합니다 ㅠ")
});

function insert_cart_check() {
	alert("장바구니에 물품을 추가했습니다.");
}

function insert_bookmark_check() {
	alert("찜목록에 물품을 추가했습니다.");
}

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
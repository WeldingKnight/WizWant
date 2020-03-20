$(function(){
    $('.detail_sellerReliability').hover(function() {
        $(".detail_seller").css("display", "none");
        $(".detail_sellerCnt").css("display", "block");
    }, function(){
        $(".detail_seller").css("display", "block");
        $(".detail_sellerCnt").css("display", "none");
    });
    
});
$(function(){
	$("#product_sale_input").click(function() {
	alert("파일 오류방지를 위해서 다시한번 업로드 해주시길 바랍니다.")
	});
});
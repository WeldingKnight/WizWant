$(function(){
    $('.detail_sellerReliability').hover(function() {
        $(".detail_seller").css("display", "none");
        $(".detail_sellerCnt").css("display", "block");
    }, function(){
        $(".detail_seller").css("display", "block");
        $(".detail_sellerCnt").css("display", "none");
    });
});
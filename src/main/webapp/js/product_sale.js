//상위 셀렉트로 하위 셀렉트 제어하기
function showSub(hrefVal) {       
    if(hrefVal == 1) {
        $("#digital").attr("selected","selected");
        $("#detail_category select[name*=SUB1]").show();
        $("#detail_category select[name*=SUB2]").show();
        $("#detail_category select[name*=SUB3]").hide();
        $("#detail_category select[name*=SUB4]").hide();
        $("#detail_category select[name*=SUB5]").hide();
        $("#detail_category select[name*=SUB6]").hide();
        $("#detail_category select[name*=SUB7]").hide();
        $("#detail_category select[name*=SUB8]").hide();
    } else if(hrefVal == 2) {
        $("#tel").attr("selected","selected");
        $("#detail_category select[name*=SUB1]").hide();
        $("#detail_category select[name*=SUB2]").hide();
        $("#detail_category select[name*=SUB3]").show();
        $("#detail_category select[name*=SUB4]").show();
        $("#detail_category select[name*=SUB5]").hide();
        $("#detail_category select[name*=SUB6]").hide();
        $("#detail_category select[name*=SUB7]").hide();
        $("#detail_category select[name*=SUB8]").hide();
    } else if(hrefVal == 3) {
        $("#clothing").attr("selected","selected");
        $("#detail_category select[name*=SUB1]").hide();
        $("#detail_category select[name*=SUB2]").hide();
        $("#detail_category select[name*=SUB3]").hide();
        $("#detail_category select[name*=SUB4]").hide();
        $("#detail_category select[name*=SUB5]").show();
        $("#detail_category select[name*=SUB6]").show();
        $("#detail_category select[name*=SUB7]").hide();
        $("#detail_category select[name*=SUB8]").hide();
    } else if(hrefVal == 4) {
        $("#grocery").attr("selected","selected");
        $("#detail_category select[name*=SUB1]").hide();
        $("#detail_category select[name*=SUB2]").hide();
        $("#detail_category select[name*=SUB3]").hide();
        $("#detail_category select[name*=SUB4]").hide();
        $("#detail_category select[name*=SUB5]").hide();
        $("#detail_category select[name*=SUB6]").hide();
        $("#detail_category select[name*=SUB7]").show();
        $("#detail_category select[name*=SUB8]").show();
    } 
}
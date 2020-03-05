$(function(){
    $('#detail_sort1').hover(function() {
        $("#detail_category").css("display", "block");
    });
});
$(function(){
    $('#detail_category').children().click(function(){
        var idV = $(this).attr("id"); //id뽑아오기 digital
        if(idV == "detail_digital"){
            $("#detail_sort2 > ul").css("display", "none");
            $("#detail_sort2 > .detail_digital").css("display", "block");
            $("#detail_sort3 > ul").css("display", "none");
            $("#detail_sort4 > ul").css("display", "none");
            $("#detail_sort5 > ul").css("display","none");
        }
        else if(idV =="detail_mobile"){
            $("#detail_sort2 > ul").css("display", "none");
            $("#detail_sort2 > .detail_mobile").css("display", "block");
            $("#detail_sort3 > ul").css("display", "none");
            $("#detail_sort4 > ul").css("display", "none");
            $("#detail_sort5 > ul").css("display","none");
        }
        else if(idV =="detail_clothes"){
            $("#detail_sort2 > ul").css("display", "none");
            $("#detail_sort2 > .detail_clothes").css("display", "block");
            $("#detail_sort3 > ul").css("display", "none");
            $("#detail_sort4 > ul").css("display", "none");
            $("#detail_sort5 > ul").css("display","none");
        }
        else if(idV =="detail_fashion"){
            $("#detail_sort2 > ul").css("display", "none");
            $("#detail_sort2 > .detail_fashion").css("display", "block");
            $("#detail_sort3 > ul").css("display", "none");
            $("#detail_sort4 > ul").css("display", "none");
            $("#detail_sort5 > ul").css("display","none");
        }   
    });
    $('#detail_sort2').find("ul > li").click(function(){
            var id1 = $(this).attr("class");
            if(id1 == "detail_desktop"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_desktop").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }  
            else if(id1 == "detail_laptop"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_laptop").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            else if(id1 == "detail_tablet"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_tablet").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            else if(id1 == "detail_smart"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_smart").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            else if(id1 == "detail_interface"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_interface").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            else if(id1 == "detail_feature"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_feature").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            else if(id1 == "detail_male"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_male").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            else if(id1 == "detail_female"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_female").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            else if(id1 == "detail_watch"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_watch").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            else if(id1 == "detail_shoes"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_shoes").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            else if(id1 == "detail_except"){
                $("#detail_sort3 > ul").css("display","none");
                $("#detail_sort3 > .detail_except").css("display", "block");
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display","none");
            }
            $('#detail_sort3').find("ul > li").click(function(){
                $("#detail_sort4 > ul").css("display", "none");
                $("#detail_sort4 > ul").css("display", "block");
                $("#detail_sort5 > ul").css("display","none");
            });
            $('#detail_sort4').find("ul > li").click(function(){
                $("#detail_sort5 > ul").css("display", "none");
                $("#detail_sort5 > ul").css("display", "block");
                $("#detail_sort5 > ul").mouseleave(function(){
                    $("#detail_category").css("display", "none");
                    $("#detail_sort2 > ul").css("display", "none");
                    $("#detail_sort3 > ul").css("display", "none");
                    $("#detail_sort4 > ul").css("display", "none");
                    $("#detail_sort5 > ul").css("display","none");
                });
            });
    }); 
});
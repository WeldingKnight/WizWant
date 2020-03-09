
$(function(){
	var tmpObj = new Object();
	var tmpArr;
	
	tmpArr = ['디지털','모바일','의류','패션잡화'];
	tmpObj.big = tmpArr;
	
	tmpArr  = [
		{"digital":['데스크탑','노트북','태블릿']},
		{"mobile":['스마트폰','주변기기','피처폰']},
		{"clothes":['남성','여성']},
		{"fashion":['시계','신발','그 외']}
	];
	tmpObj.middle = tmpArr;
	
	tmpArr = [
		{'desktop':['조립','브랜드(삼성,LG,애플)','브랜드(기타)']},
		{'laptop':['애플','삼성,LG','기타 브랜드']},
		{'tablet':['애플','삼성,LG','기타 브랜드']},
		{'smart':['애플','삼성,LG','기타 브랜드']},
		{'interface':['애플','삼성,LG','기타 브랜드']},
		{'feature':['삼성,LG','기타 브랜드']},
		{'male':['하의','상의','그 외']},
		{'female':['하의','상의','그 외']},
		{'watch':['남','여','브랜드 별']},
		{'shoes':['남','여','브랜드 별']},
		{'except':['남','여','브랜드']}
	];
	tmpObj.small     = tmpArr;
	
	tmpArr = ['서울','경기/인천','부산/울산','대구/경북','대전/세종','광주/전라','강원/제주'];
	tmpObj.local     = tmpArr;
	
	tmpArr = ['10이하','10-20','20-30','30-40','40-50','50-60','60-70','70-80','80-90','90-100','100이상'];
	tmpObj.price     = tmpArr;
	 
	
	console.log( "json object : " + JSON.stringify(tmpObj));
	var Json = JSON.stringify(tmpObj);
	console.log(tmpObj.middle[0]);
	console.log(tmpObj.small[0].desktop[0]);
	
    $('#detail_category').children().click(function(){
		var idV = $(this).attr("id"); //id뽑아오기 digital
	    if(idV == "detail_digital"){
	    	var html = '';
	    	for(var i=0;i<tmpObj.middle[0].digital.length; i++){
	    		html += '<li class="detail_digital'+i+'"><a href="#">' +tmpObj.middle[0].digital[i] + '</a></li>';
	    	}
	      $('#detail_sort2 > .detail_digital').html(html);   
	      $("#detail_sort2 > ul").css("display", "none");
	      $("#detail_sort2 > .detail_digital").css("display", "block");
	      $("#detail_sort3 > ul").css("display", "none");
	      $("#detail_sort4 > ul").css("display", "none");
          $("#detail_sort5 > ul").css("display","none");
	    }
	    else if(idV =="detail_mobile"){
	    	var html = '';
	    	for(var i=0;i<tmpObj.middle[1].mobile.length; i++){
	    		html += '<li class="detail_mobile'+i+'"><a href="#">' +tmpObj.middle[1].mobile[i] + '</a></li>';
	    	}
	      $('#detail_sort2 > .detail_mobile').html(html);   
	      $("#detail_sort2 > ul").css("display", "none");
	      $("#detail_sort2 > .detail_mobile").css("display", "block");
	      $("#detail_sort3 > ul").css("display", "none");
	      $("#detail_sort4 > ul").css("display", "none");
          $("#detail_sort5 > ul").css("display","none");
	    }
	    else if(idV =="detail_clothes"){
	    	var html = '';
	    	for(var i=0;i<tmpObj.middle[2].clothes.length; i++){
	    		html += '<li class="detail_clothes'+i+'"><a href="#">' +tmpObj.middle[2].clothes[i] + '</a></li>';
	    	}
	      $('#detail_sort2 > .detail_clothes').html(html);   
	      $("#detail_sort2 > ul").css("display", "none");
	      $("#detail_sort2 > .detail_clothes").css("display", "block");
	      $("#detail_sort3 > ul").css("display", "none");
	      $("#detail_sort4 > ul").css("display", "none");
          $("#detail_sort5 > ul").css("display","none");
	    }
	    else if(idV =="detail_fashion"){
	    	var html = '';
	    	for(var i=0;i<tmpObj.middle[3].fashion.length; i++){
	    		html += '<li class="detail_fashion'+i+'"><a href="#">' +tmpObj.middle[3].fashion[i] + '</a></li>';
	    	}
	      $('#detail_sort2 > .detail_fashion').html(html);   
	      $("#detail_sort2 > ul").css("display", "none");
	      $("#detail_sort2 > .detail_fashion").css("display", "block");
	      $("#detail_sort3 > ul").css("display", "none");
	      $("#detail_sort4 > ul").css("display", "none");
          $("#detail_sort5 > ul").css("display","none");
	    }
	    $('#detail_sort2 ul li').click(function(){
	        var id1 = $(this).attr("class");
	        console.log(tmpObj.small[6].male);
	        if(id1 == "detail_digital0"){
	            $("#detail_sort3 > ul").css("display","none");
	            var html = '';
		    	for(var i=0;i<tmpObj.small[0].desktop.length; i++){
		    		html += '<li class="detail_digital0'+i+'"><a href="#">' +tmpObj.small[0].desktop[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_desktop').html(html);
	            $("#detail_sort3 > .detail_desktop").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }  
	        else if(id1 == "detail_digital1"){
	        	$("#detail_sort3 > ul").css("display","none");
	            var html = '';
		    	for(var i=0;i<tmpObj.small[1].laptop.length; i++){
		    		html += '<li class="detail_digital1'+i+'"><a href="#">' +tmpObj.small[1].laptop[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_desktop').html(html);
	            $("#detail_sort3 > .detail_desktop").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_digital2"){
				$("#detail_sort3 > ul").css("display","none");
				var html = '';
				for(var i=0;i<tmpObj.small[2].tablet.length; i++){
					html += '<li class="detail_digital2'+i+'"><a href="#">' +tmpObj.small[2].tablet[i] + '</a></li>';
				}
				$('#detail_sort3 > .detail_desktop').html(html);
				$("#detail_sort3 > .detail_desktop").css("display", "block");
				$("#detail_sort4 > ul").css("display", "none");
				$("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_mobile0"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[3].smart.length; i++){
		    		html += '<li class="detail_mobile0'+i+'"><a href="#">' +tmpObj.small[3].smart[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_mobile').html(html);
	            $("#detail_sort3 > .detail_mobile").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_mobile1"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[4].interface.length; i++){
		    		html += '<li class="detail_mobile1'+i+'"><a href="#">' +tmpObj.small[4].interface[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_mobile').html(html);
	            $("#detail_sort3 > .detail_mobile").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_mobile2"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[5].feature.length; i++){
		    		html += '<li class="detail_mobile2'+i+'"><a href="#">' +tmpObj.small[5].feature[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_mobile').html(html);
	            $("#detail_sort3 > .detail_mobile").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_clothes0"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[6].male.length; i++){
		    		html += '<li class="detail_clothes0'+i+'"><a href="#">' +tmpObj.small[6].male[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_clothes').html(html);
	            $("#detail_sort3 > .detail_clothes").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_clothes1"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[7].female.length; i++){
		    		html += '<li class="detail_clothes1'+i+'"><a href="#">' +tmpObj.small[7].female[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_clothes').html(html);
	            $("#detail_sort3 > .detail_clothes").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_fashion0"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[8].watch.length; i++){
		    		html += '<li class="detail_fashion0'+i+'"><a href="#">' +tmpObj.small[8].watch[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_fashion').html(html);
	            $("#detail_sort3 > .detail_fashion").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_fashion1"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[9].shoes.length; i++){
		    		html += '<li class="detail_fashion1'+i+'"><a href="#">' +tmpObj.small[9].shoes[i] + '</a></li>';except
		    	}
		    	$('#detail_sort3 > .detail_fashion').html(html);
	            $("#detail_sort3 > .detail_fashion").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_fashion2"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[10].except.length; i++){
		    		html += '<li class="detail_fashion2'+i+'"><a href="#">' +tmpObj.small[10].except[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_fashion').html(html);
	            $("#detail_sort3 > .detail_fashion").css("display", "block");
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

    $('#detail_sort1').hover(function() {
        $("#detail_category").css("display", "block");
    });
    
    
});

//    $('#detail_category').children().click(function(){
//    	var idV = $(this).attr("id"); //id뽑아오기 digital
//        if(idV == "detail_digital"){
//            $("#detail_sort2 > ul").css("display", "none");
//            $("#detail_sort2 > .detail_digital").css("display", "block");
//            $("#detail_sort3 > ul").css("display", "none");
//            $("#detail_sort4 > ul").css("display", "none");
//            $("#detail_sort5 > ul").css("display","none");
//        }
//    	
//    	else if(idV =="detail_mobile"){
//            $("#detail_sort2 > ul").css("display", "none");
//            $("#detail_sort2 > .detail_mobile").css("display", "block");
//            $("#detail_sort3 > ul").css("display", "none");
//            $("#detail_sort4 > ul").css("display", "none");
//            $("#detail_sort5 > ul").css("display","none");
//        }
//        else if(idV =="detail_clothes"){
//            $("#detail_sort2 > ul").css("display", "none");
//            $("#detail_sort2 > .detail_clothes").css("display", "block");
//            $("#detail_sort3 > ul").css("display", "none");
//            $("#detail_sort4 > ul").css("display", "none");
//            $("#detail_sort5 > ul").css("display","none");
//        }
//        else if(idV =="detail_fashion"){
//            $("#detail_sort2 > ul").css("display", "none");
//            $("#detail_sort2 > .detail_fashion").css("display", "block");
//            $("#detail_sort3 > ul").css("display", "none");
//            $("#detail_sort4 > ul").css("display", "none");
//            $("#detail_sort5 > ul").css("display","none");
//        }   
//    });
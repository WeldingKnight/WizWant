

$(function(){
	function setDiv(name, index){
		var html = '';
		for(var i=0;i<tmpObj.middle[index].length; i++){
    		html += '<li class="detail_'+i+'"><a href="#">' +tmpObj.middle[index][i] + '</a></li>';
    	}
		$('#detail_sort2 > .'+name).html(html);   
	    $("#detail_sort2 > ul").css("display", "none");
	    $("#detail_sort2 > ."+name).css("display", "block");
	    $("#detail_sort3 > ul").css("display", "none");
	    $("#detail_sort4 > ul").css("display", "none");
	    $("#detail_sort5 > ul").css("display","none");
	}
	
	function setDiv2(name, index) {
		var html = '';
		$("#detail_sort3 > ul").css("display","none");
    	for(var i=0;i<tmpObj.small[index].length; i++){
    		html += '<li class="detail__'+i+'"><a href="#">' +tmpObj.small[index][i] + '</a></li>';
    	}
    	$('#detail_sort3 > .'+name).html(html);
        $("#detail_sort3 > ."+name).css("display", "block");
        $("#detail_sort4 > ul").css("display", "none");
        $("#detail_sort5 > ul").css("display","none");
	}
	
	//json으로 nav텝 목록 담기
	var tmpObj = new Object();
	var tmpArr;
	
	tmpArr = ['디지털','모바일','의류','패션잡화'];
	tmpObj.big = tmpArr;
	
	tmpArr  = [
		['데스크탑','노트북','태블릿'],
		['스마트폰','주변기기','피처폰'],
		['남성','여성'],
		['시계','신발','그 외']
	];
	tmpObj.middle = tmpArr;
	
	tmpArr = [
		['조립','브랜드(삼성,LG,애플)','브랜드(기타)'],
		['애플','삼성,LG','기타 브랜드'],
		['애플','삼성,LG','기타 브랜드'],
		['애플','삼성,LG','기타 브랜드'],
		['애플','삼성,LG','기타 브랜드'],
		['삼성,LG','기타 브랜드'],
		['하의','상의','그 외'],
		['하의','상의','그 외'],
		['남','여','브랜드 별'],
		['남','여','브랜드 별'],
		['남','여','브랜드 별']
	];
	tmpObj.small     = tmpArr;
	
	tmpArr = ['서울','경기/인천','부산/울산','대구/경북','대전/세종','광주/전라','강원/제주'];
	tmpObj.local     = tmpArr;
	
	tmpArr = ['10이하','10-20','20-30','30-40','40-50','50-60','60-70','70-80','80-90','90-100','100이상'];
	tmpObj.price     = tmpArr;
	 
	
	console.log( "json object : " + JSON.stringify(tmpObj));
	var Json = JSON.stringify(tmpObj);
	console.log(tmpObj.middle[0]);
	// 첫 카테고리에서 메뉴 선택시 메뉴 보이기
    $('#detail_category').children().click(function(){
		var idV = $(this).attr("id"); //id뽑아오기 digital
		console.log(idV);
	    if(idV == "detail_digital"){
	    	setDiv("detail_digital", 0);
	    }
	    else if(idV =="detail_mobile"){
	    	setDiv("detail_mobile", 1);
	    }
	    else if(idV =="detail_clothes"){
	    	setDiv("detail_mobile", 2);
	    }
	    else if(idV =="detail_fashion"){
	    	setDiv("detail_mobile", 3);
	    }
	    
	    // 2번쨰 카테고리에서 메뉴 선택시 메뉴 보이기
	    
	    $('#detail_sort2 ul li').click(function(){
	        var id1 = $(this).attr("class");
	        if(id1 == "detail_0"){
	        	setDiv2("detail_0", 0);
	        }  
	        else if(id1 == "detail_digital1"){
	        	$("#detail_sort3 > ul").css("display","none");
	            var html = '';
		    	for(var i=0;i<tmpObj.small[1].laptop.length; i++){
		    		html += '<li class="detail_digital1'+i+'"><a href="#">' +tmpObj.small[1].laptop[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_laptop').html(html);
	            $("#detail_sort3 > .detail_laptop").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_digital2"){
				$("#detail_sort3 > ul").css("display","none");
				var html = '';
				for(var i=0;i<tmpObj.small[2].tablet.length; i++){
					html += '<li class="detail_digital2'+i+'"><a href="#">' +tmpObj.small[2].tablet[i] + '</a></li>';
				}
				$('#detail_sort3 > .detail_tablet').html(html);
				$("#detail_sort3 > .detail_tablet").css("display", "block");
				$("#detail_sort4 > ul").css("display", "none");
				$("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_mobile0"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[3].smart.length; i++){
		    		html += '<li class="detail_mobile0'+i+'"><a href="#">' +tmpObj.small[3].smart[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_smart').html(html);
	            $("#detail_sort3 > .detail_smart").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_mobile1"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[4].interface.length; i++){
		    		html += '<li class="detail_mobile1'+i+'"><a href="#">' +tmpObj.small[4].interface[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_interface').html(html);
	            $("#detail_sort3 > .detail_interface").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_mobile2"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[5].feature.length; i++){
		    		html += '<li class="detail_mobile2'+i+'"><a href="#">' +tmpObj.small[5].feature[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_feature').html(html);
	            $("#detail_sort3 > .detail_feature").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_clothes0"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[6].male.length; i++){
		    		html += '<li class="detail_clothes0'+i+'"><a href="#">' +tmpObj.small[6].male[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_male').html(html);
	            $("#detail_sort3 > .detail_male").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_clothes1"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[7].female.length; i++){
		    		html += '<li class="detail_clothes1'+i+'"><a href="#">' +tmpObj.small[7].female[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_female').html(html);
	            $("#detail_sort3 > .detail_female").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_fashion0"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[8].watch.length; i++){
		    		html += '<li class="detail_fashion0'+i+'"><a href="#">' +tmpObj.small[8].watch[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_watch').html(html);
	            $("#detail_sort3 > .detail_watch").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_fashion1"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[9].shoes.length; i++){
		    		html += '<li class="detail_fashion1'+i+'"><a href="#">' +tmpObj.small[9].shoes[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_shoes').html(html);
	            $("#detail_sort3 > .detail_shoes").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        else if(id1 == "detail_fashion2"){
	        	$("#detail_sort3 > ul").css("display","none");
	        	var html = '';
		    	for(var i=0;i<tmpObj.small[10].except.length; i++){
		    		html += '<li class="detail_fashion2'+i+'"><a href="#">' +tmpObj.small[10].except[i] + '</a></li>';
		    	}
		    	$('#detail_sort3 > .detail_except').html(html);
	            $("#detail_sort3 > .detail_except").css("display", "block");
	            $("#detail_sort4 > ul").css("display", "none");
	            $("#detail_sort5 > ul").css("display","none");
	        }
	        
	        // 3번쨰 카테고리에서 메뉴 선택시 메뉴 보이기
	        
	        $('#detail_sort3').find("ul > li").click(function(){      	
	            $("#detail_sort4 > ul").css("display", "none");
	            var html = '';
		    	for(var i=0;i<tmpObj.local.length; i++){
		    		html += '<li class="detail_local'+i+'"><a href="#">' +tmpObj.local[i] + '</a></li>';
		    	}
		    	$('#detail_sort4 > .detail_local').html(html);
	            $("#detail_sort4 > .detail_local").css("display", "block");
	            $("#detail_sort5 > ul").css("display","none");
	        
		        // 4번쨰 카테고리에서 메뉴 선택시 메뉴 보이기
		        $('#detail_sort4').find("ul > li").click(function(){
		            $("#detail_sort5 > ul").css("display", "none");
		            var html = '';
			    	for(var i=0;i<tmpObj.price.length; i++){
			    		html += '<li class="detail_price'+i+'"><a href="#">' +tmpObj.price[i] + '</a></li>';
			    	}
			    	$('#detail_sort5 > .detail_price').html(html);
		            $("#detail_sort5 > ul").css("display", "block");
		            // 마지막 메뉴에서 마우스를 떠나면 모든 메뉴 안보이게
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
	});
    $('#detail_sort1').hover(function() {
        $("#detail_category").css("display", "block");
    });
    
});
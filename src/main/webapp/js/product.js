$(function(){
	function setDiv(name, index){
		var html = '';
		for(var i=0;i<tmpObj.middle[index].length; i++){
    		html += '<li class="'+name+i+'"><a href="#">' +tmpObj.middle[index][i] + '</a></li>\n';
    	}
		$('#detail_sort2 > .'+name).html(html);   
	    $("#detail_sort2 > ul").css("display", "none");
	    $("#detail_sort2 > ."+name).css("display", "block");
	    $("#detail_sort3 > ul").css("display", "none");
	    $("#detail_sort4 > ul").css("display", "none");
	    $("#detail_sort5 > ul").css("display","none");
	    
	    $("#detail_sort1 > ul li").css("background-color","dodgerblue");
	    $("#"+name).css("background-color","#e8491d");
	}
	
	function setDiv2(name, index) {
		var html = '';
		$("#detail_sort3 > ul").css("display","none");
    	for(var i=0;i<tmpObj.small[index].length; i++){
    		html += '<li class="'+name+i+'"><a href="#">' +tmpObj.small[index][i] + '</a></li>\n';
    		
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
	
//	var sessionId = session.getAttribute(Classification);
//	console.log($.session("Classification"));
	

	
	// 첫 카테고리에서 메뉴 선택시 메뉴 보이기
    $('#detail_category').children().click(function(){
		var idV = $(this).attr("id"); //id뽑아오기 digital
	    if(idV == "detail_digital"){
	    	setDiv("detail_digital", 0);
	    }
	    else if(idV =="detail_mobile"){
	    	setDiv("detail_mobile", 1);
	    }
	    else if(idV =="detail_clothes"){
	    	setDiv("detail_clothes", 2);
	    }
	    else if(idV =="detail_fashion"){
	    	setDiv("detail_fashion", 3);
	    }
	    
	    // 2번쨰 카테고리에서 메뉴 선택시 메뉴 보이기
	    
	    $('#detail_sort2 ul li').click(function(){
	        var id1 = $(this).attr("class");
	        if(id1 == "detail_digital0"){
	        	setDiv2("detail_digital0", 0);
	        }  
	        else if(id1 == "detail_digital1"){
	        	setDiv2("detail_digital1", 1);
	        }
	        else if(id1 == "detail_digital2"){
	        	setDiv2("detail_digital2", 2);
	        }
	        else if(id1 == "detail_mobile0"){
	        	setDiv2("detail_mobile0", 3);
	        }
	        else if(id1 == "detail_mobile1"){
	        	setDiv2("detail_mobile1", 4);
	        }
	        else if(id1 == "detail_mobile2"){
	        	setDiv2("detail_mobile2", 5);
	        }
	        else if(id1 == "detail_clothes0"){
	        	setDiv2("detail_clothes0", 6);
	        }
	        else if(id1 == "detail_clothes1"){
	        	setDiv2("detail_clothes1", 7);
	        }
	        else if(id1 == "detail_fashion0"){
	        	setDiv2("detail_fashion0", 8);
	        }
	        else if(id1 == "detail_fashion1"){
	        	setDiv2("detail_fashion1", 9);
	        }
	        else if(id1 == "detail_fashion2"){
	        	setDiv2("detail_fashion2", 10);
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
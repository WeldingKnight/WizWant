/**
 * 
 */



//
//$(function(){
//    $('div.one > a.relative > img').eq(1).show();
//    $('div.one > a.relative > img').eq(0).hide();  
//  });
//
//
//function changeImg(e){
//    var im = e;
//    var active = document.getElementsByClassName('active');   
//    var hover = document.getElementsByClassName('hover-img');
//
//    for (i=0; i<active.length; i++) {
//        active[i].style.display='block';
//    }
//    for (i=0; i<hover.length; i++) {
//        hover[i].style.display='none';
//    }
//    im.style.display = 'none';
//    im.nextSibling.nextSibling.style.display ='block';
//}

//2020.03.13
//async function initBoard(){
//	let boardData = await functionName("select * from qna_board");
//	
//	let sort = $.urlParam('sort');
//	
//	if(sort == 'order'){
//		boardData.qna_kind()
//	}
////	
////	boardData.qna_kind()
//	//정렬
//	
//	//
//	append()
//	
//}
//
//$.urlParam = function (name) {
//    let results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
//    if (results == null) {
//        return null;
//    }
//    else {
//        return results[1] || 0;
//    }
//}
//
//let sort = $.urlParam('sort') - 1;
//if (page == -1) {
//    page = 0;
//}


//2020-03.15
//$(function(){
//	change();
//  });
//
//function changeImg(e){
//	var im = e;
//	im.classList.remove( 'acitve' );
//	im.nextSibling.nextSibling.classList.add( 'active' );
//	
////  im.style.display = 'none';
////  im.nextSibling.nextSibling.style.display ='block';
//}
//function change(){
//	 var active = document.getElementsByClassName('active');   
//     var hover = document.getElementsByClassName('hover-img');
//     active.style.display='none';
//     hover.style.display='block';
//}
/**
 * 
 */
$(function(){
    $('div.one > a.relative > img').eq(1).show();
    $('div.one > a.relative > img').eq(0).hide();  
  });

$(document).ready(function(){
    $("div.content  > div.faq > div.faq_item").hide();
    // $("ul > li:first-child a").next().show();
    $("div.content > div.faq > div.faq_title").click(function(){
      $(this).next().stop().slideToggle(300);
      // $(this).next().slideDown(300);
      $("div.content > div.faq > div.faq_title").not(this).next().slideUp(300);
      return false;
    });
    //이거 없어야 자동으로 맨 위에꺼 안나오길래 지워놈(의태)
//    $("div.content > div.faq > div.faq_title").eq(0).trigger("click");
    
 });

function changeImg(e){
    var im = e;
    var active = document.getElementsByClassName('active');   
    var hover = document.getElementsByClassName('hover-img');

    for (i=0; i<active.length; i++) {
        active[i].style.display='block';
    }
    for (i=0; i<hover.length; i++) {
        hover[i].style.display='none';
    }
    im.style.display = 'none';
    im.nextSibling.nextSibling.style.display ='block';
}
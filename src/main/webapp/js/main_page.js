
$(document).ready(function() {

	/* 메인 페이지 슬라이드 jquery */

	var mainurl = window.location.pathname;
	
	

	if (mainurl == '/MVC_reshop/wiz_want.do'|| mainurl == '/MVC_reshop/') {

		var slideIndex = 0;
		showSlides();

		function showSlides() {
			var i;
			var slides = document.getElementsByClassName("mainSlides");
			var dots = document.getElementsByClassName("main_dot");
			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slideIndex++;
			if (slideIndex > slides.length) {
				slideIndex = 1
			}
			for (i = 0; i < dots.length; i++) {
				dots[i].className = dots[i].className.replace(" active", "");
			}
			slides[slideIndex - 1].style.display = "block";
			dots[slideIndex - 1].className += " active";
			setTimeout(showSlides, 3500); // Change image every 2 seconds
		}
	}

});
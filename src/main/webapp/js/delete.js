/**
 * 
 */
$(document).ready(function() {
	$("#password").focus();

	
	$("#delete_user").on("click", function() {

		var delete_id = $('#id').val();
		
		
		var delete_pw = $('#password').val();


		if (delete_pw == "") {
			$('#delete_pw').text('필수입력사항입니다.');
			$('#delete_pw').css('color', 'red');
			$("#password").focus();
			return false;
		} else {
			if (confirm("정말탈퇴할거냐능!!탈퇴하면빻린이라능!!") == true) { // 확인

				return true;

			} else { // 취소
				return false;
			}

		}

	});

});
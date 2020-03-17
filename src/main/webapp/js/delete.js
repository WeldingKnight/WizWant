/**
 * 
 */
$(document).ready(function() {
	$("#password").focus();

	$("#delete_user").on("click", function() {

		var delete_id = $('#id').val();
		var login_pw = $('#login_pw').val();

		var delete_pw = $('#password').val();

		if (delete_pw == "") {
			$('#delete_pw').text('필수입력사항입니다.');
			$('#delete_pw').css('color', 'red');
			$("#password").focus();
			return false;
		} else if (login_pw != delete_pw) {
			
			$('#delete_pw').text('비밀번호가 틀렸습니다.');
			$('#delete_pw').css('color', 'red');
			$("#password").focus();
			return false;

		} else {
			if (confirm("정말 탈퇴하시겠습니까?(탈퇴하시면 판매 게시글 및 작성글이 전부 삭제됩니다!)") == true) { // 확인		
				return true;

			} else { // 취소
				return false;
			}

		}

	});

});
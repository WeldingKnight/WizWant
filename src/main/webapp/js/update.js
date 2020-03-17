/**
 * 
 */
$(document).ready(function() {
	
	$("#password").blur(function() {
		var password = $('#password').val();

		if (password == "") {
			$("#update_pw").text("비밀번호를 입력해주세요 :p");
			$("#update_pw").css("color", "red");
		} else {
			$("#update_pw").text("");
		}
	}); // $("#password").blur(function()

	$("#pwdchk").blur(function() {
		var password = $('#password').val();
		var update_pwConfirm = $('#pwdchk').val();

		if (update_pwConfirm == "") {
			$("#update_pw").text("");
		} else if (update_pwConfirm == password) {
			$("#update_pwcConfirm").text("일치합니다.");
			$("#update_pwcConfirm").css("color", "black");
		}
	}); // $("#pwdchk").blur(function()

	$("#update_input").on("click", function() {

		var update_pw = $('#password').val();
		var update_pwConfirm = $('#pwdchk').val();

		if (update_pw == "") {

			$('#update_pw').text('필수입력사항입니다.');
			$('#update_pw').css('color', 'red');
			$("#password").focus();

			return false;

		} else if (update_pwConfirm == "") {
			$('#update_pw').text('비밀번호 재확인은 필수사항입니다.');
			$('#update_pw').css('color', 'red');
			$("#password").focus();
			return false;

		} else if (update_pw != update_pwConfirm) {
			$("#update_pwcConfirm").text("비밀번호가 일치하지 않습니다.");
			$("#update_pwcConfirm").css("color", "red");
			$("#password").focus();

			return false;
		} else {
			if (confirm("이대로 가입하시겠습니까??") == true) { // 확인

				return true;

			} else { // 취소

				return false;

			}

		}

	});

});
/**
 * 
 */
$(document).ready(function() {
	$("#id").focus();

	$("#id").blur(function() { // $("#id").blur(function()
		// id = "id_reg" / name = "userId"
		var insert_id = $('#id').val();

		var idJ = /^[a-z0-9]{4,12}$/;
		$.ajax({
			url : '/MVC_reshop/insertidchk.do?insertId=' + insert_id,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : " + data);

				if (data == 1) {
					// 1 : 아이디가 중복되는 문구
					$("#insert_idchk").text("사용중인 아이디입니다 :p");
					$("#insert_idchk").css("color", "red");

				} else {

					if (idJ.test(insert_id)) {
						// 0 : 아이디 길이 / 문자열 검사
						$("#insert_idchk").text("사용가능한 아이디입니다.");
						$("#insert_idchk").css("color", "black");
					} else if (insert_id == "") {

						$('#insert_idchk').text('필수입력사항입니다.');
						$('#insert_idchk').css('color', 'red');
					} else {
						$('#insert_idchk').text("아이디는 소문자와 숫자 4~12자리만 가능합니다.");
						$('#insert_idchk').css('color', 'red');
					}
				}
			},
			error : function() {
				console.log("실패");
			}
		});
	});// $("#id").blur(function()

	$("#password").blur(function() {
		var password = $('#password').val();

		if (password == "") {
			$("#insert_pw").text("비밀번호를 입력해주세요 :p");
			$("#insert_pw").css("color", "red");
		} else {
			$("#insert_pw").text("");
		}
	}); // $("#password").blur(function()

	$("#pwdchk").blur(function() {
		var password = $('#password').val();
		var insert_pwConfirm = $('#pwdchk').val();

		if (insert_pwConfirm == "") {
			$("#insert_pw").text("");
		} else if(insert_pwConfirm==password){
			$("#insert_pwcConfirm").text("일치합니다.");
			$("#insert_pwcConfirm").css("color", "black");
		}
	}); //$("#pwdchk").blur(function() 

	
	$("#insert_input").on("click", function() {

		var insert_id = $('#id').val();
		var insert_pw = $('#password').val();
		var insert_pwConfirm = $('#pwdchk').val();

		if (insert_id == "") {
			$('#insert_idchk').text('필수입력사항입니다.');
			$('#insert_idchk').css('color', 'red');
			$("#id").focus();
			return false;

		} else if (insert_pw == "") {

			$('#insert_pw').text('필수입력사항입니다.');
			$('#insert_pw').css('color', 'red');
			$("#password").focus();

			return false;

		} else if (insert_pwConfirm == "") {
			$('#insert_pw').text('비밀번호 재확인은 필수사항입니다.');
			$('#insert_pw').css('color', 'red');
			$("#password").focus();
			return false;
			
		} else if (insert_pw != insert_pwConfirm) {
			$("#insert_pwcConfirm").text("비밀번호가 일치하지 않습니다.");
			$("#insert_pwcConfirm").css("color", "red");
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
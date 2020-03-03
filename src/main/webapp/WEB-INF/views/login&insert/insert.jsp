<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
	 <div id="insert_wrap">
    <h1 style="font-size: 80px; color: dodgerblue;" >WIZ*WANT</h1>
  
    <h1 style="font-size: 30px; color: dodgerblue;">회원가입</h1>  
        
            <form action="./JUNGO.html" id="insert_form">
                <table id="insert_table">
                    
                    <tr><td>아이디</td></tr>
                    <tr><td><input style="width:300px;height:30px;font-size:30px;" type="text" id="id" name="id" accesskey="L"  maxlength="41"></td></tr>
                    <tr><td>비밀번호</td></tr>
                    <tr><td><input style="width:300px;height:30px;font-size:30px;"type="password" id="pwd" name="pwd" accesskey="L" maxlength="41"></td></tr>
                    <tr><td>비밀번호 확인</td></tr>
                    <tr><td><input style="width:300px;height:30px;font-size:30px;"type="password" id="pwdchk" name="pwdchk" accesskey="L"  maxlength="41"></td></tr>
                    <tr><td>이름</td></tr>
                    <tr><td><input style="width:300px;height:30px;font-size:30px;"type="text" id="name" name="name" accesskey="L"  maxlength="41"></td></tr>
                    <tr><td>본인 확인 이메일</td></tr>
                    <tr><td>
                    <input style="width:300px;height:30px;font-size:30px;"type="email" id="email" name="email" accesskey="L"  maxlength="41">
                    </td></tr>
                    <tr><td>성별</td></tr>
                    <tr><td>
                    <select name="sex"style="width:300px;height:30px;font-size:20px;">
                        <option value="none">성별</option>
                        <option value="남">남</option>
                        <option value="여">여</option>
                    </select>
                    </td></tr>
                    <tr><td>생년월일</td></tr>
                    <tr><td>
                    <input style="width:90px;height:30px;font-size:20px;"type="text" id="birth_y" name="birth" accesskey="L"  maxlength="41">&nbsp;
                        <select  style="width:90px;height:30px;font-size:20px;" name="birth_m" id="birth_m">
                            <script>
                                for(i=1;i<=12;i++){
                                document.write("<option>"+i+"</option>");
                                }
                            </script>
                        </select>&nbsp;
                    <input style="width:90px;height:30px;font-size:20px;"type="text" id="birth_d" name="birth_d" accesskey="L"  maxlength="41">
                    </td></tr>
                   
                    <tr><td>주소</td></tr>
                    <tr><td><input style="width:300px;height:30px;font-size:20px;"type="text" id="adress" name="adress" accesskey="L"  maxlength="41"></td></tr>
                    </td></tr>
                    <input  style="width:300px;height:50px;font-size:20px; background-color:dodgerblue; color: white;" type="submit" title="회원가입" alt="회원가입" value="회원가입" background-color="skyblue" id="insert">
                </td></tr>
                </table>
            </form>
    </div>

</body>
</html>
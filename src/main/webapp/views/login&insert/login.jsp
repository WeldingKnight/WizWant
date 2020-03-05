<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/login.css">
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>  
    <div id="login_wrap">
    <h1 style="font-size: 80px; color: dodgerblue;" >WIZ*WANT</h1>
  
    <h1 style="font-size: 50px; color: dodgerblue;">로그인<h1>  
        
            <form action="wiz_want.do" id="login_form">
                <table >
                    <br> 
                    <input style="width:300px;height:50px;font-size:30px;" type="text" id="id" name="id" accesskey="L" placeholder="아이디"  maxlength="41"><br/><br/>
                  
                    <input style="width:300px;height:50px;font-size:30px;"type="password" id="pwd" name="pwd" accesskey="L" placeholder="비밀번호" maxlength="41"><br/><br/>
                
                    <input  style="width:300px;height:50px;font-size:30px; background-color:dodgerblue; color: white;" type="submit" title="로그인" alt="로그인" value="로그인" background-color="skyblue" id="log.login"><br/>
            
                </table>
            </form>
    </div>
</body>
</html>
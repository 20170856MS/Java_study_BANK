<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join Page</h1>>
	<hr>
    <div>
   	 <form action="./join" method="post">
   		 <div class = "container">
       		아이디 <input type="text" name ="username" > <br>
   	    	비밀번호 <input type="password" name = "password" > <br>
       		이름 <input type="text" name = "name"> <br>
       		이메일 <input type="email" name = "email"> <br>
       		휴대폰번호 <input type = "text" name="phone"><br>
       		<input type="submit" value="등록">
        	<input type="reset" value="초기화">
       	 </div>
   	 </form>
    </div>
    <a href="../index.html">index</a>
    
</body>
</html>
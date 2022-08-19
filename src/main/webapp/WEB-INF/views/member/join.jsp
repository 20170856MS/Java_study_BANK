<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>Join Page</h1>>
	<hr>
    <div>
   	 <form action="join.iu" method="post">
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
    
    <c:import url="../template/footer.jsp"></c:import>
	
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
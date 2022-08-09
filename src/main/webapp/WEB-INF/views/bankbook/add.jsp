<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Page</h1>
	<hr>
	<div>
		<form action="./add" method = "post">
			책번호<input type="number" value ="booknum"><hr>
			책이름<input type="text" value ="bookname"><hr>
			<input type="submit" value="등록">
        	<input type="reset" value="초기화">
		</form>
	</div>
</body>
</html>
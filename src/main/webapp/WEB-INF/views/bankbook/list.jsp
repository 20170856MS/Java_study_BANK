<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	//스크립틀릿 <%사이에 java code 작성
	//HTML표현식 <%= 자바변수 또는 값

--%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<a href="../">index</a>
	<!-- /bankbook/list -->
	
	<!-- /bankbook/detail jsp : detail.jsp  link주소는 상대경로 -->
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var ="dto">
				<tr>
					<td><a href = "./detail.iu?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
					<td>${dto.bookRate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="./add.iu">상품 등록</a>
</body>
</html>
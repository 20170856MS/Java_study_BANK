<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 	
	//요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope
	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("DTO"); 
--%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail</h1>
	
	<!-- 상대경로 -->
	<a href="../member/login.iu">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join.iu">Join</a>
	<a href="./list.iu">리스트보기</a>
	
	<table border="1">
		<tr>
			<th>Num</th>
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
		</tr>
		<tr>
			<td>${requestScope.bankBookDTO.getBookName()}</td>
			<td>${requestScope.bankBookDTO.bookName}</td>
			<td>${bankBookDTO.bookRate}</td> <%--requesteScope.dto.getBookRate --%>
			<td>${bankBookDTO.bookSale}</td>
		</tr>
	</table>
	<a href="./update.iu?bookNum=${bankBookDTO.bookNum}">수정</a>
	<a href="./delete.iu?bookNum=${bankBookDTO.bookNum}">삭제</a>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="../bankAccount/add.iu?bookNum=${bankBookDTO.bookNum}">가입하기</a>
	</c:if>
	
</body>
</html>
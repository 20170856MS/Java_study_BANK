<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("DTO"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail</h1>
	
	<!-- 상대경로 -->
	<a href="../member/login">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join">Join</a>
	
	<% if(bankBookDTO != null){ %>
	<table border="1">
		<thead>
			<tr>
				<th>Num</th><th>Name</th><th>Rate</th><th>Sale</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%= bankBookDTO.getBookNum() %></td>
				<td><%= bankBookDTO.getBookName() %></td>
				<td><%= bankBookDTO.getBookRate() %></td>
				<td><% if(bankBookDTO.getBookSale()==1){ %>
						판매중
					<%}else if(bankBookDTO.getBookSale()==0){ %>
						판매금지
					<%} %>
				</td>
			</tr>
		</tbody>
	</table>
	<%}else{ %>
		<h3>데이터 없음</h3>
	<%} %>
</body>
</html>
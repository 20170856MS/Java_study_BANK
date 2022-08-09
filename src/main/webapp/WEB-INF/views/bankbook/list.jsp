<%@page import="com.iu.start.bankBook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//스크립틀릿 <%사이에 java code 작성
	//HTML표현식 <%= 자바변수 또는 값
	ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	
	<!-- /bankbook/detail jsp : detail.jsp  link주소는 상대경로 -->
	
	<table border="1">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th>
			</tr>
		</thead>
		<tbody>
			<% for(BankBookDTO bankBookDTO : ar){ %>
				<tr>
				
					<td><a href = "./detail?bookNum=<%= bankBookDTO.getBookNum()%>"><%= bankBookDTO.getBookName() %></a></td>
					<td><%= bankBookDTO.getBookRate() %></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	
	<a href="./detail">BankBook Detail</a>
</body>
</html>
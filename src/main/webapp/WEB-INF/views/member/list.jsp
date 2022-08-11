<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Member List Page</h1>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>				
				<th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach begin="0" end="10" var="i" step="2">
				<h3>${i}</h3>
			</c:forEach>
			
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${pageScope.dto.UserName}</td>
				<td>${pageScope.dto.name}</td>
				<td>${pageScope.dto.email}</td>
				<td>${pageScope.dto.phone}</td>
			</tr>
			
			</c:forEach>
			<!-- for(int i=0;i<10;i+2) 음수X-->
			
			<%-- <% for(BankMembersDTO bankMembersDTO:ar){ %>
			<tr>
				<td><%= bankMembersDTO.getUsername() %> </td>
				<td><%= bankMembersDTO.getName() %> </td>
				<td><%= bankMembersDTO.getEmail() %> </td>
				<td><%= bankMembersDTO.getPhone() %> </td>
			</tr>
			<%} %> --%>
		</tbody>
	</table>
</body>
</html>
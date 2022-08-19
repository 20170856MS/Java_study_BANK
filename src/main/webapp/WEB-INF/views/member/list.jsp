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
	<h1>Member List Page</h1>

	<table class = "table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>				
				<th scope="col">Phone</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${pageScope.dto.username}</td>
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
	
	<c:import url="../template/footer.jsp"></c:import>
	
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Update Page</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>Num</th>
				<th>Name</th>
				<th>Rate</th>
				<th>Sale</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.bankBookDTO.getBookNum()}</td>
				<td>${requestScope.bankBookDTO.bookName}</td>
				<td>${bankBookDTO.bookRate}</td>
				<td>${bankBookDTO.bookSale }
						<!-- 판매중
						판매금지 -->
				</td>
			</tr>
		</tbody>
	</table>
	
	<form action="/bankbook/update" method=post>
	
		<input type="hidden" name="bookNum" readonly="readonly" value="${bankBookDTO.bookNum}}">
		<div>
			Name : <input type="text" name="bookName" value=${bankBookDTO.bookName}>
		</div>
		<div>
			Rate : <input type="text" name="bookRate" value=${bankBookDTO.bookRate}>
		</div>
		<input type="submit" value="수정">
		<button type="submit">수정</button>
		
	</form>
</body>
</html>
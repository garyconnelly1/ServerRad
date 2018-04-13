<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Show shipping companies</title>
</head>
<body>
	<h1>Companies</h1>
	
	<h1></h1>
		<table>
			<tr>
				<th>Name</th>
				<th>Home Post</th>
				<th>Cost</th>
				<th>Ships</th>
			</tr>
			<c:forEach items="${companies}" var="companies">
				<tr>
					<td>${companies.name}</td>
					<td>${companies.homePort}</td>
					<td>${companies.balance}</td>
					<td>${companies.ships}</td>
				</tr>
			</c:forEach>
		</table>
		
	<a href="/">Home</a>
</body>
</html>
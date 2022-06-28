<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https:code.jquery.com/jquery-3.6.0.js">
</script>
<script
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script>
$(document).ready( function () { $('#empab').DataTable(); } );
</script>
</head>
<body>
	<H3>View All Employees</H3>
	<a href="loadForm">Add new Employee</a>
	<table border="2" id="empab">
		<thead>
			<tr>
				<th>Employee Number</th>
				<th>Employee Name</th>
				<th>Employee Address</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employees}" var="e">
				<tr>
					<td>${e.eno}</td>
					<td>${e.ename}</td>
					<td>${e.eadd}</td>
					<td><a href="editemp?id=${e.eno}">Edit</a></td>
					<td><a href="deleteemp?id=${e.eno}" onclick="deleteConfirm()">Delete</a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>
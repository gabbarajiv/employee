<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Message: ${msg}
	<form:form action="empInsert" modelAttribute="emp" method="post">
		<table>
			<tr>
				<td>EName :</td>
				<td><form:input path="ename" /></td>
			</tr>
			<tr>
				<td>EAddress :</td>
				<td><form:input path="eadd" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Insert"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form:form>
	<a href="viewEmployees">ViewAllRecords</a>
</body>
</html>
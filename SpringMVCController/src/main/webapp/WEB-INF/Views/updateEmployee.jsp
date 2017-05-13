<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateEmployee</title>
</head>
<body>
	<h1>Update the Employee Information</h1>
	<form:form action="/EmployeeSpringMVc/updateEmployee"
		commandName="employee" method="POST">
		<table>
			<tr>
				<th id="firstName">First Name</th>
				<th id="lastName">Last Name</th>
				<th id="salary">Salary</th>
			</tr>
			<tr>

				<td><form:input path="firstName" value="${employee.firstName}" /></td>
				<td><form:input path="LastName" value="${ employee.lastName}" /></td>
				<td><form:input path="salary" value="${employee.salary}" /></td>

				<td><form:input path="id" value="${employee.id}" hidden="true" />
					<input type="submit" formaction="/EmployeeSpringMVc/updateEmployee"
					value=update method="post"></td>
			</tr>
		</table>
	<a href="/EmployeeSpringMVc/index.jsp"><input type="button" class="btnCreate" value="Home"/></a>
	</form:form>

	<h2>${message}</h2>
</body>
</html>
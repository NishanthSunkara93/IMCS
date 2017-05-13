<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Employee</title>
</head>
<body>
	<h1>Delete the Specified Employee Information</h1>
	<form:form action="/EmployeeSpringMVc/updateEmployee"
		commandName="employee" method="POST">

		<p>
			<label>Employee Id</label>
		</p>
		<form:input path="id" />
		<input type="submit"
			formaction="/EmployeeSpringMVc/deleteEmployee" class="btnCreate"
			name="submit" id="submit" tabindex="2" value="Delete">

		<a href="/EmployeeSpringMVc/index.jsp"><input type="button"
			class="btnCreate" value="Home" /></a>
	</form:form>
	<h2>${message}</h2>
</body>
</html>
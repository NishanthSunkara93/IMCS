<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Update and Deletion</title>
</head>
<body>

	<!-- VIEW ALL OPERATION -->
	<form
		action='<%= request.getContextPath() %>/EmployeeUpdateAndDelete?action=viewall'
		method="post">
		<h1>Click here to view all employee details</h1>
		<button>ViewAll</button>
		<br> <br>

		<div align="center">
			<table border="1" cellpadding="5">
				<caption>
					<h3>List of users</h3>
				</caption>
				<tr>
					<th>Id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Salary</th>
					<th>Address</th>
				</tr>
				<c:forEach var="results" items="${displayResults}">
					<tr>
						<td><c:out value="${results.id}" /></td>
						<td><c:out value="${results.firstName}" /></td>
						<td><c:out value="${results.lastName}" /></td>
						<td><c:out value="${results.salary}" /></td>
						<td><c:out value="${results.address}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	<!-- VIEW ALL OPERATION -->

	<!-- DELETE OPERATION -->
	<form
		action='<%= request.getContextPath() %>/EmployeeUpdateAndDelete?action=delete'
		method="post">

		<h1>ENTER WHICH EMPLOYEE ENTRY TO BE DELETED</h1>
		Enter EmployeeID: <input name="employeeID" type="text" />
		<button>Delete</button>
	</form>

	<c:if test="${requestScope.deleted eq true}">
		<h5>Deleted Successfully</h5>
	</c:if>
	<!-- DELETE OPERATION -->

	<!-- UPDATE OPERATION -->

	<h4>ENTER EMPLOYEE ID TO UPDATE</h4>
	<form action="/EmployeeWebApp/EmployeeUpdateAndDelete?action=search"
		method="post">


		<input type="text" name="employeeId">
		<button>Update</button>

	</form>



	<c:if test="${requestScope.employee ne null}">
		<form
			action='<%=request.getContextPath()%>/EmployeeUpdateAndDelete?action=update'
			id="resultData" method="post">
			<table>
				<tr>
					<th id="firstName">First Name</th>
					<th id="lastName">Last Name</th>
					<th id="salary">Salary</th>
					<th id="address">Address</th>
					<th>Gender</th>
				</tr>
				<tr>

					<td><input type="text"
						value='${requestScope.employee.firstName}' name="firstName"></td>
					<td><input type="text"
						value='${requestScope.employee.lastName}' name="lastName"></td>
					<td><input type="text" value='${requestScope.employee.salary}'
						name="salary" /></td>
					<td><input type="text"
						value='${requestScope.employee.address}' name="address"></td>
					<td><input type="text" value='${requestScope.employee.gender}'
						readonly></td>
					<td><input type='hidden' name='employeeId'
						value='${requestScope.employee.id}' /> <input type="submit"
						value="update" /></td>
				</tr>
			</table>

		</form>
	</c:if>

	<c:if test="${requestScope.updated eq true}">
		<h5 id="update">Updated Successfully</h5>
	</c:if>

	<!-- UPDATE OPERATION -->

</body>
</html>
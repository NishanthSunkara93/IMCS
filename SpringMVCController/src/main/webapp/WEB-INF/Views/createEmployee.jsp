<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<title>EMPLOYEE CREATION</title>
</head>
<body>
<form:form  action="/EmployeeSpringMVc/createEmployee" commandName="employee" method="POST">
		<h1>Enter the employee details</h1>
	<fieldset class="boxBody">
		<div>
			<p>
				<spring:message code="employee.empFirstName.lbl"/>
			</p>
			<form:input path="firstName" />
			<form:errors path="firstName" cssClass="error" />
			<p>
				<spring:message code="employee.empLastName.lbl"/>
			</p>
			<form:input path="LastName" />
	    	<form:errors path="LastName" cssClass="error" />
			<p>
				<spring:message code="employee.empSalary.lbl"/>
			</p>
			<form:input path="salary" />
	    	<form:errors path="salary" cssClass="error" />
			
		</div>
				<input type="submit" class="btnCreate" name="submit" id="submit" tabindex="8"
				value="Create"> 
				<input type="reset" class="btnCreate" name="reset" id="reset" tabindex="9" value="Reset">

		</fieldset>
	<a href="/EmployeeSpringMVc/index.jsp"><input type="button" class="btnCreate" value="Home"/></a>
	</form:form>
</body>
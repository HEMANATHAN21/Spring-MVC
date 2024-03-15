<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="update" modelAttribute="employee">
		<label> Id </label>
		<form:input path="empId"/>
		<br>
		<label> Name </label>
		<form:input path="empName"/>
		<br>
		<label> Contact </label>
		<form:input path="empContact"/>
		<br>
		<label> Email </label>
		<form:input path="empEmail"/>
		<br>
		<label> Password </label>
		<form:input path="empPassword"/>
		<br>
		<label> City </label>
		<form:input path="empCity"/>
		<br>
		<label> Salary </label>
		<form:input path="empSalary"/>
		<br>
		<input type="submit">
	</form:form>
</body>
</html>
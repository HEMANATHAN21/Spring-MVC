<%@page import="employeemvc.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h1>Home</h1>
    <c:out value="${message}"/> 
    
    <table border="1">
    	<tr>
    		<th>Id</th>
    		<th>Name</th>
    		<th>Contact</th>
    		<th>Email</th>
    		<th>City</th>
    		<th>Salary</th>
    		<th>Edit</th>
    		<th>Delete</th>
    	</tr>
    	
    	<c:forEach var="emp" items="${empList}">  
  			<tr>
  				<td>${emp.empId}</td>
  				<td>${emp.empName}</td>
  				<td>${emp.empContact}</td>
  				<td>${emp.empEmail}</td>
  				<td>${emp.empCity}</td>
  				<td>${emp.empSalary}</td>
  				<td><a href="edit?empId=${emp.empId}">Edit</a></td>
  				<td><a href="delete?empId=${emp.empId}">Delete</a></td>
  			</tr>
		</c:forEach>
    	
    </table>
</body>
</html>
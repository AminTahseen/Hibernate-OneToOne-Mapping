<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Hibernate One to One Mapping CRUD</h3>
<br/>
<a href="create">Create New</a>

<table>
<thead>
<tr>
<th>Student ID</th>
<th>Student Name</th>
<th>Student Grade</th>
<th>Actions</th>
</tr>
</thead>

<c:forEach var="s" items="${list}">
<tbody>
<tr>
<td>${s.sid}</td>
<td>${s.sname}</td>
<td>${s.grade}</td>
<td>
<form action="edit">
<input type="hidden" value="${s.sid}" name="id"> 
<input type="submit" value="edit"> 
</form>
</td>

<td>
<form action="delete">
<input type="hidden" value="${s.sid}" name="sid"> 
<input type="hidden" value="${s.grade}" name="sgrade"> 
<input type="submit" value="delete"> 
</form>
</td>

</tr>
</tbody>

</c:forEach>

</table>
</body>


</html>
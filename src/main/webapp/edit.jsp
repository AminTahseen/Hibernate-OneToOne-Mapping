<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Edit Data</h3>
<br/>
<form action="update" method="post"> 

<table>
<tr>
<td>Student ID :</td>
<td><input type="text" name="sid" readonly="readonly" value="${sid}"></td>
</tr>
<tr>
<td>Student Name :</td>
<td><input type="text" name="sname" value="${sname}"></td>
</tr>
<tr>
<td>Student Grade :</td>
<td>
<select name="sgrade" >
  <option value="${sgrade}">${sgrade}</option>
  <option value="A+">A+</option>
  <option value="A-">A-</option>
  <option value="A">A</option>
  
  <option value="B+">B+</option>
  <option value="B-">B-</option>
  <option value="B">B</option>
  
  <option value="C+">C+</option>
  <option value="C-">C-</option>
  <option value="C">C</option>
  
  <option value="D+">D+</option>
  <option value="D-">D-</option>
  <option value="D">D</option>
  
  <option value="F">F</option>
  
</select>
</td>
</tr>
<tr>
<td><input type="submit" value="Edit"></td>
</tr>
</table>

</form>

</body>
</html>
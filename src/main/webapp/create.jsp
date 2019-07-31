<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Create New</h3>
<br/>
<form action="save" method="post"> 

<table>
<tr>
<td>Student Name :</td>
<td><input type="text" name="sname"></td>
</tr>
<tr>
<td>Student Grade :</td>
<td>
<select name="sgrade">
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
<td><input type="submit" value="Save"></td>
</tr>
</table>

</form>

</body>
</html>
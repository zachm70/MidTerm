<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Pets</title>
<style>
<!--https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro-->
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<form method = "post" action = "petNavigationServlet">
<table>
<tr>
<th>Select</th>
<th>ID</th>
<th>Name</th>
<th>Birthday</th>
<th>Breed</th>
<th>Avg Life Span</th>
<th>Healthy Weight</th>
</tr>
<c:forEach items="${requestScope.allDogs}" var="currentitem">
	<tr>
 		<td><input type="radio" name="petId" value="${currentitem.id}"></td>
 		<td>${currentitem.id} &nbsp;  </td>
 		<td>${currentitem.name}</td>
 		<td>${currentitem.birthday}</td>
 		<td>${currentitem.breed.breed}</td>
		<td>${currentitem.breed.avgAge}</td>
		<td>${currentitem.breed.healthyWeight}</td>
 	</tr>
</c:forEach>
</table>

<input type = "submit" value = "edit" name="doThisToPet">
<input type = "submit" value = "delete" name="doThisToPet">
<input type="submit" value = "add" name = "doThisToPet">
</form>
<a href="index.html"> Add new Breed</a>
</body>
</html>
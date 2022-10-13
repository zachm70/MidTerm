<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Show All Species</title>
</head>
<body>

<form method = "post" action = "SpeciesNavigationServlet">
<table>
<tr>
<th>Select</th>
<th>ID</th>
<th>Breed</th>
<th>Avg Lifespan</th>
<th>Healthy Weight</th>
</tr>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
 <td><input type="radio" name="pkid" value="${currentitem.PKID}"></td>
 <td>${currentitem.PKID} &nbsp;  </td>
 <td>${currentitem.breed}</td>
 <td>${currentitem.avgAge}</td>
 <td>${currentitem.healthyWeight}</td>
 </tr>
</c:forEach>
</table>

<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>

</body>
</html>
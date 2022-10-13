<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Species Screen</title>
</head>
<body>

<form action = "editSpeciesServlet" method="post">
Breed: <input type = "text" name = "breed" value= "${itemToEdit.breed}">
<br><br>
Average Age: <input type = "text" name = "avgAge" value= "${itemToEdit.avgAge}">
<br><br>
Healthy Weight: <input type = "text" name = "weight" value= "${itemToEdit.healthyWeight}">
<br><br>
<input type = "hidden" name = "pkid" value="${itemToEdit.PKID}">
<input type = "submit" value="Save">
</form>

</body>
</html>
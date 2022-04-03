<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>

<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<h4><a href="meals?action=create&mealId=<c:out value="${meal.id}"/>">Add meal</a></h4>
<table border="1">
    <tr>
        <th width="160">Date</th>
        <th width="300">Description</th>
        <th width="100">Calories</th>
        <th width="60"></th>
        <th width="60"></th>
    </tr>

    <c:forEach var="meal" items="${meals}">
        <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealTo"/>
        <tr style="color: <c:out value="${meal.excess ? 'red' : 'green'}" />">
            <td>${f:formatLocalDateTime(meal.dateTime, 'dd-MM-yyyy HH:mm')}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="meals?action=update&mealId=<c:out value="${meal.id}"/>">Update</a></td>
            <td><a href="meals?action=delete&mealId=<c:out value="${meal.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

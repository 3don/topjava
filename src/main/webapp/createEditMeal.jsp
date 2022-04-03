<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${action} meal</title>
</head>
<body>
    <h3><a href="index.html">Home</a></h3>
    <hr>
    <h2>${action} meal</h2>
    <form method="post" action="meals">
        <input type="hidden" name="id" value="${meal.id}">

        <label style="column-width:200px">DateTime:</label>
        <input type="datetime-local"  name="date_time" value="${meal.dateTime}" />
        <br>
        <label style="column-width:200px">Description</label>
        <input type="text" name="description" value="${meal.description}">
        <br>
        <label style="column-width:200px">Calories</label>
        <input type="number" name="calories" value="${meal.calories}">
        <br>
        <input type="submit" value="Save"/>
        <input type="button" value="Cancel" onclick="history.back()">
    </form>

</body>
</html>

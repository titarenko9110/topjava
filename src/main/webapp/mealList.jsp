<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>UserMeals</title>
</head>
<body>
<h2>UserMeal</h2>

<c:forEach items="${mealList}" var="item">
    ${item}<br>
</c:forEach>
</body>
</html>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.javawebinar.topjava.model.UserMealWithExceed" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>UserMeals</title>
</head>
<body>
<h2>UserMeal</h2>
<table border="1"><tr><th>DATE</th><th>DESCRIPTION</th><th>CALORIES</th></tr>
<%

    ArrayList<UserMealWithExceed> mealList =(ArrayList<UserMealWithExceed>) request.getAttribute("mealList");
    for(UserMealWithExceed userMeal : mealList){
        LocalDateTime l = userMeal.getDateTime();
        String s = userMeal.getDescription();
        Integer i = userMeal.getCalories();

        out.print("<tr style=\"color: " + (userMeal.isExceed() ? "red" : "green") +"\"><td>"+l+"</td><td>"+s+"</td><td>"+i+"</td></tr>");
    }

%>

</table>
<%--<c:forEach items="${mealList}" var="item">--%>
    <%--&lt;%&ndash;${item}<br>&ndash;%&gt;--%>
    <%--<tr>--%>
        <%--<td>datetame: <c:out value="${item.dateTime}"/></td>--%>
        <%--<td>description: <c:out value="${item.description}"/></td>--%>
    <%--</tr>--%>
<%--</c:forEach>--%>
</body>
</html>
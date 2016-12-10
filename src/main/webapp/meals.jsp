<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>

<jsp:useBean id="mealList" scope="request" type="java.util.List"/>
<c:if test="${!empty mealList}">
    <table width="400 px" border="1px">
        <tr>
            <th width="10%"><strong>ID</strong></th>
            <th width="30%"><strong>dateTime</strong></th>
            <th width="30%"><strong>description</strong></th>
            <th width="30%"><strong>calories</strong></th>
        </tr>
        <c:forEach items="${mealList}" var="MealWithExceed">
            <tr <c:if test="${MealWithExceed.exceed == true}">style="background: red"</c:if>
                <c:if test="${MealWithExceed.exceed == false}">style="background: green"</c:if>
            >
                <td width="10%">${MealWithExceed.id}</td>
                <td width="30%">${MealWithExceed.dateTime.toLocalDate()} ${MealWithExceed.dateTime.toLocalTime()}</td>
                <td width="30%">${MealWithExceed.description}</td>
                <td width="30%">${MealWithExceed.calories}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

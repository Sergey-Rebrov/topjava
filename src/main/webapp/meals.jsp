<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>

<jsp:useBean id="mealList" scope="request" type="java.util.List"/>

<h2>Add Meal</h2>

<form action="meals" method="post">
    <table>
        <%--@elvariable id="meal" type="ru.javawebinar.topjava.model.Meal"--%>
        <c:if test="${meal != null}">
            <tr>
                <td>
                    <strong>ID</strong>
                </td>
                <td>
                    <input name="id" type="text" value="${meal.id}" readonly="true"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <strong>dateTime</strong>
            </td>
            <td>
                <input name="dateTime" type="datetime-local" value="${meal.dateTime}"/>
            </td>
        </tr>
        <tr>
            <td>
                <strong>description</strong>
            </td>
            <td>
                <input name="description" type="text" value="${meal.description}"/>
            </td>
        </tr>
        <tr>
            <td>
                <strong>calories</strong>
            </td>
            <td>
                <input name="calories" type="number" value="${meal.calories}"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td colspan="2">
                <c:if test="${meal != null}">
                    <input class="form" type="submit"
                           value="Edit Meal" />
                </c:if>
                <c:if test="${meal.id == null}">
                    <input class="form" type="submit"
                           value="Add Meal"/>
               </c:if>
            </td>
        </tr>
    </table>
</form>

<h2>Meal List</h2>


<c:if test="${!empty mealList}">
    <table width="420 px" border="1px">
        <tr>
            <th width="5%"><strong>ID</strong></th>
            <th width="30%"><strong>dateTime</strong></th>
            <th width="30%"><strong>description</strong></th>
            <th width="25%"><strong>calories</strong></th>
            <th width="5%"><strong>Edit</strong></th>
            <th width="5%"><strong>Delete</strong></th>
        </tr>
        <c:forEach items="${mealList}" var="MealWithExceed">
            <tr
                    <c:if test="${MealWithExceed.exceed == true}">style="background: red"</c:if>
                    <c:if test="${MealWithExceed.exceed == false}">style="background: green"</c:if>
            >
                <td width="10%">${MealWithExceed.id}</td>
                <td width="30%">${MealWithExceed.dateTime.toLocalDate()} ${MealWithExceed.dateTime.toLocalTime()}</td>
                <td width="30%">${MealWithExceed.description}</td>
                <td width="25%">${MealWithExceed.calories}</td>
                <td width="5%"><a href="<c:url value="?edit=${MealWithExceed.id}"/>">Edit</a></td>
                <td width="5%"><a href="<c:url value="?remove=${MealWithExceed.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

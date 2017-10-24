<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<spring:url value="/resources/css/style.css" var = "css"/>
<spring:url value="/resources/css/bootstrap.css" var = "bootstrap"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href=${css} rel="stylesheet" />
        <link href=${bootstrap} rel="stylesheet />
        <title>Home</title>
    </head>
    <body>
    <form:form method="POST" commandName="pidor" action="add-user">
        <fieldset>
            <form:label path="username">username:</form:label>
            <form:input path="username"/>
            <form:label path="password">password:</form:label>
            <form:input path="password"/>
            <form:label path="role">role:</form:label>
            <form:input path="role"/>
            <input type="submit" value="Подтведить">
        </fieldset>
    </form:form>
        <h1>Юзвери</h1>
    <table class="table table-bordered">\
        <tr>
            <td>ID</td>
            <td>username</td>
            <td>password</td>
            <td>ROLE</td>
            <td>Action</td>
        </tr>
        <c:if test="${!empty users}">
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.role}</td>
                    <td><a href="/delete/${user.id}">delete user</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    </body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dodaj trenera</title>
    <link href="<c:url value="http://localhost:8080/main.css"/>" rel="stylesheet" type="text/css">
</head>
<body style="background-color: #168bb2">
<h1 style="color: white; text-shadow: black 0.1em 0.1em 0.2em">Podaj dane trenera</h1>
<form:form cssStyle="zoom: 1.5;color: white" method="post" modelAttribute="trainer">
    Imię</br>
    <form:input path="name"/></br>
    <form:errors path="name" cssStyle="color: red"/></br>
    Nazwisko</br>
    <form:input path="surname"/></br>
    <form:errors path="surname" cssStyle="color: red"/></br>
    Opis</br>
    <form:select path="descryption">
        <form:options items="${descryptions}"/>
    </form:select></br>
    </p>
    <input style="border-radius: 3px" type="submit" value="WYŚLIJ">
</form:form>

</body>
</html>
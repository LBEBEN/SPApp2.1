<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj karnet</title>
</head>
<body style="background-color: #168bb2">
<h1 style="color: white; text-shadow: black 0.1em 0.1em 0.2em">Rodzaj karnetu</h1>
<form:form cssStyle="zoom: 1.5" method="post" modelAttribute="bucklet">
    Nazwa</br>
    <form:input path="name"/></br>
    <form:errors path="name" cssStyle="color: #f30909"/></br>
    Cena</br>
    <form:input path="price"/></br>
    <form:errors path="price" cssStyle="color: #f30909"/></br>
    Ważność karnetu (w dniach)</br>
    <form:input path="validity" /></br>
    <form:errors path="validity" cssStyle="color: #f30909"/></br>
    Ilość wejść</br>
    <form:input path="numberOfVisits" /></br>
    <form:errors path="numberOfVisits" cssStyle="color: #f30909"/>
    </p>
    <input type="submit" value="WYŚLIJ">
</form:form>
</body>
</html>
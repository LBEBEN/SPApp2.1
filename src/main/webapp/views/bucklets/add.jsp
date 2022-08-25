<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj karnet</title>
</head>
<body bgcolor="#778899">
<h2>Dodaj nowy rodzaj karnetu</h2>
<form:form method="post" modelAttribute="bucklet">
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
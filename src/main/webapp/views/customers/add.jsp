<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nowy klient</title>
</head>
<body bgcolor="#6495ed">
<h2>Dodaj nowego klienta</h2>
<form:form method="post" modelAttribute="customer">
<div style="display:flex">
    <div style="alignment: left">Imię</br> <form:input path="name"/></br>
        <form:errors path="name" cssStyle="color: #f30909" />
    </div>
    <div style="margin: 0 30px"> Nazwisko</br><form:input path="surname"/></br><form:errors path="surname" cssStyle="color: #f30909" /></div>
</div>
</p>
<div style="display:flex">
    <div style="alignment: left"> Email</br><form:input path="email"/></br><form:errors path="email" cssStyle="color: #f30909"/></div>
    <div style="margin: 0 30px"> Numer telefonu</br><form:input path="phoneNumber"/></div>
</div>
</p>
<div style="display:flex">
    <div style="alignment: left">Numer karnetu</br><form:input path="cartNumber"/></br><form:errors path="cartNumber" cssStyle="color: #f30909"/></div>
    <div style="margin: 0 30px">Typ karnetu</br><form:select path="bucklet" id="karnet">
        <form:option value="0" label="--- wybierz ---"/>
        <form:options items="${bucklets}" itemLabel="name" itemValue="buckletId"/>
    </form:select><br>
        <form:errors path="bucklet" cssClass="ui-state-error-text" cssStyle="color: red"/>
    </div>
    <div style="margin: 0 15px">Od kiedy</br><form:input path="purchaseDate" placeholder = "dd-MM-yyyy"/></br><form:errors path="purchaseDate" cssStyle="color: #f30909"/></div>
</div>
</p>
Wpłacono depozyt
    <form:checkbox path="cartDeposit"/></br>
<p></p>
Trener</br>
<form:select path="trainer">
    <form:option value="0" label="--- wybierz ---"/>
    <form:options items="${trainers}" itemLabel="displayName" itemValue="trainerId"/>
</form:select>
<p></p>
Uwagi</br>
    <form:textarea path="comment"/></br>
<p>
        <form:errors path="*" />
    <input type="submit" value="AKCEPTUJ" style="border-bottom-style: solid"/>
    </form:form>
</body>
</html>
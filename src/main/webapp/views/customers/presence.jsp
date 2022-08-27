<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Obecność</title>
</head>
<body>
<div class="flex1">
<h1 style="color: white; text-shadow: black 0.1em 0.1em 0.2em">Wpisz numer karnetu</h1>
    <p></p>
<form  method="post" >
    <input style=" border-radius: 6px; font-size: 18px; margin: 0 10% " name="cartNumber" type="text" id="cartNumber" onchange="this.form.submit()" autofocus>
    <br></br>
    <input style=" border-radius: 2px; font-size: 14px; margin: 0 37%" type="submit" value="WYŚLIJ">
</form>
</div>
    <p></p>
<div class="flex2">
<c:choose>
    <c:when test="${info == '1'}"><h3 style="color: white; text-shadow: black 0.1em 0.1em 0.2em"> Zaakceptowano użytkownika </h3> </c:when>
    <c:when test="${info == '0'}"><h2 style="color: red; text-shadow: black 0.1em 0.1em 0.2em"> Nie ma takiego klienta lub karnet stracił ważność</h2> </c:when>
</c:choose>
</div>
</body>
<style>
    body {
        background-color: black;
        background-image: url('http://localhost:8080/logo.png');
        background-repeat: no-repeat;
        height: 90%;
        width: 90%;
        background-position: center;
        background-size: contain;

    }
    .flex1{
        width: 300px;
        height: 50px;
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        margin: auto;
    }
</style>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Obecność</title>
</head>
<body>
<h3>Wpisz numer karnetu</h3>
<form  method="post">
    <label>
        <input name="cartNumber" type="text" id="cartNumber" onchange="this.form.submit()" autofocus>
    </label>
    <input type="submit" value="WYŚLIJ">
</form>
<p></p>
<c:choose>
    <c:when test="${info == '1'}"> Zaakceptowano uzytkownika </c:when>
    <c:when test="${info == '0'}"><h2 style="color: red"> Nie ma takiego klienta lub karnet stracił ważność</h2> </c:when>
</c:choose>

</body>
</html>
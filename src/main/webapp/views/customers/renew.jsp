<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="http://localhost:8080/main.css"/>" rel="stylesheet" type="text/css">
    <title>Odnów karnet</title>
</head>
<body style="background-color: #168bb2">
<h1 style="display: flex">Odnów karnet dla <div style="color: white; margin: 0 10px;text-shadow: black 0.1em 0.1em 0.2em">${customer.name} ${customer.surname}</div></h1>

<form style="zoom: 1.5" method="post">
    <label>
        <input type="number" name="clientId" value="${customer.clientId}" hidden>
    </label>
     Ustaw typ karnetu :
    <select name="buckletType">
        <option value="${customer.bucklet.buckletId}">${customer.bucklet.name}</option>
        <c:forEach var="b" items="${bucklets}" >
            <option value="${b.buckletId}">${b.name}</option>
        </c:forEach>
    </select>
    Ustaw date
    <input type="date" name="date" value="${newDateSet}">

    <input style="border-radius: 3px" type="submit" value="ODNÓW">

</form>
</body>
</html>
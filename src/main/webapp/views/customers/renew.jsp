<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Odnów karnet</title>
</head>
<body bgcolor="#6495ed">
<h3 style="display: flex">Odnów karnet dla <div style="color: white; margin: 0 10px">${name} ${surname}</div></h3>

<form method="post">
    <label>
        <input type="number" name="clientId" value="${clientId}" hidden>
    </label>
    Ustaw typ karnetu :
    <select name="buckletType">
        <c:forEach var="b" items="${bucklets}">
            <option value="${b.buckletId}">${b.name}</option>
        </c:forEach>
    </select>
    Ustaw date
    <input type="date" name="date">

    <input type="submit" value="WYŚLIJ">

</form>
</body>
</html>
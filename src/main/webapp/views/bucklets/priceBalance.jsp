<%--
  Created by IntelliJ IDEA.
  User: ben10
  Date: 17.09.2022
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="http://localhost:8080/main.css"/>" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
    <title>Bilans karnetów</title>
</head>
<body>
<c:set var="priceTotal" value="${0}"/>
<c:forEach var="priceMap" items="${priceBalance}">
    <c:set var="priceTotal" value="${priceTotal +(priceMap.key*priceMap.value)}"/>
</c:forEach>
<p>
<h1 style="color: white; text-shadow: black 0.1em 0.1em 0.2em">Bilans karnetów</h1>
<div style="width: 100%">
    <table style="border: 1px solid " id = "price_table" class="display">
        <thead>
        <tr style="color: white">
            <th>L.p.</th>
            <th>Cena karnetu</th>
            <th>Ilość sprzedanych karnetów</th>
            <th>Cena sumaryczna</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="p" items="${priceBalance}" begin="0" end="${size}" varStatus="row">
            <tr>
                <td>${row.index+1}</td>
                <td>${p.key}</td>
                <td>${p.value}</td>
                <td>${p.value*p.key}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div style="width: 30%; margin-left: auto; margin-right: auto; text-align: center"> <h1 style="color: #f30909; border: black 2px; text-shadow: black 0.1em 0.1em 0.2em">Total ${priceTotal} zł</h1>  </div>
</div>

<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<script>
    $(document).ready( function () {
        $('#price_table').DataTable();
    });
</script>
</body>
</html>

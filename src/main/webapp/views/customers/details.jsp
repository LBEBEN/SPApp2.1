<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Szczegółowe dane</title>
</head>
<body bgcolor="#6495ed">
<h2> Klient </h2>
<div style="display: flex">
    <div><h3>${customer.name}</h3></div>
    <div style="margin: 0 10px"><h3>${customer.surname}</h3></div>
</div>
<div style="display: flex">
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Email</b><br>${customer.email}</div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Nr telefonu</b><br>${customer.phoneNumber}</div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Trener</b><br>${customer.trainer.displayName}</div>
</div>
<p>
<div style="display: flex">
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Nr karnetu</b><br>${customer.cartNumber}</div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Typ karnetu</b><br>${customer.bucklet.name}</div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Opłacono depozyt</b><br>
        <c:choose>
            <c:when test="${customer.cartDeposit == true}"><label>OPŁACONO</label> </c:when>
            <c:when test="${customer.cartDeposit == false}"><label style="color: red">NIE OPŁACONO</label> </c:when>
        </c:choose>
    </div>
</div>
<p></p>
<div style="display: flex">
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Data zakupu</b><br>${customer.purchaseDate}</div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Ważny do</b><br>${customer.expiryDate}</div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Pozostało wejść</b><br>${customer.visitsLeft}</div>
</div>
<p>
<div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Uwagi</b><br>${customer.comment}</div>
</div>
<p>
    <input type="button" onclick="location.href='/customer/all';" value="LISTA KLIENTÓW"/>
    <input type="button" onclick="location.href='/customer/edit/${customer.clientId}';" value="EDYTUJ DANE"/>
</body>
</html>
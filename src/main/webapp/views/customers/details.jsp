<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Szczegółowe dane</title>
</head>
<body style="background-color: #168bb2">
<h1 style=" display: inline-flex"> Klient <span style="margin: 0 10px; color: #8c979f;text-shadow: black 0.1em 0.1em 0.2em"> ${customer.name} ${customer.surname}</span></h1>
<div style="zoom: 1.5">
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
            <c:when test="${customer.cartDeposit == false}"><label style="color: red; font-weight: bold">NIE OPŁACONO</label> </c:when>
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
    <input style="border-radius: 4px" type="button" onclick="location.href='/customer/all';" value="LISTA KLIENTÓW"/>
    <input style="margin: 0 10px; border-radius: 4px" type="button"  onclick="location.href='/customer/edit/${customer.clientId}';" value="EDYTUJ DANE"/>
</div>
</body>
<style>
    b{
        text-shadow: black 0.1em 0.1em 0.2em
    }


</style>
</html>
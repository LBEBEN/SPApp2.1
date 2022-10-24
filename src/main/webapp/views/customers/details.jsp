<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="http://localhost:8080/main.css"/>" rel="stylesheet" type="text/css">
    <title>Szczegółowe dane</title>
</head>
<body style="background-color: #168bb2">
<h1 style=" display: inline-flex"> <label style="color: white; font-style: italic">Klient</label> <span style="margin: 0 10px; color: #8c979f;text-shadow: #0c51ec 0.1em 0.1em 0.2em;"> ${customer.name} ${customer.surname}</span></h1>
<div style="zoom: 1.5">
<div style="display: flex">
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Email</b><br><label style="color: gold">${customer.email}</label></div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Nr telefonu</b><br><label style="color: gold">${customer.phoneNumber}</label></div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Trener</b><br><label style="color: gold">${customer.trainer.displayName}</label></div>
</div>
<p>
<div style="display: flex">
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Nr karnetu</b><br><label style="color: gold">${customer.cartNumber}</label></div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Typ karnetu</b><br><label style="color: gold">${customer.bucklet.name}</label></div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Opłacono depozyt</b><br>
        <c:choose>
            <c:when test="${customer.cartDeposit == true}"><label style="color: #10d210">OPŁACONO</label> </c:when>
            <c:when test="${customer.cartDeposit == false}"><label style="color: red; font-weight: bold">NIE OPŁACONO</label> </c:when>
        </c:choose>
    </div>
</div>
<p></p>
<div style="display: flex">
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Data zakupu</b><br><label style="color: gold">${customer.purchaseDate}</label></div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Ważny do</b><br><label style="color: gold">${customer.expiryDate}</label></div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Pozostało wejść</b><br><label style="color: gold">${customer.visitsLeft}</label></div>
</div>
<p>
<div>
    <div style="margin: 0 10px; font-style: italic"><b style="color: white">Uwagi</b><br><label style="color: gold">${customer.comment}</label></div>
</div>
<p>
    <input style="border-radius: 4px" type="button" onclick="location.href='/customer/lastVisit';" value="LISTA KLIENTÓW"/>
    <input style="margin: 0 10px; border-radius: 4px" type="button"  onclick="location.href='/customer/edit/${customer.clientId}';" value="EDYTUJ DANE"/>
</div>
</body>
<style>
    b{
        text-shadow: black 0.1em 0.1em 0.2em
    }
</style>
</html>
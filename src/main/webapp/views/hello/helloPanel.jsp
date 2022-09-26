<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sport Plus</title>
</head>
<body>
<div style="width: 450px; margin: 0 37%;">
<h1 style="color: #ffffff; text-align: center">Witaj w aplikacji Sport Plus</h1>
    <div style="display: inline-block; width: 100%">
        <input style=" border-radius: 6px; font-size: 18px; " type="button" onclick="location.href='/customer/lastVisit';" value="LISTA KLIENTÓW"/>
        <input style="float: right ;margin-right: auto;  border-radius: 6px; font-size: 18px; " type="button" value="OBECNOŚĆ" onclick="window.open('/customer/presence')" />
    </div>
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
</style>
</html>
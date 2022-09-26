<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="http://localhost:8080/main.css"/>" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
    <title>Klienci</title>
</head>
<body >
<h1 style="color: white; text-shadow: black 0.1em 0.1em 0.2em">Lista klientów <label style="color: #10d210">${trainer}</label></h1>
</p>
<div style="width: 100%; display: inline-block">
    <div style="display: inline-block"><input type="button" onclick="location.href='/customer/add';" value="NOWY KLIENT" /></div>
    <div style="display: inline-block; right: auto"><form method="post">
        <select name="myViews">
            <c:forEach var="v" items="${views}">
                <option>${v}</option>
            </c:forEach>
        </select>
        <input style="border-radius: 3px" type="submit" value="POKAŻ">
    </form></div>
    <div style="display: inline-block"><input type="button" style="background-color: #17ab17; color: #940505" onclick="location.href='/customer/export';" value="EXCEL EXPORT" /></div>
</div>
<div style="display: flex">
    <div>
        <table border="1" bgcolor = #b0c4de id = "table_id" class ="display">

            <thead>
            <tr style="background-color: darkblue; color: white">
                <th>L.p.</th>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Nr karnetu</th>
                <th>Rodzaj karnetu</th>
                <th>Data zakupu</th>
                <th>Data ważności</th>
                <th>Pozostało wejść</th>
                <th>Ostatnia wizyta</th>
                <th>Uwagi</th>
                <th>
                    <div style="display: flex">
                        <div><input type="button" onclick="location.href='/trainer/all';" value="TRENERZY" /></div>
                        <div><input type="button" onclick="location.href='/bucklet/all';" value="KARNETY" /></div>
                        <div><input type="button" value="OBECNOŚĆ" onclick="window.open('/customer/presence')" /></div>
                    </div>

                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customers}" var="customer" begin="0" end="${size}" varStatus="row">
                <tr align="center" bgcolor="red">
                    <td>${row.index + 1}</td>
                    <td align="left">${customer.name}</td>
                    <td align="left">${customer.surname}</td>
                    <td>${customer.cartNumber}</td>
                    <td>${customer.bucklet.name}</td>
                    <td>${customer.purchaseDate}</td>
                    <td>${customer.expiryDate}</td>
                    <td><c:choose>
                        <c:when test="${empty customer.visitsLeft}"><label style="color: red; font-weight: bold">KONIEC KARNETU</label></c:when>
                        <c:otherwise>${customer.visitsLeft}</c:otherwise>
                    </c:choose>
                    </td>
                    <td>${customer.lastVisit}</td>
                    <td>${customer.comment}</td>
                    <td>
                        <input type="button" onclick="location.href='/customer/details/${customer.clientId}';" value="SZCZEGÓŁY"/>
                        <input type="button" onclick="location.href='/customer/renew/${customer.clientId}';" value="ODNÓW"/>
                        <input type="button" onclick="location.href='/customer/delete/${customer.clientId}';" value="USUŃ"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<script>
    $(document).ready( function () {
        $('#table_id').DataTable();
    });
</script>
</body>
</html>
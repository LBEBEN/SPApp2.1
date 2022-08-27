<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
    <title>Wszyscy trenerzy</title>
</head>
<body style="background-color: #168bb2">
<h1 style="color: white; text-shadow: black 0.1em 0.1em 0.2em">Lista trenerów</h1>
</p>
<div>
    <input style="border-radius: 3px" type="button" onclick="location.href='/trainer/add';" value="DODAJ TRENERA" />
    <input style="border-radius: 3px" type="button" onclick="location.href='/customer/all';" value="LISTA KLIENTÓW"/>
</div>
</p>

<table border="1" bgcolor = #b0c4de id = "trainerTable" class ="display">
    <thead>
    <tr style="background-color: darkblue; color: white">
        <th>L.p.</th>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Opis</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${trainers}" var="trainer" begin="0" end="${size}" varStatus="row">
        <tr align="center">
            <td>${row.index + 1}</td>
            <td align="left">${trainer.name}</td>
            <td align="left">${trainer.surname}</td>
            <td>${trainer.descryption}</td>
            <td>
                <input type="button" onclick="location.href='/trainer/edit/${trainer.trainerId}';" value="EDYTUJ"/>
                <input type="button" onclick="location.href='/trainer/delete/${trainer.trainerId}';" value="USUŃ"/>
                <input type="button" onclick="location.href='/trainer/client/${trainer.trainerId}';" value="KLIENCI"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<script>
    $(document).ready( function () {
        $('#trainerTable').DataTable();
    });
</script>
</body>
</html>
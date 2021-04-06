<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Election Application</title>
</head>
<body>
    <center>
        <h1>Election Management</h1>
        <h2>
            <a href="/new">Add New Candidate</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Candidates</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Candidates</h2></caption>
            <tr>
                <th>ID</th>
                <th>Sukunimi</th>
                <th>Etunimi</th>
                <th>Puolue</th>
                <th>Kotipaikkakunta</th>
                <th>Ika</th>
                <th>Miksi eduskuntaan</th>
                <th>Mita asioita haluat edistaa</th>
                <th>Ammatti</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="ehdokkaat" items="${listEhdokkaat}">
                <tr>
                    <td><c:out value="${ehdokkaat.ehdokas_id}" /></td>
                    <td><c:out value="${ehdokkaat.sukunimi}" /></td>
                    <td><c:out value="${ehdokkaat.etunimi}" /></td>
                    <td><c:out value="${ehdokkaat.puolue}" /></td>
                    <td><c:out value="${ehdokkaat.kotipaikkakunta}" /></td>
                    <td><c:out value="${ehdokkaat.ika}" /></td>
                    <td><c:out value="${ehdokkaat.miksi_eduskuntaan}" /></td>
                    <td><c:out value="${ehdokkaat.mita_asioita_haluat_edistaa}" /></td>
                    <td><c:out value="${ehdokkaat.ammatti}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${ehdokkaat.ehdokas_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${ehdokkaat.ehdokas_id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
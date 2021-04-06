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
        <c:if test="${ehdokkaat != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${ehdokkaat == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${ehdokkaat != null}">
                        Edit Candidate
                    </c:if>
                    <c:if test="${ehdokkaat == null}">
                        Add New Candidate
                    </c:if>
                </h2>
            </caption>
                <c:if test="${ehdokkaat != null}">
                    <input type="hidden" name="ehdokas_id" value="<c:out value='${ehdokkaat.ehdokas_id}' />" />
                </c:if>           
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${ehdokkaat.sukunimi}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Author: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${ehdokkaat.etunimi}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="45"
                            value="<c:out value='${ehdokkaat.puolue}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="45"
                            value="<c:out value='${ehdokkaat.kotipaikkakunta}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="15"
                            value="<c:out value='${ehdokkaat.ika}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="100"
                            value="<c:out value='${ehdokkaat.miksi_eduskuntaan}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="100"
                            value="<c:out value='${ehdokkaat.mita_asioita_haluat_edistaa}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="45"
                            value="<c:out value='${ehdokkaat.ammatti}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
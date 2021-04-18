<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>


<head>
    <title>All Questions to Candidates</title>
    
    <style type="text/css">
    	
    	.styled-table {
		    border-collapse: collapse;
		    margin: 25px 0;
		    font-size: 0.9em;
		    font-family: sans-serif;
		    min-width: 400px;
		    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
		    text-align: left;
}
    	.styled-table th,
		.styled-table td {
    		padding: 12px 15px;
}
	h1,
	h2 {
		text-align: center;
	}
    </style>
    
</head>
<body>
        <h1>Election Management</h1>
        <h2>
            <a href="/new">Add New Candidate</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Candidates</a>
            &nbsp;&nbsp;&nbsp;
             <a href="/lista">All Questions</a>
                &nbsp;&nbsp;&nbsp;
            <a href="/questionsForm.jsp">Add New Question</a>
             
        </h2>
 <div align="center">
        <table border="1" class="styled-table" cellpadding="5">
            <caption><h2>List of Questions</h2></caption>
            <tr>
                <th>ID</th>
                <th>Kysymys</th>

            </tr>
            <c:forEach var="kysymykset" items="${listKysymykset}">
                <tr>
                    <td><c:out value="${kysymykset.kysymys_id}" /></td>
                    <td><c:out value="${kysymykset.kysymys}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
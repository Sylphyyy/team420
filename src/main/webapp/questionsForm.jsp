<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Election Application</title>
    
    <style type="text/css">
    	
    	input {
		  width: 100%;
		  padding: 12px 20px;
		  margin: 8px 0;
		  box-sizing: border-box;
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
            <a href="/list">List All Questions</a>
            &nbsp;&nbsp;&nbsp;
         <a href="/lista">All Questions</a>
                &nbsp;&nbsp;&nbsp;
            <a href="/questionsForm.jsp">Add New Question</a>
             
        </h2>
             
      
    <div align="center">
        <c:if test="${kysymykset != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${kysymykset == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${kysymykset != null}">
                        Add Question
                    </c:if>
                    <c:if test="${kysymykset == null}">
                        Add New Question
                    </c:if>
                </h2>
            </caption>
                <c:if test="${kysymykset != null}">
                    <input type="hidden" name="kysymys_id" value="<c:out value='${kysymykset.kysymys_id}' />" />
                </c:if>           
            <tr>
                <th>ID: </th>
                <td>
                    <input type="text" name="kysymys_id" size="45"
                            value="<c:out value='${kysymykset.kysymys_id}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Kysymys: </th>
                <td>
                    <input type="text" name="kysymys" size="45"
                            value="<c:out value='${kysymykset.kysymys}' />"
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
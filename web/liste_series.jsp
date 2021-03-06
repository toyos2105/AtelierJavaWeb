<%-- 
    Document   : liste_series
    Created on : 22 nov. 2017, 12:07:20
    Author     : Formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% double num = Math.random(); %>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css?<%= num %>" rel='stylesheet'/>
    </head>
    <body>
        <c:import url="header.jsp"/>
        
        <corps>
            <div class="table-title">
                <h3>Table des séries</h3>
            </div>

            <table class="table-fill">
                <thead>
                    <tr>
                        <th class="text-left">Titre</th>
                        <th class="text-left">Titre</th>
                    </tr>
                </thead>
                <tbody class="table-hover">
                    <c:forEach items="${series}" var="serie">
                        <tr>
                            <td class="text-left">${serie.titre}</td>
                            <td class="text-left">${serie.titre}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>  
        </corps>
        <c:import url="footer.jsp"/>   
    </body>
</html>

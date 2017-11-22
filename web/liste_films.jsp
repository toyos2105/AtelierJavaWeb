<%-- 
    Document   : liste_films
    Created on : 22 nov. 2017, 12:07:20
    Author     : Formation
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" rel='stylesheet'/>
    </head>
    <body>
        <c:import url="header.jsp"/>
        
        <c:forEach items="${films}" var="film">
            ${film.titre}<br/>
        </c:forEach>
        <table>
            
            
        </table>    
        <c:import url="footer.jsp"/>   
    </body>
</html>

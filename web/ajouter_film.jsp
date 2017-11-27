<%-- 
    Document   : liste_films
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
                <h3>Ajouter un film</h3>
            </div>
            <form method="post">
                <table class="table-fill">
                    <tbody class="table-hover">
                        <tr>
                            <td class="text-left">Titre</td>
                            <td class="text-left"><input type="text" name="titre"></td>
                        </tr>
                        <tr>
                            <td class="text-left">Synopsis</td>
                            <td class="text-left"><input type="text" name="synopsis"></td>
                        </tr>
                        <tr>
                            <td class="text-left">Année</td>
                            <td class="text-left"><input type="number" min="1900" max="2020" name="annee"></td>
                        </tr>
                        <tr>
                            <td class="text-left">Durée</td>
                            <td class="text-left"><input type="number" min="1" name="duree"></td>
                        </tr>
                        <tr>
                            <td class="text-left"></td>
                            <td class="text-left"><input type="submit" value="Enregistrer"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </corps>
        <c:import url="footer.jsp"/>   
    </body>
</html>

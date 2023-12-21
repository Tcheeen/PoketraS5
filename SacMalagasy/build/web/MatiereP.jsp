<%@page import="java.util.Vector"%>
<%@page import="model.Materiels"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Résultats de la recherche</title>
</head>
<body>
    <h2>Résultats de la recherche pour la matière première : <%= request.getParameter("matierepremiere") %></h2>
    
    <ul>
        <% 
            // Récupérer la liste des matières premières depuis l'attribut de la requête
            Vector<Materiels> listeMateriels = (Vector<Materiels>)request.getAttribute("listeMateriels");

            // Afficher les résultats
            for (Materiels m : listeMateriels) {
        %>
            <li><%= m.toString() %></li>
        <%
            }
        %>
    </ul>
</body>
</html>

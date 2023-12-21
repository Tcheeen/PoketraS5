<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="model.*, java.util.*" %>
<%@page import="java.util.Vector"%>
<%@page import="model.Materiels"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>

<%
  String header = (String) request.getSession().getAttribute("header");
  String footer = (String) request.getSession().getAttribute("footer");
%>

<jsp:include page="<%= header %>"/>

<br>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Matériels</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }
        
        .view-details-button {
            background-color: blue;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }

        .delete-button {
            background-color: red;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
    </style>

    <script>
        function viewDetails(id) {
            // Ajouter le code pour afficher les détails du matériel avec l'ID spécifié
            alert("Voir les détails pour le matériel avec l'ID " + id);
        }

        function deleteMaterial(id) {
            // Ajouter le code pour supprimer le matériel avec l'ID spécifié
            alert("Supprimer le matériel avec l'ID " + id);
        }
    </script>
</head>
<body>
    <h2>Liste des Matériels</h2>

    <%
        // Récupérer les données de la requête
        Vector<Materiels> matiere = (Vector<Materiels>)request.getAttribute("matiere");
    %>

    <% if (matiere == null || matiere.isEmpty()) { %>
        <p>Aucun matiere trouvé.</p>
    <% } else { %>
        <table>
            <tr>
                <th>ID Materiel</th>
                <th>Taille</th>
                <th>Matiere Premiere</th>
                <th>Type</th>
                <th>Look</th>
                <th>Quantite</th>
                <th>Action</th>
            </tr>

            <% for (Materiels materiel : matiere) { %>
                <tr>
                    <td><%= materiel.getIdMateriel() %></td>
                    <td><%= materiel.getTaille() %></td>
                    <td><%= materiel.getMatierePremiere() %></td>
                    <td><%= materiel.getType() %></td>
                    <td><%= materiel.getLook() %></td>
                    <td><%= materiel.getQuantite() %></td>
                    <td>
                        <button class="view-details-button" onclick="viewDetails('<%= materiel.getIdMateriel() %>')">Modifier</button>
                        <button class="delete-button" onclick="deleteMaterial('<%= materiel.getIdMateriel() %>')">Delete</button>
                    </td>
                </tr>
            <% } %>
        </table>
    <% } %>
</body>
</html>
<jsp:include page="<%= footer %>"/>
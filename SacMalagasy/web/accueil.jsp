<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*, java.util.*" %>
<%
  String header = (String) request.getSession().getAttribute("header");
  String footer = (String) request.getSession().getAttribute("footer");
%>
<jsp:include page="<%= header %>"/>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f8f9fa; /* Couleur de fond */
    }

    header, footer {
        background-color: whitesmoke; /* Couleur de fond de l'en-tête et du pied de page */
        color: #ffffff; /* Couleur du texte de l'en-tête et du pied de page */
        padding: 10px;
        text-align: center;
    }

    main {
        padding: 20px;
    }

    .container {
        max-width: 1200px;
        margin: 0 auto;
    }

    .section {
        margin-bottom: 30px;
    }

    .card-container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    .card {
        border: 1px solid #dee2e6; /* Couleur de la bordure de la carte */
        border-radius: 5px;
        padding: 100px;
        margin: 10px;
        background-color: #ffffff; /* Couleur de fond de la carte */
  
    }

    .card img {
        max-width: 200px;
        height: auto;
        border-radius: 5px;
    }

    h2 {
        color: #007bff; /* Couleur du titre */
    }
    
    .horizontal-list {
        list-style-type: none;
        padding: 0;
        display: flex;
        justify-content: space-between;
    }

    .horizontal-list li {
        margin-right: 10px;
    }

    .card-buttons {
        margin-top: 10px;
        display: flex;
        justify-content: space-between;
    }

    .add-button{
        background-color: green; /* Couleur de fond des boutons */
        color: #ffffff; /* Couleur du texte des boutons */
        border: none;
        padding: 8px 12px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }
    
    .delete-button {
        background-color: red; /* Couleur de fond des boutons */
        color: #ffffff; /* Couleur du texte des boutons */
        border: none;
        padding: 8px 12px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .add-button:hover,
    .delete-button:hover {
        background-color: #218838; /* Couleur de fond des boutons au survol */
    }
  

</style>

<main>
    <div class="container">
        <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6 col-md-6">
                        <h1 style="color:blue">SAC MALAGASY "Poketra, sac a main , sac a dos"</h1>
                           <% 
                               String[] images = { "sac2.jpg", "sac3.jpg","sac5.jpg","sac6.jpg","sac7.jpg"};
                               String[] sacNames = { "Sac Cabas Bleu", "Sac Cabas Vert","Sac Cabas Vert","Sac Cabas Vert","Sac Cabas Vert"};
                               Double[] prix = {120.90, 119.29,  223.3, 229.29, 223.44};
                           %>
                        <ul class="horizontal-list">
                            <% 
                                for (int i = 0; i < images.length; i++) {
                            %>
                                <li>
                                    <div class="card">
                                        <img src="assets/img/<%= images[i] %>" alt="Image du sac" width="300px" height="300px"/>
                                        <h3><%= sacNames[i] %></h3>
                                        <h4><%= prix[i] %></h4>
                                        <div class="card-buttons">
                                            <button class="add-button">Add</button>
                                            <button class="delete-button">Delete</button>
                                        </div>
                                    </div>
                                </li>
                            <% } %>
                            <!-- Ajoutez d'autres cartes similaires ici -->
                        </ul>
                    </div>
                </div>
            </div>
        </section>
    </div>
</main>

<jsp:include page="<%= footer %>"/>
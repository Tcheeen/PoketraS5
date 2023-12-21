<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*, java.util.*" %>
<%
  String header = (String) request.getSession().getAttribute("header");
  String footer = (String) request.getSession().getAttribute("footer");
%>
<jsp:include page="<%= header %>"/>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f8f9fa; /* Choisir une couleur de fond qui vous convient */
    }

    main {
        padding: 50px;
    }

    .card {
        margin-top: 50px;
        box-shadow: 1px 6px 6px 6px;
    }

    form {
        width: 500px;
        margin: 20px auto;
        padding: 15px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        color: #3498db;
    }

    input,
    select {
        margin-bottom: 15px;
        padding: 8px;
        width: 100%;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        cursor: pointer;
    }
</style>

<main>
    <div class="container">
        <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6 col-md-6 d-flex flex-column align-items-center justify-content-center">
                        <div class="card mb-3">
                            <div class="card-body">
                                <form action="" method="POST">
                                    <h2>Insertion Employe</h2>
                                    <label for="nom">Nom :</label>
                                    <input type="text" id="nom" name="nom">
                                    <label for="prenom">Prenom :</label>
                                    <input type="text" id="prenom" name="prenom">
                                     <label for="genre">Genre type:</label>
                                    <input type="number" id="genre" name="genre">
                                    <label for="dateNaissance">Date de Naissance:</label>
                                    <input type="date" id="dateNaissance" name="dateNaissance">
                                    <label for="niveau">Niveau Etude :</label>
                                    <input type="number" id="niveau" name="niveau">
                                    <input type="submit" value="Valider">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</main>

<jsp:include page="<%= footer %>"/>
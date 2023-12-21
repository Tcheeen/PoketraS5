package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employe;

@WebServlet(name = "Ajoute_employe", urlPatterns = {"/Ajoute_employe"})
public class Ajoute_employe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("ajout_employe.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace( response.getWriter() );
        }
    }

    // Les méthodes doGet() et doPost() appellent processRequest()
    // Vous pouvez personnaliser ces méthodes si nécessaire

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try (PrintWriter out = response.getWriter()) {
            // Récupérer les valeurs du formulaire
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            int idgenre = Integer.parseInt(request.getParameter("genre"));
            String dateString = request.getParameter("dateNaissance");
            LocalDate dateNaissance = LocalDate.parse(dateString);
            int niveau = Integer.parseInt(request.getParameter("niveau"));
            // Générer une instance de la classe Materiels avec les valeurs du formulaire
           Employe materiel = new Employe(9, nom, prenom,idgenre, dateNaissance, niveau);

            // Appeler la méthode d'insertion de la classe Materiels
            Employe.insererEmploye(materiel.getId(), materiel.getNom(), materiel.getPrenom(),
                    materiel.getIdgenre(),materiel.getDateNaissance(), materiel.getIdniveauEtude());

    
        }catch(Exception e){
            e.printStackTrace( response.getWriter() );
        }
      
// Rediriger vers la nouvelle page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/liste_materiel.jsp");
        dispatcher.forward(request, response);
    }
}
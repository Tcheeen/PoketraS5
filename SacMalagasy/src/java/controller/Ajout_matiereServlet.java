package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MatierePremiere;

@WebServlet(name = "Ajout_matiereServlet", urlPatterns = {"/Ajout_matiereServlet"})
public class Ajout_matiereServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("ajout_matierePremiere.jsp").forward(request, response);
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
            String nommatiere = request.getParameter("nommatiere");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
          
            // Générer une instance de la classe Materiels avec les valeurs du formulaire
            MatierePremiere matiereP = new MatierePremiere("M4", nommatiere, (int) prix,quantite);

            // Appeler la méthode d'insertion de la classe Materiels
            MatierePremiere.insererMatierePremiere(matiereP. getIdmatiere(), matiereP.getNommatiere(), matiereP.getQuantiteMatiere(),
                    matiereP.getPrix());

    
        }catch(Exception e){
            e.printStackTrace( response.getWriter() );
        }
      
// Rediriger vers la nouvelle page JSP
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/liste_materiel.jsp");
//        dispatcher.forward(request, response);
    }
}
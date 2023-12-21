package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Materiels;

@WebServlet(name = "Ajout_materielServlet", urlPatterns = {"/Ajout_materielServlet"})
public class Ajout_materielServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("ajout_materiel.jsp").forward(request, response);
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
            String taille = request.getParameter("taille");
            String matierePremiere = request.getParameter("matierePremiere");
            String type = request.getParameter("type");
            String look = request.getParameter("look");
//            System.out.println("Avant conversion de prixUnitaire");
//       
//            double prixUnitaire = Double.parseDouble(request.getParameter("prixUnitaire"));
            System.out.println("Avant conversion de quantite");
            int quantite = Integer.parseInt(request.getParameter("quantite"));
           
            // Générer une instance de la classe Materiels avec les valeurs du formulaire
            Materiels materiel = new Materiels("S2", taille, matierePremiere, type, look, quantite);

            // Appeler la méthode d'insertion de la classe Materiels
            Materiels.insererMateriels(materiel.getIdMateriel(), materiel.getTaille(), materiel.getMatierePremiere(),
                    materiel.getType(), materiel.getLook(), materiel.getQuantite());

    
        }catch(Exception e){
            e.printStackTrace( response.getWriter() );
        }
      
// Rediriger vers la nouvelle page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/liste_materiel.jsp");
        dispatcher.forward(request, response);
    }
}
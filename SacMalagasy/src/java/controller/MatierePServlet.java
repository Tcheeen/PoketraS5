package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Materiels;
import static model.Materiels.getListeMatiereP;


@WebServlet(name="/ MatierePServlet" , urlPatterns = {"/MatierePServlet"})
public class MatierePServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Récupérer le paramètre matierepremiere depuis la requête
        String matierepremiere = request.getParameter("matierepremiere");

        try {
            // Appeler la méthode getListeMatiereP pour obtenir la liste des matières premières
            Vector<Materiels> listeMateriels = getListeMatiereP(matierepremiere);
            
                request.setAttribute("matierepremiere", matierepremiere);
                request.getRequestDispatcher("/MatiereP.jsp").forward(request, response);
                
            // Afficher les résultats dans la réponse
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Résultats de la recherche</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Résultats de la recherche pour la matière première : " + matierepremiere + "</h2>");
            out.println("<ul>");

            for (Materiels m : listeMateriels) {
                out.println("<li>" + m.toString() + "</li>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("Erreur de classe non trouvée");
        } 

    }
}

package controller;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import model.Materiels;
import static model.Materiels.getMateriels;


@WebServlet(name="/ListeMaterielsServlet" , urlPatterns = {"/ListeMaterielsServlet"})
public class ListeMaterielServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Vector<Materiels> materiels = getMateriels();
            request.setAttribute("materiels", materiels);

            // Transférer le contrôle à la page JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/liste_materiel.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Gérer l'erreur si nécessaire
        }
    }
}
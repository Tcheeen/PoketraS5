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
import static model.Materiels.getMatierePremiereLuxe;

@WebServlet(name="/ListeLook", urlPatterns = {"/ListeLook"})
public class ListeLook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Vector<Materiels> matiere = getMatierePremiereLuxe();
            request.setAttribute("matiere", matiere);

            // Transférer le contrôle à la page JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/list_look.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Gérer l'erreur si nécessaire
        }
    }
}
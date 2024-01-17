package main.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.dao.TutoradoDao;
import main.dao.TutoriaDao;
import main.model.Tutorado;
import main.model.Tutoria;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/tutoradohome"})
public class TutoradoControl extends HttpServlet {
    Tutorado tutorado = new Tutorado();
    ArrayList<Tutoria> tutorias = new ArrayList<>();
    TutoradoDao tutoradoDao = new TutoradoDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        int id = Integer.parseInt(request.getParameter("id"));

        if (action.equals("/tutoradohome"))
        {
            iniciarHome(request,response,id);
        }
        else {
            response.sendRedirect("login.jsp");
        }

    }

    protected void iniciarHome(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException {
        request.setAttribute("id",id);
        tutorado = TutoradoDao.retornarTutorado(id);
        tutorias = TutoriaDao.retornarTutoriaParaTutorado(id);
        request.setAttribute("tutorado", tutorado);
        request.setAttribute("tutorias", tutorias);
        RequestDispatcher rd = request.getRequestDispatcher("tutoradohome.jsp");
        rd.forward(request,response);
    }
}

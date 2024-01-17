package main.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.dao.TutorDao;
import main.dao.TutoriaDao;
import main.model.Tutor;
import main.model.Tutoria;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/tutorhome"})
public class TutorControl extends HttpServlet {
    Tutor tutor = new Tutor();
    ArrayList<Tutoria> tutorias = new ArrayList<>();
    TutorDao tutorDao = new TutorDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        int id = Integer.parseInt(request.getParameter("id"));

        if (action.equals("/tutorhome"))
        {
            iniciarHome(request,response,id);
        }
        else {
            response.sendRedirect("login.jsp");
        }

    }

    protected void iniciarHome(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException {
        request.setAttribute("id",id);
        tutor = tutorDao.retornarTutor(id);
        tutorias = TutoriaDao.retornarTutoriaParaTutor(id);
        request.setAttribute("tutor", tutor);
        request.setAttribute("tutorias", tutorias);
        RequestDispatcher rd = request.getRequestDispatcher("tutorhome.jsp");
        rd.forward(request,response);
    }
}


package main.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.dao.TutorDao;
import main.model.Tutor;

import java.io.IOException;

@WebServlet(urlPatterns = {"/realizarEdicaoDoTutor", "/voltarParaMainTutor"})
public class EditarTutorControl extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static TutorDao tutorDao = new TutorDao();
    Tutor tutor = new Tutor();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String action = request.getServletPath();
        int id = Integer.parseInt(request.getParameter("id"));

        if (action.equals("/realizarEdicaoDoTutor"))
        {
            atualizarDados(request,response);
        }
        else
        {
            response.sendRedirect("tutorhome?id="+id);
        }

    }

    protected void atualizarDados(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        tutor.setId(Integer.parseInt(request.getParameter("id")));
        tutor.setSenha(request.getParameter("senha"));
        tutor.setNome(request.getParameter("nome"));
        tutor.setEmail(request.getParameter("email"));
        tutor.setCurso(request.getParameter("curso"));
        tutor.setSemestre(Integer.parseInt(request.getParameter("semestre")));
        tutor.setMatricula(request.getParameter("matricula"));
        tutorDao.editarTutor(tutor);
        response.sendRedirect("tutorhome?id="+tutor.getId());
    }

}

package main.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.dao.TutoriaDao;
import main.model.Tutorado;
import main.model.Tutoria;
import main.model.Tutor;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/loginTutoriaTutorado", "/loginTutoriaTutor"})
public class LoginTutoriaControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Tutoria tutoria = new Tutoria();
    private static Tutorado tutorado = new Tutorado();
    private static Tutor tutor = new Tutor();
    private static TutoriaDao tutoriaDao = new TutoriaDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = req.getServletPath();

        if(action.equals("/loginTutoriaTutorado"))
        {
            verificarTutoriaTutorado(req, resp);
        }
        else if(action.equals("/loginTutoriaTutor"))
        {
            verificarTutoriaTutor(req, resp);
        }
        else
        {
            resp.sendRedirect("login.jsp");
        }
    }

    protected void verificarTutoriaTutorado(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        tutoria.setCodigo(Integer.parseInt(req.getParameter("codigo")));
        tutoria.setSenha(req.getParameter("senha"));
        int id = Integer.parseInt(req.getParameter("id"));

        if(tutoriaDao.lerTutoria(tutoria))
        {
            tutoriaDao.atualizarTutoriaTutorado(tutoria, id);
            resp.sendRedirect("tutoradohome?id="+id);
        }
        else
        {
            resp.getWriter().write("<script>alert('Tutoria não encontrada!'); window.location='tutoradohome?id=" + id + "';</script>");
        }
    }

    protected void verificarTutoriaTutor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        tutoria.setCodigo(Integer.parseInt(req.getParameter("codigo")));
        tutoria.setSenha(req.getParameter("senha"));
        int id = Integer.parseInt(req.getParameter("id"));

        if(tutoriaDao.lerTutoria(tutoria))
        {
            tutoriaDao.atualizarTutoriaTutor(tutoria, id);
            resp.sendRedirect("tutorhome?id="+id);
        }
        else
        {
            resp.getWriter().write("<script>alert('Tutoria não encontrada!'); window.location='tutorhome?id=" + id + "';</script>");
        }
    }

}

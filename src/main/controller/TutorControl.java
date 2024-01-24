package main.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.dao.TutorDao;
import main.dao.TutoriaDao;
import main.model.Tutor;
import main.model.Tutoria;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/tutorhome", "/edicaoTutor", "/loginTutoriaTutor", "/realizarEdicaoDoTutor", "/voltarParaMainTutor"})
public class TutorControl extends HttpServlet {
    Tutor tutor = new Tutor();
    ArrayList<Tutoria> tutorias = new ArrayList<>();
    TutorDao tutorDao = new TutorDao();
    private static TutoriaDao tutoriaDao = new TutoriaDao();
    private static Tutoria tutoria = new Tutoria();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        int id = Integer.parseInt(request.getParameter("id"));

        if (action.equals("/tutorhome"))
        {
            iniciarHome(request,response,id);
        }
        else if( action.equals("/edicaoTutor"))
        {
            irParaEdicao(request,response,id);
        }
        else if(action.equals("/loginTutoriaTutor"))
        {
            verificarTutoriaTutor(request, response);
        }
        else if (action.equals("/realizarEdicaoDoTutor"))
        {
            atualizarDadosTutor(request,response);
        }
        else if(action.equals(("/voltarParaMainTutor")))
        {
            response.sendRedirect("tutorhome?id="+id);
        }
        else
        {
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

    protected void irParaEdicao(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        tutor.setId(id);
        tutorDao.selecionarTutor(tutor);
        request.setAttribute("id", tutor.getId());
        request.setAttribute("senha",tutor.getSenha());
        request.setAttribute("nome",tutor.getNome());
        request.setAttribute("email",tutor.getEmail());
        request.setAttribute("curso",tutor.getCurso());
        request.setAttribute("semestre",tutor.getSemestre());
        request.setAttribute("matricula",tutor.getMatricula());
        RequestDispatcher rd = request.getRequestDispatcher("edicaoTutor.jsp");
        rd.forward(request,response);
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
            resp.sendRedirect("voltarParaMainTutor?id="+tutor.getId());
        }
        else
        {
            resp.getWriter().write("<script>alert('Tutoria não encontrada!'); window.location='tutorhome?id=" + id + "';</script>");
        }
    }

    protected void atualizarDadosTutor(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        tutor.setId(Integer.parseInt(request.getParameter("id")));
        tutor.setSenha(request.getParameter("senha"));
        tutor.setNome(request.getParameter("nome"));
        tutor.setEmail(request.getParameter("email"));
        tutor.setCurso(request.getParameter("curso"));
        tutor.setSemestre(Integer.parseInt(request.getParameter("semestre")));
        tutor.setMatricula(request.getParameter("matricula"));
        tutorDao.editarTutor(tutor);
        response.sendRedirect("voltarParaMainTutor?id="+tutor.getId());
    }
}


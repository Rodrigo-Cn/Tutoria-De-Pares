package main.controller;

import main.dao.*;
import main.model.Disciplina;
import main.model.Professor;
import main.model.Tutoria;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/professorhome", "/loginTutoriaProfessor", "/voltarParaMainProfessor", "/realizarEdicaoDoProfessor", "/edicaoProfessor", "/entrarTutoriaProfessor"})
public class ProfessorControl extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static Professor professor = new Professor();
    private static ProfessorDao professorDao = new ProfessorDao();
    private static ArrayList<Tutoria> tutorias = new ArrayList<>();
    private static TutoriaDao tutoriaDao = new TutoriaDao();
    private static Tutoria tutoria = new Tutoria();
    private static DisciplinaDao disciplinaDao = new DisciplinaDao();
    private static Disciplina disciplina = new Disciplina();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getServletPath();
        int id = Integer.parseInt(request.getParameter("id"));

        if(action.equals("/professorhome"))
        {
            iniciarHome(request,response,id);
        }
        else if(action.equals("/loginTutoriaProfessor"))
        {
            verificarTutoriaProfessor(request, response, id);
        }
        else if(action.equals("/voltarParaMainProfessor"))
        {
            response.sendRedirect("professorhome?id="+id);
        }
        else if(action.equals("/edicaoProfessor"))
        {
            irParaEdicao(request, response, id);
        }
        else if(action.equals("/realizarEdicaoDoProfessor"))
        {
            atualizarDadosProfessor(request,response, id);
        }
        else if(action.equals(("/entrarTutoriaProfessor")))
        {
            irParaTutoriaProfessor(request,response,id);
        }
    }

    protected void iniciarHome(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        request.setAttribute("id",id);
        professor = professorDao.retornarProfessor(id);
        tutorias = tutoriaDao.retornarTutoriaParaProfessor(id);
        request.setAttribute("professor", professor);
        request.setAttribute("tutorias", tutorias);
        RequestDispatcher rd = request.getRequestDispatcher("professorhome.jsp");
        rd.forward(request,response);
    }

    protected void verificarTutoriaProfessor(HttpServletRequest req, HttpServletResponse resp, int id) throws ServletException, IOException
    {
        disciplina.setCodigo(Integer.parseInt(req.getParameter("codigo")));

        if(disciplinaDao.lerDisciplina(disciplina))
        {
            disciplinaDao.atualizarDisciplinaProfessor(disciplina, id);
            resp.sendRedirect("voltarParaMainProfessor?id="+id);
        }
        else
        {
            resp.getWriter().write("<script>alert('Disciplina não encontrada!'); window.location='tutoradohome?id=" + id + "';</script>");
        }
    }

    protected void irParaEdicao(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        professor.setId(id);
        professorDao.selecionarProfessor(professor);
        request.setAttribute("id", professor.getId());
        request.setAttribute("senha",professor.getSenha());
        request.setAttribute("nome",professor.getNome());
        request.setAttribute("email",professor.getEmail());
        RequestDispatcher rd = request.getRequestDispatcher("edicaoProfessor.jsp");
        rd.forward(request,response);
    }
    protected void atualizarDadosProfessor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        professor.setId(Integer.parseInt(request.getParameter("id")));
        professor.setSenha(request.getParameter("senha"));
        professor.setNome(request.getParameter("nome"));
        professor.setEmail(request.getParameter("email"));
        professorDao.editarProfessor(professor);
        response.sendRedirect("voltarParaMainProfessor?id="+id);
    }

    protected void irParaTutoriaProfessor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        tutoria.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        tutoriaDao.retornaTutoria(tutoria);

        request.setAttribute("codigo", tutoria.getCodigo());
        request.setAttribute("senha", tutoria.getSenha());
        request.setAttribute("nomeTutor", tutoria.getTutor().getNome());
        request.setAttribute("nomeTutorado", tutoria.getTutorado().getNome());
        request.setAttribute("disciplina", tutoria.getDisciplina().getNome());
        request.setAttribute("nomeProfessor", tutoria.getDisciplina().getProfessor().getNome());

        RequestDispatcher rd = request.getRequestDispatcher("tutoriaProfessor.jsp");
        rd.forward(request,response);
    }


}

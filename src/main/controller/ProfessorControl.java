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
import main.model.*;
import main.dao.*;

@WebServlet(urlPatterns = {"/professorhome", "/loginTutoriaProfessor", "/voltarParaMainProfessor", "/realizarEdicaoDoProfessor", "/edicaoProfessor", "/entrarTutoriaProfessor", "/carregarMetasProfessor", "/criarMetaProfessor", "/selecionaMetaProfessor", "/editarMetaProfessor", "/deletarMetaProfessor"})
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
    MetasDao metasDao = new MetasDao();
    Metas metas = new Metas();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getServletPath();
        String idParameter = request.getParameter("id");
        int id;

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                id = Integer.parseInt(idParameter);
            } catch (NumberFormatException e) {
                id = professor.getId();
            }
        } else {
            id =  professor.getId();
        }

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
        else if(action.equals("/carregarMetasProfessor"))
        {
            irParaMetasProfessor(request,response,id);
        }
        else if(action.equals("/criarMetaProfessor"))
        {
            criarMetaProfessor(request,response, id);
        }
        else if(action.equals("/selecionaMetaProfessor"))
        {
            selecionaMeta(request,response, id);
        }
        else if(action.equals("/editarMetaProfessor"))
        {
            editarMeta(request,response, id);
        }
        else if(action.equals("/deletarMetaProfessor"))
        {
            deletarMeta(request,response, id);
        }
        else
        {
            response.sendRedirect("login.jsp");
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
        request.setAttribute("professor", professor);
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
        TutoriaDao tutoriaDao = new TutoriaDao();
        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("tutoria", tutoria);
        request.setAttribute("professor", professor);
        RequestDispatcher rd = request.getRequestDispatcher("tutoriaProfessor.jsp");
        rd.forward(request,response);
    }

    protected void irParaMetasProfessor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        professor.setId(id);
        professorDao.selecionarProfessor(professor);
        request.setAttribute("professor", professor);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        metasDao.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        RequestDispatcher rd = request.getRequestDispatcher("metasProfessor.jsp");
        rd.forward(request,response);
    }

    protected void criarMetaProfessor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        int codigoTutoria = Integer.parseInt(request.getParameter("codigo"));
        String titulo = request.getParameter("nome-criar");
        metasDao.criarMeta(codigoTutoria, titulo);

        tutoria = tutoriaDao.retornaTutoria(codigoTutoria);
        metasDao.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        professor.setId(id);
        professorDao.selecionarProfessor(professor);
        request.setAttribute("professor", professor);

        RequestDispatcher rd = request.getRequestDispatcher("metasProfessor.jsp");
        rd.forward(request,response);

    }

    protected void selecionaMeta(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        metas.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metasDao.selecionaMeta(metas);
        request.setAttribute("metas",  metas);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        metasDao.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        professor.setId(id);
        professorDao.selecionarProfessor(professor);
        request.setAttribute("professor", professor);

        RequestDispatcher rd = request.getRequestDispatcher("editarMetasProfessor.jsp");
        rd.forward(request,response);

    }

    protected void editarMeta(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {

        metas.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metas.setTitulo(request.getParameter("nome-criar"));

        metasDao.atualizarMeta(metas);

        response.sendRedirect("carregarMetasProfessor?id="+id+"&codigo="+Integer.parseInt(request.getParameter("codigo")));
    }

    protected void deletarMeta(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        metas.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metasDao.excluirMeta(metas);
        response.sendRedirect("carregarMetasProfessor?id="+id+"&codigo="+Integer.parseInt(request.getParameter("codigo")));
    }

}

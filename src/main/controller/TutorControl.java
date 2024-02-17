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
import main.model.*;
import main.dao.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/tutorhome", "/edicaoTutor", "/loginTutoriaTutor", "/realizarEdicaoDoTutor", "/voltarParaMainTutor", "/entrarTutoriaTutor", "/criarMetaTutor", "/carregarMetasTutor", "/carregarMensagensTutor", "/enviarMensagemTutor", "/selecionaMensagemTutor", "/editarMensagemTutor", "/deletarMensagemTutor"})
public class TutorControl extends HttpServlet {
    Tutor tutor = new Tutor();
    ArrayList<Tutoria> tutorias = new ArrayList<>();
    TutorDao tutorDao = new TutorDao();
    private static TutoriaDao tutoriaDao = new TutoriaDao();
    private static Tutoria tutoria = new Tutoria();
    MetasDao metasDao = new MetasDao();
    Meta metas = new Meta();
    private static MensagemDao mensagemDao = new MensagemDao();
    private static Mensagem mensagem = new Mensagem();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        String idParameter = request.getParameter("id");
        int id;

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                id = Integer.parseInt(idParameter);
            } catch (NumberFormatException e) {
                id = tutor.getId();
            }
        } else {
            id =  tutor.getId();
        }

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
        else if(action.equals(("/entrarTutoriaTutor")))
        {
            irParaTutoriaTutor(request,response,id);
        }
        else if(action.equals("/carregarMetasTutor"))
        {
            irParaMetasTutor(request,response,id);
        }
        else if(action.equals("/criarMetaTutor"))
        {
            criarMetaTutor(request,response, id);
        }
        else if(action.equals("/carregarMensagensTutor"))
        {
            irParaMensagensTutor(request,response, id);
        }
        else if(action.equals("/enviarMensagemTutor"))
        {
            enviarMensagem(request,response, id);
        }
        else if(action.equals("/selecionaMensagemTutor"))
        {
            selecionaMensagem(request,response, id);
        }
        else if(action.equals("/editarMensagemTutor"))
        {
            editarMensagem(request,response, id);
        }
        else if(action.equals("/deletarMensagemTutor"))
        {
            deletarMensagem(request,response, id);
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
        request.setAttribute("tutor",tutor);
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

    protected void irParaTutoriaTutor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        TutoriaDao tutoriaDao = new TutoriaDao();
        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("tutoria", tutoria);
        request.setAttribute("tutor", tutor);
        RequestDispatcher rd = request.getRequestDispatcher("tutoriaTutor.jsp");
        rd.forward(request,response);
    }

    protected void criarMetaTutor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        int codigoTutoria = Integer.parseInt(request.getParameter("codigo"));
        String titulo = request.getParameter("nome-criar");
        metasDao.criarMeta(codigoTutoria, titulo);

        tutoria = tutoriaDao.retornaTutoria(codigoTutoria);
        metasDao.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        tutor.setId(id);
        tutorDao.selecionarTutor(tutor);
        request.setAttribute("tutorado", tutor);

        response.sendRedirect("carregarMetasTutor?id=" + id + "&codigo=" + codigoTutoria);
    }

    protected void irParaMetasTutor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        tutor.setId(id);
        tutorDao.selecionarTutor(tutor);
        request.setAttribute("tutor", tutor);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        metasDao.cadastraMetasNaTutoria(tutoria);

        for(Meta i: tutoria.getMetas())
        {
            mensagemDao.cadastrarMensagensNaMeta(i);
        }

        request.setAttribute("tutoria", tutoria);

        RequestDispatcher rd = request.getRequestDispatcher("metasTutor.jsp");
        rd.forward(request,response);
    }

    protected void irParaMensagensTutor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Meta meta2 = new Meta();
        meta2.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metasDao.selecionaMeta(meta2);
        mensagemDao.cadastrarMensagensNaMeta(meta2);
        request.setAttribute("meta", meta2);

        tutor.setId(id);
        tutorDao.selecionarTutor(tutor);
        request.setAttribute("tutor", tutor);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        metasDao.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        RequestDispatcher rd = request.getRequestDispatcher("mensagensTutor.jsp");
        rd.forward(request,response);
    }

    protected void enviarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Mensagem mensagem2 = new Mensagem();
        String mensagem = request.getParameter("mensagemUsuario");
        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));

        mensagem2.setMsg(mensagem);
        mensagem2.setCodigoMeta(codigoMeta);
        mensagem2.setUsuario(mensagemDao.defineUsuarioDaMensagem(id));

        mensagemDao.criarMensagem(mensagem2);

        response.sendRedirect("carregarMensagensTutor?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }

    protected void selecionaMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Meta meta2 = new Meta();
        meta2.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metasDao.selecionaMeta(meta2);
        mensagemDao.cadastrarMensagensNaMeta(meta2);
        request.setAttribute("meta", meta2);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        metasDao.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        tutor.setId(id);
        tutorDao.selecionarTutor(tutor);
        request.setAttribute("tutor", tutor);

        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        mensagemDao.selecionaMensagem(mensagem);
        request.setAttribute("mensagem", mensagem);

        RequestDispatcher rd = request.getRequestDispatcher("editarMensagemTutor.jsp");
        rd.forward(request,response);
    }

    protected void editarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        mensagem.setCodigoMeta(Integer.parseInt(request.getParameter("codigoMensagem")));
        mensagem.setMsg(request.getParameter("mensagem"));
        mensagemDao.atualizarMensagem(mensagem);
        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));
        response.sendRedirect("carregarMensagensTutor?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }

    protected void deletarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        mensagemDao.deletarMensagem(mensagem);

        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));
        response.sendRedirect("carregarMensagensTutor?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }
}


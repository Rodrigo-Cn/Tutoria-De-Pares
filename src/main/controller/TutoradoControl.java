package main.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import main.model.*;
import main.dao.*;

@WebServlet(urlPatterns = {"/tutoradohome", "/edicaoTutorado", "/loginTutoriaTutorado","/realizarEdicaoDoTutorado", "/voltarParaMainTutorado", "/entrarTutoriaTutorado", "/carregarMetasTutorado", "/carregarMensagensTutorado", "/enviarMensagemTutorado", "/selecionaMensagemTutorado", "/editarMensagemTutorado", "/deletarMensagemTutorado", "/carregarAtendimentosTutorado"})
public class TutoradoControl extends HttpServlet {
    Tutorado tutorado = new Tutorado();
    ArrayList<Tutoria> tutorias = new ArrayList<>();
    TutoradoDao tutoradoDao = new TutoradoDao();
    private static TutoriaDao tutoriaDao = new TutoriaDao();
    private static Tutoria tutoria = new Tutoria();
    MetasDao metasDao = new MetasDao();
    private static Meta metas = new Meta();
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
                id = tutorado.getId();
            }
        } else {
            id =  tutorado.getId();
        }

        if (action.equals("/tutoradohome"))
        {
            iniciarHome(request,response,id);
        }
        else if(action.equals("/loginTutoriaTutorado"))
        {
            verificarTutoriaTutorado(request, response);
        }
        else if( action.equals("/edicaoTutorado"))
        {
            irParaEdicao(request,response,id);
        }
        else if (action.equals("/realizarEdicaoDoTutorado"))
        {
            atualizarDadosTutorado(request,response);
        }
        else if(action.equals("/voltarParaMainTutorado"))
        {
            response.sendRedirect("tutoradohome?id="+id);
        }
        else if(action.equals(("/entrarTutoriaTutorado")))
        {
            irParaTutoriaTutorado(request,response,id);
        }
        else if(action.equals("/carregarMetasTutorado"))
        {
            irParaMetasTutorado(request,response,id);
        }
        else if(action.equals("/carregarMensagensTutorado"))
        {
            irParaMensagensTutorado(request,response, id);
        }
        else if(action.equals("/enviarMensagemTutorado"))
        {
            enviarMensagem(request,response, id);
        }
        else if(action.equals("/selecionaMensagemTutorado"))
        {
            selecionaMensagem(request,response, id);
        }
        else if(action.equals("/editarMensagemTutorado"))
        {
            editarMensagem(request,response, id);
        }
        else if(action.equals("/deletarMensagemTutorado"))
        {
            deletarMensagem(request,response, id);
        }
        else if(action.equals("/carregarAtendimentosTutorado"))
        {
            telaAtendimentos(request,response, id);
        }

        else
        {
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

    protected void irParaEdicao(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        tutorado.setId(id);
        tutoradoDao.selecionarTutorado(tutorado);
        request.setAttribute("id", tutorado.getId());
        request.setAttribute("senha",tutorado.getSenha());
        request.setAttribute("nome",tutorado.getNome());
        request.setAttribute("email",tutorado.getEmail());
        request.setAttribute("curso",tutorado.getCurso());
        request.setAttribute("semestre",tutorado.getSemestre());
        request.setAttribute("deficiencia",tutorado.getTipoDeDeficiencia());
        request.setAttribute("matricula",tutorado.getMatricula());
        request.setAttribute("tutorado",tutorado);
        RequestDispatcher rd = request.getRequestDispatcher("edicaoTutorado.jsp");
        rd.forward(request,response);
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
            resp.sendRedirect("voltarParaMainTutorado?id="+tutorado.getId());
        }
        else
        {
            resp.getWriter().write("<script>alert('Tutoria não encontrada!'); window.location='tutoradohome?id=" + id + "';</script>");
        }
    }

    protected void atualizarDadosTutorado(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        tutorado.setId(Integer.parseInt(request.getParameter("id")));
        tutorado.setSenha(request.getParameter("senha"));
        tutorado.setNome(request.getParameter("nome"));
        tutorado.setEmail(request.getParameter("email"));
        tutorado.setCurso(request.getParameter("curso"));
        tutorado.setSemestre(Integer.parseInt(request.getParameter("semestre")));
        tutorado.setTipoDeDeficiencia(request.getParameter("deficiencia"));
        tutorado.setMatricula(request.getParameter("matricula"));
        tutorado.editarTutorado(tutorado);
        response.sendRedirect("voltarParaMainTutorado?id="+tutorado.getId());
    }

    protected void irParaTutoriaTutorado(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        TutoriaDao tutoriaDao = new TutoriaDao();
        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("tutoria", tutoria);
        request.setAttribute("tutorado", tutorado);

        RequestDispatcher rd = request.getRequestDispatcher("tutoriaTutorado.jsp");
        rd.forward(request,response);
    }

    protected void irParaMetasTutorado(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        tutorado.setId(id);
        tutoradoDao.selecionarTutorado(tutorado);
        request.setAttribute("tutorado", tutorado);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        metasDao.cadastraMetasNaTutoria(tutoria);

        for(Meta i: tutoria.getMetas())
        {
            mensagemDao.cadastrarMensagensNaMeta(i);
        }

        request.setAttribute("tutoria", tutoria);

        RequestDispatcher rd = request.getRequestDispatcher("metasTutorado.jsp");
        rd.forward(request,response);
    }

    protected void irParaMensagensTutorado(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Meta meta2 = new Meta();
        meta2.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metasDao.selecionaMeta(meta2);
        mensagemDao.cadastrarMensagensNaMeta(meta2);
        request.setAttribute("meta", meta2);

        tutorado.setId(id);
        tutoradoDao.selecionarTutorado(tutorado);
        request.setAttribute("tutorado", tutorado);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        metasDao.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        RequestDispatcher rd = request.getRequestDispatcher("mensagensTutorado.jsp");
        rd.forward(request,response);
    }

    protected void enviarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Tutorado tutorado = new Tutorado();
        tutorado.setId(id);
        tutoradoDao.selecionarTutorado(tutorado);

        Meta meta = new Meta();
        Mensagem mensagem2 = new Mensagem();
        String mensagem = request.getParameter("mensagemUsuario");
        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));

        mensagem2.setMsg(mensagem);
        mensagem2.setUsuario(tutorado);

        tutorado.criarMensagem(mensagem2, codigoMeta);

        response.sendRedirect("carregarMensagensTutorado?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
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

        tutorado.setId(id);
        tutoradoDao.selecionarTutorado(tutorado);
        request.setAttribute("tutorado", tutorado);

        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        mensagemDao.selecionaMensagem(mensagem);
        request.setAttribute("mensagem", mensagem);

        RequestDispatcher rd = request.getRequestDispatcher("editarMensagemTutorado.jsp");
        rd.forward(request,response);
    }

    protected void editarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        mensagem.setMsg(request.getParameter("mensagem"));
        tutorado.atualizarMensagem(mensagem);
        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));
        response.sendRedirect("carregarMensagensTutorado?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }

    protected void deletarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        tutorado.deletarMensagem(mensagem);

        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));
        response.sendRedirect("carregarMensagensTutorado?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }

    protected void telaAtendimentos(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        ArrayList<Atendimento> atendimentos = new ArrayList<>();
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentos = atendimentoDao.retornarAtendimentos(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("codigo",Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("tutorado", tutorado);
        request.setAttribute("atendimentos",atendimentos);
        RequestDispatcher rd = request.getRequestDispatcher("atendimentoTutorado.jsp");
        rd.forward(request,response);
    }
}
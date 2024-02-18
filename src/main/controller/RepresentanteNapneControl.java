package main.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.dao.DisciplinaDao;
import main.dao.RepresentanteNapneDao;
import main.dao.TutoriaDao;
import main.dao.UsuarioDao;
import main.dao.TutorDao;
import main.dao.TutoradoDao;
import main.model.Disciplina;
import main.model.Meta;
import main.model.Professor;
import main.model.RepresentanteNapne;
import main.model.Tutoria;
import main.model.Tutor;
import main.model.Tutorado;
import main.model.*;
import main.dao.*;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(urlPatterns = {"/napnehome","/cadastrarnapne","/telacadastronapne","/buscartutoria", "/edicaoNapne","/realizarEdicaoDoNapne", "/voltarParaMainNapne", "/menudisciplinas", "/criardisciplina", "/buscardisciplina", "/deletardisciplina", "/irCriarTutoria", "/criarTutoria", "/editarDisciplina", "/editandoDisciplina", "/entraremtutoria", "/carregarMetasNapne", "/criarMetaNapne", "/selecionaMetaNapne", "/editarMetaNapne", "/deletarMetaNapne", "/carregarMensagensNapne", "/enviarMensagemNapne", "/selecionaMensagemNapne", "/editarMensagemNapne", "/deletarMensagemNapne", "/carregarAtendimentosNapne", "/gerarRelatorioUnitario", "/gerarRelatorioFinal", "/editarTutoriaNapne", "/realizarEdicaoTutoria", "/irCriarAtendimentoNapne", "/criarAtendimentoNapne", "/deletarAtendimentoNapne"})
public class RepresentanteNapneControl extends HttpServlet {
    RepresentanteNapne representanteNapne = new RepresentanteNapne();
    RepresentanteNapneDao representanteNapneDao = new RepresentanteNapneDao();
    TutoriaDao tutoriaDao = new TutoriaDao();
    Tutoria tutoria = new Tutoria();
    TutoradoDao tutoradoDao = new TutoradoDao();
    Tutorado tutorado = new Tutorado();
    Tutor tutor = new Tutor();
    TutorDao tutorDao = new TutorDao();
    Disciplina disciplina = new Disciplina();
    DisciplinaDao disciplinaDao = new DisciplinaDao();
    UsuarioDao usuarioDao = new UsuarioDao();
    MetasDao metasDao = new MetasDao();
    Meta metas = new Meta();
    Mensagem mensagem = new Mensagem();
    MensagemDao mensagemDao = new MensagemDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getServletPath();
        String idParameter = request.getParameter("id");
        int id;

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                id = Integer.parseInt(idParameter);
            } catch (NumberFormatException e) {
                id = representanteNapne.getId();
            }
        } else {
            id =  representanteNapne.getId();
        }

        if (action.equals("/napnehome"))
        {
            iniciarHome(request,response,id);
        }
        else if (action.equals("/telacadastronapne")){
            telaCadastrarRepresentanteNapne(request,response);
        }
        else if (action.equals("/cadastrarnapne")){
            cadastrarRepresentanteNapne(request,response);
        }
        else if (action.equals("/buscartutoria")){
            buscarTutoria(request,response);
        }
        else if( action.equals("/edicaoNapne"))
        {
            irParaEdicao(request,response,id);
        }
        else if (action.equals("/realizarEdicaoDoNapne"))
        {
            atualizarDadosNapne(request,response);
        }
        else if (action.equals("/menudisciplinas"))
        {
            menuDisciplina(request,response);
        }
        else if (action.equals("/buscardisciplina"))
        {
            buscarDisciplina(request,response);
        }
        else if (action.equals("/deletardisciplina"))
        {
            deletarDisciplina(request,response);
        }
        else if(action.equals("/voltarParaMainNapne"))
        {
            response.sendRedirect("napnehome?id="+representanteNapne.getId());
        }
        else if(action.equals("/irCriarTutoria"))
        {
            irCriarTutoria(request,response,id);
        }
        else if(action.equals("/criarTutoria"))
        {
            criarTutoria(request,response, id);
        }
        else if(action.equals("/editarDisciplina"))
        {
            editarDisciplina(request,response);
        }
        else if(action.equals("/entraremtutoria"))
        {
            entrarTutoria(request,response);
        }
        else if(action.equals("/carregarMetasNapne"))
        {
            irParaMetasNapne(request,response,id);
        }
        else if(action.equals("/criarMetaNapne"))
        {
            criarMetaNapne(request,response, id);
        }
        else if(action.equals("/selecionaMetaNapne"))
        {
            selecionaMeta(request,response, id);
        }
        else if(action.equals("/editarMetaNapne"))
        {
            editarMeta(request,response, id);
        }
        else if(action.equals("/deletarMetaNapne"))
        {
            deletarMeta(request,response, id);
        }
        else if(action.equals("/carregarMensagensNapne"))
        {
            irParaMensagensNapne(request,response, id);
        }
        else if(action.equals("/enviarMensagemNapne"))
        {
            enviarMensagem(request,response, id);
        }
        else if(action.equals("/selecionaMensagemNapne"))
        {
            selecionaMensagem(request,response, id);
        }
        else if(action.equals("/editarMensagemNapne"))
        {
            editarMensagem(request,response, id);
        }
        else if(action.equals("/deletarMensagemNapne"))
        {
            deletarMensagem(request,response, id);
        }
        else if(action.equals("/carregarAtendimentosNapne"))
        {
            telaAtendimentos(request,response, id);
        }
        else if(action.equals("/gerarRelatorioUnitario")) {
            gerarRelatorioUnitario(request,response, id);
        }
        else if(action.equals("/gerarRelatorioFinal")) {
            gerarRelatorioFinal(request,response, id);
        }
        else if(action.equals("/editarTutoriaNapne")) {
            editarTutoria(request,response, id);
        }
        else if(action.equals("/realizarEdicaoTutoria")) {
            realizarEdicaoTutoria(request,response, id);
        }
        else if(action.equals("/irCriarAtendimentoNapne")) {
            irCriarAtendimentoNapne(request,response, id);
        }
        else if(action.equals("/criarAtendimentoNapne")) {
            criarAtendimentoNapne(request,response, id);
        }
        else if(action.equals("/deletarAtendimentoNapne")) {
            deletarAtendimentoNapne(request,response, id);
        }
        else
        {
            response.sendRedirect("login.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getServletPath();

        String idParameter = request.getParameter("id");
        int id;

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                id = Integer.parseInt(idParameter);
            } catch (NumberFormatException e) {
                id = representanteNapne.getId();
            }
        } else {
            id =  representanteNapne.getId();
        }

        if (action.equals("/editandoDisciplina"))
        {
            editandoDisciplina(request,response);
        }
        else if (action.equals("/criardisciplina"))
        {
            criarDisciplina(request,response);
        }
        else
        {
            response.sendRedirect("login.jsp");
        }

    }

    protected void iniciarHome(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException {
        request.setAttribute("id",id);
        representanteNapne = RepresentanteNapneDao.retornarRepresentanteNapne(id);
        request.setAttribute("representante", representanteNapne);
        RequestDispatcher rd = request.getRequestDispatcher("napnehome.jsp");
        rd.forward(request,response);
    }
    protected void telaCadastrarRepresentanteNapne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("representante", representanteNapne);
        request.setAttribute("id",representanteNapne.getId());
        RequestDispatcher rd = request.getRequestDispatcher("cadastrarNapne.jsp");
        rd.forward(request,response);
    }
    protected void cadastrarRepresentanteNapne(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("representante", representanteNapne);
        representanteNapne.setNome(request.getParameter("nome"));
        representanteNapne.setEmail(request.getParameter("email"));
        representanteNapne.setSenha(request.getParameter("senha1"));
        representanteNapneDao.cadastrarRepresentanteNapne(representanteNapne);
        response.sendRedirect("napnehome?id="+representanteNapne.getId());
    }
    protected void buscarTutoria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<Tutoria> tutorias = new ArrayList<>();
        request.setAttribute("id",representanteNapne.getId());
        request.setAttribute("representante", representanteNapne);
        String select = request.getParameter("select");
        String buscar = request.getParameter("buscar");
        request.setAttribute("buscar",buscar);

        if (buscar==null || buscar == ""){
            tutorias = TutoriaDao.retornarTodasTutorias();
        }else {
            if (select.equals("todos")){
                tutorias = TutoriaDao.retornarTodasTutoriasGenerico(buscar);
            } else if (select.equals("matricula-tutor")) {
                tutorias = tutoriaDao.retornarTodasTutoriasMatriculaTutor(buscar);
            }
            else if (select.equals("matricula-tutorado")) {
                tutorias = tutoriaDao.retornarTodasTutoriasMatriculaTutorado(buscar);
            }
            else if (select.equals("nome-tutor")) {
                tutorias = tutoriaDao.retornarTodasTutoriasNomeTutor(buscar);
            }
            else if (select.equals("nome-tutorado")) {
                tutorias = tutoriaDao.retornarTodasTutoriasNomeTutorado(buscar);
            }
            else if (select.equals("nome-disciplina")) {
                tutorias = tutoriaDao.retornarTodasTutoriasNomeDisciplina(buscar);
            }
        }
        request.setAttribute("tutorias", tutorias);
        RequestDispatcher rd = request.getRequestDispatcher("buscarTutoria.jsp");
        rd.forward(request,response);

    }

    protected void irParaEdicao(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        representanteNapne.setId(id);
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
        request.setAttribute("id", representanteNapne.getId());
        request.setAttribute("senha",representanteNapne.getSenha());
        request.setAttribute("nome",representanteNapne.getNome());
        request.setAttribute("email", representanteNapne.getEmail());
        RequestDispatcher rd = request.getRequestDispatcher("edicaoNapne.jsp");
        rd.forward(request,response);
    }

    protected void atualizarDadosNapne(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        representanteNapne.setId(Integer.parseInt(request.getParameter("id")));
        representanteNapne.setSenha(request.getParameter("senha"));
        representanteNapne.setNome(request.getParameter("nome"));
        representanteNapne.setEmail(request.getParameter("email"));
        representanteNapneDao.editarRepresentanteNapne(representanteNapne);
        response.sendRedirect("voltarParaMainNapne?id="+representanteNapne.getId());
    }
    protected void menuDisciplina(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("representante", representanteNapne);
        RequestDispatcher rd = request.getRequestDispatcher("menuDisciplina.jsp");
        rd.forward(request,response);
    }
    protected void criarDisciplina(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Disciplina disciplina = new Disciplina();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        Professor professor = new Professor();

        disciplina.setNome(request.getParameter("nome-disciplina"));
        String codigoProfessorString = request.getParameter("codigo-professor");

        if (codigoProfessorString != null && !codigoProfessorString.isEmpty()) {
            professor.setId(Integer.parseInt(codigoProfessorString));
            disciplina.setProfessor(professor);
            if (usuarioDao.lerTipoUsuarioDisciplina(disciplina.getProfessor().getId())==1){
                disciplinaDao.cadastrarDisciplina(disciplina);
                String mensagem = "Disciplina Cadastrada com Sucesso.";
                request.setAttribute("mensagemErro", mensagem);

            } else {
                String mensagem = "Código de Professor está Incorreto.";
                request.setAttribute("mensagemErro", mensagem);
            }
        }else {
            disciplinaDao.cadastrarDisciplinaSemProfessor(disciplina);
            String mensagem = "Disciplina Cadastrada com Sucesso.";
            request.setAttribute("mensagemErro", mensagem);
        }

        request.setAttribute("representante", representanteNapne);

        RequestDispatcher rd = request.getRequestDispatcher("menuDisciplina.jsp");
        rd.forward(request,response);
    }
    protected void buscarDisciplina(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        String buscar = request.getParameter("disciplina-buscar");
        request.setAttribute("buscar",buscar);

        if (buscar == null || buscar == ""){
            disciplinas = disciplinaDao.retornarTodasDisciplinas();
        }else {
            disciplinas = disciplinaDao.retornarDisciplinas(request.getParameter("disciplina-buscar"));
        }

        request.setAttribute("representante", representanteNapne);
        request.setAttribute("disciplinas", disciplinas);

        RequestDispatcher rd = request.getRequestDispatcher("buscarDisciplina.jsp");
        rd.forward(request,response);
    }
    protected void deletarDisciplina(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinaDao.excluirDisciplina(Integer.parseInt(request.getParameter("codigo")));

        request.setAttribute("representante", representanteNapne);
        RequestDispatcher rd = request.getRequestDispatcher("menuDisciplina.jsp");
        rd.forward(request,response);
    }

    protected void irCriarTutoria(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        representanteNapne.setId(id);
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
        request.setAttribute("representante", representanteNapne);
        RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
        rd.forward(request,response);
    }
    protected void criarTutoria(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        representanteNapne.setId(id);
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
        request.setAttribute("representante", representanteNapne);
        Integer idTutor = definirIdDeTutor(request,response);
        Integer idTutorado = definirIdDeTutorado(request,response);
        Tutoria tutoria2 = new Tutoria();
        if(verificaSeDisciplinaExiste(request,response, disciplina))
        {
            if(usuarioDao.verificaSeUsuarioExiste(idTutor) && usuarioDao.verificaSeUsuarioExiste(idTutorado))
            {
                disciplina = disciplinaDao.retornarDisciplina(disciplina.getCodigo());
                tutoria2.setDisciplina(disciplina);
                tutoria2.setSenha(request.getParameter("senha"));

                if(idTutorado!=null)
                {
                    if(usuarioDao.lerTipoUsuarioDisciplina(idTutorado) != 3)
                    {
                        request.setAttribute("mensagem", "Coloque apenas ID de tutorado no campo do tutorado!");
                        RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
                        rd.forward(request, response);
                        return;
                    }
                    else
                    {
                        tutorado.setId(idTutorado);
                        tutoradoDao.selecionarTutorado(tutorado) ;
                        tutoria2.setTutorado(tutorado);
                    }
                }

                if(idTutor!=null)
                {
                    if(usuarioDao.lerTipoUsuarioDisciplina(idTutor) != 2)
                    {
                        request.setAttribute("mensagem", "Coloque apenas ID de tutor no compo do tutor!");
                        RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
                        rd.forward(request, response);
                        return;
                    }
                    else
                    {
                        tutor.setId(idTutor);
                        tutorDao.selecionarTutor(tutor) ;
                        tutoria2.setTutor(tutor);
                    }
                }

                tutoriaDao.criarTutoria(tutoria2);
                tutoriaDao.selecionaUltimaTutoria(tutoria2);
                request.setAttribute("mensagem", "sucesso");
                request.setAttribute("codigo", tutoria2.getCodigo());
                request.setAttribute("senha", tutoria2.getSenha());
                RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
                rd.forward(request, response);
            }
            else if(usuarioDao.verificaSeUsuarioExiste(idTutor) == false && usuarioDao.verificaSeUsuarioExiste(idTutorado) == true)
            {
                request.setAttribute("mensagem", "Tutor inserido não existe!");
                RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
                rd.forward(request, response);
                return;
            }
            else if(usuarioDao.verificaSeUsuarioExiste(idTutor) == true && usuarioDao.verificaSeUsuarioExiste(idTutorado) == false)
            {
                request.setAttribute("mensagem", "Tutorado inserido não existe!");
                RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
                rd.forward(request, response);
                return;
            }
            else
            {
                request.setAttribute("mensagem", "Tanto o tutor quando o tutorado inseridos não existem!");
                RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
                rd.forward(request, response);
                return;
            }
        }
        else
        {
            request.setAttribute("mensagem", "TUTORIA NÃO FOI CRIADA! DISCIPLINA NÃO ENCONTRADA");
            RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
            rd.forward(request, response);
        }

    }

    protected Integer definirIdDeTutor(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if(request.getParameter("idTutor") == null || request.getParameter("idTutor").isEmpty())
        {
            return null;
        }
        else
        {
            return Integer.parseInt(request.getParameter("idTutor"));
        }
    }

    protected Integer definirIdDeTutorado(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if(request.getParameter("idTutorado") == null || request.getParameter("idTutorado").isEmpty())
        {
            return null;
        }
        else
        {
            return Integer.parseInt(request.getParameter("idTutorado"));
        }
    }

    protected boolean verificaSeDisciplinaExiste(HttpServletRequest request, HttpServletResponse response, Disciplina disciplina) throws IOException
    {
        disciplina.setCodigo(Integer.parseInt(request.getParameter("idDisciplina")));
        if(disciplinaDao.lerDisciplina(disciplina))
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    protected void editarDisciplina(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        Disciplina disciplina = new Disciplina();
        disciplina = disciplinaDao.retornarDisciplina(Integer.parseInt(request.getParameter("codigo")));

        request.setAttribute("representante", representanteNapne);
        request.setAttribute("disciplina", disciplina);
        RequestDispatcher rd = request.getRequestDispatcher("editarDisciplina.jsp");
        rd.forward(request,response);
    }
    protected void editandoDisciplina(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        Disciplina disciplina = new Disciplina();
        Professor professor = new Professor();

        disciplina.setCodigo(Integer.parseInt(request.getParameter("codigo-disciplina")));
        disciplina.setNome(request.getParameter("nome-disciplina"));
        String codigoProfessorString = request.getParameter("id-professor");

        if (codigoProfessorString != null && !codigoProfessorString.isEmpty()) {
            professor.setId(Integer.parseInt(codigoProfessorString));
            disciplina.setProfessor(professor);
            if (usuarioDao.lerTipoUsuarioDisciplina(disciplina.getProfessor().getId())==1){
                disciplinaDao.editarDisciplina(disciplina);
                String mensagem = "Disciplina editada com Sucesso.";
                request.setAttribute("mensagemErro", mensagem);
            } else {
                String mensagem = "Código de Professor está Incorreto.";
                request.setAttribute("mensagemErro", mensagem);
            }
        }else {
            disciplinaDao.editarDisciplinaSemProfessor(disciplina);
            String mensagem = "Disciplina editada com Sucesso.";
            request.setAttribute("mensagemErro", mensagem);
        }

        request.setAttribute("representante", representanteNapne);
        RequestDispatcher rd = request.getRequestDispatcher("menuDisciplina.jsp");
        rd.forward(request,response);
    }
    protected void entrarTutoria(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TutoriaDao tutoriaDao = new TutoriaDao();
        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("tutoria", tutoria);
        request.setAttribute("representante", representanteNapne);

        RequestDispatcher rd = request.getRequestDispatcher("tutoriaNapne.jsp");
        rd.forward(request,response);
    }

    protected void irParaMetasNapne(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        representanteNapne.setId(id);
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
        request.setAttribute("representante", representanteNapne);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        metasDao.cadastraMetasNaTutoria(tutoria);

        for(Meta i: tutoria.getMetas())
        {
            mensagemDao.cadastrarMensagensNaMeta(i);
        }
        request.setAttribute("tutoria", tutoria);

        RequestDispatcher rd = request.getRequestDispatcher("metasNapne.jsp");
        rd.forward(request,response);
    }

    protected void criarMetaNapne(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Tutoria tutoria3 = new Tutoria();
        MetasDao metasDao2 = new MetasDao();

        int codigoTutoria = Integer.parseInt(request.getParameter("codigo"));
        String titulo = request.getParameter("nome-criar");

        metasDao2.criarMeta(codigoTutoria, titulo);

        tutoria3 = tutoriaDao.retornaTutoria(codigoTutoria);
        metasDao2.cadastraMetasNaTutoria(tutoria3);
        request.setAttribute("tutoria", tutoria3);
        

        representanteNapne.setId(id);
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
        request.setAttribute("representante", representanteNapne);


        response.sendRedirect("carregarMetasNapne?id=" + id + "&codigo=" + codigoTutoria);


    }

    protected void selecionaMeta(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        metas.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metasDao.selecionaMeta(metas);
        request.setAttribute("metas",  metas);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        metasDao.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        representanteNapne.setId(id);
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
        request.setAttribute("representante", representanteNapne);

        RequestDispatcher rd = request.getRequestDispatcher("editarMetasNapne.jsp");
        rd.forward(request,response);

    }

    protected void editarMeta(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {

        metas.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metas.setTitulo(request.getParameter("nome-criar"));

        metasDao.atualizarMeta(metas);

        response.sendRedirect("carregarMetasNapne?id="+id+"&codigo="+Integer.parseInt(request.getParameter("codigo")));
    }

    protected void deletarMeta(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        metas.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));

        mensagemDao.cadastrarMensagensNaMeta(metas);

        if(metas.getMensagens().isEmpty())
        {
            metasDao.excluirMeta(metas);
        }
        else
        {
            for(Mensagem i: metas.getMensagens())
            {
                mensagemDao.deletarMensagem(i);
            }
            metasDao.excluirMeta(metas);
        }

        response.sendRedirect("carregarMetasNapne?id="+id+"&codigo="+Integer.parseInt(request.getParameter("codigo")));
    }

    protected void irParaMensagensNapne(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Meta meta2 = new Meta();
        meta2.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metasDao.selecionaMeta(meta2);
        mensagemDao.cadastrarMensagensNaMeta(meta2);
        request.setAttribute("meta", meta2);

        representanteNapne.setId(id);
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
        request.setAttribute("representante", representanteNapne);

        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        metasDao.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        RequestDispatcher rd = request.getRequestDispatcher("mensagensNapne.jsp");
        rd.forward(request,response);
    }

    protected void enviarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        RepresentanteNapne representanteNapne = new RepresentanteNapne();
        representanteNapne.setId(id);
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);

        Mensagem mensagem2 = new Mensagem();
        String mensagem = request.getParameter("mensagemUsuario");
        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));

        mensagem2.setMsg(mensagem);
        mensagem2.setCodigoMeta(codigoMeta);
        mensagem2.setUsuario(representanteNapne);

        mensagemDao.criarMensagem(mensagem2);

        response.sendRedirect("carregarMensagensNapne?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
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

        representanteNapne.setId(id);
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
        request.setAttribute("representante", representanteNapne);

        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        mensagemDao.selecionaMensagem(mensagem);
        request.setAttribute("mensagem", mensagem);

        RequestDispatcher rd = request.getRequestDispatcher("editarMensagemNapne.jsp");
        rd.forward(request,response);
    }

    protected void editarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        mensagem.setCodigoMeta(Integer.parseInt(request.getParameter("codigoMensagem")));
        mensagem.setMsg(request.getParameter("mensagem"));
        mensagemDao.atualizarMensagem(mensagem);
        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));
        response.sendRedirect("carregarMensagensNapne?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }

    protected void deletarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        mensagemDao.deletarMensagem(mensagem);

        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));
        response.sendRedirect("carregarMensagensNapne?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }
    protected void telaAtendimentos(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        ArrayList<Atendimento> atendimentos = new ArrayList<>();
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentos = atendimentoDao.retornarAtendimentos(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("codigo",Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("representante", representanteNapne);
        request.setAttribute("atendimentos",atendimentos);
        RequestDispatcher rd = request.getRequestDispatcher("atendimentoNapne.jsp");
        rd.forward(request,response);
    }
    protected void gerarRelatorioUnitario(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Atendimento atendimento = new Atendimento();
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimento = atendimentoDao.retornarAtendimentoUnico(Integer.parseInt(request.getParameter("id")));
        Document document = new Document();
        try{
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition","inline;filename="+"Relatório.pdf");
            PdfWriter.getInstance(document,response.getOutputStream());
            document.open();
            document.addTitle("Relatório Tutoria de Pares");
            document.addAuthor("Sistema Tutória de Pares");
            document.addKeywords("Java, IText , Project, Tutoria de Pares");
            document.addSubject("add/edit document");
            document.addCreator("Rodrigo Costa e Samuel Araújo");
            ServletContext context = getServletContext();
            String imagePath = context.getRealPath("/imagens/pdf/brasao.png");
            Image imagem = Image.getInstance(imagePath);
            imagem.setAlignment(Element.ALIGN_MIDDLE);
            imagem.scaleToFit(70, 70);
            document.add(imagem);
            Paragraph institutoParagrafo = new Paragraph("INSTITUTO FEDERAL DE EDUCAÇÃO, CIÊNCIA E TECNOLOGIA BAIANO.");
            institutoParagrafo.setAlignment(Element.ALIGN_CENTER);
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 19, BaseColor.BLACK);
            institutoParagrafo.setFont(font);
            document.add(institutoParagrafo);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            Paragraph titulo = new Paragraph("RELATÓRIO DE AVALIAÇÃO SEMANAL DO NAPNE:");
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setFont(font);
            titulo.setSpacingAfter(13f);
            document.add(titulo);
            PdfPTable tabela = new PdfPTable(1);
            Font fontCelula = FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, BaseColor.BLACK);
            PdfPCell cell1 = new PdfPCell(new Phrase("Disciplina: "+tutoria.getDisciplina().getNome(),fontCelula));
            cell1.setMinimumHeight(20f);
            tabela.addCell(cell1);
            PdfPCell cell2 = new PdfPCell(new Phrase("Data: "+atendimento.getData(),fontCelula));
            cell2.setMinimumHeight(20f);
            tabela.addCell(cell2);
            PdfPCell cell3 = new PdfPCell(new Phrase("Tutor: "+tutoria.getTutor().getNome(),fontCelula));
            cell3.setMinimumHeight(20f);
            tabela.addCell(cell3);
            PdfPCell cell4 = new PdfPCell(new Phrase("Tutorado: "+tutoria.getTutorado().getNome(),fontCelula));
            cell4.setMinimumHeight(20f);
            tabela.addCell(cell4);
            PdfPCell cell5 = new PdfPCell(new Phrase("Docente: "+tutoria.getDisciplina().getProfessor().getNome(),fontCelula));
            cell5.setMinimumHeight(20f);
            tabela.addCell(cell5);
            PdfPCell cell6 = new PdfPCell(new Phrase("Conteúdo Tratado: "+atendimento.getConteudo(),fontCelula));
            cell6.setMinimumHeight(20f);
            tabela.addCell(cell6);
            document.add(tabela);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            Font fonte14 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14);
            Paragraph discursoParagraph = new Paragraph();
            discursoParagraph.add(new Phrase("Eu, "+representanteNapne.getNome()+", declaro que o Tutor "+tutoria.getTutor().getNome() +" cumpriu a atividade semanal com carga horária de "+ atendimento.getCargaHoraria() +" hora(s), realizando todas as atividades planejadas.", fonte14));
            discursoParagraph.add(Chunk.NEWLINE);
            discursoParagraph.setAlignment(Element.ALIGN_JUSTIFIED);
            discursoParagraph.setIndentationLeft(70f);
            discursoParagraph.setIndentationRight(70f);
            document.add(discursoParagraph);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataAtual = sdf.format(new Date());
            Font fontecidade = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, BaseColor.BLACK);
            Paragraph cidadeDataParagraph = new Paragraph("Guanambi - Bahia, "+ dataAtual+ ".",fontecidade);
            cidadeDataParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(cidadeDataParagraph);
            document.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    protected void gerarRelatorioFinal(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {

        ArrayList<Atendimento> atendimentos = new ArrayList<>();
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentos = atendimentoDao.retornarAtendimentos(Integer.parseInt(request.getParameter("codigo")));
        Document document = new Document();
        try{
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition","inline;filename="+"Relatório.pdf");
            PdfWriter.getInstance(document,response.getOutputStream());
            document.open();
            document.addTitle("Relatório Tutoria de Pares");
            document.addAuthor("Sistema Tutória de Pares");
            document.addKeywords("Java, IText , Project, Tutoria de Pares");
            document.addSubject("add/edit document");
            document.addCreator("Rodrigo Costa e Samuel Araújo");
            ServletContext context = getServletContext();
            String imagePath = context.getRealPath("/imagens/pdf/brasao.png");
            Image imagem = Image.getInstance(imagePath);
            imagem.setAlignment(Element.ALIGN_MIDDLE);
            imagem.scaleToFit(70, 70);
            document.add(imagem);
            Paragraph institutoParagrafo = new Paragraph("INSTITUTO FEDERAL DE EDUCAÇÃO, CIÊNCIA E TECNOLOGIA BAIANO.");
            institutoParagrafo.setAlignment(Element.ALIGN_CENTER);
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 19, BaseColor.BLACK);
            institutoParagrafo.setFont(font);
            document.add(institutoParagrafo);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            Paragraph titulo = new Paragraph("RELATÓRIO DE TODOS ATENDIMENTOS DA TUTORIA:");
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setFont(font);
            titulo.setSpacingAfter(13f);
            document.add(titulo);
            PdfPTable tabela = new PdfPTable(1);
            Font fontCelula = FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, BaseColor.BLACK);
            PdfPCell cell1 = new PdfPCell(new Phrase("Disciplina: "+tutoria.getDisciplina().getNome(),fontCelula));
            cell1.setMinimumHeight(20f);
            tabela.addCell(cell1);
            PdfPCell cell3 = new PdfPCell(new Phrase("Tutor: "+tutoria.getTutor().getNome(),fontCelula));
            cell3.setMinimumHeight(20f);
            tabela.addCell(cell3);
            PdfPCell cell4 = new PdfPCell(new Phrase("Tutorado: "+tutoria.getTutorado().getNome(),fontCelula));
            cell4.setMinimumHeight(20f);
            tabela.addCell(cell4);
            PdfPCell cell5 = new PdfPCell(new Phrase("Docente: "+tutoria.getDisciplina().getProfessor().getNome(),fontCelula));
            cell5.setMinimumHeight(20f);
            tabela.addCell(cell5);
            document.add(tabela);
            document.add(Chunk.NEWLINE);
            PdfPTable tabela2 = new PdfPTable(3);
            Font fonteNegrito = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            tabela2.addCell(new Phrase("Conteúdo", fonteNegrito));
            tabela2.addCell(new Phrase("Carga Horária (Horas)", fonteNegrito));
            tabela2.addCell(new Phrase("Dias", fonteNegrito));
            int totalDeHoras=0;
            int totalDeDias=0;
            for (int i=0; i<atendimentos.size(); i++){
                tabela2.addCell(atendimentos.get(i).getConteudo());
                tabela2.addCell(Integer.toString(atendimentos.get(i).getCargaHoraria()));
                tabela2.addCell(atendimentos.get(i).getData());
                totalDeHoras+=atendimentos.get(i).getCargaHoraria();
                totalDeDias++;
            }
            tabela2.addCell(new Phrase("Total", fonteNegrito));
            tabela2.addCell(Integer.toString(totalDeHoras));
            tabela2.addCell(Integer.toString(totalDeDias));
            document.add(tabela2);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            Font fonte14 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14);
            Paragraph discursoParagraph = new Paragraph();
            discursoParagraph.add(new Phrase("Eu, "+representanteNapne.getNome()+", declaro que esse documento é oficial.", fonte14));
            discursoParagraph.add(Chunk.NEWLINE);
            discursoParagraph.setAlignment(Element.ALIGN_CENTER);
            discursoParagraph.setIndentationLeft(70f);
            discursoParagraph.setIndentationRight(70f);
            document.add(discursoParagraph);
            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataAtual = sdf.format(new Date());
            Font fontecidade = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, BaseColor.BLACK);
            Paragraph cidadeDataParagraph = new Paragraph("Guanambi - Bahia, "+ dataAtual+ ".",fontecidade);
            cidadeDataParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(cidadeDataParagraph);
            document.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    protected void editarTutoria(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        TutoriaDao tutoriaDao = new TutoriaDao();
        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        request.setAttribute("tutoria", tutoria);
        request.setAttribute("representante", representanteNapne);

        RequestDispatcher rd = request.getRequestDispatcher("editarTutoriaNapne.jsp");
        rd.forward(request,response);
    }

    protected void realizarEdicaoTutoria(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        TutoriaDao tutoriaDao = new TutoriaDao();
        tutoria = tutoriaDao.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));

        Integer idTutor = definirIdDeTutor(request,response);
        Integer idTutorado = definirIdDeTutorado(request,response);

        if(usuarioDao.verificaSeUsuarioExiste(idTutor) && usuarioDao.verificaSeUsuarioExiste(idTutorado))
        {

            if(idTutorado!=null)
            {
                if(usuarioDao.lerTipoUsuarioDisciplina(idTutorado) != 3)
                {
                    request.setAttribute("mensagem", "Coloque apenas ID de tutorado no campo do tutorado!");
                    request.setAttribute("tutoria", tutoria);
                    request.setAttribute("representante", representanteNapne);
                    RequestDispatcher rd = request.getRequestDispatcher("editarTutoriaNapne.jsp");
                    rd.forward(request,response);
                    return;
                }
            }

            if(idTutor!=null)
            {
                if(usuarioDao.lerTipoUsuarioDisciplina(idTutor) != 2)
                {
                    request.setAttribute("mensagem", "Coloque apenas ID de tutor no compo do tutor!");
                    request.setAttribute("tutoria", tutoria);
                    request.setAttribute("representante", representanteNapne);
                    RequestDispatcher rd = request.getRequestDispatcher("editarTutoriaNapne.jsp");
                    return;
                }
            }
            tutorado.setId(idTutorado);
            tutoradoDao.selecionarTutorado(tutorado) ;
            tutoria.setTutorado(tutorado);
            tutor.setId(idTutor);
            tutorDao.selecionarTutor(tutor) ;
            tutoria.setTutor(tutor);
            tutoria.setSenha(request.getParameter("senha"));
            tutoriaDao.editarTutoria(tutoria);
            request.setAttribute("tutoria", tutoria);
            request.setAttribute("representante", representanteNapne);
            RequestDispatcher rd = request.getRequestDispatcher("tutoriaNapne.jsp");
            rd.forward(request,response);

        }
        else if(usuarioDao.verificaSeUsuarioExiste(idTutor) == false && usuarioDao.verificaSeUsuarioExiste(idTutorado) == true)
        {
            request.setAttribute("mensagem", "Tutor inserido não existe!");
            request.setAttribute("tutoria", tutoria);
            request.setAttribute("representante", representanteNapne);
            RequestDispatcher rd = request.getRequestDispatcher("editarTutoriaNapne.jsp");
            rd.forward(request, response);
            return;
        }
        else if(usuarioDao.verificaSeUsuarioExiste(idTutor) == true && usuarioDao.verificaSeUsuarioExiste(idTutorado) == false)
        {
            request.setAttribute("mensagem", "Tutorado inserido não existe!");
            request.setAttribute("tutoria", tutoria);
            request.setAttribute("representante", representanteNapne);
            RequestDispatcher rd = request.getRequestDispatcher("editarTutoriaNapne.jsp");
            rd.forward(request, response);
            return;
        }
        else
        {
            request.setAttribute("mensagem", "Tanto o tutor quando o tutorado inseridos não existem!");
            request.setAttribute("tutoria", tutoria);
            request.setAttribute("representante", representanteNapne);
            RequestDispatcher rd = request.getRequestDispatcher("editarTutoriaNapne.jsp");
            rd.forward(request, response);
            return;
        }

    }

    protected void irCriarAtendimentoNapne(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        request.setAttribute("tutoria", tutoria);
        request.setAttribute("representante", representanteNapne);
        RequestDispatcher rd = request.getRequestDispatcher("criarAtendimentoNapne.jsp");
        rd.forward(request, response);
    }

    protected void criarAtendimentoNapne(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Atendimento atendimento = new Atendimento();
        AtendimentoDao atendimentoDao = new AtendimentoDao();

        atendimento.setData(request.getParameter("date"));
        atendimento.setHorario(request.getParameter("horario"));
        atendimento.setCargaHoraria(Integer.parseInt(request.getParameter("cargaHoraria")));
        atendimento.setLocal(request.getParameter("local"));
        atendimento.setConteudo(request.getParameter("conteudoTratado"));

        atendimentoDao.criarAtendimento(atendimento, Integer.parseInt(request.getParameter("codigo")));
        int id_atendimento = atendimentoDao.retornaUltimoIdAtendimento();
        atendimento.setId(id_atendimento);

        response.sendRedirect("carregarAtendimentosNapne?id=" + id + "&codigo=" + Integer.parseInt(request.getParameter("codigo")));
    }

    protected void deletarAtendimentoNapne(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Atendimento atendimento = new Atendimento();
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimento.setId(Integer.parseInt(request.getParameter("idAtendimento")));
        atendimentoDao.deletarAtendimento(atendimento);

        response.sendRedirect("carregarAtendimentosNapne?id=" + id + "&codigo=" + Integer.parseInt(request.getParameter("codigoTutoria")));
    }


}
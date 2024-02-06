package main.controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.dao.DisciplinaDao;
import main.dao.RepresentanteNapneDao;
import main.dao.TutoriaDao;
import main.dao.UsuarioDao;
import main.dao.TutorDao;
import main.dao.TutoradoDao;
import main.model.Disciplina;
import main.model.Professor;
import main.model.RepresentanteNapne;
import main.model.Tutoria;
import main.model.Tutor;
import main.model.Tutorado;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/napnehome","/cadastrarnapne","/telacadastronapne","/buscartutoria", "/edicaoNapne","/realizarEdicaoDoNapne", "/voltarParaMainNapne", "/menudisciplinas", "/criardisciplina", "/buscardisciplina", "/deletardisciplina", "/irCriarTutoria", "/criarTutoria", "/editarDisciplina", "/editandoDisciplina"})
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
        else if (action.equals("/criardisciplina"))
        {
            criarDisciplina(request,response);
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

        int idTutor = definirIdDeTutor(request,response);
        int idTutorado = definirIdDeTutorado(request,response);
        Tutoria tutoria2 = new Tutoria();
        if(verificaSeDisciplinaExiste(request,response, disciplina))
        {
            disciplina = disciplinaDao.retornarDisciplina(disciplina.getCodigo());
            tutoria2.setDisciplina(disciplina);
            tutoria2.setSenha(request.getParameter("senha"));

            if(idTutorado!=0)
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

            if(idTutor!=0)
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
            request.setAttribute("mensagem", "TUTORIA CRIADA COM SUCESSO!");
            RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
            rd.forward(request, response);
        }
        else
        {
            request.setAttribute("mensagem", "TUTORIA NÃO FOI CRIADA! DISCIPLINA NÃO ENCONTRADA");
            RequestDispatcher rd = request.getRequestDispatcher("criarTutoria.jsp");
            rd.forward(request, response);
        }

    }

    protected int definirIdDeTutor(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if(request.getParameter("idTutor") == null || request.getParameter("idTutor").isEmpty())
        {
            return 0;
        }
        else
        {
            return Integer.parseInt(request.getParameter("idTutor"));
        }
    }

    protected int definirIdDeTutorado(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if(request.getParameter("idTutorado") == null || request.getParameter("idTutorado").isEmpty())
        {
            return 0;
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
}
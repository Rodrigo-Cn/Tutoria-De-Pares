package main.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.dao.RepresentanteNapneDao;
import main.dao.TutoriaDao;
import main.model.RepresentanteNapne;
import main.model.Tutoria;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/napnehome","/cadastrarnapne","/telacadastronapne","/buscartutoria"})
public class RepresentanteNapneControl extends HttpServlet {
    RepresentanteNapne representanteNapne = new RepresentanteNapne();
    RepresentanteNapneDao representanteNapneDao = new RepresentanteNapneDao();
    TutoriaDao tutoriaDao = new TutoriaDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getServletPath();
        int id = Integer.parseInt(request.getParameter("id"));

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
        else {
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
}
package main.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.dao.ProfessorDao;
import main.dao.TutorDao;
import main.dao.TutoradoDao;
import main.model.Professor;
import main.model.Tutor;
import main.model.Tutorado;

import java.io.IOException;

@WebServlet(urlPatterns = {"/main","/cadastrar"})
public class CadastrarControl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    Professor professor = new Professor();
    Tutor tutor = new Tutor();
    Tutorado tutorado = new Tutorado();
    ProfessorDao professorDao = new ProfessorDao();
    TutorDao tutorDao = new TutorDao();
    TutoradoDao tutoradoDao = new TutoradoDao();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String action = request.getServletPath();
        if (action.equals("/cadastrar")){
            realizarCadastro(request,response);
        }else {
            response.sendRedirect("cadastrar.html");
        }
    }
    protected void realizarCadastro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipoDeUsuario = request.getParameter("ocupacao");

        if (tipoDeUsuario.equals("professor")){

            professor.cadastrar(request.getParameter("nome"),request.getParameter("email"),request.getParameter("senha"));
            professorDao.cadastrarProfessor(professor);
            response.sendRedirect("cadastrar.html");

        }else {

            String tipoDeAluno = request.getParameter("select");

            if (tipoDeAluno.equals("tutor")){

                tutor.cadastrar(request.getParameter("nome"),request.getParameter("email"),request.getParameter("senha"),request.getParameter("matricula"));
                tutorDao.cadastrarTutor(tutor);
                response.sendRedirect("cadastrar.html");

            }else {

                tutorado.cadastrar(request.getParameter("nome"),request.getParameter("email"),request.getParameter("senha"),request.getParameter("matricula"));
                tutoradoDao.cadastrarTutorado(tutorado);
                response.sendRedirect("cadastrar.html");

            }
        }
    }
}

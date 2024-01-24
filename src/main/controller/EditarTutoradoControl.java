package main.controller;

import main.dao.TutoradoDao;
import main.dao.UsuarioDao;
import main.model.Tutorado;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/realizarEdicaoDoTutorado", "/voltarParaMainTutorado"})
public class EditarTutoradoControl extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static TutoradoDao tutoradoDao = new TutoradoDao();
    Tutorado tutorado = new Tutorado();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String action = request.getServletPath();
        int id = Integer.parseInt(request.getParameter("id"));

        if (action.equals("/realizarEdicaoDoTutorado"))
        {
            atualizarDados(request,response);
        }
        else
        {
            response.sendRedirect("tutoradohome?id="+id);

        }

    }

    protected void atualizarDados(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        tutorado.setId(Integer.parseInt(request.getParameter("id")));
        tutorado.setSenha(request.getParameter("senha"));
        tutorado.setNome(request.getParameter("nome"));
        tutorado.setEmail(request.getParameter("email"));
        tutorado.setCurso(request.getParameter("curso"));
        tutorado.setSemestre(Integer.parseInt(request.getParameter("semestre")));
        tutorado.setTipoDeDeficiencia(request.getParameter("deficiencia"));
        tutorado.setMatricula(request.getParameter("matricula"));
        tutoradoDao.editarTutorado(tutorado);
        response.sendRedirect("voltarParaMainTutor?id="+tutorado.getId());
    }

}

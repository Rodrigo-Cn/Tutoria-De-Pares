package main.controller;

import main.dao.UsuarioDao;
import main.model.Professor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static UsuarioDao usuarioDao = new UsuarioDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String action = request.getServletPath();
        if (action.equals("/login"))
        {
            realizarLogin(request,response);
        }
        else
        {
            response.sendRedirect("login.html");
        }
    }

    protected void realizarLogin(HttpServletRequest request, HttpServletResponse response) throws IOException
    {

       if( usuarioDao.lerUsuario(request.getParameter("email"), request.getParameter("senha")) == null)
        {
            response.getWriter().write("<script>alert('Credenciais inválidas. Verifique seu email e senha.'); window.location='login.jsp';</script>");
        }
        else if(usuarioDao.lerUsuario(request.getParameter("email"), request.getParameter("senha")) instanceof Professor)
        {
            response.getWriter().write("<script>alert('Login bem-sucedido como professor.');</script>");
            //response.sendRedirect("/telaProfessor");
        }
        else
        {
            response.getWriter().write("<script>alert('Login bem-sucedido como aluno.');</script>");
            //response.sendReirect("/telaAluno");
        }
    }
}

package main.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.dao.UsuarioDao;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static UsuarioDao usuarioDao = new UsuarioDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String action = request.getServletPath();
        if (action.equals("/login"))
        {
            realizarLogin(request,response);
        }else {
            response.sendRedirect("login.jsp");
        }
    }

    protected void realizarLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        int tipoDeUsuario = usuarioDao.lerTipoUsuario(request.getParameter("email"), request.getParameter("senha"));
       if(tipoDeUsuario  == 0)
        {
            request.setAttribute("erroLogin", "Credenciais inválidas!");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return;
        }
        else
        {
            if(tipoDeUsuario ==1){
                response.sendRedirect("professorhome?id="+usuarioDao.lerIdUsuario(request.getParameter("email"), request.getParameter("senha")));
            } else if (tipoDeUsuario == 2) {
                response.sendRedirect("tutorhome?id="+usuarioDao.lerIdUsuario(request.getParameter("email"), request.getParameter("senha")));
            }
            else if (tipoDeUsuario == 3) {
                response.sendRedirect("tutoradohome?id="+usuarioDao.lerIdUsuario(request.getParameter("email"), request.getParameter("senha")));
            }else {
                response.sendRedirect("napnehome?id="+usuarioDao.lerIdUsuario(request.getParameter("email"), request.getParameter("senha")));
            }
        }
    }
}

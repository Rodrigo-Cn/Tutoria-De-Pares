package main.controller;


import jakarta.servlet.RequestDispatcher;
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

@WebServlet(urlPatterns = {"/tutoradohome", "/edicaoTutorado", "/loginTutoriaTutorado","/realizarEdicaoDoTutorado", "/voltarParaMainTutorado", "/entrarTutoriaTutorado"})
public class TutoradoControl extends HttpServlet {
    Tutorado tutorado = new Tutorado();
    ArrayList<Tutoria> tutorias = new ArrayList<>();
    TutoradoDao tutoradoDao = new TutoradoDao();
    private static TutoriaDao tutoriaDao = new TutoriaDao();
    private static Tutoria tutoria = new Tutoria();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        int id = Integer.parseInt(request.getParameter("id"));


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
        tutoradoDao.editarTutorado(tutorado);
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
}

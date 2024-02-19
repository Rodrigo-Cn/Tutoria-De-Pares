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
import main.dao.TutorDao;
import main.dao.TutoriaDao;
import main.model.Meta;
import main.model.Tutor;
import main.model.Tutoria;
import main.model.*;
import main.dao.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(urlPatterns = {"/tutorhome", "/edicaoTutor", "/loginTutoriaTutor", "/realizarEdicaoDoTutor", "/voltarParaMainTutor", "/entrarTutoriaTutor", "/criarMetaTutor", "/carregarMetasTutor", "/carregarMensagensTutor", "/enviarMensagemTutor", "/selecionaMensagemTutor", "/editarMensagemTutor", "/deletarMensagemTutor", "/carregarAtendimentosTutor","/gerarRelatorioFinalTutor", "/irCriarAtendimentoTutor", "/criarAtendimentoTutor"})
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
        else if(action.equals("/carregarAtendimentosTutor"))
        {
            telaAtendimentos(request,response, id);
        }
        else if(action.equals("/gerarRelatorioFinalTutor")) {
            gerarRelatorioFinal(request,response, id);
        }
        else if(action.equals("/irCriarAtendimentoTutor"))
        {
            irCriarAtendimento(request,response, id);
        }
        else if(action.equals("/criarAtendimentoTutor")) {
            criarAtendimento(request,response, id);
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
        Tutor tutor = new Tutor();
        tutor.setId(id);
        tutorDao.selecionarTutor(tutor);

        Mensagem mensagem2 = new Mensagem();
        String mensagem = request.getParameter("mensagemUsuario");
        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));

        mensagem2.setMsg(mensagem);
        mensagem2.setCodigoMeta(codigoMeta);
        mensagem2.setUsuario(tutor);

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
    protected void telaAtendimentos(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        ArrayList<Atendimento> atendimentos = new ArrayList<>();
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentos = atendimentoDao.retornarAtendimentos(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("codigo",Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("tutor", tutor);
        request.setAttribute("atendimentos",atendimentos);
        RequestDispatcher rd = request.getRequestDispatcher("atendimentoTutor.jsp");
        rd.forward(request,response);
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
            discursoParagraph.add(new Phrase("Documento não oficial, usado apenas como meio de vizualização.", fonte14));
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
        request.setAttribute("tutor", tutor);

        response.sendRedirect("carregarMetasTutor?id=" + id + "&codigo=" + codigoTutoria);
    }

    protected void irCriarAtendimento(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        request.setAttribute("tutoria", tutoria);
        request.setAttribute("tutor", tutor);
        RequestDispatcher rd = request.getRequestDispatcher("criarAtendimentoTutor.jsp");
        rd.forward(request, response);
    }

    protected void criarAtendimento(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
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

        response.sendRedirect("carregarAtendimentosTutor?id=" + id + "&codigo=" + Integer.parseInt(request.getParameter("codigo")));
    }

}
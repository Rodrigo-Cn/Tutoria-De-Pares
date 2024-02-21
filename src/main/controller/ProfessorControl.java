package main.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.ServletContext;
import main.dao.*;
import main.model.Disciplina;
import main.model.Meta;
import main.model.Professor;
import main.model.Tutoria;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import main.model.*;

@WebServlet(urlPatterns = {"/professorhome", "/loginTutoriaProfessor", "/voltarParaMainProfessor", "/realizarEdicaoDoProfessor", "/edicaoProfessor", "/entrarTutoriaProfessor", "/carregarMetasProfessor", "/criarMetaProfessor", "/selecionaMetaProfessor", "/editarMetaProfessor", "/deletarMetaProfessor", "/carregarMensagensProfessor", "/enviarMensagemProfessor", "/selecionaMensagemProfessor", "/editarMensagemProfessor", "/deletarMensagemProfessor", "/carregarAtendimentosProfessor", "/gerarRelatorioUnitarioProfessor", "/gerarRelatorioFinalProfessor", "/irCriarAtendimentoProfessor", "/criarAtendimentoProfessor", "/deletarAtendimentoProfessor", "/editandoAtendimentoProfessor", "/editarAtendimentoProfessor"})
public class ProfessorControl extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static Professor professor = new Professor();
    private static ProfessorDao professorDao = new ProfessorDao();
    private static ArrayList<Tutoria> tutorias = new ArrayList<>();
    private static TutoriaDao tutoriaDao = new TutoriaDao();
    private static Tutoria tutoria = new Tutoria();
    private static DisciplinaDao disciplinaDao = new DisciplinaDao();
    private static Disciplina disciplina = new Disciplina();
    private static MetasDao metasDao = new MetasDao();
    private static Meta metas = new Meta();
    private static MensagemDao mensagemDao = new MensagemDao();
    private static Mensagem mensagem = new Mensagem();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getServletPath();
        String idParameter = request.getParameter("id");
        int id;

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                id = Integer.parseInt(idParameter);
            } catch (NumberFormatException e) {
                id = professor.getId();
            }
        } else {
            id =  professor.getId();
        }

        if(action.equals("/professorhome"))
        {
            iniciarHome(request,response,id);
        }
        else if(action.equals("/loginTutoriaProfessor"))
        {
            verificarTutoriaProfessor(request, response, id);
        }
        else if(action.equals("/voltarParaMainProfessor"))
        {
            response.sendRedirect("professorhome?id="+id);
        }
        else if(action.equals("/edicaoProfessor"))
        {
            irParaEdicao(request, response, id);
        }
        else if(action.equals(("/entrarTutoriaProfessor")))
        {
            irParaTutoriaProfessor(request,response,id);
        }
        else if(action.equals("/carregarMetasProfessor"))
        {
            irParaMetasProfessor(request,response,id);
        }
        else if(action.equals("/selecionaMetaProfessor"))
        {
            selecionaMeta(request,response, id);
        }
        else if(action.equals("/deletarMetaProfessor"))
        {
            deletarMeta(request,response, id);
        }
        else if(action.equals("/carregarMensagensProfessor"))
        {
            irParaMensagensProfessor(request,response, id);
        }
        else if(action.equals("/selecionaMensagemProfessor"))
        {
            selecionaMensagem(request,response, id);
        }
        else if(action.equals("/editarMensagemProfessor"))
        {
            editarMensagem(request,response, id);
        }
        else if(action.equals("/deletarMensagemProfessor"))
        {
            deletarMensagem(request,response, id);
        }
        else if(action.equals("/carregarAtendimentosProfessor"))
        {
            telaAtendimentos(request,response, id);
        }
        else if(action.equals("/gerarRelatorioUnitarioProfessor")) {
            gerarRelatorioUnitario(request,response);
        }
        else if(action.equals("/gerarRelatorioFinalProfessor")) {
            gerarRelatorioFinal(request,response, id);
        }
        else if(action.equals("/irCriarAtendimentoProfessor")) {
            irCriarAtendimento(request,response, id);
        }
        else if(action.equals("/criarAtendimentoProfessor")) {
            criarAtendimento(request,response, id);
        }
        else if(action.equals("/deletarAtendimentoProfessor")) {
            deletarAtendimento(request,response, id);
        }
        else if(action.equals("/editandoAtendimentoProfessor")) {
            editandoAtendimento(request,response);
        }
        else
        {
            response.sendRedirect("login.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        String idParameter = request.getParameter("id");
        int id;

        if (idParameter != null && !idParameter.isEmpty()) {
            try {
                id = Integer.parseInt(idParameter);
            } catch (NumberFormatException e) {
                id = professor.getId();
            }
        } else {
            id =  professor.getId();
        }

        if(action.equals("/editarAtendimentoProfessor"))
        {
            editarAtendimento(request,response);
        }
        else if(action.equals("/realizarEdicaoDoProfessor"))
        {
            atualizarDadosProfessor(request,response, id);
        }
        else if(action.equals("/criarMetaProfessor"))
        {
            criarMetaProfessor(request,response, id);
        }
        else if(action.equals("/editarMetaProfessor"))
        {
            editarMeta(request,response, id);
        }
        else if(action.equals("/enviarMensagemProfessor"))
        {
            enviarMensagem(request,response, id);
        }
    }

    protected void iniciarHome(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        request.setAttribute("id",id);
        professor = professor.retornarProfessor(id);
        tutorias = professor.retornarTutoriaParaProfessor(id);
        request.setAttribute("professor", professor);
        request.setAttribute("tutorias", tutorias);
        RequestDispatcher rd = request.getRequestDispatcher("professorhome.jsp");
        rd.forward(request,response);
    }

    protected void verificarTutoriaProfessor(HttpServletRequest req, HttpServletResponse resp, int id) throws ServletException, IOException
    {
        disciplina.setCodigo(Integer.parseInt(req.getParameter("codigo")));

        if(professor.lerDisciplina(disciplina))
        {
            professor.atualizarDisciplinaProfessor(disciplina, id);
            resp.sendRedirect("voltarParaMainProfessor?id="+id);
        }
        else
        {
            resp.getWriter().write("<script>alert('Disciplina não encontrada!'); window.location='tutoradohome?id=" + id + "';</script>");
        }
    }

    protected void irParaEdicao(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        professor.setId(id);
        professor.selecionarProfessor(professor);
        request.setAttribute("id", professor.getId());
        request.setAttribute("senha",professor.getSenha());
        request.setAttribute("nome",professor.getNome());
        request.setAttribute("email",professor.getEmail());
        request.setAttribute("professor", professor);
        RequestDispatcher rd = request.getRequestDispatcher("edicaoProfessor.jsp");
        rd.forward(request,response);
    }
    protected void atualizarDadosProfessor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        professor.setId(Integer.parseInt(request.getParameter("id")));
        professor.setSenha(request.getParameter("senha"));
        professor.setNome(request.getParameter("nome"));
        professor.setEmail(request.getParameter("email"));
        professor.editarProfessor(professor);

        response.sendRedirect("voltarParaMainProfessor?id="+id);
    }

    protected void irParaTutoriaProfessor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        tutoria = professor.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("tutoria", tutoria);
        request.setAttribute("professor", professor);
        RequestDispatcher rd = request.getRequestDispatcher("tutoriaProfessor.jsp");
        rd.forward(request,response);
    }

    protected void irParaMetasProfessor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        professor.setId(id);
        professor.selecionarProfessor(professor);
        request.setAttribute("professor", professor);

        tutoria = professor.retornaTutoria(Integer.parseInt(request.getParameter("codigo")));
        professor.cadastraMetasNaTutoria(tutoria);

        for(Meta i: tutoria.getMetas())
        {
            professor.cadastrarMensagensNaMeta(i);
        }
        request.setAttribute("tutoria", tutoria);

        RequestDispatcher rd = request.getRequestDispatcher("metasProfessor.jsp");
        rd.forward(request,response);
    }

    protected void criarMetaProfessor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        int codigoTutoria = Integer.parseInt(request.getParameter("codigo"));
        String titulo = request.getParameter("nome-criar");
        professor.criarMeta(codigoTutoria, titulo);

        tutoria = professor.retornaTutoria(codigoTutoria);
        professor.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        professor.setId(id);
        professor.selecionarProfessor(professor);
        request.setAttribute("professor", professor);

        response.sendRedirect("carregarMetasProfessor?id=" + id + "&codigo=" + codigoTutoria);
    }

    protected void selecionaMeta(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        metas.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        professor.selecionaMeta(metas);
        request.setAttribute("metas",  metas);

        tutoria = professor.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        professor.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        professor.setId(id);
        professor.selecionarProfessor(professor);
        request.setAttribute("professor", professor);

        RequestDispatcher rd = request.getRequestDispatcher("editarMetasProfessor.jsp");
        rd.forward(request,response);

    }

    protected void editarMeta(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {

        metas.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        metas.setTitulo(request.getParameter("nome-criar"));

        professor.atualizarMeta(metas);

        response.sendRedirect("carregarMetasProfessor?id="+id+"&codigo="+Integer.parseInt(request.getParameter("codigo")));
    }

    protected void deletarMeta(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        //AQUI AO DELETAR UMA META, É NECESSÁIO APAGAR TODAS AS MENSAGENS QUE ESTÃO NELE ANTES. POR ISSO A CONDIÇÃO E O LAÇODE REPETIÇÃO
        metas.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        professor.cadastrarMensagensNaMeta(metas);

        if(metas.getMensagens().isEmpty())
        {
            professor.excluirMeta(metas);
        }
        else
        {
            for(Mensagem i: metas.getMensagens())
            {
                professor.deletarMensagem(i);
            }
            professor.excluirMeta(metas);
        }
        response.sendRedirect("carregarMetasProfessor?id="+id+"&codigo="+Integer.parseInt(request.getParameter("codigo")));
    }
    protected void irParaMensagensProfessor(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Meta meta2 = new Meta();
        meta2.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        professor.selecionaMeta(meta2);
        professor.cadastrarMensagensNaMeta(meta2);
        request.setAttribute("meta", meta2);

        professor.setId(id);
        professor.selecionarProfessor(professor);
        request.setAttribute("professor", professor);

        tutoria = professor.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        professor.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        RequestDispatcher rd = request.getRequestDispatcher("mensagensProfessor.jsp");
        rd.forward(request,response);
    }

    protected void enviarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Professor professor = new Professor();
        professor.setId(id);
        professor.selecionarProfessor(professor);

        Mensagem mensagem2 = new Mensagem();
        String mensagem = request.getParameter("mensagemUsuario");
        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));

        mensagem2.setMsg(mensagem);
        mensagem2.setUsuario(professor);

        professor.criarMensagem(mensagem2, codigoMeta);

        response.sendRedirect("carregarMensagensProfessor?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }

    protected void selecionaMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Meta meta2 = new Meta();
        meta2.setCodigo(Integer.parseInt(request.getParameter("codigoMeta")));
        professor.selecionaMeta(meta2);
        professor.cadastrarMensagensNaMeta(meta2);
        request.setAttribute("meta", meta2);

        tutoria = professor.retornaTutoria(Integer.parseInt(request.getParameter("codigoTutoria")));
        professor.cadastraMetasNaTutoria(tutoria);
        request.setAttribute("tutoria", tutoria);

        professor.setId(id);
        professor.selecionarProfessor(professor);
        request.setAttribute("professor", professor);

        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        professor.selecionaMensagem(mensagem);
        request.setAttribute("mensagem", mensagem);

        RequestDispatcher rd = request.getRequestDispatcher("editarMensagemProfessor.jsp");
        rd.forward(request,response);
    }

    protected void editarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        mensagem.setMsg(request.getParameter("mensagem"));
        professor.atualizarMensagem(mensagem);
        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));
        response.sendRedirect("carregarMensagensProfessor?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }

    protected void deletarMensagem(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        mensagem.setCodigoMensagem(Integer.parseInt(request.getParameter("codigoMensagem")));
        professor.deletarMensagem(mensagem);

        int codigoMeta = Integer.parseInt(request.getParameter("codigoMeta"));
        int codigoTutoria = Integer.parseInt(request.getParameter("codigoTutoria"));
        response.sendRedirect("carregarMensagensProfessor?codigoMeta=" + codigoMeta + "&codigoTutoria=" + codigoTutoria + "&id=" + id);
    }

    protected void telaAtendimentos(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        ArrayList<Atendimento> atendimentos = new ArrayList<>();
        atendimentos = professor.retornarAtendimentos(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("codigo",Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("professor", professor);
        request.setAttribute("atendimentos",atendimentos);
        RequestDispatcher rd = request.getRequestDispatcher("atendimentoProfessor.jsp");
        rd.forward(request,response);
    }
    protected void gerarRelatorioUnitario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Atendimento atendimento = new Atendimento();
        atendimento = professor.retornarAtendimentoUnico(Integer.parseInt(request.getParameter("id")));
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
            Paragraph titulo = new Paragraph("RELATÓRIO DE AVALIAÇÃO SEMANAL DO PROFESSOR:");
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
            discursoParagraph.add(new Phrase("Eu, "+professor.getNome()+", declaro que o Tutor "+tutoria.getTutor().getNome() +" cumpriu a atividade semanal com carga horária de "+ atendimento.getCargaHoraria() +" hora(s), realizando todas as atividades planejadas.", fonte14));
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
        atendimentos = professor.retornarAtendimentos(Integer.parseInt(request.getParameter("codigo")));
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
            discursoParagraph.add(new Phrase("Eu, "+professor.getNome()+", declaro que esse documento é oficial.", fonte14));
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

    protected void irCriarAtendimento(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        request.setAttribute("tutoria", tutoria);
        request.setAttribute("professor", professor);
        RequestDispatcher rd = request.getRequestDispatcher("criarAtendimentoProfessor.jsp");
        rd.forward(request, response);
    }

    protected void criarAtendimento(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Atendimento atendimento = new Atendimento();

        atendimento.setData(request.getParameter("date"));
        atendimento.setHorario(request.getParameter("horario"));
        atendimento.setCargaHoraria(Integer.parseInt(request.getParameter("cargaHoraria")));
        atendimento.setLocal(request.getParameter("local"));
        atendimento.setConteudo(request.getParameter("conteudoTratado"));

        professor.criarAtendimento(atendimento, Integer.parseInt(request.getParameter("codigo")));
        int id_atendimento = professor.retornaUltimoIdAtendimento();
        atendimento.setId(id_atendimento);

        response.sendRedirect("carregarAtendimentosProfessor?id=" + id + "&codigo=" + Integer.parseInt(request.getParameter("codigo")));
    }

    protected void deletarAtendimento(HttpServletRequest request, HttpServletResponse response, int id) throws IOException, ServletException
    {
        Atendimento atendimento = new Atendimento();
        atendimento.setId(Integer.parseInt(request.getParameter("idAtendimento")));
        professor.deletarAtendimento(atendimento);

        response.sendRedirect("carregarAtendimentosProfessor?id=" + id + "&codigo=" + Integer.parseInt(request.getParameter("codigoTutoria")));
    }
    protected void editandoAtendimento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Atendimento atendimento = new Atendimento();
        atendimento = professor.retornarAtendimento(Integer.parseInt(request.getParameter("codigo")));
        request.setAttribute("tutoria",tutoria);
        request.setAttribute("professor",professor);
        request.setAttribute("atendimento",atendimento);
        RequestDispatcher rd = request.getRequestDispatcher("editarAtendimentoProfessor.jsp");
        rd.forward(request,response);
    }
    protected void editarAtendimento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Atendimento atendimento = new Atendimento();
        atendimento.setCargaHoraria(Integer.parseInt(request.getParameter("cargaHoraria")));
        atendimento.setData(request.getParameter("date"));
        atendimento.setId(Integer.parseInt(request.getParameter("id2")));
        atendimento.setLocal(request.getParameter("local"));
        atendimento.setHorario(request.getParameter("horario"));
        atendimento.setConteudo(request.getParameter("conteudoTratado"));
        professor.editarAtendimento(atendimento);
        response.sendRedirect("carregarAtendimentosProfessor?"+ "codigo=" + tutoria.getCodigo());
    }
}

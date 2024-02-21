package main.model;
import main.dao.*;
import java.util.ArrayList;

public class Professor extends Usuario {
    private ArrayList<String> disciplinas = new ArrayList<>();

    public Professor() {

    }

    public Professor(String nome, int idade, String email, int id, ArrayList<String> disciplinas) {
        super(nome, idade, email, id);
        this.disciplinas = disciplinas;
    }

    public Professor(String nome, int idade, String email, int id, String senha) {
        super(nome, idade, email, id, senha);
    }

    public void adicionarDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
    }

    public ArrayList<String> getDisciplinas() {
        return disciplinas;
    }

    public void cadastrar(String nome, String email, String senha) {
        super.cadastrar(nome, email, senha);
    }

    public void cadastrarProfessor(Professor professor) {
        ProfessorDao professorDao = new ProfessorDao();
        professorDao.cadastrarProfessor(professor);
    }

    public static Professor retornarProfessor(int id) {
        ProfessorDao professorDao = new ProfessorDao();
        return professorDao.retornarProfessor(id);
    }

    public void selecionarProfessor(Professor professor) {
        ProfessorDao professorDao = new ProfessorDao();
        professorDao.selecionarProfessor(professor);
    }

    public void editarProfessor(Professor professor) {
        ProfessorDao professorDao = new ProfessorDao();
        professorDao.editarProfessor(professor);
    }

    public static ArrayList<Tutoria> retornarTutoriaParaProfessor(int id) {
        ArrayList<Tutoria> tutorias = new ArrayList<>();
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornarTutoriaParaProfessor(id);
    }

    public static Tutoria retornaTutoria(int codigo) {
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornaTutoria(codigo);
    }

    public static void cadastraMetasNaTutoria(Tutoria tutoria) {
        MetasDao metasDao = new MetasDao();
        metasDao.cadastraMetasNaTutoria(tutoria);
    }

    public static void criarMeta(int codigo, String titulo) {
        MetasDao metasDao = new MetasDao();
        metasDao.criarMeta(codigo, titulo);
    }

    public static void selecionaMeta(Meta meta) {
        MetasDao metasDao = new MetasDao();
        metasDao.selecionaMeta(meta);
    }

    public static void atualizarMeta(Meta meta) {
        MetasDao metasDao = new MetasDao();
        metasDao.atualizarMeta(meta);
    }

    public static void excluirMeta(Meta meta) {
        MetasDao metasDao = new MetasDao();
        metasDao.excluirMeta(meta);
    }

    public static void cadastrarMensagensNaMeta(Meta meta) {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.cadastrarMensagensNaMeta(meta);
    }

    public static void criarMensagem(Mensagem mensagem, int codigoMeta) {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.criarMensagem(mensagem, codigoMeta);
    }

    public static void selecionaMensagem(Mensagem mensagem) {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.selecionaMensagem(mensagem);
    }

    public static void atualizarMensagem(Mensagem mensagem) {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.atualizarMensagem(mensagem);
    }

    public static void deletarMensagem(Mensagem mensagem) {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.atualizarMensagem(mensagem);
    }

    public static ArrayList<Atendimento> retornarAtendimentos(int codigo) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return atendimentoDao.retornarAtendimentos(codigo);
    }

    public static Atendimento retornarAtendimentoUnico(int id) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return atendimentoDao.retornarAtendimentoUnico(id);
    }

    public static void criarAtendimento(Atendimento atendimento, int codigoTutoria) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.criarAtendimento(atendimento, codigoTutoria);
    }

    public static int retornaUltimoIdAtendimento() {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return atendimentoDao.retornaUltimoIdAtendimento();
    }

    public static void deletarAtendimento(Atendimento atendimento) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.deletarAtendimento(atendimento);
    }

    public static Atendimento retornarAtendimento(int id) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        return atendimentoDao.retornarAtendimento(id);
    }

    public static void editarAtendimento(Atendimento atendimento) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.editarAtendimento(atendimento);
    }

    public static boolean lerDisciplina (Disciplina disciplina)
    {
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        return disciplinaDao.lerDisciplina(disciplina);
    }
    public static void atualizarDisciplinaProfessor(Disciplina disciplina, int id)
    {
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinaDao.atualizarDisciplinaProfessor(disciplina, id);
    }


}
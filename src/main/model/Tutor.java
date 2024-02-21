package main.model;

import main.dao.*;

import java.util.ArrayList;

public class Tutor extends Usuario {
    private String curso;
    private int semestre;
    private String matricula;

    public Tutor() {
    }

    public Tutor(String nome, int idade, String email, int id, String matricula) {
        super(nome, idade, email, id);
        this.matricula = matricula;
    }

    public Tutor(String nome, int idade, String email, int id, String senha, String matricula, String curso, int semestre) {
        super(nome, idade, email, id, senha);
        this.matricula = matricula;
        this.curso = curso;
        this.semestre = semestre;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void cadastrar(String nome, String email, String senha, String matricula) {
        super.cadastrar(nome, email, senha);
        this.matricula = matricula;
    }

    public void cadastrarTutor(Tutor tutor) {
        TutorDao tutorDao = new TutorDao();
        tutorDao.cadastrarTutor(tutor);
    }

    public Tutor retornarTutor(int id) {
        TutorDao tutorDao = new TutorDao();
        return tutorDao.retornarTutor(id);
    }

    public void selecionarTutor(Tutor tutor) {
        TutorDao tutorDao = new TutorDao();
        tutorDao.selecionarTutor(tutor);
    }

    public void editarTutor(Tutor tutor) {
        TutorDao tutorDao = new TutorDao();
        tutorDao.editarTutor(tutor);
    }

    public static ArrayList<Tutoria> retornarTutoriaParaTutor(int id) {
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornarTutoriaParaTutor(id);
    }

    public static boolean lerTutoria (Tutoria tutoria)
    {
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.lerTutoria(tutoria);
    }

    public static void atualizarTutoriaTutor(Tutoria tutoria, int id)
    {
        TutoriaDao tutoriaDao = new TutoriaDao();
        tutoriaDao.atualizarTutoriaTutor(tutoria, id);
    }

    public static Tutoria retornaTutoria(int codigo)
    {
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornaTutoria(codigo);
    }

    public static void cadastrarMensagensNaMeta(Meta meta)
    {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.cadastrarMensagensNaMeta(meta);
    }

    public static void criarMensagem(Mensagem mensagem, int codigoMeta)
    {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.criarMensagem(mensagem, codigoMeta);
    }

    public static void selecionaMensagem(Mensagem mensagem)
    {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.selecionaMensagem(mensagem);
    }

    public static void atualizarMensagem(Mensagem mensagem)
    {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.atualizarMensagem(mensagem);
    }

    public static void deletarMensagem(Mensagem mensagem)
    {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.deletarMensagem(mensagem);
    }

    public static void cadastraMetasNaTutoria(Tutoria tutoria)
    {
        MetasDao metasDao = new MetasDao();
        metasDao.cadastraMetasNaTutoria(tutoria);
    }

    public static void selecionaMeta(Meta meta)
    {
        MetasDao metasDao = new MetasDao();
        metasDao.selecionaMeta(meta);
    }

    public static void criarMeta(int codigo, String titulo)
    {
        MetasDao metasDao = new MetasDao();
        metasDao.criarMeta(codigo, titulo);
    }

    public static void criarAtendimento(Atendimento atendimento, int codigoTutoria)
    {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.criarAtendimento(atendimento, codigoTutoria);
    }
}




package main.model;

import main.dao.*;

import java.util.ArrayList;

public class RepresentanteNapne extends Usuario{
    private String cargo;
    public RepresentanteNapne(){

    }
    public RepresentanteNapne(String nome, int idade, String email, int id){
        super(nome, idade, email, id);
        this.cargo = cargo;
    }
    public RepresentanteNapne(String nome, int idade, String email, int id, String senha, String cargo){
        super(nome, idade, email, id, senha);
        this.cargo = cargo;
    }
    public RepresentanteNapne(String nome, int idade, String email, int id, String senha){
        super(nome, idade, email, id, senha);
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }
    public void cadastrar(String nome, String email, String senha) {
        super.cadastrar(nome, email, senha);
    }
    public static RepresentanteNapne retornarRepresentanteNapne(int id){
        RepresentanteNapneDao representanteNapneDao = new RepresentanteNapneDao();
        return representanteNapneDao.retornarRepresentanteNapne(id);
    }
    public void cadastrarRepresentanteNapne(RepresentanteNapne representanteNapne) {
        RepresentanteNapneDao representanteNapneDao = new RepresentanteNapneDao();
        representanteNapneDao.cadastrarRepresentanteNapne(representanteNapne);
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasGenerico(String nome) {
        TutoriaDao tutoriaDao = new TutoriaDao();
        return TutoriaDao.retornarTodasTutoriasGenerico(nome);
    }
    public static ArrayList<Tutoria> retornarTodasTutorias() {
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornarTodasTutorias();
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasMatriculaTutor(String matricula){
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornarTodasTutoriasMatriculaTutor(matricula);
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasMatriculaTutorado(String matricula){
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornarTodasTutoriasMatriculaTutorado(matricula);
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasNomeTutor(String nome){
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornarTodasTutoriasNomeTutor(nome);
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasNomeTutorado(String nome){
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornarTodasTutoriasNomeTutorado(nome);
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasNomeDisciplina(String nome){
        TutoriaDao tutoriaDao = new TutoriaDao();
        return tutoriaDao.retornarTodasTutoriasNomeDisciplina(nome);
    }
    public void selecionarRepresentanteNapne(RepresentanteNapne representanteNapne)
    {
        RepresentanteNapneDao representanteNapneDao = new RepresentanteNapneDao();
        representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
    }
    public void editarRepresentanteNapne(RepresentanteNapne representanteNapne)
    {
        RepresentanteNapneDao representanteNapneDao = new RepresentanteNapneDao();
        representanteNapneDao.editarRepresentanteNapne(representanteNapne);
    }
    public void cadastrarDisciplina(Disciplina disciplina){
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinaDao.cadastrarDisciplina(disciplina);
    }
    public void cadastrarDisciplinaSemProfessor(Disciplina disciplina){
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinaDao.cadastrarDisciplinaSemProfessor(disciplina);
    }
    public static ArrayList<Disciplina> retornarDisciplinas(String nome){
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        return disciplinaDao.retornarDisciplinas(nome);
    }
    public static ArrayList<Disciplina> retornarTodasDisciplinas(){
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        return disciplinaDao.retornarTodasDisciplinas();
    }
    public void excluirDisciplina(int codigo){
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinaDao.excluirDisciplina(codigo);
    }
    public void editarDisciplina(Disciplina disciplina){
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinaDao.editarDisciplina(disciplina);
    }
    public void editarDisciplinaSemProfessor(Disciplina disciplina){
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        disciplinaDao.editarDisciplinaSemProfessor(disciplina);
    }
    public static void criarMeta(int codigo, String titulo)
    {
        MetasDao metasDao = new MetasDao();
        metasDao.criarMeta(codigo,titulo);
    }
    public static void atualizarMeta(Meta meta)
    {
        MetasDao metasDao = new MetasDao();
        metasDao.atualizarMeta(meta);
    }
    public static void excluirMeta(Meta meta)
    {
        MetasDao metasDao = new MetasDao();
        metasDao.excluirMeta(meta);
    }
    public static void criarMensagem(Mensagem mensagem, int codigoMeta)
    {
        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.criarMensagem(mensagem,codigoMeta);
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
    public static void criarAtendimento(Atendimento atendimento, int codigoTutoria)
    {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.criarAtendimento(atendimento,codigoTutoria);
    }
    public static void deletarAtendimento(Atendimento atendimento)
    {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.deletarAtendimento(atendimento);
    }
    public static void editarAtendimento(Atendimento atendimento) {
        AtendimentoDao atendimentoDao = new AtendimentoDao();
        atendimentoDao.editarAtendimento(atendimento);
    }
}

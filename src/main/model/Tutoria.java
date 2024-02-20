package main.model;
import java.util.ArrayList;

public class Tutoria {
    private int codigo;
    private String senha;
    private Tutor tutor;
    private Tutorado tutorado;
    private Disciplina disciplina;
    private ArrayList<Meta> metas = new ArrayList<>();
    private ArrayList<Atendimento> atendimentos = new ArrayList<>();
    public Tutoria(){

    }
    public Tutoria(int codigo, String senha){

    }
    public Tutoria(int codigo, String senha, Tutorado tutorado, Disciplina disciplina){
        this.codigo = codigo;
        this.senha = senha;
        this.tutorado = tutorado;
        this.disciplina = disciplina;
    }
    public Tutoria(int codigo, String senha, Tutor tutor, Tutorado tutorado, Disciplina disciplina, ArrayList<Meta> metas){
        this.codigo = codigo;
        this.senha = senha;
        this.tutor = tutor;
        this.tutorado = tutorado;
        this.disciplina = disciplina;
        this.metas = metas;
    }
    public Tutoria(int codigo, String senha, Tutor tutor, Tutorado tutorado, Disciplina disciplina){
        this.codigo = codigo;
        this.senha = senha;
        this.tutor = tutor;
        this.tutorado = tutorado;
        this.disciplina = disciplina;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutorado(Tutorado tutorado) {
        this.tutorado = tutorado;
    }

    public Tutorado getTutorado() {
        return tutorado;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public ArrayList<Meta> getMetas() {
        return metas;
    }

    public void setMetas(Meta metas) {
        this.metas.add(metas);
    }

    public void setAtendimentos(ArrayList<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }
}

package main.model;

import java.util.ArrayList;

public class Tutorado extends Usuario{
    private String tipoDeDeficiencia;
    private String curso;
    private int semestre;
    private String matricula;

    public Tutorado(){

    }
    public Tutorado(String nome, int idade, String email, int id, String matricula){
        super(nome, idade, email, id);
        this.matricula = matricula;
    }
    public Tutorado(String nome, int idade, String email, int id, String senha, String matricula, int semestre, String curso, String tipoDeDeficiencia){
        super(nome, idade, email, id, senha);
        this.matricula = matricula;
        this.semestre = semestre;
        this.curso = curso;
        this.tipoDeDeficiencia = tipoDeDeficiencia;
    }
    public void setTipoDeDeficiencia(String tipoDeDeficiencia) {
        this.tipoDeDeficiencia = tipoDeDeficiencia;
    }

    public String getTipoDeDeficiencia() {
        return tipoDeDeficiencia;
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

}

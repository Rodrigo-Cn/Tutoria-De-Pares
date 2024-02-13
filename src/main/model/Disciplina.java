package main.model;

public class Disciplina {
    private String nome;
    private int codigo;
    private Professor professor;

    public Disciplina(){

    }
    public Disciplina(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
    }
    public Disciplina(String nome, int codigo, Professor professor){
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }
}

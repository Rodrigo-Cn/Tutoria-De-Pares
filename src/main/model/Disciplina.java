package main.model;

import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private int codigo;
    private Professor professor;
    ArrayList<String> componenteCurricular = new ArrayList<>();
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
    public Disciplina(String nome, int codigo, Professor professor, ArrayList<String> componenteCurricular){
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
        this.componenteCurricular = componenteCurricular;
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

    public void setComponenteCurricular(ArrayList<String> componenteCurricular) {
        this.componenteCurricular = componenteCurricular;
    }

    public ArrayList<String> getComponenteCurricular() {
        return componenteCurricular;
    }
}

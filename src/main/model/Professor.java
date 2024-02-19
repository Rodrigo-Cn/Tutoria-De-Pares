package main.model;

import java.util.ArrayList;

public class Professor extends Usuario{
    private  ArrayList<String> disciplinas = new ArrayList<>();
    public Professor(){

    }
    public Professor(String nome, int idade, String email, int id, ArrayList<String> disciplinas){
        super(nome, idade, email, id);
        this.disciplinas = disciplinas;
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
}

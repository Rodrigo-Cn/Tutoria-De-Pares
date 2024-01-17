package main.model;

public class Tutoria {
    private int codigo;
    private String senha;
    private Tutor tutor;
    private Tutorado tutorado;
    private Disciplina disciplina;
    public Tutoria(){

    }
    public Tutoria(int codigo, String senha){

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
}

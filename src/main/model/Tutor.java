package main.model;

public class Tutor extends Usuario{
    private String curso;
    private int semestre;
    private String matricula;
    public Tutor(){
    }
    public Tutor(String nome, int idade, String email, int id, String matricula){
        super(nome, idade, email, id);
        this.matricula = matricula;
    }
    public Tutor(String nome, int idade, String email, int id, String senha, String matricula, String curso, int semestre){
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
}

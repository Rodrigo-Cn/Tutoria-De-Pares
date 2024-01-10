package main.model;

public abstract class Usuario {
    private String nome;
    private int idade;
    private String email;
    private String senha;
    private int id;
    public Usuario(){
    }
    public Usuario(String nome, int idade, String email, int id){
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha() {
        return senha;
    }
    public void cadastrar(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}

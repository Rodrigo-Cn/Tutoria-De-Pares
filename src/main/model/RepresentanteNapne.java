package main.model;

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
}

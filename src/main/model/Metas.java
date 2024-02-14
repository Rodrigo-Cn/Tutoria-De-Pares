package main.model;
import java.util.ArrayList;

public class Metas {
    private String titulo;
    private int codigo;
    private ArrayList<Mensagem> mensagens = new ArrayList<>();

    public Metas()
    {

    }

    public Metas(String titulo, int codigo, ArrayList<Mensagem> mensagens )
    {
        this.titulo = titulo;
        this.codigo = codigo;
        this.mensagens = mensagens;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(Mensagem mensagem) {
        this.mensagens.add(mensagem);
    }
}

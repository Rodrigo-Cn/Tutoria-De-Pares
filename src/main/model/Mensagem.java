package main.model;

public class Mensagem
{
    private String msg;
    private Usuario usuario;
    private int codigoMensagem;


    public Mensagem()
    {

    }

    public Mensagem(String msg, Usuario usuario, int codigoMensagem)
    {
        this.msg = msg;
        this.usuario = usuario;
        this.codigoMensagem = codigoMensagem;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCodigoMensagem() {
        return codigoMensagem;
    }

    public void setCodigoMensagem(int codigoMensagem) {
        this.codigoMensagem = codigoMensagem;
    }

}

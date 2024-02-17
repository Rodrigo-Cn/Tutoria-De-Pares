package main.model;
public class Atendimento {
    private int id;
    private String conteudo;
    private String data;
    private String local;
    private String horario;
    private int cargaHoraria;

    public Atendimento(){}
    public Atendimento(int id, String conteudo, String data, String local, String horario, int cargaHoraria){
        this.id = id;
        this.conteudo = conteudo;
        this.data = data;
        this.local = local;
        this.horario = horario;
        this.cargaHoraria = cargaHoraria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
}

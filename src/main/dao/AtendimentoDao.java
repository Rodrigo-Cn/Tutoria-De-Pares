package main.dao;

import main.model.Atendimento;
import main.model.Tutoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AtendimentoDao {
    public static ArrayList<Atendimento> retornarAtendimentos(int codigo){
        ConectionDB conectionDB = new ConectionDB();
        ArrayList<Atendimento> atendimentos = new ArrayList<>();

        String read = "SELECT * FROM atendimento WHERE codigo_tutoria = ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, codigo);
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Atendimento atendimento = new Atendimento();
                atendimento.setId(rs.getInt("id_atendimento"));
                atendimento.setConteudo(rs.getString("conteudo_atendimento"));
                atendimento.setData(rs.getString("data_atendimento"));
                atendimento.setLocal(rs.getString("local_atendimento"));
                atendimento.setHorario(rs.getString("horario_atendimento"));
                atendimento.setCargaHoraria(rs.getInt("carga_horaria"));
                atendimentos.add(atendimento);
            }
            return atendimentos;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static Atendimento retornarAtendimentoUnico(int id){
        ConectionDB conectionDB = new ConectionDB();
        Atendimento atendimento = new Atendimento();
        String read = "SELECT * FROM atendimento WHERE id_atendimento = ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            if (rs.next()){
                atendimento.setId(rs.getInt("id_atendimento"));
                atendimento.setConteudo(rs.getString("conteudo_atendimento"));
                atendimento.setData(rs.getString("data_atendimento"));
                atendimento.setLocal(rs.getString("local_atendimento"));
                atendimento.setHorario(rs.getString("horario_atendimento"));
                atendimento.setCargaHoraria(rs.getInt("carga_horaria"));
            }
            return atendimento;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}

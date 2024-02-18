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

    public static void criarAtendimento(Atendimento atendimento, int codigoTutoria)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        String sql = "INSERT INTO atendimento (conteudo_atendimento, data_atendimento, local_atendimento, horario_atendimento, carga_horaria, codigo_tutoria) VALUES (?, ?, ?, ?, ?, ?)";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setString(1, atendimento.getConteudo());
            ps.setString(2, atendimento.getData());
            ps.setString(3, atendimento.getLocal());
            ps.setString(4, atendimento.getHorario());
            ps.setInt(5, atendimento.getCargaHoraria());
            ps.setInt(6, codigoTutoria);
            ps.execute();
            ps.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static int retornaUltimoIdAtendimento()
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT a.id_atendimento FROM atendimento a INNER JOIN (SELECT MAX(id_atendimento) as ultimo_codigo FROM atendimento) max_t ON a.id_atendimento = max_t.ultimo_codigo";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();

            if(rs.next())
            {
                return rs.getInt(1);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return 0;
    }

    public static void deletarAtendimento(Atendimento atendimento)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        String sql = "DELETE FROM atendimento WHERE id_atendimento=?";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, atendimento.getId());
            ps.execute();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}

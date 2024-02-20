package main.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.dao.*;
import main.model.*;
public class MensagemDao
{
    public static void cadastrarMensagensNaMeta(Meta meta)
    {
        UsuarioDao usuarioDao = new UsuarioDao();

        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM mensagens WHERE codigo_metas=?";

        int idUsuario = 0;

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, meta.getCodigo());
            rs = ps.executeQuery();

            while(rs.next())
            {
                Mensagem mensagem = new Mensagem();
                mensagem.setMsg(rs.getString(1));
                mensagem.setCodigoMensagem(rs.getInt(3));

                idUsuario = rs.getInt(4);
                mensagem.setUsuario(usuarioDao.retornaNomeIdUsuario(idUsuario));

                meta.setMensagens(mensagem);
            }
            rs.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void criarMensagem(Mensagem mensagem, int codigoMeta)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        String sql = "INSERT INTO mensagens (mensagem, id_usuario, codigo_metas) VALUES (?, ?, ?)";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setString(1, mensagem.getMsg());
            ps.setInt(2, mensagem.getUsuario().getId());
            ps.setInt(3, codigoMeta);
            ps.execute();
            ps.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void selecionaMensagem(Mensagem mensagem)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM mensagens WHERE codigo_mensagem=?";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, mensagem.getCodigoMensagem());
            rs = ps.executeQuery();

            if(rs.next())
            {
                mensagem.setMsg(rs.getString(1));
                mensagem.setCodigoMensagem(rs.getInt(3));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void atualizarMensagem(Mensagem mensagem)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;

        String sql = "UPDATE mensagens SET mensagem=? WHERE codigo_mensagem=?";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setString(1, mensagem.getMsg());
            ps.setInt(2, mensagem.getCodigoMensagem());
            ps.executeUpdate();
            ps.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void deletarMensagem(Mensagem mensagem)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        String sql = "DELETE FROM mensagens WHERE codigo_mensagem=?";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, mensagem.getCodigoMensagem());
            ps.execute();
            ps.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

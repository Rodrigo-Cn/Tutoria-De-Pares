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
                mensagem.setUsuario(defineUsuarioDaMensagem(idUsuario));

                meta.setMensagens(mensagem);
            }
            rs.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static Usuario defineUsuarioDaMensagem(int idUsuario)
    {
        UsuarioDao usuarioDao = new UsuarioDao();
        ProfessorDao professorDao = new ProfessorDao();
        TutoradoDao tutoradoDao = new TutoradoDao();
        TutorDao tutorDao = new TutorDao();
        RepresentanteNapneDao representanteNapneDao = new RepresentanteNapneDao();

        int cargoDoUsuario = usuarioDao.lerTipoUsuarioDisciplina(idUsuario);

        if(cargoDoUsuario==1)
        {
            Professor professor = new Professor();
            professor.setId(idUsuario);
            professorDao.selecionarProfessor(professor);
            return professor;
        }
        else if(cargoDoUsuario==2)
        {
            Tutor tutor = new Tutor();
            tutor.setId(idUsuario);
            tutorDao.selecionarTutor(tutor);
            return tutor;

        }
        else if(cargoDoUsuario==3)
        {
            Tutorado tutorado = new Tutorado();
            tutorado.setId(idUsuario);
            tutoradoDao.selecionarTutorado(tutorado);
            return tutorado;
        }
        else if(cargoDoUsuario==4)
        {
            RepresentanteNapne representanteNapne = new RepresentanteNapne();
            representanteNapne.setId(idUsuario);
            representanteNapneDao.selecionarRepresentanteNapne(representanteNapne);
            return representanteNapne;
        }
        else
        {
            return null;
        }
    }

    public static void criarMensagem(Mensagem mensagem)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        String sql = "INSERT INTO mensagens (mensagem, codigo_metas, id_usuario) VALUES (?, ?, ?)";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setString(1, mensagem.getMsg());
            ps.setInt(2, mensagem.getCodigoMeta());
            ps.setInt(3, mensagem.getUsuario().getId());
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
                mensagem.setCodigoMeta(rs.getInt(2));
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

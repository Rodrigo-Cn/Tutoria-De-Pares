package main.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.model.*;
public class MetasDao {

    public static void cadastraMetasNaTutoria(Tutoria tutoria)
    {
        ConectionDB con = new ConectionDB();;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT titulo, codigo_metas FROM metas WHERE codigo_tutoria=?";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, tutoria.getCodigo());
            rs = ps.executeQuery();

            while(rs.next())
            {
                Meta meta = new Meta();
                meta.setTitulo(rs.getString(1));
                meta.setCodigo(rs.getInt(2));
                tutoria.setMetas(meta);
            }
            rs.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void criarMeta(int codigo, String titulo)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        String sql = "INSERT INTO metas (codigo_tutoria,titulo) VALUES (?, ?);";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, titulo);
            ps.execute();
            ps.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void selecionaMeta(Meta meta)
    {
        String sql = "SELECT * FROM metas WHERE codigo_metas=?";
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, meta.getCodigo());
            rs = ps.executeQuery();

            if(rs.next())
            {
                //meta.setCodigo(rs.getInt(1));
                meta.setTitulo(rs.getString(2));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public static void atualizarMeta(Meta meta)
    {
        String sql = "UPDATE metas SET titulo=? WHERE codigo_metas=?";
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setString(1, meta.getTitulo());
            ps.setInt(2, meta.getCodigo());
            ps.executeUpdate();
            ps.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void excluirMeta(Meta meta)
    {
        String sql = "DELETE FROM metas WHERE codigo_metas=?";
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, meta.getCodigo());
            ps.executeUpdate();
            ps.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

}


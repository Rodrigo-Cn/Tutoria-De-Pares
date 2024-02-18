package main.dao;
import main.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.controller.*;
import main.model.*;

public class UsuarioDao {
    ConectionDB conectionDB = new ConectionDB();
    public int lerIdUsuario(String email, String senha) {

        String read = "SELECT id FROM usuario WHERE email = ? AND senha = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, email);
            readUser.setString(2, senha);
            ResultSet rs = readUser.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                rs.close();
                readUser.close();
                con.close();
                return id;

            } else {
                rs.close();
                readUser.close();
                con.close();
                return 0;

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    public int lerTipoUsuario(String email, String senha) {
        String read = "SELECT tipo_de_usuario FROM usuario WHERE email = ? AND senha = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, email);
            readUser.setString(2, senha);

            ResultSet rs = readUser.executeQuery();

            if (rs.next()) {
                int tipoUsuario = rs.getInt("tipo_de_usuario");
                rs.close();
                readUser.close();
                con.close();

                return tipoUsuario;
            } else {
                rs.close();
                readUser.close();
                con.close();
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }
    public int lerTipoUsuarioDisciplina(int id) {
        String read = "SELECT tipo_de_usuario FROM usuario WHERE id = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);

            ResultSet rs = readUser.executeQuery();

            if (rs.next()) {
                int tipoUsuario = rs.getInt("tipo_de_usuario");
                rs.close();
                readUser.close();
                con.close();

                return tipoUsuario;
            } else {
                rs.close();
                readUser.close();
                con.close();
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    public boolean verificaSeUsuarioExiste(Integer id)
    {
        if(id != null)
        {
            String sql = "SELECT * FROM usuario WHERE id = ?";
            try {
                Connection con = conectionDB.conectar();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            return false;
        }
        else
        {
            return true;
        }
    }

    public Usuario retornaNomeIdUsuario(int id)
    {
        Tutor tutor = new Tutor();
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT nome,id FROM usuario WHERE id=?";

        try
        {
            ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
            {
                tutor.setNome(rs.getString(1));
                tutor.setId(rs.getInt(2));
            }
            rs.close();
            return tutor;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }


}

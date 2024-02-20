package main.dao;

import main.model.Professor;
import main.model.Tutorado;
import main.model.Tutoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TutoradoDao {
    ConectionDB conectionDB = new ConectionDB();
    public void cadastrarTutorado(Tutorado tutorado){
        String create = "INSERT INTO usuario (nome,email,senha,tipo_de_usuario,matricula) VALUES (?, ?, ?, ?, ?)";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newUser = con.prepareStatement(create);
            newUser.setString(1,tutorado.getNome());
            newUser.setString(2,tutorado.getEmail());
            newUser.setString(3, tutorado.getSenha());
            newUser.setInt(4,3);
            newUser.setString(5, tutorado.getMatricula());
            newUser.execute();
            newUser.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Tutorado retornarTutorado(int id){
        ConectionDB conectionDB = new ConectionDB();
        Tutorado tutorado = null;

        String read = "SELECT * FROM usuario WHERE id = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            if (rs.next()){
                tutorado = new Tutorado(rs.getString("nome"), rs.getInt("idade"), rs.getString("email"), rs.getInt("id"), rs.getString("senha"), rs.getString("matricula"),rs.getInt("semestre"), rs.getString("curso"), rs.getString("tipo_de_deficiencia"));
            }
            return tutorado;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public void selecionarTutorado(Tutorado tutorado)
    {
        String read = "SELECT * FROM usuario WHERE id=?";

        try
        {
            Connection con = conectionDB.conectar();
           PreparedStatement ps = con.prepareStatement(read);
           ps.setInt(1, tutorado.getId());
           ResultSet rs = ps.executeQuery();

           while(rs.next())
           {
               tutorado.setNome(rs.getString(1));
               tutorado.setIdade(rs.getInt(2));
               tutorado.setEmail(rs.getString(3));
               tutorado.setSenha(rs.getString(4));
               tutorado.setId(rs.getInt(5));
               tutorado.setCurso(rs.getString(6));
               tutorado.setSemestre(rs.getInt(7));
               tutorado.setMatricula(rs.getString(8));
               tutorado.setTipoDeDeficiencia((rs.getString(9)));

           }
           con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void editarTutorado (Tutorado tutorado)
    {
        String update = "UPDATE usuario SET nome=?, email=?, senha=?, curso=?, semestre=?, matricula=?, tipo_de_deficiencia=? WHERE id=?";

        try
        {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, tutorado.getNome());
            ps.setString(2, tutorado.getEmail());
            ps.setString(3, tutorado.getSenha());
            ps.setString(4, tutorado.getCurso());
            ps.setInt(5, tutorado.getSemestre());
            ps.setString(6, tutorado.getMatricula());
            ps.setString(7, tutorado.getTipoDeDeficiencia());
            ps.setInt(8, tutorado.getId());
            ps.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

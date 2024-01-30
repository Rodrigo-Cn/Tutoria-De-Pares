package main.dao;

import main.model.Professor;
import main.model.RepresentanteNapne;
import main.model.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfessorDao {
    ConectionDB conectionDB = new ConectionDB();
    public void cadastrarProfessor(Professor professor){
        String create = "INSERT INTO usuario (nome,email,senha,tipo_de_usuario) VALUES (?, ?, ?, ?)";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newUser = con.prepareStatement(create);
            newUser.setString(1,professor.getNome());
            newUser.setString(2,professor.getEmail());
            newUser.setString(3, professor.getSenha());
            newUser.setInt(4,1);
            newUser.execute();
            newUser.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static Professor retornarProfessor(int id)
    {
        Professor professor = new Professor();
        ConectionDB conectionDB = new ConectionDB();
        String read = "SELECT * FROM usuario WHERE id = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            if (rs.next()){
                professor.setId(rs.getInt("id"));
                professor.setNome(rs.getString("nome"));
                professor.setIdade(rs.getInt("idade"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));
            }
            return professor;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public void selecionarProfessor(Professor professor)
    {
        String read = "SELECT * FROM usuario WHERE id=?";
        try
        {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(read);
            ps.setInt(1, professor.getId());
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                professor.setNome(rs.getString(1));
                professor.setIdade(rs.getInt(2));
                professor.setEmail(rs.getString(3));
                professor.setSenha(rs.getString(4));
                professor.setId(rs.getInt(5));
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void editarProfessor(Professor professor)
    {
        String update = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?";

        try
        {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getEmail());
            ps.setString(3, professor.getSenha());
            ps.setInt(4, professor.getId());
            ps.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

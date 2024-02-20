package main.dao;

import main.model.Professor;
import main.model.Tutor;
import main.model.Tutorado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TutorDao {
    ConectionDB conectionDB = new ConectionDB();
    public void cadastrarTutor(Tutor tutor){
        String create = "INSERT INTO usuario (nome,email,senha,tipo_de_usuario,matricula) VALUES (?, ?, ?, ?, ?)";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newUser = con.prepareStatement(create);
            newUser.setString(1,tutor.getNome());
            newUser.setString(2,tutor.getEmail());
            newUser.setString(3, tutor.getSenha());
            newUser.setInt(4,2);
            newUser.setString(5, tutor.getMatricula());
            newUser.execute();
            newUser.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public Tutor retornarTutor(int id) {

        String read = "SELECT * FROM usuario WHERE id = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            if (rs.next()) {
                Tutor tutor = new Tutor(rs.getString("nome"), rs.getInt("idade"), rs.getString("email"), rs.getInt("id"), rs.getString("senha"), rs.getString("matricula"), rs.getString("curso"), rs.getInt("semestre"));
                rs.close();
                readUser.close();
                con.close();
                return tutor;

            } else {
                rs.close();
                readUser.close();
                con.close();
                return null;

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public void selecionarTutor(Tutor tutor)
    {
        String read = "SELECT * FROM usuario WHERE id=?";

        try
        {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(read);
            ps.setInt(1, tutor.getId());
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                tutor.setNome(rs.getString(1));
                tutor.setIdade(rs.getInt(2));
                tutor.setEmail(rs.getString(3));
                tutor.setSenha(rs.getString(4));
                tutor.setId(rs.getInt(5));
                tutor.setCurso(rs.getString(6));
                tutor.setSemestre(rs.getInt(7));
                tutor.setMatricula(rs.getString(8));
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void editarTutor (Tutor tutor)
    {
        String update = "UPDATE usuario SET nome=?, email=?, senha=?, curso=?, semestre=?, matricula=? WHERE id=?";

        try
        {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, tutor.getNome());
            ps.setString(2, tutor.getEmail());
            ps.setString(3, tutor.getSenha());
            ps.setString(4, tutor.getCurso());
            ps.setInt(5, tutor.getSemestre());
            ps.setString(6, tutor.getMatricula());
            ps.setInt(7, tutor.getId());
            ps.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

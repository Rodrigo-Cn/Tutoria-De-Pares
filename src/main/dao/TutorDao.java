package main.dao;

import main.model.Professor;
import main.model.Tutor;

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
                Tutor tutor = new Tutor();
                tutor.setId(rs.getInt("id"));
                tutor.setNome(rs.getString("nome"));
                tutor.setIdade(rs.getInt("idade"));
                tutor.setEmail(rs.getString("email"));
                tutor.setSenha(rs.getString("senha"));
                tutor.setCurso(rs.getString("curso"));
                tutor.setSemestre(rs.getInt("semestre"));
                tutor.setMatricula(rs.getString("matricula"));
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
}

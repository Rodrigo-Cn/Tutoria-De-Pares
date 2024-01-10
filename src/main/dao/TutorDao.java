package main.dao;

import main.model.Professor;
import main.model.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}

package main.dao;

import main.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}

package main.dao;

import main.model.Professor;
import main.model.Tutorado;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}

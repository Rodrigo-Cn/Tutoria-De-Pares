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
        Tutorado tutorado = new Tutorado();

        String read = "SELECT * FROM usuario WHERE id = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            if (rs.next()){
                tutorado.setId(rs.getInt("id"));
                tutorado.setNome(rs.getString("nome"));
                tutorado.setIdade(rs.getInt("idade"));
                tutorado.setEmail(rs.getString("email"));
                tutorado.setSenha(rs.getString("senha"));
                tutorado.setTipoDeDeficiencia(rs.getString("tipo_de_deficiencia"));
                tutorado.setCurso(rs.getString("curso"));
                tutorado.setSemestre(rs.getInt("semestre"));
                tutorado.setMatricula(rs.getString("matricula"));
            }
            return tutorado;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}

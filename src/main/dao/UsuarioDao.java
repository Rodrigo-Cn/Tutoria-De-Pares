package main.dao;
import main.model.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import main.controller.*;
import main.model.*;

public class UsuarioDao {
    ConectionDB conectionDB = new ConectionDB();
    private static Professor professor;
    private static Tutor tutor;
    private static Tutorado tutorado;

    public Usuario lerUsuario(String email, String senha){
        String read = "SELECT tipo_de_usuario,nome,idade,email,senha,id,curso,semestre,matricula,tipo_de_deficiencia,cargo FROM usuario WHERE email = ? AND senha = ?";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, email);
            readUser.setString(2, senha);

            ResultSet rs = readUser.executeQuery();

            //readUser.execute();
            if(rs.next())
            {
                if(rs.getInt(1)==1)
                {
                    professor = new Professor();
                    professor.setNome(rs.getString(2));
                    professor.setIdade(rs.getInt(3));
                    professor.setEmail(rs.getString(4));
                    professor.setSenha(rs.getString(5));
                    professor.setId(rs.getInt(6));
                    return professor;
                }
                else if(rs.getInt(1)==2)
                {
                    tutor = new Tutor();
                    tutor.setNome(rs.getString(2));
                    tutor.setIdade(rs.getInt(3));
                    tutor.setEmail(rs.getString(4));
                    tutor.setSenha(rs.getString(5));
                    tutor.setId(rs.getInt(6));
                    tutor.setCurso(rs.getString(7));
                    tutor.setSemestre(rs.getInt(8));
                    tutor.setMatricula(rs.getString(9));
                    return tutor;
                }
                else
                {
                    tutorado = new Tutorado();
                    tutorado.setNome(rs.getString(2));
                    tutorado.setIdade(rs.getInt(3));
                    tutorado.setEmail(rs.getString(4));
                    tutorado.setSenha(rs.getString(5));
                    tutorado.setId(rs.getInt(6));
                    tutorado.setCurso(rs.getString(7));
                    tutorado.setSemestre(rs.getInt(8));
                    tutorado.setMatricula(rs.getString(9));
                    return tutorado;
                }

            }
            readUser.close();
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}

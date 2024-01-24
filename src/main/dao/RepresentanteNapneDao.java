package main.dao;

import main.model.RepresentanteNapne;
import main.model.Tutorado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RepresentanteNapneDao {
    ConectionDB conectionDB = new ConectionDB();
    public static RepresentanteNapne retornarRepresentanteNapne(int id){
        RepresentanteNapne representanteNapne = new RepresentanteNapne();
        ConectionDB conectionDB = new ConectionDB();
        String read = "SELECT * FROM usuario WHERE id = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            if (rs.next()){
                representanteNapne.setId(rs.getInt("id"));
                representanteNapne.setNome(rs.getString("nome"));
                representanteNapne.setIdade(rs.getInt("idade"));
                representanteNapne.setEmail(rs.getString("email"));
                representanteNapne.setSenha(rs.getString("senha"));
                representanteNapne.setCargo(rs.getString("cargo"));
            }
            return representanteNapne;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public void cadastrarRepresentanteNapne(RepresentanteNapne representanteNapne){
        String create = "INSERT INTO usuario (nome,email,senha,tipo_de_usuario) VALUES (?, ?, ?, ?)";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newUser = con.prepareStatement(create);
            newUser.setString(1,representanteNapne.getNome());
            newUser.setString(2,representanteNapne.getEmail());
            newUser.setString(3, representanteNapne.getSenha());
            newUser.setInt(4,4);
            newUser.execute();
            newUser.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

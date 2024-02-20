package main.dao;

import main.model.RepresentanteNapne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RepresentanteNapneDao {
    ConectionDB conectionDB = new ConectionDB();
    public static RepresentanteNapne retornarRepresentanteNapne(int id){
        RepresentanteNapne representanteNapne = null;
        ConectionDB conectionDB = new ConectionDB();
        String read = "SELECT * FROM usuario WHERE id = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            if (rs.next()){
                representanteNapne = new RepresentanteNapne(rs.getString("nome"), rs.getInt("idade"), rs.getString("email"), rs.getInt("id"), rs.getString("senha"), rs.getString("cargo"));
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

    public void selecionarRepresentanteNapne(RepresentanteNapne representanteNapne)
    {
        String read = "SELECT * FROM usuario WHERE id=?";

        try
        {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(read);
            ps.setInt(1, representanteNapne.getId());
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                representanteNapne.setNome(rs.getString(1));
                representanteNapne.setIdade(rs.getInt(2));
                representanteNapne.setEmail(rs.getString(3));
                representanteNapne.setSenha(rs.getString(4));
                representanteNapne.setId(rs.getInt(5));
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void editarRepresentanteNapne(RepresentanteNapne representanteNapne)
    {
        String update = "UPDATE usuario SET nome=?, email=?, senha=? WHERE id=?";

        try
        {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, representanteNapne.getNome());
            ps.setString(2, representanteNapne.getEmail());
            ps.setString(3, representanteNapne.getSenha());
            ps.setInt(4, representanteNapne.getId());
            ps.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}

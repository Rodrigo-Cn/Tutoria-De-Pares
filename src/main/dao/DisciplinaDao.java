package main.dao;

import main.model.Disciplina;
import main.model.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisciplinaDao {
    public static Disciplina retornarDisciplina(int id){

        ConectionDB conectionDB = new ConectionDB();

        String read = "SELECT * FROM disciplina WHERE codigo = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            if (rs.next()) {
                Disciplina disciplina = new Disciplina();

                disciplina.setNome(rs.getString("nome"));
                disciplina.setCodigo(rs.getInt("codigo"));

                rs.close();
                readUser.close();
                con.close();

                return disciplina;

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

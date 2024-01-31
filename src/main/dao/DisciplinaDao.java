package main.dao;

import main.model.Disciplina;
import main.model.Tutor;
import main.model.Tutoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisciplinaDao {
    public static Disciplina retornarDisciplina(int id){

        ConectionDB conectionDB = new ConectionDB();
        ProfessorDao professorDao = new ProfessorDao();

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
                disciplina.setProfessor(professorDao.retornarProfessor(rs.getInt("id_professor")));

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

    public static void atualizarDisciplinaProfessor(Disciplina disciplina, int id)
    {
        ConectionDB con = new ConectionDB();
        String update = "UPDATE disciplina SET id_professor = ? WHERE codigo = ?";
        PreparedStatement ps = null;

        try
        {
            ps = con.conectar().prepareStatement(update);
            ps.setInt(1, id);
            ps.setInt(2, disciplina.getCodigo());
            ps.execute();
            ps.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static boolean lerDisciplina (Disciplina disciplina)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String read = "SELECT * FROM disciplina WHERE codigo = ?";

        try
        {
            ps = con.conectar().prepareStatement(read);
            ps.setInt(1, disciplina.getCodigo());
            rs = ps.executeQuery();

            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
}

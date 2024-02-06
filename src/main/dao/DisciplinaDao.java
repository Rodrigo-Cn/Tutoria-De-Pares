package main.dao;

import main.model.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DisciplinaDao {
    public static Disciplina retornarDisciplina(int codigo){

        ConectionDB conectionDB = new ConectionDB();
        ProfessorDao professorDao = new ProfessorDao();

        String read = "SELECT * FROM disciplina WHERE codigo = ?";
        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, codigo);
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
    public void cadastrarDisciplina(Disciplina disciplina){
        ConectionDB conectionDB = new ConectionDB();

        String create = "INSERT INTO disciplina (nome,id_professor) VALUES (?, ?)";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newUser = con.prepareStatement(create);
            newUser.setString(1, disciplina.getNome());
            newUser.setInt(2,disciplina.getProfessor().getId());
            newUser.execute();
            newUser.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void cadastrarDisciplinaSemProfessor(Disciplina disciplina){
        ConectionDB conectionDB = new ConectionDB();

        String create = "INSERT INTO disciplina (nome) VALUES (?)";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newUser = con.prepareStatement(create);
            newUser.setString(1, disciplina.getNome());
            newUser.execute();
            newUser.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static ArrayList<Disciplina> retornarDisciplinas(String nome){
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        ConectionDB conectionDB = new ConectionDB();
        ProfessorDao professorDao = new ProfessorDao();

        String read = "SELECT * FROM disciplina WHERE nome LIKE ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, nome+"%");
            ResultSet rs = readUser.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();

                disciplina.setNome(rs.getString("nome"));
                disciplina.setCodigo(rs.getInt("codigo"));
                disciplina.setProfessor(professorDao.retornarProfessor(rs.getInt("id_professor")));

                disciplinas.add(disciplina);
            }

            rs.close();
            readUser.close();
            con.close();
            return disciplinas;

        } catch (Exception e) {

            System.out.println(e);
            return null;

        }
    }
    public static ArrayList<Disciplina> retornarTodasDisciplinas(){
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        ConectionDB conectionDB = new ConectionDB();
        ProfessorDao professorDao = new ProfessorDao();

        String read = "SELECT * FROM disciplina";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            ResultSet rs = readUser.executeQuery();

            while (rs.next()) {
                Disciplina disciplina = new Disciplina();

                disciplina.setNome(rs.getString("nome"));
                disciplina.setCodigo(rs.getInt("codigo"));
                disciplina.setProfessor(professorDao.retornarProfessor(rs.getInt("id_professor")));
                disciplinas.add(disciplina);

            }

            rs.close();
            readUser.close();
            con.close();
            return disciplinas;

        } catch (Exception e) {

            System.out.println(e);
            return null;

        }
    }
    public void excluirDisciplina(int codigo){
        ConectionDB conectionDB = new ConectionDB();

        String create = "DELETE FROM disciplina WHERE codigo = ?";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newUser = con.prepareStatement(create);
            newUser.setInt(1, codigo);
            newUser.execute();
            newUser.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void editarDisciplina(Disciplina disciplina){
        ConectionDB conectionDB = new ConectionDB();

        String create = "UPDATE disciplina SET nome=?, id_professor=? WHERE codigo = ?";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newUser = con.prepareStatement(create);
            newUser.setString(1, disciplina.getNome());
            newUser.setInt(2, disciplina.getProfessor().getId());
            newUser.setInt(3, disciplina.getCodigo());
            newUser.executeUpdate();
            newUser.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void editarDisciplinaSemProfessor(Disciplina disciplina){
        ConectionDB conectionDB = new ConectionDB();

        String create = "UPDATE disciplina SET nome=?, id_professor=null WHERE codigo = ?";
        try{
            Connection con = conectionDB.conectar();
            PreparedStatement newUser = con.prepareStatement(create);
            newUser.setString(1, disciplina.getNome());
            newUser.setInt(2, disciplina.getCodigo());
            newUser.executeUpdate();
            newUser.close();
            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}

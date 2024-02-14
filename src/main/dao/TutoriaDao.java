package main.dao;
import main.model.Tutoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

public class TutoriaDao {
    public static ArrayList<Tutoria> retornarTutoriaParaTutor(int id){
        ConectionDB conectionDB = new ConectionDB();
        TutoradoDao tutoradoDao = new TutoradoDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT * FROM tutoria WHERE id_tutor = ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt(1));
                tutoria.setSenha(rs.getString(2));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt(4)));
                tutoria.setDisciplina(disciplinaDao.retornarDisciplina(rs.getInt(5)));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static ArrayList<Tutoria> retornarTutoriaParaTutorado(int id){
        ConectionDB conectionDB = new ConectionDB();
        TutorDao tutorDao = new TutorDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT * FROM tutoria WHERE id_tutorado = ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt(1));
                tutoria.setSenha(rs.getString(2));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt(3)));
                tutoria.setDisciplina(DisciplinaDao.retornarDisciplina(rs.getInt(5)));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<Tutoria> retornarTutoriaParaProfessor(int id){
        ConectionDB conectionDB = new ConectionDB();
        TutorDao tutorDao = new TutorDao();
        TutoradoDao tutoradoDao = new TutoradoDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT t.codigo,t.senha,t.id_tutor,t.id_tutorado,t.codigo_disciplina FROM tutoria t INNER JOIN disciplina d ON t.codigo_disciplina=d.codigo INNER JOIN usuario u ON d.id_professor = ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setInt(1, id);
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt(1));
                tutoria.setSenha(rs.getString(2));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt(3)));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt(4)));
                tutoria.setDisciplina(DisciplinaDao.retornarDisciplina(rs.getInt(5)));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static boolean lerTutoria (Tutoria tutoria)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String read = "SELECT * FROM tutoria WHERE codigo = ? AND senha = ?";

        try
        {
            ps = con.conectar().prepareStatement(read);
            ps.setInt(1, tutoria.getCodigo());
            ps.setString(2, tutoria.getSenha());
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

    public static void atualizarTutoriaTutorado(Tutoria tutoria, int id)
    {
        ConectionDB con = new ConectionDB();
        String update = "UPDATE tutoria SET id_tutorado = ? WHERE codigo = ?";
        PreparedStatement ps = null;

        try
        {
            ps = con.conectar().prepareStatement(update);
            ps.setInt(1, id);
            ps.setInt(2, tutoria.getCodigo());
            ps.execute();
            ps.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


    public static void atualizarTutoriaTutor(Tutoria tutoria, int id)
    {
        ConectionDB con = new ConectionDB();
        String update = "UPDATE tutoria SET id_tutor = ? WHERE codigo = ?";
        PreparedStatement ps = null;

        try
        {
            ps = con.conectar().prepareStatement(update);
            ps.setInt(1, id);
            ps.setInt(2, tutoria.getCodigo());
            ps.execute();
            ps.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static ArrayList<Tutoria> retornarTodasTutorias(){
        ConectionDB conectionDB = new ConectionDB();
        TutoradoDao tutoradoDao = new TutoradoDao();
        TutorDao tutorDao = new TutorDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT * FROM tutoria";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt(1));
                tutoria.setSenha(rs.getString(2));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt(3)));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt(4)));
                tutoria.setDisciplina(disciplinaDao.retornarDisciplina(rs.getInt(5)));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasMatriculaTutor(String matricula){
        ConectionDB conectionDB = new ConectionDB();
        TutoradoDao tutoradoDao = new TutoradoDao();
        TutorDao tutorDao = new TutorDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT * FROM tutoria t INNER JOIN usuario u on t.id_tutor = u.id WHERE matricula = ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, matricula);
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt(1));
                tutoria.setSenha(rs.getString(2));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt(3)));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt(4)));
                tutoria.setDisciplina(disciplinaDao.retornarDisciplina(rs.getInt(5)));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasMatriculaTutorado(String matricula){
        ConectionDB conectionDB = new ConectionDB();
        TutoradoDao tutoradoDao = new TutoradoDao();
        TutorDao tutorDao = new TutorDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT * FROM tutoria t INNER JOIN usuario u on t.id_tutorado = u.id WHERE matricula = ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, matricula);
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt(1));
                tutoria.setSenha(rs.getString(2));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt(3)));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt(4)));
                tutoria.setDisciplina(disciplinaDao.retornarDisciplina(rs.getInt(5)));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasNomeTutor(String nome){
        ConectionDB conectionDB = new ConectionDB();
        TutoradoDao tutoradoDao = new TutoradoDao();
        TutorDao tutorDao = new TutorDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT * FROM tutoria t INNER JOIN usuario u on t.id_tutor = u.id WHERE nome LIKE ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, nome + "%");
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt("codigo"));
                tutoria.setSenha(rs.getString("senha"));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt("id_tutor")));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt("id_tutorado")));
                tutoria.setDisciplina(disciplinaDao.retornarDisciplina(rs.getInt("codigo_disciplina")));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasNomeTutorado(String nome){
        ConectionDB conectionDB = new ConectionDB();
        TutoradoDao tutoradoDao = new TutoradoDao();
        TutorDao tutorDao = new TutorDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT * FROM tutoria t INNER JOIN usuario u on t.id_tutorado = u.id WHERE nome LIKE ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, nome + "%");
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt("codigo"));
                tutoria.setSenha(rs.getString("senha"));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt("id_tutor")));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt("id_tutorado")));
                tutoria.setDisciplina(disciplinaDao.retornarDisciplina(rs.getInt("codigo_disciplina")));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasNomeDisciplina(String nome){
        ConectionDB conectionDB = new ConectionDB();
        TutoradoDao tutoradoDao = new TutoradoDao();
        TutorDao tutorDao = new TutorDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT * FROM tutoria t INNER JOIN disciplina d on t.codigo_disciplina = d.codigo WHERE nome LIKE ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, nome + "%");
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt("codigo"));
                tutoria.setSenha(rs.getString("senha"));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt("id_tutor")));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt("id_tutorado")));
                tutoria.setDisciplina(disciplinaDao.retornarDisciplina(rs.getInt("codigo_disciplina")));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static ArrayList<Tutoria> retornarTodasTutoriasGenerico(String nome){
        ConectionDB conectionDB = new ConectionDB();
        TutoradoDao tutoradoDao = new TutoradoDao();
        TutorDao tutorDao = new TutorDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ArrayList<Tutoria> tutorias = new ArrayList<>();

        String read = "SELECT * FROM tutoria t INNER JOIN disciplina d on t.codigo_disciplina = d.codigo INNER JOIN usuario u1 on t.id_tutorado = u1.id INNER JOIN usuario u2 on t.id_tutor = u2.id WHERE d.nome LIKE ? OR u1.nome LIKE ? OR u2.nome LIKE ?";

        try {
            Connection con = conectionDB.conectar();
            PreparedStatement readUser = con.prepareStatement(read);
            readUser.setString(1, nome + "%");
            readUser.setString(2, nome + "%");
            readUser.setString(3, nome + "%");
            ResultSet rs = readUser.executeQuery();

            while (rs.next()){
                Tutoria tutoria = new Tutoria();
                tutoria.setCodigo(rs.getInt("codigo"));
                tutoria.setSenha(rs.getString("senha"));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt("id_tutor")));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt("id_tutorado")));
                tutoria.setDisciplina(disciplinaDao.retornarDisciplina(rs.getInt("codigo_disciplina")));
                tutorias.add(tutoria);
            }
            return tutorias;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static Tutoria retornaTutoria(int codigo)
    {
        Tutoria tutoria = new Tutoria();
        TutoradoDao tutoradoDao = new TutoradoDao();
        TutorDao tutorDao = new TutorDao();
        DisciplinaDao disciplinaDao = new DisciplinaDao();
        ConectionDB conectionDB = new ConectionDB();
        String sql = "SELECT * FROM tutoria WHERE codigo = ?";

        try
        {
            Connection con = conectionDB.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                tutoria.setCodigo(rs.getInt(1));
                tutoria.setSenha(rs.getString(2));
                tutoria.setTutor(tutorDao.retornarTutor(rs.getInt(3)));
                tutoria.setTutorado(tutoradoDao.retornarTutorado(rs.getInt(4)));
                tutoria.setDisciplina(disciplinaDao.retornarDisciplina(rs.getInt(5)));
                return tutoria;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        return null;
    }

    public static void criarTutoria(Tutoria tutoria)
    {
        ConectionDB conectionDB = new ConectionDB();
        String sql = "INSERT INTO tutoria (senha,id_tutor,id_tutorado,codigo_disciplina) VALUES (?, ?, ?, ?)";

        try
        {
            PreparedStatement ps = conectionDB.conectar().prepareStatement(sql);
            ps.setString(1, tutoria.getSenha());
            if (tutoria.getTutor() != null) {
                ps.setInt(2, tutoria.getTutor().getId());
            } else {
                ps.setNull(2, Types.INTEGER);
            }
            if (tutoria.getTutorado() != null) {
                ps.setInt(3, tutoria.getTutorado().getId());
            } else {
                ps.setNull(3, Types.INTEGER);
            }
            ps.setInt(4, tutoria.getDisciplina().getCodigo());
            ps.execute();
            ps.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static Tutoria selecionaUltimaTutoria(Tutoria tutoria)
    {
        ConectionDB con = new ConectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT t.codigo, t.senha FROM tutoria t INNER JOIN (SELECT MAX(codigo) as ultimo_codigo FROM tutoria) max_t ON t.codigo = max_t.ultimo_codigo";
        try
        {
            ps = con.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next())
            {
                tutoria.setCodigo(rs.getInt(1));
                tutoria.setSenha(rs.getString(2));
            }
            ps.close();
            return tutoria;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return tutoria;
    }


}

package main.dao;
import jdk.jshell.spi.ExecutionControl;
import main.model.Tutoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}

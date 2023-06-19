package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;
import util.DML_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TiereDAO {
    public static ObservableList<Tiere> getTiere () { //Gibt eine Liste der Tiere aus der Datenbank zurück
            ObservableList<Tiere> tiereList =
                FXCollections.observableArrayList();
        Connection con;
        Tiere tiere;
        
        try {
            con = DBConnector.connect();
            String sql = "SELECT * FROM tiere";
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                tiereList.add(new Tiere(
                     rs.getInt("TiereId"),
                     rs.getString("TName"),
                     rs.getString("Art"),
                     rs.getInt("Alter"),
                     rs.getString("Geschlecht"),
                     rs.getInt("Gehege"),
                     rs.getTime("Futterzeit")
                ));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return tiereList;
    }

    public static String getTiereById (int id) {
        Connection con;
        String Tiere = "no Tiere";
        
        try {
            con = DBConnector.connect();
            String sql = "SELECT * FROM Tiere Where id = " + id;
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            rs.first();
            Tiere = rs.getString("Tiere");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Tiere;
    }

    public static void update(Tiere actTiere) {
        String sql = "UPDATE Tiere SET "
                + " Name  = '" + actTiere.getTName() + "'"
                + ", Art  = '" + actTiere.getArt() + "'"
                + ", Alter = " + actTiere.getAlter() + "'"
                + ", Geschlecht = '" + actTiere.getGeschlecht() + "'"
                + ", Gehege = " + actTiere.getGehege()
                + ", Futterzeit = '" + actTiere.getFutterzeit() + "'"
                + " WHERE id = " + actTiere.getTId();
        System.out.println("sql: " + sql);
    }
    public static void deleteTiere(Tiere tiere) {
        String sql = "DELETE FROM Tiere WHERE TiereId = " + tiere.getTId();
        DML_DAO.executeDML(sql);
    }
}
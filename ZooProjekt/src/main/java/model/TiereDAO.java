package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TiereDAO {
    public static ObservableList<Tiere> getTiere () {
            ObservableList<Tiere> Zoo =
                FXCollections.observableArrayList();
        Connection con;
        Tiere tiere;
        
        try {
            con = DBConnector.connect();
            String sql = "SELECT * FROM Tiere";
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                tiere = new Tiere(
                     rs.getInt("id"),
                     rs.getString("Name"),
                     rs.getString("Art"),
                     rs.getInt("Alter"),
                     rs.getString("Geschlecht"),
                     rs.getInt("Gehege"),
                     rs.getDate("Futterzeit")
                );
                Zoo.add(tiere);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return Tiere;
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
}

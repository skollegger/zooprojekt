package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;
import util.DML_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ZooDAO { //hier wird das Objekt gemacht
    public static ObservableList<Zoo> getZoo () {//Gibt eine Liste der Zoo´s aus der Datenbank zurück
        ObservableList<Zoo> zooList =
                FXCollections.observableArrayList();
        Connection con;
        
        try {
            con = DBConnector.connect();
            String sql = "SELECT * from zoo";
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                zooList.add(new Zoo(
                     rs.getInt("ZooId"),
                     rs.getString("ZName"),
                     rs.getString("Ort"),
                     rs.getInt("Eintrittskosten"),
                     rs.getTime("Oeffnungszeiten"),
                     rs.getTime("Schliesszeit"))
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return zooList;
    }
    public static String getZooById (int id) {
        Connection con;
        String Zoo = "no Zoo";

        try {
            con = DBConnector.connect();
            String sql = "SELECT z.* FROM Zoo z Where id = " + id;
            ResultSet rs = con.createStatement().executeQuery(sql);

            rs.first();
            Zoo = rs.getString("Zoo");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Zoo;
    }

    public static void update(Zoo actZoo) {
        String sql = "UPDATE persons SET "
                + " Name  = '" + actZoo.getZName() + "'"
                + ", Ort  = '" + actZoo.getOrt() + "'"
                + ", Eintrittskosten = " + actZoo.getEintrittskosten()  + "'"
                + ", Oeffnungszeiten = '" + actZoo.getOeffnungszeiten() + "'"
                + ", Schliesszeiten = '" + actZoo.getSchliesszeiten() + "'"
                + " WHERE id = " + actZoo.getZId();
        System.out.println("sql: " + sql);
    }
    public static void deleteZoo(Zoo zoo) {
        String sql = "DELETE FROM zoo WHERE ZId = " + zoo.getZId();
        DML_DAO.executeDML(sql);
    }
}

package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;
import util.DML_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ZooDAO {
    public static ObservableList<Zoo> getZoo () {
        ObservableList<Zoo> zooList =
                FXCollections.observableArrayList();
        Connection con;
        
        try {
            con = DBConnector.connect();
            String sql = "SELECT z.*, t.TId, m.MId From  Zoo z, Tiere t, Mitarbeiter m";
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                zooList.add(new Zoo(
                     rs.getInt("Id"),
                     rs.getString("Name"),
                     rs.getString("Ort"),
                     rs.getInt("Eintrittskosten"),
                     rs.getTime("Oeffnungszeiten"),
                     rs.getTime("Schliesszeiten"),
                     rs.getString("department"),
                     rs.getString("Tiere"),
                     rs.getString("Mitarbeiter"),
                     rs.getInt("TierId"),
                     rs.getInt("MitarbeiterId"))
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
                + " Name  = '" + actZoo.getName() + "'"
                + ", Ort  = '" + actZoo.getOrt() + "'"
                + ", Eintrittskosten = " + actZoo.getEintrittskosten()  + "'"
                + ", Oeffnungszeiten = '" + actZoo.getOeffnungszeiten() + "'"
                + ", Schliesszeiten = '" + actZoo.getSchliesszeiten() + "'"
                + " WHERE id = " + actZoo.getZId();
        System.out.println("sql: " + sql);
        DML_DAO.executeDML(sql);
        /*
        for (Person p : persons) {
            if (p.getId() == actPerson.getId()) {
                p.setFirstName(actPerson.getFirstName());
                p.setLastName(actPerson.getLastName());
                p.setYob(actPerson.getYob());
                p.setFullTime(actPerson.isFullTime());
                p.setCountryId(actPerson.getCountryId());
                //System.out.println("set coutryId: " + p.getCountryId());
                break;
            }
        }
        */
        //for (Person p : persons) 
        //        System.out.println(p);
    }
    
    
}

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
            String sql = "SELECT z.* From  Zoo z";
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                zooList.add(new Zoo(
                     rs.getInt("Id"),
                     rs.getString("Name"),
                     rs.getString("Ort"),
                     rs.getInt("Eintrittskosten"),
                     rs.getDate("Oeffnungszeiten"),
                     rs.getDate("Schliesszeiten"))
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return zooList;
    }

    public static void update(Zoo actZoo) {
        String sql = "UPDATE persons SET "
                + " Name  = '" + actZoo.getName() + "'"
                + ", Ort  = '" + actZoo.getOrt() + "'"
                + ", Eintrittskosten = " + actZoo.getEintrittskosten()  + "'"
                + ", Oeffnungszeiten = '" + actZoo.getOeffnungszeiten() + "'"
                + ", Schliesszeiten = '" + (actZoo.getSchliesszeiten() ? 'y':'n') + "'"
                + " WHERE id = " + actZoo.getZooId();
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

package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TiereDAO {
    public static ObservableList<Tiere> getCountries () {
        ObservableList<Tiere> countries =
                FXCollections.observableArrayList();
        Connection con;
        Tiere tiere;
        
        try {
            con = DBConnector.connect();
            String sql = "SELECT * FROM countries";
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                tiere = new Tiere(
                     rs.getInt("id"),
                     rs.getString("country"),
                     rs.getString("country_code"),
                     rs.getInt("area")
                );
                countries.add(tiere);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return countries;
    }

    public static String getCountryById (int id) {
        Connection con;
        String country = "no country";
        
        try {
            con = DBConnector.connect();
            String sql = "SELECT * FROM countries Where id = " + id;
            ResultSet rs = con.createStatement().executeQuery(sql);
            
            rs.first();
            country = rs.getString("country");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return country;
    }
}

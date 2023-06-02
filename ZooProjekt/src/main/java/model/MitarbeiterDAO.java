package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MitarbeiterDAO {
    public static ObservableList<Mitarbeiter> getMitarbeiter () {
        ObservableList<Mitarbeiter> Zoo =
                FXCollections.observableArrayList();
        Connection con;
        Mitarbeiter mitarbeiter;

        try {
            con = DBConnector.connect();
            String sql = "SELECT * FROM Mitarbeiter";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                mitarbeiter = new Mitarbeiter(
                        rs.getInt("id"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getInt("Plz"),
                        rs.getString("Strasse"),
                        rs.getInt("HausNr"),
                        rs.getDate("Geburtstag")
                );
                Zoo.add(mitarbeiter);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return Zoo;
    }

    public static String getMitarbeiterById (int id) {
        Connection con;
        String Mitarbeiter = "no Mitarbeiter";

        try {
            con = DBConnector.connect();
            String sql = "SELECT * FROM countries Where id = " + id;
            ResultSet rs = con.createStatement().executeQuery(sql);

            rs.first();
            Mitarbeiter = rs.getString("country");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Mitarbeiter;
    }
}

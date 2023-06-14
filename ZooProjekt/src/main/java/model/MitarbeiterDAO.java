package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;
import util.DML_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MitarbeiterDAO {
    public static ObservableList<Mitarbeiter> getMitarbeiter() {
        ObservableList<Mitarbeiter> mitarbeiterList =
                FXCollections.observableArrayList();
        Connection con;
        Mitarbeiter mitarbeiter;

        try {
            con = DBConnector.connect();
            String sql = "SELECT m.* FROM mitarbeiter m";
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                mitarbeiterList.add(new Mitarbeiter(
                        rs.getInt("id"),
                        rs.getString("Vorname"),
                        rs.getString("Nachname"),
                        rs.getInt("Plz"),
                        rs.getString("Strasse"),
                        rs.getInt("HausNr"),
                        rs.getDate("Geburtstag")
                ));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return mitarbeiterList;
    }
    public static String getMitarbeiterById (int id) {
        Connection con;
        String Mitarbeiter = "no Mitarbeiter";

        try {
            con = DBConnector.connect();
            String sql = "SELECT m.* FROM Mitarbeiter m Where id = " + id;
            ResultSet rs = con.createStatement().executeQuery(sql);

            rs.first();
            Mitarbeiter = rs.getString("Mitarbeiter");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return Mitarbeiter;
    }
    public static void update(Mitarbeiter actMitarbeiter) {
        String sql = "UPDATE Mitarbeiter SET "
                + " Vorname  = '" + actMitarbeiter.getVorname() + "'"
                + ", Nachname  = '" + actMitarbeiter.getNachname() + "'"
                + ", Plz = " + actMitarbeiter.getPlz() + "'"
                + ", Strasse = '" + actMitarbeiter.getStrasse() + "'"
                + ", HausNr = " + actMitarbeiter.getHausNr()
                + ", Geburtstag = '" + actMitarbeiter.getGeburtstag() + "'"
                + " WHERE id = " + actMitarbeiter.getMId();
        System.out.println("sql: " + sql);
        DML_DAO.executeDML(sql);
    }
}
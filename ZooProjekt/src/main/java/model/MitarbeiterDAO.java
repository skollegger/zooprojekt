package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MitarbeiterDAO {
    public static ObservableList<Mitarbeiter> getMitarbeiter () {
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
                );
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return mitarbeiterList;
    }
    public static void update(Mitarbeiter actMitarbeiter) {
        String sql = "UPDATE Mitarbeiter SET "
                + " Vorname  = '" + actMitarbeiter.getVorname() + "'"
                + ", Nachname  = '" + actMitarbeiter.getNachname() + "'"
                + ", Plz = " + actMitarbeiter.getPlz() + "'"
                + ", Strasse = '" + actMitarbeiter.getStrasse() + "'"
                + ", HausNr = " + actMitarbeiter.getHausNr()
                + ", Geburtstag = '" + (actMitarbeiter.getGeburtstag() ? 'y' : 'n') + "'"
                + " WHERE id = " + actMitarbeiter.getId();
        System.out.println("sql: " + sql);
        DML_DAO.executeDML(sql);
    }
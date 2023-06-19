package model;
import java.util.Date;

public class Mitarbeiter {
    private int MitarbeiterId; //Parameter
    private String Vorname;
    private String Nachname;
    private Integer Plz;
    private String Strasse;
    private Integer HausNr;
    private Date Geburtstag;

    public Mitarbeiter(int mitarbeiterId, String vorname, String nachname,
                       Integer plz, String strasse, Integer HausNr, Date geburtstag) {
        MitarbeiterId = mitarbeiterId;
        Vorname = vorname;
        Nachname = nachname;
        Plz = plz;
        Strasse = strasse;
        this.HausNr = HausNr;
        Geburtstag = geburtstag;
    }

    public int getMitarbeiterId() {
        return MitarbeiterId;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        Vorname = vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) {
        Nachname = nachname;
    }

    public Integer getPlz() {
        return Plz;
    }

    public void setPlz(Integer plz) {
        Plz = plz;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public Integer getHausNr() {
        return HausNr;
    }

    public void setHausNr(Integer HausNr) {
        this.HausNr = HausNr;
    }

    public Date getGeburtstag() {
        return Geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        Geburtstag = geburtstag;
    }

    @Override
    public String toString() {
        return  "Vorname: " + Vorname +
                ", Nachname: " + Nachname;
    }
}
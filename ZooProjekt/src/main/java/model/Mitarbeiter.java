package model;

import java.util.Date;

public class Mitarbeiter {
    private int id;
    private String Vorname;
    private String Nachname;
    private int Plz;
    private String Strasse;
    private int HausNr;
    private Date Geburtstag;

    public Mitarbeiter(int id, String Vorname, String Nachname, int Plz, String Strasse, int HausNr, Date Geburtstag) {
        this.id = id;
        Vorname = Vorname;
        Nachname = Nachname;
        Plz = Plz;
        Strasse = Strasse;
        HausNr = HausNr;
        Geburtstag = Geburtstag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPlz() {
        return Plz;
    }

    public void setPlz(int plz) {
        Plz = plz;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public int getHausNr() {
        return HausNr;
    }

    public void setHausNr(int hausNr) {
        HausNr = hausNr;
    }

    public Date getGeburtstag() {
        return Geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        Geburtstag = geburtstag;
    }
/*
@Override
public String toString() {
    return country;
}

*/
}

package model;

import java.util.Date;

public class Tiere {
    private int TId;
    private String Name;
    private String Art;
    private int Alter;
    private String Geschlecht;
    private int Gehege;
    private Date Futterzeit;

    public Tiere(int id, String name, String art, int alter, String geschlecht, int gehege, Date futterzeit) {
        this.TId = id;
        Name = name;
        Art = art;
        Alter = alter;
        Geschlecht = geschlecht;
        Gehege = gehege;
        Futterzeit = futterzeit;
    }
    public int getTId() {
        return TId;
    }
    public void setTId(int TId) {
        this.TId = TId;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getArt() {
        return Art;
    }

    public void setArt(String art) {
        Art = art;
    }

    public int getAlter() {
        return Alter;
    }

    public void setAlter(int alter) {
        Alter = alter;
    }

    public String getGeschlecht() {
        return Geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        Geschlecht = geschlecht;
    }

    public int getGehege() {
        return Gehege;
    }

    public void setGehege(int gehege) {
        Gehege = gehege;
    }

    public Date getFutterzeit() {
        return Futterzeit;
    }

    public void setFutterzeit(Date futterzeit) {
        Futterzeit = futterzeit;
    }
}

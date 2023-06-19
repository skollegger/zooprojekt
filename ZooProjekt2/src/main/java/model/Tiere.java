package model;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class Tiere {
    private int TiereId;
    private String TName;
    private String Art;
    private int Alter;
    private String Geschlecht;
    private int Gehege;
    private Time Futterzeit;

    public Tiere(int id, String name, String art, int alter, String geschlecht, int gehege, Time futterzeit) {
        this.TiereId = id;
        TName = name;
        Art = art;
        Alter = alter;
        Geschlecht = geschlecht;
        Gehege = gehege;
        Futterzeit = futterzeit;
    }
    public int getTId() {
        return TiereId;
    }
    public void setTId(int TId) {
        this.TiereId = TId;
    }
    public String getTName() {
        return TName;
    }

    public void setTName(String name) {
        TName = name;
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

    public void setFutterzeit(Time futterzeit) {
        Futterzeit = futterzeit;
    }
    @Override
    public String toString() {
        return  "Tiername " + TName +
                ", Gehege:  " + Gehege;
    }
}

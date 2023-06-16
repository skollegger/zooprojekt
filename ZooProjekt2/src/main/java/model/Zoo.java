package model;

import java.sql.Time;

public class Zoo {
    private int ZooId;
    private String ZName;
    private String Ort;
    private Integer Eintrittskosten;
    private Time Oeffnungszeiten;
    private Time Schliesszeiten;
    private int TiereId;
    private int MitarbeiterId;


    public Zoo(int id, String name, String ort, Integer eintrittskosten,
               Time oeffnungszeiten, Time schliesszeiten,
               int TId, int MId) {
        this.ZooId = id;
        ZName = name;
        Ort = ort;
        Eintrittskosten = eintrittskosten;
        Oeffnungszeiten = oeffnungszeiten;
        Schliesszeiten = schliesszeiten;
        this.TiereId = TId;
        this.MitarbeiterId = MId;
    }

    public Zoo(int ZId, String name, String ort, Integer eintrittskosten,
               Time oeffnungszeiten, Time schliesszeiten) {
        this.ZooId = ZId;
        ZName = name;
        Ort = ort;
        Eintrittskosten = eintrittskosten;
        Oeffnungszeiten = oeffnungszeiten;
        Schliesszeiten = schliesszeiten;
    }

    public int getZId() {
        return ZooId;
    }

    public String getZName() {
        return ZName;
    }

    public void setZName(String name) {
        ZName = name;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public Integer getEintrittskosten() {
        return Eintrittskosten;
    }

    public void setEintrittskosten(Integer eintrittskosten) {
        Eintrittskosten = eintrittskosten;
    }

    public Time getOeffnungszeiten() {
        return Oeffnungszeiten;
    }
    public void setOeffnungszeiten(Time oeffnungszeiten) {
        Oeffnungszeiten = oeffnungszeiten;
    }

    public Time getSchliesszeiten() {
        return Schliesszeiten;
    }

    public void setSchliesszeiten(Time schliesszeiten) {
        Schliesszeiten = schliesszeiten;
    }

    public int getTiereId() {
        return TiereId;
    }
    public int getMitarbeiterID(){
        return MitarbeiterId;
    }

    @Override
    public String toString() {
        return  "Zooname " + ZName +
                ", Ort " + Ort;
    }
}
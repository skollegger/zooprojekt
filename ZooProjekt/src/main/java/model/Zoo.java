package model;

import java.sql.Time;

public class Zoo {
    private int ZId;
    private String Name;
    private String Ort;
    private Integer Eintrittskosten;
    private Time Oeffnungszeiten;
    private Time Schliesszeiten;

    public Zoo(int id, String name, String ort, Integer eintrittskosten,
               Time oeffnungszeiten, Time schliesszeiten) {
        this.ZId = id;
        Name = name;
        Ort = ort;
        Eintrittskosten = eintrittskosten;
        Oeffnungszeiten = oeffnungszeiten;
        Schliesszeiten = schliesszeiten;
    }

    public int getZId() {
        return ZId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
}
package model;

import java.util.Date;

public class Zoo {
    private int ZId;
    private String Name;
    private String Ort;
    private Integer Eintrittskosten;
    private Date Oeffnungszeiten;
    private Date Schliesszeiten;

    public Zoo(int id, String name, String ort, Integer eintrittskosten,
               Date oeffnungszeiten, Date schliesszeiten) {
        this.ZId = id;
        Name = name;
        Ort = ort;
        Eintrittskosten = eintrittskosten;
        Oeffnungszeiten = oeffnungszeiten;
        Schliesszeiten = schliesszeiten;
    }

    public void getZId(int id) {
        this.ZId = id;
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

    public Date getOeffnungszeiten() {
        return Oeffnungszeiten;
    }

    public void setOeffnungszeiten(Date oeffnungszeiten) {
        Oeffnungszeiten = oeffnungszeiten;
    }

    public Date getSchliesszeiten() {
        return Schliesszeiten;
    }

    public void setSchliesszeiten(Date schliesszeiten) {
        Schliesszeiten = schliesszeiten;
    }
}
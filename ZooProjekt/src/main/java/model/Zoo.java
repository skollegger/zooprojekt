package model;

import java.sql.Time;

public class Zoo {
    private int ZId;
    private String Name;
    private String Ort;
    private Integer Eintrittskosten;
    private Time Oeffnungszeiten;
    private Time Schliesszeiten;
    private String department;
    private int TId;
    private int MId;
    private String mitarbeiter;

    private String tiere;


    public Zoo(int id, String name, String ort, Integer eintrittskosten,
               Time oeffnungszeiten, Time schliesszeiten,
               String department, String tiere, String mitarbeiter, int TId, int MId) {
        this.ZId = id;
        Name = name;
        Ort = ort;
        Eintrittskosten = eintrittskosten;
        Oeffnungszeiten = oeffnungszeiten;
        Schliesszeiten = schliesszeiten;
        this.department = "Graz";
        this.TId = TId;
        this.MId = MId;
        this.mitarbeiter = new String(mitarbeiter);
        this.tiere = new String(tiere);

    }

    public Zoo(int ZId, String name, String ort, Integer eintrittskosten,
               Time oeffnungszeiten, Time schliesszeiten, String department) {
        this.ZId = ZId;
        Name = name;
        Ort = ort;
        Eintrittskosten = eintrittskosten;
        Oeffnungszeiten = oeffnungszeiten;
        Schliesszeiten = schliesszeiten;
        this.department = department;
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

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDepartment() {
        return department;
    }
    public int getTId() {
        return TId;
    }
    public int getMID(){
        return MId;
    }
}
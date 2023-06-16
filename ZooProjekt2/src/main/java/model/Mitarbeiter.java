package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Mitarbeiter {
    private int MitarbeiterId;
    private StringProperty vornameProperty;
    private StringProperty nachnameProperty;
    private IntegerProperty plzProperty;
    private StringProperty strasseProperty;
    private IntegerProperty hausNrProperty;
    private Date gebProperty;

    public Mitarbeiter(int id, String vorname, String nachname, int plz, String strasse, int hausNr, Date geb) {
        this.MitarbeiterId = id;
        this.vornameProperty = new SimpleStringProperty(vorname);
        this.nachnameProperty = new SimpleStringProperty(nachname);
        this.plzProperty = new SimpleIntegerProperty(plz);
        this.strasseProperty = new SimpleStringProperty(strasse);
        this.hausNrProperty = new SimpleIntegerProperty(hausNr);
        gebProperty = geb;
    }

    public int getMId() {
        return MitarbeiterId;
    }

    public String getVornameProperty() {
        return vornameProperty.get();
    }

    public StringProperty vornamePropertyProperty() {
        return vornameProperty;
    }

    public void setVornameProperty(String vornameProperty) {
        this.vornameProperty.set(vornameProperty);
    }

    public String getNachnameProperty() {
        return nachnameProperty.get();
    }

    public StringProperty nachnamePropertyProperty() {
        return nachnameProperty;
    }

    public void setNachnameProperty(String nachnameProperty) {
        this.nachnameProperty.set(nachnameProperty);
    }

    public int getPlzProperty() {
        return plzProperty.get();
    }

    public IntegerProperty plzPropertyProperty() {
        return plzProperty;
    }

    public void setPlzProperty(int plzProperty) {
        this.plzProperty.set(plzProperty);
    }

    public String getStrasseProperty() {
        return strasseProperty.get();
    }

    public StringProperty strassePropertyProperty() {
        return strasseProperty;
    }

    public void setStrasseProperty(String strasseProperty) {
        this.strasseProperty.set(strasseProperty);
    }

    public int getHausNrProperty() {
        return hausNrProperty.get();
    }

    public IntegerProperty hausNrPropertyProperty() {
        return hausNrProperty;
    }

    public void setHausNrProperty(int hausNrProperty) {
        this.hausNrProperty.set(hausNrProperty);
    }

    public Date getGebProperty() {
        return gebProperty;
    }

    public void setGebProperty(Date gebProperty) {
        this.gebProperty = gebProperty;
    }
}
package model;

import javafx.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.property.StringProperty;

public class Zoo {
    private int id;
    private StringProperty NameProperty;
    private StringProperty OrtProperty;
    private IntegerProperty EintrittskostenProperty;
    private Date Oeffnungszeiten;
    private Date Schliesszeiten;

    public Zoo(int id, String lastName, String firstName, int yob) {
        this.id = id;
        this.lastNameProperty = new SimpleStringProperty (lastName);
        this.firstNameProperty = new SimpleStringProperty (firstName);
        this.yobProperty = new SimpleIntegerProperty (yob);
        this.fullTimeProperty = new SimpleBooleanProperty(false);
        this.department = "IT";
    }

    public Zoo(int id, String lastName, String firstName, int yob,
               String department, boolean fullTime, int countryId, String country) {
        this(id, lastName, firstName, yob);         //eigener Konstruktoraufruf
        this.department = department;
        //this.fullTimeProperty = new SimpleBooleanProperty(fullTime);
        this.fullTimeProperty.set(fullTime);
        this.countryId = countryId;
        this.countryProperty = new SimpleStringProperty(country);
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastNameProperty.get();
    }

    public String getFirstName() {
        return firstNameProperty.get();
    }

    public int getYob() {
        return yobProperty.get();
    }

    @Override
    public String toString() {
        //return String.format("%16s %16s", lastName, firstName);
        return lastNameProperty.get() + ' ' + firstNameProperty.get();
    }

    public void setLastName(String lastName) {
        this.lastNameProperty.set(lastName);
    }

    public void setFirstName(String firstName) {
        this.firstNameProperty.set(firstName);
    }

    public void setYob(int yob) {
        this.yobProperty.set(yob);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isFullTime() {
        return fullTimeProperty.get();
    }

    public void setFullTime(boolean fullTime) {
        this.fullTimeProperty.set(fullTime);
    }

    public int getCountryId() {
        return countryId;
    }
    
    public String getCountry() {
        return this.countryProperty.get();
    }
    
    public void setCountry (String country) {
        this.countryProperty.set(country);
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
    //wegen TableColunm
    public StringProperty lastNameProperty(){
        return this.lastNameProperty;
    }
    
    public StringProperty firstNameProperty(){
        return this.firstNameProperty;
    }
    
    public IntegerProperty yobProperty(){
        return this.yobProperty;
    }
    
    public BooleanProperty fullTimeProperty(){
        return this.fullTimeProperty;
    }
    
    public StringProperty countryStringProperty(){
        return this.countryProperty;
    }
}
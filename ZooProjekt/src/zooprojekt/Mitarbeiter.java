/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zooprojekt;

import java.util.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author julia
 */
public class Mitarbeiter {
    private int MitarbeiterId;
    private StringProperty Vorname;
    private StringProperty Nachname;
    private IntegerProperty Plz;
    private StringProperty Strasse;
    private StringProperty HausNr;
    private Date Geburtstag;
}

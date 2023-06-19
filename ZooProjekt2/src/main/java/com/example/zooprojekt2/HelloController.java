package com.example.zooprojekt2;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.util.Callback;
import model.*;

import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;

public class HelloController implements Initializable  {

    @FXML
    private TableColumn<Zoo, String> tcName;
    @FXML
    private TableColumn<Zoo, Time> tcOeffnungszeiten;
    @FXML
    private TableColumn<Zoo, Time> tcSchliesszeiten;
    @FXML
    private TableColumn<Zoo, String> tcOrt;
    @FXML
    private TableColumn<Zoo, Integer> tcEintrittskosten;
    @FXML
    private ChoiceBox cbZoo;
    @FXML
    private Button btnShowZoo;
    @FXML
    private TableColumn<Tiere, String> tcTName;
    @FXML
    private TableColumn<Tiere, String> tcArt;
    @FXML
    private TableColumn<Tiere, Integer> tcAlter;
    @FXML
    private TableColumn<Tiere, String> tcGeschlecht;
    @FXML
    private TableColumn<Tiere, Integer> tcGehege;
    @FXML
    private TableColumn<Tiere, Time> tcFutterzeit;
    @FXML
    private TableView<Zoo> tvZoo;
    @FXML
    private TableView<Tiere> tvTiere;
    @FXML
    private ChoiceBox cbTiere;
    @FXML
    private Button btnShowTiere;
    @FXML
    private TableColumn<Mitarbeiter, String> tcVorname;
    @FXML
    private TableColumn<Mitarbeiter, String> tcNachname;
    @FXML
    private TableColumn<Mitarbeiter, Integer> tcPlz;
    @FXML
    private TableColumn<Mitarbeiter, String> tcStrasse;
    @FXML
    private TableColumn<Mitarbeiter, Date> tcGeburtstag;
    @FXML
    private TableColumn<Mitarbeiter, Integer> tcHausNr;
    @FXML
    private ChoiceBox cbMitarbeiter;
    @FXML
    private Button btnShowMitarbeiter;
    @FXML
    private TableView tvMitarbeiter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcOeffnungszeiten.setCellValueFactory(new PropertyValueFactory<>("Oeffnungszeiten"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("ZName"));
        tcSchliesszeiten.setCellValueFactory(new PropertyValueFactory<>("Schliesszeiten"));
        tcOrt.setCellValueFactory(new PropertyValueFactory<>("Ort"));
        tcEintrittskosten.setCellValueFactory(new PropertyValueFactory<>("Eintrittskosten"));

        tvZoo.setItems(ZooDAO.getZoo()); //Objekt der DAO und speichert die Daten in die Tableview
        cbZoo.setItems(ZooDAO.getZoo());

        tcTName.setCellValueFactory(new PropertyValueFactory<>("TName"));
        tcArt.setCellValueFactory(new PropertyValueFactory<>("Art"));
        tcAlter.setCellValueFactory(new PropertyValueFactory<>("Alter"));
        tcGeschlecht.setCellValueFactory(new PropertyValueFactory<>("Geschlecht"));
        tcGehege.setCellValueFactory(new PropertyValueFactory<>("Gehege"));
        tcFutterzeit.setCellValueFactory(new PropertyValueFactory<>("Futterzeit"));

        tvTiere.setItems(TiereDAO.getTiere());
        cbTiere.setItems(TiereDAO.getTiere());

        tcVorname.setCellValueFactory(new PropertyValueFactory<>("Vorname"));
        tcNachname.setCellValueFactory(new PropertyValueFactory<>("Nachname"));
        tcPlz.setCellValueFactory(new PropertyValueFactory<>("Plz"));
        tcStrasse.setCellValueFactory(new PropertyValueFactory<>("Strasse"));
        tcHausNr.setCellValueFactory(new PropertyValueFactory<>("HausNr"));
        tcGeburtstag.setCellValueFactory(new PropertyValueFactory<>("Geburtstag"));

        tvMitarbeiter.setItems(MitarbeiterDAO.getMitarbeiter());
        cbMitarbeiter.setItems(MitarbeiterDAO.getMitarbeiter());
    }

    @FXML
    public void handleShowZoo(ActionEvent actionEvent) {

        Zoo zoo = (Zoo) cbZoo.getSelectionModel().getSelectedItem();
        System.out.println(zoo);
    }

    @FXML
    public void handleShowTiere(ActionEvent actionEvent) {
        Tiere tiere = (Tiere) cbTiere.getSelectionModel().getSelectedItem();
        System.out.println(tiere);
    }

    @FXML
    public void handleShowMitarbeiter(ActionEvent actionEvent) {
        Mitarbeiter mitarbeiter = (Mitarbeiter) cbMitarbeiter.getSelectionModel().getSelectedItem();
        System.out.println(mitarbeiter);
    }
}
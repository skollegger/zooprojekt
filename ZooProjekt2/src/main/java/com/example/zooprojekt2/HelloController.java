package com.example.zooprojekt2;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.util.Callback;
import model.Zoo;
import model.ZooDAO;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;

public class HelloController implements Initializable  {

    @FXML
    private TableView<Zoo> tvPersons;
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
    private Button btnShow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcOeffnungszeiten.setCellValueFactory(new PropertyValueFactory<>("Oeffnungszeiten"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("ZName"));
        tcSchliesszeiten.setCellValueFactory(new PropertyValueFactory<>("Schliesszeiten"));
        tcOrt.setCellValueFactory(new PropertyValueFactory<>("Ort"));
        tcEintrittskosten.setCellValueFactory(new PropertyValueFactory<>("Eintrittskosten"));

        tvPersons.setItems(ZooDAO.getZoo()); //Objekt der DAO und speichert die Daten in die Tableview
        cbZoo.setItems(ZooDAO.getZoo());
    }

    @FXML
    public void handleShow(ActionEvent actionEvent) {

        Zoo zoo = (Zoo) cbZoo.getSelectionModel().getSelectedItem();
        System.out.println(zoo);


    }
}
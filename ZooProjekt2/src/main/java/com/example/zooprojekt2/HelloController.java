package com.example.zooprojekt2;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.util.Callback;
import model.Zoo;
import model.ZooDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable  {

    @FXML
    private TableView tvPersons;
    @FXML
    private TableColumn tcName;
    @FXML
    private TableColumn tcOeffnungszeiten;
    @FXML
    private TableColumn tcSchliesszeiten;
    @FXML
    private TableColumn tcOrt;
    @FXML
    private TableColumn tcEintrittskosten;
    @FXML
    private ChoiceBox cbZoo;
    @FXML
    private Button btnShow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbZoo.setItems(ZooDAO.getZoo());


    }

    @FXML
    public void handleShow(ActionEvent actionEvent) {

        Zoo zoo = (Zoo) cbZoo.getSelectionModel().getSelectedItem();
        System.out.println(zoo);


    }
}
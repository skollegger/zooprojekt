package personed;

import com.sun.javafx.charts.Legend;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Tiere;
import model.TiereDAO;
import model.Mitarbeiter;
import model.MitarbeiterDAO;
import model.Zoo;
import model.ZooDAO;

import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;


public class FXML_PersonedController implements Initializable {
    private Zoo actZoo;
    @FXML
    private TextField tfName;
    @FXML
    private MenuItem miSave;
    @FXML
    private RadioButton rbWien;
    @FXML
    private RadioButton rbGraz;
    @FXML
    private RadioButton rbSalzburg;
    @FXML
    private TextField tfOeffnungszeiten;
    @FXML
    private TextField tfSchliesszeiten;
    @FXML
    private ToggleGroup tgDepartments;
    @FXML
    private Spinner spEintrittskosten;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spEintrittskosten.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(6,20)
        );/*
        cbTiere.setItems(TiereDAO.getTiere());
        cbMitarbeiter.setItems(MitarbeiterDAO.getMitarbeiter());*/
    }

    @FXML
    private void handleMiSaveAction(ActionEvent event) {
        actZoo.setName(tfName.getText());
        actZoo.setOeffnungszeiten((Time) tfOeffnungszeiten.getOnAction());
        actZoo.setSchliesszeiten((Time) tfSchliesszeiten.getOnAction());
        actZoo.setDepartment(((RadioButton)tgDepartments.getSelectedToggle()).getText());
        ZooDAO.update (actZoo);
    }
    
    public void setActZoo (Zoo actZoo) {
        this.actZoo = actZoo;
        tfName.setText(actZoo.getName());
        tgDepartments.getSelectedToggle();
        /*tfOeffnungszeiten.setValueFactory(actZoo.getOeffnungszeiten());
        tfSchliesszeiten.setValueFactory(actZoo.getSchliesszeiten());*/
        rbGraz.setSelected(true);  //Defaultauswahl
    }

    public void setZoo (Zoo actZoo) {
        this.actZoo = actZoo;
        tfName.setText(actZoo.getName());/*
        tfOeffnungszeiten.setText(actZoo.getOeffnungszeiten());
        spEintrittskosten.getValueFactory().setValue(actZoo.getEintrittskosten());*/
        rbWien.setSelected(true);  //Defaultauswahl
        rbGraz.setSelected(false);  //Defaultauswahl
        rbSalzburg.setSelected(false);  //Defaultauswahl
        for (Toggle rb : tgDepartments.getToggles()) {
            if (((RadioButton)rb).getText().equals(actZoo.getDepartment()))
                tgDepartments.selectToggle(rb);
        }
    }
}

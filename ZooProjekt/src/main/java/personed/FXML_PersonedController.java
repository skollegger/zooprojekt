package personed;

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

import java.lang.foreign.ValueLayout;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;


public class FXML_PersonedController implements Initializable {
    private Zoo actZoo;
    
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfOrt;
    @FXML
    private Spinner<Integer> tfEintrittskosten;
    @FXML
    private Spinner<Time> tfOeffnungszeiten;
    @FXML
    private Spinner<Time> tfSchliesszeiten;
    @FXML
    private MenuItem miSave;
    @FXML
    private Spinner<Integer> spYob;
    @FXML
    private RadioButton rbIt;
    @FXML
    private ComboBox<Tiere> cbTiere;
    @FXML
    private ComboBox<Mitarbeiter> cbMitarbeiter;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spYob.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1950,2020)
        );
        cbTiere.setItems(TiereDAO.getTiere());
    }    

    @FXML
    private void handleMiSaveAction(ActionEvent event) {
        actZoo.setName(tfName.getText());
        actZoo.setOrt(tfOrt.getText());
        actZoo.setEintrittskosten(Integer.valueOf(tfEintrittskosten.getId()));
        actZoo.setOeffnungszeiten(tfOeffnungszeiten.getValue());
        actZoo.setSchliesszeiten(tfSchliesszeiten.getValue());
        ZooDAO.update (actZoo);
    }
    
    public void setActZoo (Zoo actZoo) {
        this.actZoo = actZoo;
        tfName.setText(actZoo.getName());
        tfOrt.setText(actZoo.getOrt());
        tfOeffnungszeiten.setValueFactory(actZoo.getOeffnungszeiten());
        tfSchliesszeiten.setValueFactory(actZoo.getSchliesszeiten());
        rbIt.setSelected(true);  //Defaultauswahl
    }
}

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
    private ToggleGroup tgDepartments;
    @FXML
    private RadioButton rbWien;
    @FXML
    private RadioButton rbGraz;
    @FXML
    private RadioButton rbSalzburg;
    @FXML
    private Spinner spOeffnungszeiten;
    @FXML
    private Spinner spSchliesszeiten;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spOeffnungszeiten.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(6,9)
        );
        cbZoo.setItems(TiereDAO.getTiere());
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

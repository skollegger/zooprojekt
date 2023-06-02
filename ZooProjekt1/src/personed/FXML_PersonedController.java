package personed;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import model.Tiere;
import model.TiereDAO;
import model.Zoo;
import model.PersonDAO;


public class FXML_PersonedController implements Initializable {
    private Zoo actZoo;
    
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfFirstName;
    @FXML
    private MenuItem miSave;
    @FXML
    private Spinner<Integer> spYob;
    @FXML
    private RadioButton rbIt;
    @FXML
    private ToggleGroup tgDepartments;
    @FXML
    private RadioButton rbSales;
    @FXML
    private RadioButton rbFinance;
    @FXML
    private CheckBox chbFullTime;
    @FXML
    private ComboBox<Tiere> cbCountries;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spYob.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1950,2020)
        );
        cbCountries.setItems(TiereDAO.getCountries());
    }    

    @FXML
    private void handleMiSaveAction(ActionEvent event) {
        actZoo.setLastName(tfLastName.getText());
        actZoo.setFirstName(tfFirstName.getText());
        actZoo.setYob(spYob.getValue());
        actZoo.setDepartment(((RadioButton)tgDepartments.getSelectedToggle()).getText());
        actZoo.setFullTime(chbFullTime.isSelected());
        actZoo.setCountryId(cbCountries.getSelectionModel().getSelectedItem().getId());
        actZoo.setCountry(TiereDAO.getCountryById(actZoo.getCountryId()));
        PersonDAO.update (actZoo);
    }
    
    public void setPerson (Zoo actZoo) {
        this.actZoo = actZoo;
        tfLastName.setText(actZoo.getLastName());
        tfFirstName.setText(actZoo.getFirstName());
        spYob.getValueFactory().setValue(actZoo.getYob());
        rbIt.setSelected(true);  //Defaultauswahl
        for (Toggle rb : tgDepartments.getToggles()) {
            if (((RadioButton)rb).getText().equals(actZoo.getDepartment()))
                tgDepartments.selectToggle(rb);
        }
        chbFullTime.setSelected(actZoo.isFullTime());
        for (Tiere tiere : cbCountries.getItems())
            if (tiere.getId() == actZoo.getCountryId())
                cbCountries.getSelectionModel().select(tiere);
    }
}

package controls;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Zoo;
import model.ZooDAO;
import personed.FXML_PersonedController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class FXMLDocumentController implements Initializable {
    private Zoo actZoo;
    private String []departments = {"IT", "Sales", "Finance"};
    //private RadioButton []radios = new RadioButton[departments.length];
    //private ToggleGroup deptRadioGrp = new ToggleGroup();
    private ObservableList<Zoo> zooList;
    private ListProperty<Zoo> listProperty = new SimpleListProperty();

    @FXML
    private ComboBox<Zoo> cbPersons;
    @FXML
    private MenuItem miEdit;
    @FXML
    private MenuItem miShow;
    @FXML
    private TableView<Zoo> tvPersons;
    @FXML               //Zeilenobjektklasse, Memberklasse
    private TableColumn<Zoo, String> tcLastname;
    @FXML
    private TableColumn<Zoo, String> tcFirstname;
    @FXML
    private TableColumn<Zoo, Integer> tcYob;
    @FXML
    private TableColumn<Zoo, Boolean> tcFullTime;
    @FXML
    private TableColumn<Zoo, String> tcCountry;
    
    
    //Zeitpunkt: Öffnen der GUI, nachdem alle
    //  Controls erzeugt wurden
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        //cbPersons.setItems(PersonDAO.getPersons());
        zooList = ZooDAO.getZoo();
        //ComboBox an die Liste binden
        cbPersons.itemsProperty().bind(listProperty);
        listProperty.setValue(zooList);
        
        //Spalten der TableView an die Member binden
        tcLastname.setCellValueFactory(new PropertyValueFactory("lastName"));
        tcFirstname.setCellValueFactory(new PropertyValueFactory("firstName"));
        tcYob.setCellValueFactory(new PropertyValueFactory("yob"));
        tcFullTime.setCellValueFactory(new PropertyValueFactory("fullTime"));        
        tcCountry.setCellValueFactory(new PropertyValueFactory("country"));
        tvPersons.setItems(zooList);
    }

    @FXML
    private void handleCbPersonsAction(ActionEvent event) {
        //merke den aktuellen Datensatz
        actZoo = cbPersons.getSelectionModel().getSelectedItem();
        //getSelectedItem liefert eine Referenz auf ein Personenobjekt !!!
        //lblName.setText(cbPersons.getSelectionModel().getSelectedItem().getLastName());
    }

    @FXML
    private void handleMiEditAction(ActionEvent event) {
        int inx = cbPersons.getSelectionModel().getSelectedIndex();
        if (inx == -1)
            return;
        actZoo = zooList.get(inx);
        
        try {
            FXMLLoader loader = new FXMLLoader();                   //Loader Objekt
            loader.setLocation(getClass().getResource("/personed/FXML_Personed.fxml"));
            Parent root = loader.load();                            //Wurzelcontrol
            FXML_PersonedController ctrl = loader.getController();  //ref. Controlerobj
            ctrl.setActZoo(actZoo);
            Stage stage = new Stage();                              //neue Bühne
            stage.initModality(Modality.WINDOW_MODAL);              //im Vordergrund
            stage.setScene(new Scene(root));
            stage.showAndWait();                                    //Anzeige
            System.out.println("after Dialog: " + actZoo);
            zooList.set(inx, actZoo);

            //cbPersons.setItems(PersonDAO.getPersons());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //lade die Textfelder mit den Personendaten
        /*
        for (int i = 0; i < radios.length; i++)
            if (actPerson.getDepartment().equals(departments[i]))
                radios[i].setSelected(true);
        if (actPerson.getDepartment().equals("IT"))
            rbIt.setSelected(true);
        else if(actPerson.getDepartment().equals("Sales"))
            rbSales.setSelected(true);
        else if(actPerson.getDepartment().equals("Finance"))
            rbFinance.setSelected(true);
        */
        //tfYob.setText("" + actPerson.getYob());
    }

    private void handleMiSaveAction(ActionEvent event) {
        //if (actPerson == null)
        //    return;
        //welcher Eintrag wurde selektiert (-1 falls keiner)
        int inx = cbPersons.getSelectionModel().getSelectedIndex();
        if (inx == -1)
            return;
        actZoo = zooList.get(inx);
/*        
        //cbPersons.getItems().remove(actPerson);
        //??
        //cbPersons.getItems().add(actPerson);
        //cbPersons.setItems(PersonDAO.getPersons());
        myPersonList.set(inx, actPerson);
*/
    }

    @FXML
    private void handleMiShowAction(ActionEvent event) {
    }
}
       /*
        if (cbNames.getItems() == null)
            System.out.println("zu Beginn null");
        cbNames.getItems().add("Hansi");
        cbNames.getItems().add("Fritz");
        cbNames.getItems().add("Sepp");
        cbNames.getItems().add("Maria");
        //cbNames.setItems(value);
        ObservableList<String> namesList = FXCollections.observableArrayList(
                "Vinzent","Mario","Rene"
        );
        cbNames.setItems(namesList);
        cbNames.setVisible(false);          //unsichtbar
*/
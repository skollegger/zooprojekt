module com.example.zooprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.controllsdemo to javafx.fxml;
    exports com.example.controllsdemo; //muss gleich heißen wie bei den Resources,
    // weil es die Dateien, wie: anzeigemenu und so sonst nicht findet
}
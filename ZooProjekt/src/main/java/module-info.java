module com.example.zooprojekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zooprojekt to javafx.fxml;
    exports com.example.zooprojekt;
}
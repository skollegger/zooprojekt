module com.example.zooprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.zooprojekt to javafx.fxml;
    //exports com.example.zooprojekt;
}
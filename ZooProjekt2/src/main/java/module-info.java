module com.example.zooprojekt2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.zooprojekt2 to javafx.fxml;
    exports com.example.zooprojekt2;
}
module com.example.zooprojekt2 {
    requires javafx.controls; //Bibliotheken
    requires javafx.fxml;
    requires java.sql;

    opens model to javafx.base;
    opens com.example.zooprojekt2 to javafx.fxml;
    exports com.example.zooprojekt2;
}
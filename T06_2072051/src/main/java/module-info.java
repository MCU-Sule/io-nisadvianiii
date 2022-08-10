module com.example.t06_2072051 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.t06_2072051.model;
    opens com.example.t06_2072051 to javafx.fxml;
    exports com.example.t06_2072051;

}
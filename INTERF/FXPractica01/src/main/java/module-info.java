module org.example.fxpractica01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.fxpractica01 to javafx.fxml;
    exports org.example.fxpractica01;
}
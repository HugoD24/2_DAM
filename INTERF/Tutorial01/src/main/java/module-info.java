module org.example.tutorial01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tutorial01 to javafx.fxml;
    exports org.example.tutorial01;
}
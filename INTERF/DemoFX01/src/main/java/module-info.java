module org.example.demofx01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demofx01 to javafx.fxml;
    exports org.example.demofx01;
}
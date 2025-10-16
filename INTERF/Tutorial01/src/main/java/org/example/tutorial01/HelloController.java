package org.example.tutorial01;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label lblName;

    /*INI ESTO ES UNA PRUEBA
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    FIN ESTO ES UNA PRUEBA
    }*/

    @FXML
    protected void onHelloButtonClickName() {
        lblName.setText("Hugo");
    }


}

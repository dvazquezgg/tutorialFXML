package mx.edu.greengates.cs.tutorial;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WelcomeController {

    @FXML
    private TextField txtInput;

    @FXML
    private Label lblName;

    @FXML
    private void onButtonClicked() {
        String text = txtInput.getText();
        lblName.setText(text);
        txtInput.clear();
    }

}

package ui;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class InputScreenController {

    @FXML
    private JFXButton subminButton;

    @FXML
    private Label backButton;

    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
        App.getScenesManager().goToMainScreen();
    }

    @FXML
    void onSubmitClicked(ActionEvent event) {

    }
}
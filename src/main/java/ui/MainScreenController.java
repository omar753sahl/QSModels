package ui;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import models.QueueType;

import java.io.IOException;

public class MainScreenController {

    @FXML
    private JFXButton mm1Button;

    @FXML
    private JFXButton mmkButton;

    @FXML
    private JFXButton mmcButton;

    @FXML
    private JFXButton mmckButton;

    @FXML
    public void initialize() {
        System.out.println("Done loading MainScreen components!");
    }

    @FXML
    void onMm1Clicked(ActionEvent event) throws IOException {
        App.getScenesManager().goToInputScreen(QueueType.MM1);
    }

    @FXML
    void onMmcClicked(ActionEvent event) throws IOException {
        App.getScenesManager().goToInputScreen(QueueType.MMC);
    }

    @FXML
    void onMmckClicked(ActionEvent event) throws IOException {
        App.getScenesManager().goToInputScreen(QueueType.MMCK);
    }

    @FXML
    void onMmkClicked(ActionEvent event) throws IOException {
        App.getScenesManager().goToInputScreen(QueueType.MMK);
    }
}

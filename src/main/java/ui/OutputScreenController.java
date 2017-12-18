package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import models.QueueSystemInput;
import models.QueueType;

import java.io.IOException;

public class OutputScreenController {


    private QueueType queueType;
    private QueueSystemInput inputs;

    public void initView(QueueType queueType, QueueSystemInput inputs) {
        this.queueType = queueType;
        this.inputs = inputs;

        System.out.println("QueueType: " + queueType.name());
        System.out.println(inputs);
    }

    @FXML
    private BorderPane root;

    @FXML
    private JFXTextField arrivalRateField;

    @FXML
    private JFXTextField serviceRateField;

    @FXML
    private JFXTextField numberOfServersField;

    @FXML
    private JFXTextField systemCapacityField;

    @FXML
    private JFXButton submitButton;

    @FXML
    private Label backButton;

    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
        App.getScenesManager().goToInputScreen(queueType);
    }
}

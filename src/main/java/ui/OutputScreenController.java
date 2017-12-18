package ui;

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

    @FXML
    private BorderPane root;

    @FXML
    private Label labelL;

    @FXML
    private Label labelLq;

    @FXML
    private Label labelW;

    @FXML
    private Label labelWq;

    @FXML
    private Label backButton;

    public void initView(QueueType queueType, QueueSystemInput inputs) {
        this.queueType = queueType;
        this.inputs = inputs;

        System.out.println("QueueType: " + queueType.name());
        System.out.println(inputs);
    }

    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
        App.getScenesManager().goToInputScreen(queueType);
    }
}

package ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import models.QueueSystemInput;
import models.QueueType;
import utils.InputFieldValidation;
import utils.MathUtils;
import utils.TextUtils;

import java.io.IOException;
import java.util.Arrays;

public class InputScreenController {
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

    private QueueType queueType;
    private boolean showSystemCapacity;
    private boolean showNumberOfServers;

    public void initView(QueueType queueName) {
        this.queueType = queueName;

        switch (queueName) {
            case MM1:
                showSystemCapacity = false;
                showNumberOfServers = false;
                break;
            case MMC:
                showSystemCapacity = false;
                showNumberOfServers = true;
                break;
            case MM1K:
                showSystemCapacity = true;
                showNumberOfServers = false;
                break;
            case MMCK:
                showSystemCapacity = true;
                showNumberOfServers = true;
                break;
        }

        systemCapacityField.setDisable(!showSystemCapacity);
        numberOfServersField.setDisable(!showNumberOfServers);

        JFXTextField[] arr = {serviceRateField, arrivalRateField, numberOfServersField, systemCapacityField};
        Arrays.stream(arr).forEach(s -> {
            if (!s.isDisabled()) {
                InputFieldValidation validator = new InputFieldValidation();
                validator.setMessage("Enter a valid value");
                s.getValidators().add(validator);
            }
        });
    }

    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
        App.getScenesManager().goToMainScreen();
    }

    @FXML
    void onSubmitClicked(ActionEvent event) throws Exception {
        if (areInputsValid())
            submit();
    }

    private void submit() throws Exception {
        System.out.println("Whohooooooo inputs are valid");
        Double arrivalRate = MathUtils.eval(arrivalRateField.getText());
        Double serviceRate = MathUtils.eval(serviceRateField.getText());

        Integer numberOfServers = null;
        Integer systemCapacity = null;

        if (showNumberOfServers) {
            numberOfServers = MathUtils.eval(numberOfServersField.getText()).intValue();
        }

        if (showSystemCapacity) {
            systemCapacity = MathUtils.eval(systemCapacityField.getText()).intValue();
        }

        QueueSystemInput inputs = new QueueSystemInput(arrivalRate, serviceRate, numberOfServers, systemCapacity);
        App.getScenesManager().goToOutputScreen(queueType, inputs);
    }

    private boolean areInputsValid() {
        JFXTextField[] arr = {serviceRateField, arrivalRateField, numberOfServersField, systemCapacityField};
        Arrays.stream(arr).forEach(JFXTextField::validate);
        return Arrays.stream(arr).allMatch(field -> {
            if (field.isDisabled())
                return true;

            if (TextUtils.isEmpty(field.getText()))
                return false;

            try {
                MathUtils.eval(field.getText());
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
}
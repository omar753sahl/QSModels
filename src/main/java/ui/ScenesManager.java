package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.QueueSystemInput;
import models.QueueType;

import java.io.IOException;

public class ScenesManager {
    private Stage window;

    public ScenesManager(Stage window) {
        this.window = window;
    }

    private void goToNewScene(Scene scene) {
        window.setScene(scene);
        window.sizeToScene();
        if (!window.isShowing()) {
            window.show();
        }
    }

    private FXMLLoader goToNewScene(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        goToNewScene(scene);
        root.requestFocus();
        return loader;
    }

    public void goToMainScreen() throws IOException {
        goToNewScene("../../resources/fxml/main_screen.fxml");
    }

    public void goToInputScreen(QueueType queueType) throws IOException {
        FXMLLoader loader = goToNewScene("../../resources/fxml/input_screen.fxml");
        loader.<InputScreenController>getController().initView(queueType);
    }

    public void goToOutputScreen(QueueType queueType, QueueSystemInput inputs) throws IOException {
        FXMLLoader loader = goToNewScene("../../resources/fxml/output_screen.fxml");
        loader.<OutputScreenController>getController().initView(queueType, inputs);
    }
}

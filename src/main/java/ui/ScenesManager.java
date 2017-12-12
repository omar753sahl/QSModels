package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScenesManager {
    private Stage window;

    public ScenesManager(Stage window) {
        this.window = window;
    }

    public void goToNewScene(Scene scene) {
        window.setScene(scene);
        if (!window.isShowing()) {
            window.show();
        }
    }

    public void goToNewScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(root);
        goToNewScene(scene);
        root.requestFocus();
    }

    public void goToMainScreen() throws IOException {
        goToNewScene("../../resources/fxml/main_screen.fxml");
    }
}

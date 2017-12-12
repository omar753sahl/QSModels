package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.paint.Color.TRANSPARENT;

public class App extends Application {
    private static ScenesManager scenesManager;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("QS Models");
        primaryStage.getIcons().add(new Image("../resources/qs_models_icon.png"));

        scenesManager = new ScenesManager(primaryStage);
        scenesManager.goToMainScreen();
    }

    public static ScenesManager getScenesManager() {
        return scenesManager;
    }
}

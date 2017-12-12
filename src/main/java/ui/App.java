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
    private Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.window = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("../../resources/fxml/main_screen.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("QS Models");
        primaryStage.getIcons().add(new Image("../resources/qs_models_icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
    }

    public Stage getWindow() {
        return window;
    }

    public void setScene(Scene scene) {
        window.setScene(scene);
    }
}

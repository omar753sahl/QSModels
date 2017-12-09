package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.paint.Color.TRANSPARENT;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/fxml/main_screen.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("QS Models");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
    }
}

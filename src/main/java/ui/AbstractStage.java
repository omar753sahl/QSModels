package ui;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AbstractStage extends Stage {
    public AbstractStage() {
        super(StageStyle.DECORATED);
        setTitle("QS Models");
        getIcons().add(new Image("../resources/qs_models_icon.png"));
    }
}

package Controller;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;


/**
 * Created by Gorka Olalde on 21/9/16.
 */
public class ControladorPuntuacion {

    private final int HPOS = 750;
    private final int VPOS = 10;

    Label label = new Label();

    public AnchorPane initControlador(SimpleIntegerProperty points) {
        AnchorPane pane = new AnchorPane();
        pane.setStyle("-fx-background-color: transparent");
        pane.getChildren().add(label);
        points.addListener((o, oldVal, newVal) -> Platform.runLater(() -> label.setText(newVal.toString())));
        label.setLayoutX(HPOS);
        label.setLayoutY(VPOS);
        label.setStyle("-fx-font-size: 28;" + " -fx-text-fill: white");
        return pane;
    }
}

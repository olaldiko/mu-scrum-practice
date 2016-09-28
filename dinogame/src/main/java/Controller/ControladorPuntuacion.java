package Controller;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


/**
 * Created by Gorka Olalde on 21/9/16.
 */
class ControladorPuntuacion {

    private final Label label = new Label();

    public AnchorPane initControlador(SimpleIntegerProperty points) {
        AnchorPane pane = new AnchorPane();
        pane.setStyle("-fx-background-color: transparent");
        pane.getChildren().add(label);
        points.addListener((o, oldVal, newVal) -> Platform.runLater(() -> label.setText(newVal.toString())));
        int HPOS = 750;
        label.setLayoutX(HPOS);
        int VPOS = 10;
        label.setLayoutY(VPOS);
        label.setStyle("-fx-font-size: 28;" + " -fx-text-fill: white");
        return pane;
    }
}

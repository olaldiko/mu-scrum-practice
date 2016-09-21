package Controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;

import java.awt.*;

/**
 * Created by Gorka Olalde on 21/9/16.
 */
public class ControladorPuntuacion {

    private final int HPOS = 700;
    private final int VPOS = 100;

    Label label = new Label();

    public void initControlador(AnchorPane pane, SimpleIntegerProperty points) {
        points.addListener((o, oldVal, newVal) -> label.setText(newVal.toString()));
        label.setLocation(HPOS, VPOS);
    }
}

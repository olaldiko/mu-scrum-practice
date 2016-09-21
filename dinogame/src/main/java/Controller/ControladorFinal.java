package Controller;

import Model.GameModel;
import Model.Principal;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Gorka Olalde on 21/9/16.
 */
public class ControladorFinal {

    ControladorPrincipal principal;

    SimpleIntegerProperty points = new SimpleIntegerProperty();

    @FXML
    TextField nameTextField;

    @FXML
    Label pointsLabel;

    @FXML
    Button replayBtn;

    @FXML
    Button backBtn;


    public AnchorPane showScreen(ControladorPrincipal principal, SimpleIntegerProperty points) throws IOException {
        AnchorPane pane;
        FXMLLoader loader = new FXMLLoader(Principal.class.getResource("/gameEndsScreen.fxml"));
        this.principal = principal;
        points.bind(points);
        points.addListener((o, oldVal, newVal) -> pointsLabel.setText(newVal.toString()));
        loader.setController(this);
        pane = loader.load();
        replayBtn.setOnAction(e -> onReplayPressed());
        backBtn.setOnAction(e -> onBackPressed());
        return pane;
    }

    public void onBackPressed() {
        principal.mostrarMenu();
    }

    public void onReplayPressed() {
        principal.mostrarJuego();
    }
}

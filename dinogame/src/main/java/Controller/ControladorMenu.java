package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
class ControladorMenu {

    private ControladorPrincipal controller;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private VBox vbox;
    @FXML
    private Button playButton;
    @FXML
    private Button scoresButton;
    @FXML
    private Button exitButton;
    @FXML
    private Text titleText;
    @FXML
    private Text copyrightText;
    @FXML
    void exitButtonPressed(ActionEvent event) {

    }

    @FXML
    void playButtonPressed(ActionEvent event) {
        controller.mostrarJuego();
    }

    @FXML
    void scoresButtonPressed(ActionEvent event) {

    }

    public void setController(ControladorPrincipal controller) {
        this.controller = controller;
    }

}

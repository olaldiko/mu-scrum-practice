package Controller;

import GameLogic.GameSound;
import Model.Principal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
class ControladorMenu {

    private final GameSound gameSound = GameSound.getInstance();
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
        controller.finalizarJuego();
    }

    @FXML
    void playButtonPressed(ActionEvent event) {
        gameSound.stopMenuMusic();
        controller.mostrarJuego();
    }

    @FXML
    void scoresButtonPressed(ActionEvent event) {
        controller.mostrarRanking();
    }

    public AnchorPane initControlador(ControladorPrincipal controller) throws IOException {
        this.controller = controller;
        AnchorPane pane;
        FXMLLoader loader = new FXMLLoader(Principal.class.getResource("/menu.fxml"));
        loader.setController(this);
        pane = loader.load();
        return pane;
    }

}

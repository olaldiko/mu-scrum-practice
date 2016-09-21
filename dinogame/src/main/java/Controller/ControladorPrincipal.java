package Controller;

import GameLogic.GameSound;
import Model.GameModel;
import Model.Principal;
import View.VistaJuego;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControladorPrincipal {
    private final VistaJuego vistaJuego = new VistaJuego();

    private final ControladorMenu controladorMenu = new ControladorMenu();
    private final ControladorJuego controladorJuego = new ControladorJuego();
    private final ControladorPuntuacion controladorPuntuacion = new ControladorPuntuacion();
    private final ControladorFinal controladorFinal = new ControladorFinal();
    private GameSound gameSound = GameSound.getInstance();

    private GameModel model;

    public VistaJuego getVistaJuego() {
        return vistaJuego;
    }

    public void initControlador(GameModel model) throws IOException {
        this.model = model;
        AnchorPane capaMenu = controladorMenu.initControlador(this);
        AnchorPane capaPuntuacion = controladorPuntuacion.initControlador(model.scoreProperty());
        vistaJuego.initVistaJuego();
        vistaJuego.setCapaMenu(capaMenu);
        vistaJuego.setCapaPuntuacion(capaPuntuacion);
        controladorJuego.initControlador(model, vistaJuego);

    }

    public void mostrarJuego() {
        model.resetScore();
        controladorJuego.startGame();

    }

    public void mostrarMenu() {
        model.stopGameTimer();
        vistaJuego.mostrarMenu();
    }


}

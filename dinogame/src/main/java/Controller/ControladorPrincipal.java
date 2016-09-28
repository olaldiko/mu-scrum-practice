package Controller;

import GameLogic.GameSound;
import Model.GameModel;
import Model.Principal;
import View.VistaJuego;
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
    private final GameSound gameSound = GameSound.getInstance();
    private final Principal principal;
    private GameModel model;
    public ControladorPrincipal(Principal principal) {
        this.principal = principal;
    }

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
        controladorJuego.initControlador(model, vistaJuego, this);

    }

    public void mostrarJuego() {
        model.resetScore();
        vistaJuego.mostrarJuego();
        controladorJuego.startGame();
    }

    public void mostrarMenu() {
        model.stopGameTimer();
        vistaJuego.mostrarMenu();
        gameSound.playMenuMusic();
    }

    public void mostrarFinJuego() {
        controladorJuego.endGame();
        gameSound.playDieSound();
        try {
            vistaJuego.setCapaFinalScreen(controladorFinal.showScreen(this, model.scoreProperty()));
            vistaJuego.mostrarFinal();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void finalizarJuego() {
        principal.exitGame();

    }

    public void mostrarRanking() {
        ControladorRanking ranking = new ControladorRanking(this);
        vistaJuego.setCapaRanking(ranking.initRanking());
        vistaJuego.mostrarRanking();
    }


}

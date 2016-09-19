package Controller;

import GameLogic.GameSound;
import Model.Principal;
import View.VistaJuego;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControladorPrincipal {
    private final VistaJuego vistaJuego = new VistaJuego();

    private final ControladorMenu controladorMenu = new ControladorMenu();
    private final ControladorJuego controladorJuego = new ControladorJuego();
    private GameSound gameSound = GameSound.getInstance();

    public VistaJuego getVistaJuego() {
        return vistaJuego;
    }

    public void initControlador() {
        vistaJuego.initVistaJuego();
    }

    public void mostrarJuego() {
        controladorJuego.initControlador(vistaJuego);

    }

    public void mostrarMenu() {

        FXMLLoader loader = new FXMLLoader(Principal.class.getResource("/menu.fxml"));
        loader.setController(controladorMenu);
        try {
            vistaJuego.setCapaMenu(loader.load());
            controladorMenu.setController(this);
            gameSound.playMenuMusic();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

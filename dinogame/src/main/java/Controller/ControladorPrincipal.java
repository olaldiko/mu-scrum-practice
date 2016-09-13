package Controller;

import View.VistaJuego;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControladorPrincipal {
    VistaJuego vistaJuego = new VistaJuego();

    ControladorMenu controladorMenu;
    ControladorJuego controladorJuego = new ControladorJuego();


    public VistaJuego getVistaJuego() {
        return vistaJuego;
    }

    public void initControlador() {
        vistaJuego.initVistaJuego();
    }

    public void mostrarJuego() {
        controladorJuego.initControlador(vistaJuego);

    }

}

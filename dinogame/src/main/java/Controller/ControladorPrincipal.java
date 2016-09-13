package Controller;

import View.VistaJuego;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControladorPrincipal {
    VistaJuego vistaJuego = new VistaJuego();

    ControladorMenu controladorMenu;
    ControladorJuego controladorJuego;


    public VistaJuego getVistaJuego() {
        return vistaJuego;
    }

}

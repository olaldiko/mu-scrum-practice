package Controller;

import GameLogic.*;
import Model.GameModel;
import View.VistaJuego;
import javafx.animation.AnimationTimer;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControladorJuego {

    GameModel modelo = new GameModel();
    VistaJuego vistaJuego = new VistaJuego();


    SistemaColisiones sistemaColisiones;
    MovimientoFondo movimientoFondo;
    CreadorObstaculos creadorObstaculos;
    MovimientoObstaculos movimientoObstaculos;
    ControlJugador controlJugador;
    public void initControlador() {

    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            controlJugador.recibirInteraccion();
            movimientoFondo.moverFondo();
            creadorObstaculos.crearObstaculos();
            movimientoObstaculos.moverObstaculos();
            if (sistemaColisiones.calcularColisiones()) {
                //Mostrar fin del juego
            }
        }
    };

}

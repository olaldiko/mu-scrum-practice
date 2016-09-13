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
    VistaJuego vistaJuego;


    SistemaColisiones sistemaColisiones;
    MovimientoFondo movimientoFondo;
    CreadorObstaculos creadorObstaculos;
    MovimientoObstaculos movimientoObstaculos;
    ControlJugador controlJugador;

    public void initControlador(VistaJuego vistaJuego) {
        sistemaColisiones = new SistemaColisiones(modelo.getObstaculos(), modelo.getJugador());
        movimientoFondo = new MovimientoFondo();
        creadorObstaculos = new CreadorObstaculos();
        movimientoObstaculos = new MovimientoObstaculos(modelo.getObstaculos(), vistaJuego.getCapaObstaculos());
        controlJugador = new ControlJugador();

        movimientoFondo.initFondo(vistaJuego.getCapaFondo());
        vistaJuego.mostrarJuego();
        timer.start();
    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            controlJugador.recibirInteraccion();
            movimientoFondo.moverFondo(now);
            creadorObstaculos.crearObstaculos();
            movimientoObstaculos.moverObstaculos();
            if (sistemaColisiones.calcularColisiones()) {
                //Mostrar fin del juego
            }
        }
    };

}

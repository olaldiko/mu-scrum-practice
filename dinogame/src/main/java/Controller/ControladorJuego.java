package Controller;

import GameLogic.*;
import Model.GameModel;
import View.VistaJuego;
import javafx.animation.AnimationTimer;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
class ControladorJuego {

    private final GameModel modelo = new GameModel();
    VistaJuego vistaJuego;
    GameSound gameSound = GameSound.getInstance();

    private SistemaColisiones sistemaColisiones;
    private MovimientoFondo movimientoFondo;
    private CreadorObstaculos creadorObstaculos;
    private MovimientoObstaculos movimientoObstaculos;
    private ControlJugador controlJugador;

    public void initControlador(VistaJuego vistaJuego) {
        sistemaColisiones = new SistemaColisiones(modelo.getObstaculos(), modelo.getJugador());
        movimientoFondo = new MovimientoFondo();
        creadorObstaculos = new CreadorObstaculos(modelo.getObstaculos());
        movimientoObstaculos = new MovimientoObstaculos(modelo.getObstaculos(), vistaJuego.getCapaObstaculos());
        controlJugador = new ControlJugador();
        controlJugador.initControlJugador(modelo.getJugador(), vistaJuego.getCapaJugador());

        movimientoFondo.initFondo(vistaJuego.getCapaFondo());
        movimientoFondo.startAnimation();
        vistaJuego.mostrarJuego();
        gameSound.playGameMusic();
        timer.start();
        movimientoFondo.changeWallpaper();
    }


    private final AnimationTimer timer = new AnimationTimer() {
        double playRate = 1.0;
        @Override
        public void handle(long now) {
            controlJugador.recibirInteraccion();
            creadorObstaculos.crearObstaculo();
            //        movimientoObstaculos.moverObstaculos();
            if (sistemaColisiones.calcularColisiones()) {
                //Mostrar fin del juego
            }
        }
    };

}

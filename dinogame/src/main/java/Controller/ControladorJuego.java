package Controller;

import GameLogic.*;
import Model.GameModel;
import View.VistaJuego;
import javafx.animation.AnimationTimer;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
class ControladorJuego {

    private GameModel modelo;
    VistaJuego vistaJuego;
    GameSound gameSound = GameSound.getInstance();

    private SistemaColisiones sistemaColisiones;
    private MovimientoFondo movimientoFondo;
    private CreadorObstaculos creadorObstaculos;
    private MovimientoObstaculos movimientoObstaculos;
    private ControlJugador controlJugador;

    public void initControlador(GameModel model, VistaJuego vistaJuego) {
        this.modelo = model;
        this.vistaJuego = vistaJuego;
        sistemaColisiones = new SistemaColisiones(modelo.getObstaculos(), modelo.getJugador());
        movimientoFondo = new MovimientoFondo();
        creadorObstaculos = new CreadorObstaculos(vistaJuego.getCapaObstaculos());
        movimientoObstaculos = new MovimientoObstaculos(vistaJuego.getCapaObstaculos(), modelo);
        controlJugador = new ControlJugador();
        controlJugador.initControlJugador(modelo.getJugador(), vistaJuego.getCapaJugador());
        movimientoFondo.initFondo(vistaJuego.getCapaFondo());

    }


    public void startGame() {
        movimientoFondo.startAnimation();
        vistaJuego.mostrarJuego();
        gameSound.playGameMusic();
        timer.start();
        modelo.startGameTimer();
    }

    public void endGame() {
        movimientoFondo.stopAnimation();
        gameSound.stopGameMusic();
        timer.stop();
        modelo.stopGameTimer();

    }

    private final AnimationTimer timer = new AnimationTimer() {
        double playRate = 1.0;
        @Override
        public void handle(long now) {
            creadorObstaculos.setObstaculo();
            creadorObstaculos.crearObstaculo();
            movimientoObstaculos.moverObstaculos();
            if (sistemaColisiones.calcularColisiones()) {
                //Mostrar fin del juego
            }
        }
    };

}

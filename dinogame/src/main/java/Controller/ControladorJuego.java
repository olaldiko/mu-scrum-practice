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
    ControladorPrincipal principal;
    GameSound gameSound = GameSound.getInstance();

    private SistemaColisiones sistemaColisiones;
    private MovimientoFondo movimientoFondo;
    private CreadorObstaculos creadorObstaculos;
    private MovimientoObstaculos movimientoObstaculos;
    private ControlJugador controlJugador;

    public void initControlador(GameModel model, VistaJuego vistaJuego, ControladorPrincipal principal) {
        this.modelo = model;
        this.vistaJuego = vistaJuego;
        this.principal = principal;
        modelo.setObstaculos(vistaJuego.getCapaObstaculos().getChildren());
        sistemaColisiones = new SistemaColisiones(modelo.getObstaculos(), modelo.getJugador());
        movimientoFondo = new MovimientoFondo();
        creadorObstaculos = new CreadorObstaculos(vistaJuego.getCapaObstaculos());
        movimientoObstaculos = new MovimientoObstaculos(vistaJuego.getCapaObstaculos(), modelo);
        controlJugador = new ControlJugador();
        controlJugador.initControlJugador(modelo.getJugador(), vistaJuego.getCapaObstaculos());
        movimientoFondo.initFondo(vistaJuego.getCapaFondo());

    }


    public void startGame() {
        movimientoFondo.startAnimation();
        movimientoFondo.startWallChanger();
       // creadorObstaculos.borrarObstaculos();
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
          //  creadorObstaculos.setObstaculo();
          //  creadorObstaculos.crearObstaculo();
            movimientoObstaculos.moverObstaculos();
            if (sistemaColisiones.calcularColisiones()) {
                principal.mostrarFinJuego();
            }
        }
    };

}

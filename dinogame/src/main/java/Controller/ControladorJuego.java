package Controller;

import GameLogic.*;
import Model.GameModel;
import View.VistaJuego;
import javafx.animation.AnimationTimer;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
class ControladorJuego {

    private final GameSound gameSound = GameSound.getInstance();
    private GameModel modelo;
    private VistaJuego vistaJuego;
    private ControladorPrincipal principal;
    private SistemaColisiones sistemaColisiones;
    private MovimientoFondo movimientoFondo;
    private MovimientoObstaculos movimientoObstaculos;
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

    public void initControlador(GameModel model, VistaJuego vistaJuego, ControladorPrincipal principal) {
        this.modelo = model;
        this.vistaJuego = vistaJuego;
        this.principal = principal;
        modelo.setObstaculos(vistaJuego.getCapaObstaculos().getChildren());
        sistemaColisiones = new SistemaColisiones(modelo.getObstaculos(), modelo.getJugador());
        movimientoFondo = new MovimientoFondo();
        CreadorObstaculos creadorObstaculos = new CreadorObstaculos(vistaJuego.getCapaObstaculos());
        movimientoObstaculos = new MovimientoObstaculos(vistaJuego.getCapaObstaculos(), modelo);
        ControlJugador controlJugador = new ControlJugador();
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

}

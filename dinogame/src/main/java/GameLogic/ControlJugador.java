package GameLogic;

import Model.Jugador;
import Model.Principal;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControlJugador {
    private Jugador jugador;
    private double contadorSup = 1;
    private double contadorInf = 30;
    private boolean animacion;
    private final int XPOS = 50;
    private final int YPOS = 440;
    private final int JUMP_HEIGHT = 210;
    private final int JUMP_DURATION = 700;

    private final Image bola = new Image(Principal.class.getResource("/bola.png").toString());
    private AnchorPane capaJugador;
    private GameSound gameSound = GameSound.getInstance();
    private SequentialTransition jump = new SequentialTransition();

    public void initControlJugador(Jugador jugador, AnchorPane capaJugador) {
        this.capaJugador = capaJugador;
        setJugador(jugador);
        jugador.setImage(bola);
        jugador.setLayoutX(XPOS);
        jugador.setLayoutY(YPOS);
        capaJugador.getChildren().add(jugador);
        jugador.setFocusTraversable(true);
        jugador.requestFocus();
        createAnimation();
    }

    private void setJugador(Jugador jugador) {
        this.jugador = jugador;
        this.jugador.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                animacion = true;
                gameSound.playJumpSound();
                playAnimation();
            }
        });
    }

    private void playAnimation() {
        if(jump.getStatus() != Animation.Status.RUNNING) {
            jump.playFromStart();
        }
    }

    private void createAnimation() {
        TranslateTransition jumpUp = new TranslateTransition(Duration.millis(JUMP_DURATION), jugador);
        TranslateTransition jumpDown = new TranslateTransition(Duration.millis(JUMP_DURATION), jugador);
        jumpUp.setFromY(0);
        jumpUp.setToY(-JUMP_HEIGHT);
        jumpDown.setFromY(-JUMP_HEIGHT);
        jumpDown.setToY(0);
        jumpUp.setInterpolator(Interpolator.SPLINE(0.5408, 1.0000, 0.8553, 1.0000));
        jumpDown.setInterpolator(Interpolator.SPLINE(0.3816, 0.0000, 0.7118, 0.2585));
        jump.getChildren().addAll(jumpUp, jumpDown);
    }

}

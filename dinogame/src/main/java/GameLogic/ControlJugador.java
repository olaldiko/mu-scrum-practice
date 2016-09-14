package GameLogic;

import Model.Jugador;
import Model.Principal;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControlJugador {
    private Jugador jugador;
    private double contadorSup = 1;
    private double contadorInf = 30;
    private boolean animacion;
    private final int XPOS = 50;
    private final int YPOS = 400;
    private final Image bola = new Image(Principal.class.getResource("/bola.png").toString());
    private AnchorPane capaJugador;


    public void initControlJugador(Jugador jugador, AnchorPane capaJugador) {
        this.capaJugador = capaJugador;
        setJugador(jugador);
        jugador.setImage(bola);
        jugador.setCache(true);
        jugador.setLayoutX(XPOS);
        jugador.setLayoutY(YPOS);
        capaJugador.getChildren().add(jugador);
        jugador.setFocusTraversable(true);
        jugador.requestFocus();
    }

    private void setJugador(Jugador jugador) {
        this.jugador = jugador;
        this.jugador.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                animacion = true;
            }
        });
    }

    public void recibirInteraccion() {
        if(animacion) {
            if (contadorSup < 30) {
                jugador.setLayoutY(jugador.getLayoutY() - (50 * (1 / contadorSup)));
                contadorSup++;
            } else if (contadorSup <= 60) {
                jugador.setLayoutY(jugador.getLayoutY() + (50 * (1 / contadorInf)));
                contadorSup++;
                contadorInf--;
            }
            if (contadorSup == 60) {
                contadorSup = 1;
                contadorInf = 30;
                animacion=false;
            }
        }
    }
}

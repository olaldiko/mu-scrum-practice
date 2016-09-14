package GameLogic;

import Model.Jugador;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControlJugador {
    Jugador jugador;
    static float contadorSup;
    static float contadorInf;
    boolean isPressed;
    static boolean animacion;
    public ControlJugador(){
        contadorInf=0;
        contadorSup=0;
        jugador=new Jugador();
        animacion=false;
        installEventHandler(jugador);
    }
    private void installEventHandler(final Jugador jugador) {
        final EventHandler<KeyEvent> keyEventHandler =
                new EventHandler<KeyEvent>() {
                    public void handle(final KeyEvent keyEvent) {
                        if (keyEvent.getCode() == KeyCode.SPACE) {
                            keyEvent.consume();
                        }
                    }
                };
        jugador.setOnKeyPressed(e -> animacion = true);
    }

    public void recibirInteraccion() {
        if(animacion) {
            if (contadorSup <= 30) {
                jugador.setLayoutY(jugador.getLayoutY() + (150 * (1 / contadorSup)));
                contadorSup++;
                contadorInf++;
            } else if (contadorSup <= 60) {
                jugador.setLayoutY(jugador.getLayoutY() - (150 * (1 / contadorSup)));
                contadorInf--;
                contadorSup++;
            }
            if (contadorSup == 60) {
                contadorSup = 0;
                contadorInf = 0;
                animacion=false;
            }
        }
    }
}

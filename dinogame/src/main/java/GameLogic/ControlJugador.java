package GameLogic;

import Model.Jugador;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControlJugador {
    Jugador jugador;
    static float contadorSup;
    static float contadorInf;

    public void recibirInteraccion() {
        if(contadorSup<=30) {
            jugador.setLayoutY(jugador.getLayoutY() + (150 * (1 / contadorSup)));
            contadorSup++;
            contadorInf++;
        }else if(contadorSup<=60) {
            jugador.setLayoutY(jugador.getLayoutY() - (150 * (1 / contadorSup)));
            contadorInf--;
            contadorSup++;
        }
        if(contadorSup==60) {
            contadorSup = 0;
            contadorInf = 0;
        }
    }
}

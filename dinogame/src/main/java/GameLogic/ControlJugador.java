package GameLogic;

import Model.Jugador;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class ControlJugador {
    Jugador jugador;
    static float contador;
    static float contador1;
    static float posicionY;

    public void recibirInteraccion() {

        if(contador<=30) {
            posicionY = posicionY + (150 * (1 / contador));
            contador++;
            contador1++;
        }else if(contador<=60) {
            posicionY = posicionY - (150 * (1 / contador1));
            contador1--;
            contador++;
        }
        if(contador==60) {
            contador = 0;
            contador1 = 0;
        }
    }
}

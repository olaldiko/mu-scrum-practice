package GameLogic;

import Model.Jugador;
import Model.Obstaculo;
import javafx.collections.ObservableList;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class SistemaColisiones {
    private ObservableList<Obstaculo> listaObstaculos;
    private Jugador jugador;


    public SistemaColisiones(ObservableList<Obstaculo> listaObstaculos, Jugador jugador) {
        initColisiones(listaObstaculos, jugador);
    }

    private void initColisiones(ObservableList<Obstaculo> listaObstaculos, Jugador jugador) {
        this.listaObstaculos = listaObstaculos;
        this.jugador = jugador;
    }

    public boolean calcularColisiones() {

        return false;
    }
}

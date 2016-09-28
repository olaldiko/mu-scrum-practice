package GameLogic;

import Model.Jugador;
import Model.Obstaculo;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class SistemaColisiones {
    private ObservableList<Node> listaObstaculos;
    private Jugador jugador;


    public SistemaColisiones(ObservableList<Node> listaObstaculos, Jugador jugador) {
        initColisiones(listaObstaculos, jugador);
    }

    private void initColisiones(ObservableList<Node> listaObstaculos, Jugador jugador) {
        this.listaObstaculos = listaObstaculos;
        this.jugador = jugador;
    }

    public boolean calcularColisiones() {
        for (Node n : listaObstaculos) {
            if (n instanceof Obstaculo) {
                if (n.getBoundsInParent().intersects(jugador.getBoundsInParent())) {
                    return true;
                }
            }
        }
        return false;
    }
}

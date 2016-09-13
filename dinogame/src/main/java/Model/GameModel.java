package Model;

import Model.Jugador;
import Model.Obstaculo;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class GameModel {
    Jugador jugador;

    ObservableList<Obstaculo> obstaculos = new SimpleListProperty<>();

    public ObservableList<Obstaculo> getObstaculos() {
        return obstaculos;
    }

    public Jugador getJugador() {
        return jugador;
    }
}

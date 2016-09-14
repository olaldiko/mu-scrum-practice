package GameLogic;

import Model.Obstaculo;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class MovimientoObstaculos {
    private ObservableList<Obstaculo> listaObstaculos;
    private AnchorPane capaObstaculos;

    public MovimientoObstaculos(ObservableList<Obstaculo> listaObstaculos, AnchorPane capaObstaculos) {
        initMovimientoObstaculos(listaObstaculos, capaObstaculos);
    }

    private void initMovimientoObstaculos(ObservableList<Obstaculo> listaObstaculos, AnchorPane capaObstaculos) {
        this.listaObstaculos = listaObstaculos;
        this.capaObstaculos = capaObstaculos;
    }

    public void moverObstaculos() {

    }
}

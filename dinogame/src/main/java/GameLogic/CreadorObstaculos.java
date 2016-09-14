package GameLogic;

import Model.Obstaculo;
import javafx.collections.ObservableList;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class CreadorObstaculos {
    private ObservableList<Obstaculo> listaObstaculos;

    public CreadorObstaculos(ObservableList<Obstaculo> listaObstaculos) {
        initCreadorObstaculos(listaObstaculos);
    }

    private void initCreadorObstaculos(ObservableList<Obstaculo> listaObstaculos) {
        this.listaObstaculos = listaObstaculos;
    }
    public void crearObstaculos() {

    }
}

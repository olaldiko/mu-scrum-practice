package GameLogic;

import Model.GameModel;
import Model.Obstaculo;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class MovimientoObstaculos {
    private ObservableList<Obstaculo> listaObstaculos;
    private AnchorPane capaObstaculos;
    long nivel;
    GameModel model;

    public MovimientoObstaculos(ObservableList<Obstaculo> listaObstaculos, AnchorPane capaObstaculos) {
        initMovimientoObstaculos(listaObstaculos, capaObstaculos);
        nivel=0;
    }

    private void initMovimientoObstaculos(ObservableList<Obstaculo> listaObstaculos, AnchorPane capaObstaculos) {
        this.listaObstaculos = listaObstaculos;
        this.capaObstaculos = capaObstaculos;
    }

    public void moverObstaculos() {
        nivel=model.getElapsedTimeProperty();
        for(Obstaculo obs:listaObstaculos){
            obs.setLayoutX(obs.getLayoutX() - nivel/2000);
            if(obs.getLayoutX()<680){
                listaObstaculos.remove(obs);
            }
        }
    }
}

package GameLogic;

import Model.GameModel;
import Model.Obstaculo;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class MovimientoObstaculos {
    private ObservableList<Node> listaObstaculos;
    private AnchorPane capaObstaculos;
    SimpleLongProperty nivel;
    GameModel model;

    public MovimientoObstaculos(AnchorPane capaObstaculos, GameModel model) {
        initMovimientoObstaculos(capaObstaculos, model);
    }

    private void initMovimientoObstaculos(AnchorPane capaObstaculos, GameModel model) {
        listaObstaculos = capaObstaculos.getChildren();
        this.capaObstaculos = capaObstaculos;
        this.model = model;
    }

    public void moverObstaculos() {
        nivel=model.elapsedTimeProperty();
        for(Node obs : listaObstaculos){
            obs.setLayoutX(obs.getLayoutX() - nivel.longValue()/2000);
            if(obs.getLayoutX()<-56){
                obs.setLayoutX(800);
                model.obstaculoEsquivado();
            }
        }
    }
}

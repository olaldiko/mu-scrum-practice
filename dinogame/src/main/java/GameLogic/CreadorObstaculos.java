package GameLogic;

import Model.Obstaculo;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;


/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class CreadorObstaculos {
    private final int cantidad;
    private final int contador;
    private boolean posibleNuevo;

    public CreadorObstaculos(AnchorPane capaObstaculos) {
        initCreadorObstaculos(capaObstaculos);
        cantidad = 3;
        contador = 0;
        posibleNuevo=false;
    }

    private void initCreadorObstaculos(AnchorPane capaObstaculos) {
        Obstaculo obstaculo;
        ObservableList<Node> listaObstaculos = capaObstaculos.getChildren();
        for(int i=0;i<5;i++){
            obstaculo = new Obstaculo();
            obstaculo.setLayoutY(420);
            obstaculo.setLayoutX(860);
            listaObstaculos.add(obstaculo);
        }
    }

    public void setObstaculo(){
            posibleNuevo=true;
        }

}

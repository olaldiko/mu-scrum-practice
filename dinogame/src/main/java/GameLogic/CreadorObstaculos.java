package GameLogic;

import Model.Obstaculo;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Random;

import java.util.Random;


/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class CreadorObstaculos {
    int cantidad;
    int contador;
    boolean posibleNuevo;
    private ObservableList<Node> listaObstaculos;

    public CreadorObstaculos(AnchorPane capaObstaculos) {
        initCreadorObstaculos(capaObstaculos);
        cantidad = 3;
        contador = 0;
        posibleNuevo=false;
    }

    private void initCreadorObstaculos(AnchorPane capaObstaculos) {
        Obstaculo obstaculo;
        listaObstaculos = capaObstaculos.getChildren();
        for(int i=0;i<5;i++){
            obstaculo = new Obstaculo();
            obstaculo.setLayoutY(420);
            obstaculo.setLayoutX(800);
            listaObstaculos.add(obstaculo);
        }
    }

  /*  public boolean crearObstaculo() {
        Obstaculo obstaculo;
        if(posibleNuevo) {
            if (contador < cantidad) {
                contador++;
                obstaculo = new Obstaculo();
                obstaculo.setLayoutY(420);
                obstaculo.setLayoutX(800);
                listaObstaculos.add(obstaculo);
 //               posibleNuevo=false;
                return true;
            }
        }
        return false;
    }
*/
    /*
    public void borrarObstaculos() {
        ArrayList<Node> nodesForRemoval = new ArrayList<>();
        for (Node n : listaObstaculos) {
            if (n instanceof Obstaculo) {
                nodesForRemoval.add(n);
                contador--;
            }
        }
        listaObstaculos.removeAll(nodesForRemoval);
    }
    */

    public void setObstaculo(){
            posibleNuevo=true;
        }

}

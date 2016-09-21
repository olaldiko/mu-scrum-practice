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
    Random rand;
    int cantidad;
    int contador;
    boolean posibleNuevo;
    private ObservableList<Node> listaObstaculos;

    public CreadorObstaculos(AnchorPane capaObstaculos) {
        initCreadorObstaculos(capaObstaculos);
        cantidad = 3;
        rand = new Random();
        contador = 0;
        posibleNuevo=false;
    }

    private void initCreadorObstaculos(AnchorPane capaObstaculos) {
        listaObstaculos = capaObstaculos.getChildren();
    }

    public boolean crearObstaculo() {
        Obstaculo obstaculo;
        if(posibleNuevo) {
           // if (rand.nextBoolean() != false) {
             if(rand.nextInt(100)==2){
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
        }
        return false;
    }

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

    public void setObstaculo(){
            posibleNuevo=true;
        }

}

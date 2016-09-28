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

package GameLogic;

import Model.Obstaculo;
import javafx.collections.ObservableList;

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
    private ObservableList<Obstaculo> listaObstaculos;

    public CreadorObstaculos(ObservableList<Obstaculo> listaObstaculos) {
        initCreadorObstaculos(listaObstaculos);
    }

    private void initCreadorObstaculos(ObservableList<Obstaculo> listaObstaculos) {
        this.listaObstaculos = listaObstaculos;
    }
    public void crearObstaculos() {

    }
    public CreadorObstaculos() {
            cantidad = 5;
            rand = new Random();
            contador = 0;
            posibleNuevo=false;
    }
    public boolean crearObstaculo() {
        if(posibleNuevo) {
            if (rand.nextBoolean() != false) {
                if (contador < cantidad) {
                    contador++;
                    posibleNuevo=false;
                    return true;
                }
            }
        }
        return false;
        }
    public void setObstaculo(){
            posibleNuevo=true;
        }
    public boolean quitarObstaculo() {
        if (contador < cantidad && contador != 0) {
            contador--;
            if (contador < 0) {
                contador = 0;
            }
            return true;
        }else{
            return false;
        }
    }
}

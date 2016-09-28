package GameLogic;

import Model.GameModel;
import Model.Obstaculo;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class MovimientoObstaculos {
    private final int BASE_DURATION = 6000;
    private ObservableList<Obstaculo> listaObstaculos = FXCollections.observableArrayList();
    private GameModel model;
    private int contador;
   private Random rand;
    private TranslateTransition[] moverIzq;


    public MovimientoObstaculos(AnchorPane capaObstaculos, GameModel model) {
        initMovimientoObstaculos(capaObstaculos, model);
    }

    private void initMovimientoObstaculos(AnchorPane capaObstaculos, GameModel model) {
        for (Node n : capaObstaculos.getChildren()) {
            if (n instanceof Obstaculo) {
                listaObstaculos.add((Obstaculo) n);
            }
        }
        this.model = model;
        this.rand = new Random();
        this.moverIzq = new TranslateTransition[5];
        for(int i=0;i<5;i++){
            moverIzq[i] = new TranslateTransition(Duration.millis(BASE_DURATION), listaObstaculos.get(i));
            moverIzq[i].setFromX(0);
            moverIzq[i].setToX(-910);
        }
        this.contador=0;
    }

    public void stopMovimientoObstaculos() {
        Arrays.stream(moverIzq).forEach(translateTransition -> translateTransition.jumpTo(Duration.ZERO));
        Arrays.stream(moverIzq).forEach(Animation::stop);
        contador = 0;
    }


    public void moverObstaculos() {
        Arrays.stream(moverIzq).forEach(tr -> {
            if (tr.getStatus() == Transition.Status.STOPPED) {
                if(rand.nextInt(1200)==1) {
                    tr.playFromStart();
                    contador++;
                    if (contador > 5) {
                        model.obstaculoEsquivado();
                    }
                }
           }
        });
   }
}

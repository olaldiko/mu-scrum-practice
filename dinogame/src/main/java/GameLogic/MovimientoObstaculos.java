package GameLogic;

import Model.GameModel;
import Model.Obstaculo;
import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Random;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class MovimientoObstaculos {
    private ObservableList<Node> listaObstaculos;
    private AnchorPane capaObstaculos;
    SimpleLongProperty nivel;
    SimpleObjectProperty<Duration> duration;
    GameModel model;
   // private SequentialTransition animacionObstaculo = new SequentialTransition();
    private SequentialTransition animacionObstaculo[] = new SequentialTransition[5];
    Random rand;
    TranslateTransition moverIzq[]=new TranslateTransition[5];


    public MovimientoObstaculos(AnchorPane capaObstaculos, GameModel model) {
        initMovimientoObstaculos(capaObstaculos, model);
    }

    private void initMovimientoObstaculos(AnchorPane capaObstaculos, GameModel model) {
        listaObstaculos = capaObstaculos.getChildren();
        this.capaObstaculos = capaObstaculos;
        this.model = model;
        this.rand = new Random();
        for(int i=0;i<5;i++){
            moverIzq[i] = new TranslateTransition(Duration.millis(10000), listaObstaculos.get(i));
            moverIzq[i].setFromX(0);
            moverIzq[i].setToX(856);
            //animacionObstaculo.getChildren().addAll(moverIzq[i]);
            animacionObstaculo[i]=new SequentialTransition();
            animacionObstaculo[i].getChildren().addAll(moverIzq[i]);
        }
    }

   /*
    public void moverObstaculos() {

        nivel=model.elapsedTimeProperty();
        for(Node obs : listaObstaculos){
            if (obs instanceof Obstaculo) {
                obs.setLayoutX(obs.getLayoutX() - nivel.longValue() / 2000);
                if (obs.getLayoutX() < -56) {
                    obs.setLayoutX(800);
                    model.obstaculoEsquivado();
                }
            }
        }
    }
*/
   public void moverObstaculos() {
       int i=-1;
       nivel=model.elapsedTimeProperty();
       for(Node obs : listaObstaculos){
           i++;
           if (obs instanceof Obstaculo) {
               if(rand.nextInt(150)==2) {
                   if (obs.getLayoutX() == 800) {
                       moverIzq[i].playFromStart();
                   }
                   if (obs.getLayoutX() < -56) {
                       model.obstaculoEsquivado();
                       moverIzq[i].setToX(856);
                   }
               }
           }
       }
   }
}

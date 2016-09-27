package GameLogic;

import Model.GameModel;
import Model.Obstaculo;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleLongProperty;
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
    GameModel model;
    private SequentialTransition animacionObstaculo = new SequentialTransition();
    Random rand;

    public MovimientoObstaculos(AnchorPane capaObstaculos, GameModel model) {
        initMovimientoObstaculos(capaObstaculos, model);
        rand = new Random();
    }

    private void initMovimientoObstaculos(AnchorPane capaObstaculos, GameModel model) {
        listaObstaculos = capaObstaculos.getChildren();
        this.capaObstaculos = capaObstaculos;
        this.model = model;
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
       TranslateTransition moverIzq;
       nivel=model.elapsedTimeProperty();
       for(Node obs : listaObstaculos){
           if (obs instanceof Obstaculo) {
               if(rand.nextInt(150)==2) {
                   moverIzq = new TranslateTransition(Duration.millis(10000), obs);
                   moverIzq.setFromX(0);
                   moverIzq.setToX(856);
                   if (obs.getLayoutX() == 800) {
                       moverIzq.playFromStart();
                   }
                   animacionObstaculo.getChildren().addAll(moverIzq);
                   if (obs.getLayoutX() < -56) {
                       model.obstaculoEsquivado();
                       moverIzq.playFromStart();
                   }
               }
           }
       }
   }
}

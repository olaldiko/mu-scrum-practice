package GameLogic;

import Model.GameModel;
import Model.Obstaculo;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class MovimientoObstaculos {
    private ObservableList<Node> listaObstaculos;
    private AnchorPane capaObstaculos;
    SimpleLongProperty nivel;
    SimpleObjectProperty<Duration> duration;
    GameModel model;
    private SequentialTransition animacionObstaculo = new SequentialTransition();

    public MovimientoObstaculos(AnchorPane capaObstaculos, GameModel model) {
        initMovimientoObstaculos(capaObstaculos, model);
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
               moverIzq=new TranslateTransition(Duration.millis(10000),obs);
               moverIzq.setFromX(0);
               moverIzq.setToX(856);
               moverIzq.durationProperty().bind(duration);
               if(obs.getLayoutX()==800){
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

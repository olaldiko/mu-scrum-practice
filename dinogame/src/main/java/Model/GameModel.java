package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class GameModel {


    private final Jugador jugador = new Jugador();
    private final SimpleLongProperty elapsedTimeProperty = new SimpleLongProperty();
    private final SimpleIntegerProperty jumpedObstaclesProperty = new SimpleIntegerProperty();
    private final SimpleIntegerProperty scoreProperty = new SimpleIntegerProperty();
    private final TimerThread timerThread = new TimerThread();
    private ObservableList<Node> obstaculos;

    public ObservableList<Node> getObstaculos() {
        return obstaculos;
    }

    public void setObstaculos(ObservableList<Node> obstaculos) {
        this.obstaculos = obstaculos;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void initModel() {
        initScoreCounter();
        initGameTimer();
    }

    private void initGameTimer() {
        elapsedTimeProperty.bind(timerThread.elapsedTimeProperty());
        timerThread.start();
    }

    private void initScoreCounter() {
        double SCORE_OBSTACLE_MULTIPLIER = 10000;
        double SCORE_TIME_MULTIPLIER = 0.001;
        scoreProperty.bind(jumpedObstaclesProperty.multiply(SCORE_OBSTACLE_MULTIPLIER).add(elapsedTimeProperty).multiply(SCORE_TIME_MULTIPLIER));
    }

    public SimpleLongProperty elapsedTimeProperty() {
        return elapsedTimeProperty;
    }

    public SimpleIntegerProperty scoreProperty() {
        return scoreProperty;
    }

    public void resetScore() {
        timerThread.resetTimer();
        jumpedObstaclesProperty.set(0);
    }


    public void startGameTimer() {
        timerThread.startTimer();
    }

    public void stopGameTimer() {
        timerThread.stopTimer();
    }

    public void obstaculoEsquivado(){
        jumpedObstaclesProperty.set(jumpedObstaclesProperty.get() + 1);
    }


}

package Model;

import Model.Jugador;
import Model.Obstaculo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.ObservableList;
import javafx.util.Duration;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class GameModel {


    private final double SCORE_TIME_MULTIPLIER = 0.001;

    private final double SCORE_OBSTACLE_MULTIPLIER = 10;

    private final Jugador jugador = new Jugador();

    private final ObservableList<Obstaculo> obstaculos = new SimpleListProperty<>();

    private SimpleLongProperty elapsedTimeProperty = new SimpleLongProperty();

    private SimpleIntegerProperty jumpedObstaclesProperty = new SimpleIntegerProperty();

    private SimpleIntegerProperty scoreProperty = new SimpleIntegerProperty();

    public ObservableList<Obstaculo> getObstaculos() {
        return obstaculos;
    }

    private TimerThread timerThread = new TimerThread();

    public Jugador getJugador() {
        return jugador;
    }

    public void initGameTimer() {
        elapsedTimeProperty.bind(timerThread.elapsedTimeProperty());
    }

    public void initScoreCounter() {
        scoreProperty.bind(
                elapsedTimeProperty.multiply(SCORE_TIME_MULTIPLIER)
                        .add(jumpedObstaclesProperty.multiply(SCORE_OBSTACLE_MULTIPLIER)));
    }

    public SimpleLongProperty elapsedTimeProperty() {
        return elapsedTimeProperty;
    }

    public void resetScore() {
        elapsedTimeProperty.set(0);
        jumpedObstaclesProperty.set(0);
    }

    public void startGameTimer() {
        timerThread.start();
    }

    public void stopGameTimer() {
        timerThread.stopTimer();
    }


}

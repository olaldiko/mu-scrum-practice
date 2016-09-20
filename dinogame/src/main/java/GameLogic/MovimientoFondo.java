package GameLogic;

import Model.Principal;
import javafx.animation.*;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class MovimientoFondo {

    private AnchorPane capaFondo;
    ObservableList<ImageView> objetosFondo = new SimpleListProperty<>();
    ArrayList<TranslateTransition> transitions = new ArrayList<>();


    private final Image cloud = new Image(Principal.class.getResource("/SingleCloud.png").toString(), true);
    private final int MAX_CLOUDS = 10;
    private final int DEFAULT_TRANSITION = 4000;
    private final int MAX_HEIGHT = 200;
    private final int WAIT_BETWEEN_CLOUDS = 400;
    private final int CLOUD_MARGIN_R = 300;
    private final int CLOUD_MARGIN_L = 100;
    private final int SPEED = 5;
    private final int WALL_TRANSITION_DURATION = 8000;
    private boolean isNight = false;

    private final String dayWallpaper = "-fx-background-color:  linear-gradient(#1e5799 0%,#2989d8 50%,#207cca 79%,#9b861f 82%,#93794f 100%)";
    private final String nightWallpaper = "-fx-background-color: linear-gradient(#100621 0%,#0f274f 50%,#173f91 79%,#603b0d 82%,#473b26 100%)";




    public void initFondo(AnchorPane capaFondo) {
        this.capaFondo = capaFondo;
        cargarEstilosFondo();
        loadClouds();
    }

    private void loadClouds() {
        TranslateTransition transition;
        ImageView cloudView;
        for (int i = 0; i < MAX_CLOUDS; i++) {
            cloudView = new ImageView(cloud);
            cloudView.setLayoutX(-CLOUD_MARGIN_L);
            cloudView.setLayoutY(Math.random() * MAX_HEIGHT);
            transition = new TranslateTransition(Duration.millis(DEFAULT_TRANSITION), cloudView);
            transition.setFromX(Principal.WIDTH + CLOUD_MARGIN_R);
            transition.setToX(-CLOUD_MARGIN_L);
            transition.setCycleCount(TranslateTransition.INDEFINITE);
            capaFondo.getChildren().add(cloudView);
            transitions.add(transition);

        }
    }

    public void startAnimation() {
        Thread startDelayThread = new Thread(() -> {
            for (TranslateTransition tr : transitions) {
                tr.playFromStart();
                try {
                    Thread.sleep(WAIT_BETWEEN_CLOUDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        startDelayThread.start();
    }

    public void stopAnimation() {
        for (TranslateTransition tr : transitions) {
            tr.stop();
        }
    }

    private void cargarEstilosFondo() {
        capaFondo.setStyle(dayWallpaper);
    }

    public void changeWallpaper() {
        Timeline timeline = new Timeline();
        final KeyValue nighKv = new KeyValue(capaFondo.styleProperty(), nightWallpaper, Interpolator.EASE_BOTH);
        final KeyValue dayKv = new KeyValue(capaFondo.styleProperty(), dayWallpaper, Interpolator.EASE_BOTH);
        KeyFrame keyFrame;
        if (!isNight) {
            keyFrame = new KeyFrame(Duration.millis(WALL_TRANSITION_DURATION), nighKv);
        } else {
            keyFrame = new KeyFrame(Duration.millis(WALL_TRANSITION_DURATION), dayKv);
        }
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }


}

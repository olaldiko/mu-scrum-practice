package GameLogic;

import Model.Principal;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
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

    private final ArrayList<TranslateTransition> transitions = new ArrayList<>();
    private final GameSound gameSound = GameSound.getInstance();
    private final Image cloud = new Image(Principal.class.getResource("/SingleCloud.png").toString(), true);
    private final int MAX_CLOUDS = 10;
    private final int DEFAULT_TRANSITION = 4000;
    private final int MAX_HEIGHT = 200;
    private final int WAIT_BETWEEN_CLOUDS = 400;
    private final int CLOUD_MARGIN_R = 300;
    private final int CLOUD_MARGIN_L = 100;
    private final int SPEED = 5;
    private final int WALL_TRANSITION_DURATION = 8000;
    private final String dayWallpaper = "-fx-background-color:  linear-gradient(#1e5799 0%,#2989d8 50%,#207cca 79%,#9b861f 82%,#93794f 100%)";
    private final String duskWallpaper = "-fx-background-color:  linear-gradient(to bottom, #721616 0%,#e58a7b 50%,#7db9e8 79%,#a38f58 82%,#8e5c16 100%)";
    private final String nightWallpaper = "-fx-background-color: linear-gradient(#100621 0%,#0f274f 50%,#173f91 79%,#603b0d 82%,#473b26 100%)";
    ObservableList<ImageView> objetosFondo = new SimpleListProperty<>();
    private AnchorPane capaFondo;
    private Thread changerThread;
    private int wall_index = 0;
    private boolean isNight = false;
    private DoubleProperty musicRate;

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
        musicRate = gameSound.gameMusicRateProperty();
        musicRate.set(1.0);
        wall_index = 0;
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

    public void startWallChanger() {
        changerThread = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    break;
                }
                Platform.runLater(this::changeWallpaper);
                musicRate.set(musicRate.get() + 0.2);
            }
        });
        changerThread.start();
    }

    public void stopAnimation() {
        transitions.forEach(translateTransition -> translateTransition.jumpTo(Duration.ZERO));
        transitions.forEach(Animation::stop);
        changerThread.interrupt();
        Platform.runLater(() -> capaFondo.setStyle(dayWallpaper));
    }

    private void cargarEstilosFondo() {
        capaFondo.setStyle(dayWallpaper);
    }

    private void changeWallpaper() {
        switch (wall_index % 3) {
            case 0:
                capaFondo.setStyle(dayWallpaper);
                break;
            case 1:
                capaFondo.setStyle(duskWallpaper);
                break;
            case 2:
                capaFondo.setStyle(nightWallpaper);
                break;
            default:
                capaFondo.setStyle(dayWallpaper);
        }
        wall_index++;
    }


}

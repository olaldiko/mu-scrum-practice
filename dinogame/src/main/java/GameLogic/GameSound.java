package GameLogic;

import Model.Principal;
import javafx.beans.property.DoubleProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Created by Gorka Olalde on 20/9/16.
 */
public class GameSound {

    private static GameSound instance = null;

    private final MediaPlayer jumpSound;
    private final MediaPlayer dieSound;
    private final MediaPlayer menuMusic;
    private final MediaPlayer gameMusic;


    private GameSound() {
        jumpSound = new MediaPlayer(new Media(Principal.class.getResource("/jump.mp3").toString()));
        dieSound = new MediaPlayer(new Media(Principal.class.getResource("/die.mp3").toString()));
        menuMusic = new MediaPlayer(new Media(Principal.class.getResource("/menumus.mp3").toString()));
        gameMusic = new MediaPlayer(new Media(Principal.class.getResource("/gamemus.mp3").toString()));

        menuMusic.setCycleCount(MediaPlayer.INDEFINITE);
        gameMusic.setCycleCount(MediaPlayer.INDEFINITE);

        jumpSound.setOnEndOfMedia(jumpSound::stop);

    }

    public static GameSound getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new GameSound();
        }
        return instance;
    }

    public void playMenuMusic() {
        menuMusic.play();
    }

    public void stopMenuMusic() {
        menuMusic.stop();
    }

    public void playGameMusic() {
        gameMusic.setRate(1.0);
        gameMusic.play();
    }

    public void stopGameMusic() {
        gameMusic.stop();
    }

    public void setGameMusicRate(double rate) {
        gameMusic.setRate(rate);
    }


    public void playJumpSound() {
        jumpSound.play();
    }

    public void playDieSound() {
        dieSound.play();
    }

    public DoubleProperty gameMusicRateProperty() {
        return gameMusic.rateProperty();
    }

}

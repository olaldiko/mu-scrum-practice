package Model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

/**
 * Created by Gorka Olalde on 19/9/16.
 */
public class TimerThread extends Thread {

    private final int REFRESH_INTERVAL = 100;

    private volatile boolean stopTimer;

    private long startTimeMilis;

    private final SimpleLongProperty timeMilis = new SimpleLongProperty();


    @Override
    public void run() {
        stopTimer = false;
        startTimeMilis = System.currentTimeMillis();
        while (!stopTimer) {
            timeMilis.set(System.currentTimeMillis() - startTimeMilis);
            try {
                Thread.sleep(REFRESH_INTERVAL);
            } catch (InterruptedException e) {
                stopTimer = true;
            }
        }
    }


    public SimpleLongProperty elapsedTimeProperty() {
        return timeMilis;
    }

    public void stopTimer() {
        stopTimer = true;
    }
}

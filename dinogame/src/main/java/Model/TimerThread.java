package Model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Gorka Olalde on 19/9/16.
 */
public class TimerThread extends Thread {

    private final int REFRESH_INTERVAL = 100;

    private volatile boolean stopTimer = true;

    private long startTimeMilis;

    private final SimpleLongProperty timeMilis = new SimpleLongProperty();

    Lock candado = new ReentrantLock();
    Condition wait = candado.newCondition();

    public TimerThread() {
        this.setName("TimerThread");

    }

    @Override
    public void run() {
        while (true) {
            candado.lock();
            startTimeMilis = System.currentTimeMillis();
            while (!stopTimer) {
                timeMilis.set(System.currentTimeMillis() - startTimeMilis);
                try {
                    Thread.sleep(REFRESH_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (stopTimer) {
                try {
                    wait.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            candado.unlock();
        }
    }


    public SimpleLongProperty elapsedTimeProperty() {
        return timeMilis;
    }

    public void stopTimer() {
        stopTimer = true;
    }
    public void startTimer() {
        candado.lock();
        stopTimer = false;
        wait.signal();
        candado.unlock();
    }

    public void resetTimer() {
        timeMilis.set(0);
    }
}

package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by urko on 27/09/16.
 */
public class Puntuacion implements Comparable<Puntuacion>{

    public final SimpleIntegerProperty score = new SimpleIntegerProperty();

    public final SimpleStringProperty nombre = new SimpleStringProperty();

    public int getScore() {
        return score.get();
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    @Override
    public int compareTo(Puntuacion p) {
        if (score.get() < p.getScore()) {
            return -1;
        } else if (score.get() == p.getScore()) {
            return 0;
        } else {
            return 1;
        }
    }
}

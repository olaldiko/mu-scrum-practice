package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by urko on 27/09/16.
 */
public class Puntuacion implements Comparable<Puntuacion>{

    public SimpleIntegerProperty score = new SimpleIntegerProperty();

    public SimpleStringProperty nombre = new SimpleStringProperty();

    public int getScore() {
        return score.get();
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(score);
    }


    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
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

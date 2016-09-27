package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by urko on 27/09/16.
 */
public class Puntuacion implements Comparable<Puntuacion>{

    public SimpleIntegerProperty puntuacion = new SimpleIntegerProperty();

    public int getPuntuacion() {
        return puntuacion.get();
    }

    public SimpleIntegerProperty puntuacionProperty() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion.set(puntuacion);
    }

    public SimpleStringProperty nombre = new SimpleStringProperty();


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
        if (puntuacion.get() < p.getPuntuacion()) {
            return -1;
        } else if (puntuacion.get() == p.getPuntuacion()) {
            return 0;
        } else {
            return 1;
        }
    }
}

package View;

import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class VistaJuego {

    StackPane stack = new StackPane();
    AnchorPane capaFondo = new AnchorPane();
    AnchorPane capaObstaculos = new AnchorPane();
    AnchorPane capaJugador = new AnchorPane();
    AnchorPane capaMenu = new AnchorPane();


    public void mostrarMenu() {
        stack.getChildren().remove(capaFondo);
        stack.getChildren().remove(capaObstaculos);
        stack.getChildren().remove(capaJugador);
    }

    public void mostrarJuego() {
        stack.getChildren().add(capaFondo);
        stack.getChildren().add(capaObstaculos);
        stack.getChildren().add(capaJugador);
    }


    public Parent getRootPane() {
        return stack;
    }
}

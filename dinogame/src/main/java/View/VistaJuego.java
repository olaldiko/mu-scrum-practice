package View;

import Model.Principal;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class VistaJuego {

    private final StackPane stack = new StackPane();

    private final AnchorPane capaFondo = new AnchorPane();

    private final AnchorPane capaObstaculos = new AnchorPane();

    private final AnchorPane capaJugador = new AnchorPane();

    private AnchorPane capaPuntuacion;

    private AnchorPane capaMenu;

    private AnchorPane capaFinalScreen;

    public void initVistaJuego() {
        stack.setPrefSize(Principal.WIDTH, Principal.HEIGHT);
        capaFondo.setPrefSize(Principal.WIDTH, Principal.HEIGHT);
        capaObstaculos.setPrefSize(Principal.WIDTH, Principal.HEIGHT);
        capaJugador.setPrefSize(Principal.WIDTH, Principal.HEIGHT);
        capaObstaculos.setStyle("-fx-background-color: transparent");
        capaJugador.setStyle("-fx-background-color: transparent");
    }

    public void mostrarMenu() {
        stack.getChildren().remove(capaFondo);
        stack.getChildren().remove(capaObstaculos);
        stack.getChildren().remove(capaJugador);
        stack.getChildren().add(capaMenu);
    }
    public void mostrarJuego() {
        stack.getChildren().remove(capaMenu);
        stack.getChildren().add(capaFondo);
        stack.getChildren().add(capaObstaculos);
        stack.getChildren().add(capaJugador);
        stack.getChildren().add(capaPuntuacion);
    }


    public Parent getRootPane() {
        return stack;
    }

    public AnchorPane getCapaFondo() {
        return capaFondo;
    }


    public AnchorPane getCapaObstaculos() {
        return capaObstaculos;
    }

    public void setCapaMenu(AnchorPane capaMenu) {
        this.capaMenu = capaMenu;
    }

    public AnchorPane getCapaJugador() {
        return capaJugador;
    }

    public void setCapaPuntuacion(AnchorPane capaPuntuacion) {
        this.capaPuntuacion = capaPuntuacion;
    }

    public void setCapaFinalScreen(AnchorPane capaFinalScreen) {
        this.capaFinalScreen = capaFinalScreen;
    }

}

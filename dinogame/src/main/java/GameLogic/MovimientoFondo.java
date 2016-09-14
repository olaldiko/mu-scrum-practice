package GameLogic;

import Model.Principal;
import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Created by Gorka Olalde on 12/9/16.
 */
public class MovimientoFondo {

    private AnchorPane capaFondo;
    ObservableList<ImageView> objetosFondo = new SimpleListProperty<>();
    private final Image cloud = new Image(Principal.class.getResource("/SingleCloud.png").toString());
    final int MAX_CLOUDS = 10;
    private final int MAX_HEIGHT = 200;
    private final int CLOUD_SIZE = 50;
    private final int SPEED = 5;

    public void initFondo(AnchorPane capaFondo) {
        this.capaFondo = capaFondo;
        cargarEstilosFondo();
        cloudCreator();
    }

    private void cargarEstilosFondo() {
        capaFondo.setStyle("-fx-background-color:  linear-gradient(#b3dced 0%,#32b0a4 12%,#29b8e5 45%,#bce0ee 100%)");
    }

    private void cloudCreator() {
        ImageView cloudView = new ImageView(cloud);
        cloudView.setLayoutX(Principal.WIDTH + CLOUD_SIZE);
        cloudView.setLayoutY(Math.random() * MAX_HEIGHT);
        cloudView.setFitHeight(20);
        cloudView.setFitWidth(40);
        cloudView.setCache(true);
        Platform.runLater(() -> capaFondo.getChildren().add(cloudView));

    }

    public void moverFondo(long now) {
        if (now % 50 == 0 && capaFondo.getChildren().size() < 10) {
            cloudCreator();
        }
        for (Node p : capaFondo.getChildren()) {
            if (p.getLayoutX() > 0) {
                Platform.runLater(() -> p.setLayoutX(p.getLayoutX() - SPEED));
            } else {
                Platform.runLater(() -> capaFondo.getChildren().remove(p));
            }
        }
    }

}

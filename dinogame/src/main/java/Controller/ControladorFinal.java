package Controller;

import Model.FileManager;
import Model.Principal;
import Model.Puntuacion;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Gorka Olalde on 21/9/16.
 */
public class ControladorFinal {

    @FXML
    Label enterNameLabel;
    @FXML
    TextField nameTextField;
    @FXML
    Label pointsLabel;
    @FXML
    Button replayBtn;
    @FXML
    Button backBtn;
    private ControladorPrincipal principal;
    private SimpleIntegerProperty points = new SimpleIntegerProperty();
    private ObservableList<Puntuacion> ranking;
    private boolean isHighScore;
    private AnchorPane pane;

    public AnchorPane showScreen(ControladorPrincipal principal, SimpleIntegerProperty points) throws IOException {
        this.principal = principal;
        this.points = points;
        FXMLLoader loader = new FXMLLoader(Principal.class.getResource("/gameEndsScreen.fxml"));
        loader.setController(this);
        pane = loader.load();
        replayBtn.setOnAction(e -> onReplayPressed());
        backBtn.setOnAction(e -> onBackPressed());
        pointsLabel.setText(points.getValue().toString());
        checkForHighScore();
        return pane;
    }

    public void checkForHighScore() {
        ranking = FileManager.readFile();
        if (ranking.size() == 0) {
            isHighScore = true;
        } else {
            ranking.stream()
                    .filter(p -> points.get() > p.getScore())
                    .forEach(p -> isHighScore = true);
        }
        if (!isHighScore) {
            pane.getChildren().remove(enterNameLabel);
            pane.getChildren().remove(nameTextField);
        }
    }

    public void storeScore() {
        Puntuacion p;
        if (isHighScore) {
            p = new Puntuacion();
            p.setNombre(nameTextField.getText());
            p.setScore(points.get());
            ranking.add(p);
            FileManager.writeFile(ranking);
        }
    }

    public void onBackPressed() {
        storeScore();
        principal.mostrarMenu();
    }

    public void onReplayPressed() {
        storeScore();
        principal.mostrarJuego();
    }
}

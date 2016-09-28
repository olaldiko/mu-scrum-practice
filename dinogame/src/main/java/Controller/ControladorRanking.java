package Controller;

import Model.FileManager;
import Model.Principal;
import Model.Puntuacion;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Gorka Olalde on 27/9/16.
 */
class ControladorRanking {

    private final ControladorPrincipal principal;
    @FXML
    private TableView<Puntuacion> scoreTable;
    @FXML
    private TableColumn<Puntuacion, String> nameCol;
    @FXML
    private TableColumn<Puntuacion, Integer> scoreCol;
    @FXML
    private Button backBtn;
    private ObservableList<Puntuacion> tableModel;

    public ControladorRanking(ControladorPrincipal principal) {
        this.principal = principal;
    }

    private void loadScores() {
        tableModel = FileManager.readFile();
        scoreTable.setItems(tableModel);
    }

    private void setCellRenderers() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
    }
    @FXML
    public void returnButtonPressed() {
        principal.mostrarMenu();
    }


    public AnchorPane initRanking() {
        AnchorPane pane = null;
        FXMLLoader loader = new FXMLLoader(Principal.class.getResource("/scoreScreen.fxml"));
        loader.setController(this);
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setCellRenderers();
        loadScores();
        scoreTable.getSortOrder().clear();
        scoreTable.getSortOrder().add(scoreCol);
        return pane;
    }

}

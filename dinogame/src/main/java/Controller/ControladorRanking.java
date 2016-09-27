package Controller;

import Model.FileManager;
import Model.Puntuacion;
import javafx.beans.binding.StringBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

/**
 * Created by Gorka Olalde on 27/9/16.
 */
public class ControladorRanking {

    @FXML
    private TableView<Puntuacion> scoreTable;

    @FXML
    private TableColumn<Puntuacion, String> nameCol;

    @FXML
    private TableColumn<Puntuacion, Integer> scoreCol;

    @FXML
    private Button backBtn;

    ControladorPrincipal principal;

    ObservableList<Puntuacion> tableModel;

    public void ControladorRanking(ControladorPrincipal principal) {
        this.principal = principal;
        nameCol.setCellValueFactory(new PropertyValueFactory<Puntuacion, String>("nombre"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<Puntuacion, Integer>("score"));

    }

    public void loadScores() {
        tableModel = FileManager.readFile();
        scoreTable.setItems(tableModel);
    }


    @FXML
    public void returnButtonPressed() {
        principal.mostrarMenu();
    }


}

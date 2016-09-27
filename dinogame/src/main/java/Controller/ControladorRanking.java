package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by Gorka Olalde on 27/9/16.
 */
public class ControladorRanking {

    @FXML
    private TableView<?> scoreTable;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> scoreCol;

    @FXML
    private Button backBtn;

    ControladorPrincipal principal;

    public void ControladorRanking(ControladorPrincipal principal) {


    }

}

package Model;

import Controller.ControladorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Gorka Olalde on 8/9/16.
 */
public class Principal extends Application{
    public final static int WIDTH = 800;
    public final static int HEIGHT = 600;
    private final ControladorPrincipal controller = new ControladorPrincipal();
    private final GameModel model = new GameModel();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(controller.getVistaJuego().getRootPane());
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setScene(scene);
        model.initModel();
        controller.initControlador(model);
        controller.mostrarMenu();
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            model.stopGameTimer();
            primaryStage.close();
        });
    }
 }

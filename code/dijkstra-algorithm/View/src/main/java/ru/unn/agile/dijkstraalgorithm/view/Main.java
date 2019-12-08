package ru.unn.agile.dijkstraalgorithm.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private static final String APP_TITLE = "Dijkstra Algorithm";
    private static final String APP_FXML = "Dijkstra.fxml";
    private static final String STYLE_RESOURCES = "style.css";

    @Override
    public void start(final Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(APP_FXML));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(STYLE_RESOURCES).toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle(APP_TITLE);
        primaryStage.show();
    }

    public static void main(final String[] args) {
        launch(args);
    }
}



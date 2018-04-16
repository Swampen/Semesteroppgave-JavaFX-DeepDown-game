package deepDown;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import deepDown.menuControllers.StartMenuController;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Scene scene;
    private Parent root;

    @Override
    public void start(Stage stage) throws IOException{

        StartMenuController startMenu = new StartMenuController();
        URL url = getClass().getResource("/deepDown/resource/FXML/startMenu.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(startMenu);
        root = loader.load();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Deep Down");
        stage.show();
    }

    public Parent getRoot(){
        return root;
    }
}
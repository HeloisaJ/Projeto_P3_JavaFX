package pega;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import Quarto.SistemaDeQuartos;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Stage stage;


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("viewinicial"), 500, 500);
        stage.setScene(scene);
        stage.setTitle("Tela incial");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
        SistemaDeQuartos.inicializarQuartos();
        this.stage = stage;
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        if(fxml.equals(""))
        {
            stage.setTitle("");
        }
    }
    

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
}
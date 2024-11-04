package org.example.di_ejerciciopracticoev_tema3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplication extends Application {
    private static Stage ventana;

    @Override
    public void start(Stage stage){
        ventana = stage;
        loadFXML("views/main-view.fxml", "Login", 250, 350, false);
        stage.show();
    }

    public static void loadFXML(String view, String title, Integer anchura, Integer altura, Boolean resizable) {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplication.class.getResource(view));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),anchura,altura);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ventana.setTitle(title);
        ventana.setScene(scene);
        ventana.setResizable(resizable);

        //Hace que la ventana se centre en la pantalla
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        ventana.setX((screenBounds.getWidth() - anchura) / 2);
        ventana.setY((screenBounds.getHeight() - altura) / 2);
    }

    public static void main(String[] args) {
        launch();
    }
}
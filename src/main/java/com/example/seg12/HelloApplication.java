package com.example.seg12;

import com.example.seg12.model.VaultContent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static VaultContent v = new VaultContent();
    @Override
    public void start(Stage stage) throws IOException {
        openWindow("hello-view.fxml");
    }

    public static void openWindow(String fxml){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("SafeBox");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}
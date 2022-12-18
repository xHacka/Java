package com.example.javacourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = loadScene(getClass(), "main", 640, 360);
        loadStage(stage, scene, "Main Application");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Scene loadScene(Class cls, String fxml, int w, int h) throws IOException {
        String fxmlFile = fxml.endsWith(".fxml") ? fxml : String.format("%s.fxml", fxml);
        FXMLLoader fxmlLoader = new FXMLLoader(cls.getResource(fxmlFile));
        return new Scene(fxmlLoader.load(), w, h);
    }

    public static void loadStage(Stage stage, Scene scene, String title) {
        stage.setTitle(title);
        stage.setScene(scene);
    }
}
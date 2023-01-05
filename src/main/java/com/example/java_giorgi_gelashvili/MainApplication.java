package com.example.java_giorgi_gelashvili;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static final int WINDOW_HEIGHT = 720;
    public static final int WINDOW_WIDTH = -1;

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = new FXMLLoader(MainApplication.class.getResource("base.fxml")).load();
        Scene scene = new Scene(root, root.getMaxWidth(), WINDOW_HEIGHT);
        stage.setTitle("Quiz 5");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
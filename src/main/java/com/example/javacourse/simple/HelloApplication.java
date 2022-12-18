package com.example.javacourse.simple;

import com.example.javacourse.MainApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = MainApplication.loadScene(getClass(), "hello-view", 640, 360);
        MainApplication.loadStage(stage, scene, "Simple Application");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
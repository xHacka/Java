package com.example.javacourse.calc;

import com.example.javacourse.MainApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalcApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = MainApplication.loadScene(getClass(), "calc", 640, 360);
        MainApplication.loadStage(stage, scene, "Simple Calculator");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
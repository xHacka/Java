package com.example.javacourse.charts;

import com.example.javacourse.MainApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ChartsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = MainApplication.loadScene(getClass(), "charts", 1000, 720);
        MainApplication.loadStage(stage, scene, "Charts");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
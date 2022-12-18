package com.example.javacourse;

import com.example.javacourse.calc.CalcApplication;
import com.example.javacourse.charts.ChartsApplication;
import com.example.javacourse.simple.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private Button calcBtn;

    @FXML
    private Button chartsBtn;

    @FXML
    private Button simpleBtn;

    @FXML
    void showCalc(ActionEvent event) {
        showStage(CalcApplication.class, "calc", "Simple Calculator", 160, 240);
    }

    @FXML
    void showCharts(ActionEvent event) {
        showStage(ChartsApplication.class, "charts", "Charts", 1000, 720);
    }

    @FXML
    void showSimple(ActionEvent event) {
        showStage(HelloApplication.class, "hello-view", "Simple Application", 120, 100);
    }

    private void showStage(Class cls, String fxml, String title, int w, int h) {
        try {
            Scene scene = MainApplication.loadScene(cls, fxml, w, h);
            Stage stage = new Stage();
            MainApplication.loadStage(stage, scene, title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

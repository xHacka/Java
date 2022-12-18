package com.example.javacourse.charts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ChartsController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private CategoryAxis barChartXAxis;
    @FXML
    private NumberAxis barChartYAxis;

    @FXML
    private BubbleChart<Number, Number> bubbleChart;
    @FXML
    public NumberAxis bubbleChartXAxis, bubbleChartYAxis;

    @FXML
    private LineChart<Number, Number> lineChart;
    @FXML
    public NumberAxis lineChartXAxis, lineChartYAxis;

    @FXML
    private PieChart pieChart;

    private void fillBarChart() {
        final String austria = "Austria";
        final String brazil = "Brazil";
        final String france = "France";
        final String italy = "Italy";
        final String usa = "USA";

        barChartXAxis.setLabel("Country");
        barChartYAxis.setLabel("Value");
        barChart.setTitle("Country Summary");

        XYChart.Series<String, Number> series1 = new XYChart.Series<>(
                FXCollections.observableArrayList(
                        new XYChart.Data<>(austria, 25601.34),
                        new XYChart.Data<>(brazil, 20148.82),
                        new XYChart.Data<>(france, 10000),
                        new XYChart.Data<>(italy, 35407.15),
                        new XYChart.Data<>(usa, 12000)
                )
        );
        XYChart.Series<String, Number> series2 = new XYChart.Series<>(
                FXCollections.observableArrayList(
                        new XYChart.Data<>(austria, 57401.85),
                        new XYChart.Data<>(brazil, 41941.19),
                        new XYChart.Data<>(france, 45263.37),
                        new XYChart.Data<>(italy, 117320.16),
                        new XYChart.Data<>(usa, 14845.27)
                )
        );
        XYChart.Series<String, Number> series3 = new XYChart.Series<>(
                FXCollections.observableArrayList(
                        new XYChart.Data<>(austria, 45000.65),
                        new XYChart.Data<>(brazil, 44835.76),
                        new XYChart.Data<>(france, 18722.18),
                        new XYChart.Data<>(italy, 17557.31),
                        new XYChart.Data<>(usa, 92633.68)
                )
        );
        series1.setName("2003");
        series2.setName("2004");
        series3.setName("2005");

        //Setting the data to bar chart
        barChart.getData().addAll(series1, series2, series3);
    }

    public void fillBubbleChart() {
        bubbleChartXAxis.setLabel("Week");
        bubbleChartYAxis.setLabel("Product Budget");
        bubbleChart.setTitle("Budget Monitoring");

        XYChart.Series series1 = new XYChart.Series(
                FXCollections.observableArrayList(
                        new XYChart.Data(3, 35),
                        new XYChart.Data(12, 60),
                        new XYChart.Data(15, 15),
                        new XYChart.Data(22, 30),
                        new XYChart.Data(28, 20),
                        new XYChart.Data(35, 41),
                        new XYChart.Data(42, 17),
                        new XYChart.Data(49, 30)
                )
        );
        XYChart.Series series2 = new XYChart.Series(
                FXCollections.observableArrayList(
                        new XYChart.Data(8, 15),
                        new XYChart.Data(13, 23),
                        new XYChart.Data(15, 45),
                        new XYChart.Data(24, 30),
                        new XYChart.Data(38, 78),
                        new XYChart.Data(40, 41),
                        new XYChart.Data(45, 57),
                        new XYChart.Data(47, 23)
                )
        );

        series1.setName("Product 1");
        series2.setName("Product 2");
        bubbleChart.getData().addAll(series1, series2);
    }

    public void fillPieChart() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));
        pieChart.setData(pieChartData);
        pieChart.setTitle("Imported Fruits");
    }

    public void fillLineChart() {
        lineChartXAxis.setLabel("Number of Month");
        lineChart.setTitle("Stock Monitoring, 2010");

        XYChart.Series<Number, Number> series = new XYChart.Series<>(
                FXCollections.observableArrayList(
                        new XYChart.Data<>(1, 23),
                        new XYChart.Data<>(2, 14),
                        new XYChart.Data<>(3, 15),
                        new XYChart.Data<>(4, 24),
                        new XYChart.Data<>(5, 34),
                        new XYChart.Data<>(6, 36),
                        new XYChart.Data<>(7, 22),
                        new XYChart.Data<>(8, 45),
                        new XYChart.Data<>(9, 43),
                        new XYChart.Data<>(10, 17),
                        new XYChart.Data<>(11, 29),
                        new XYChart.Data<>(12, 25)
                )
        );
        series.setName("My portfolio");
        lineChart.getData().add(series);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fillPieChart();
        fillBarChart();
        fillBubbleChart();
        fillLineChart();
    }
}
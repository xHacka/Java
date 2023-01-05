package com.example.java_giorgi_gelashvili;

import com.example.java_giorgi_gelashvili.utils.PlaneUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;

public class MainController implements Initializable {
    @FXML
    private DatePicker dateInput;
    @FXML
    private TextField sourceInput;
    @FXML
    private TextField destinationInput;
    @FXML
    private TextField priceInput;
    @FXML
    private TextField seatsInput;
    @FXML
    private TextField seatsOccupiedInput;
    @FXML
    private TableView<Plane> flightsTable;
    @FXML
    private AnchorPane mainFrame;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private CategoryAxis barChartX;
    @FXML
    private NumberAxis barChartY;
    @FXML
    private TextField generateInput;

    private void populateTable() {
        List<String> headerNames = new ArrayList<>(List.of("source", "destination", "date", "seats", "seatsOccupied", "price"));
        List<TableColumn<Plane, String>> headers = new ArrayList<>(
                List.of(
                        new TableColumn<>("Source"),
                        new TableColumn<>("Destination"),
                        new TableColumn<>("Source"),
                        new TableColumn<>("Seats"),
                        new TableColumn<>("Seats Occupied"),
                        new TableColumn<>("Price")
                ));
        for (int i = 0; i < headerNames.size(); i++) {
            // !!! IMPORTANT !!!
            headers.get(i).setCellValueFactory(
                    new PropertyValueFactory<>(headerNames.get(i))
            );
        }
        headers.get(0).setPrefWidth(140);
        headers.get(1).setPrefWidth(140);
        flightsTable.getColumns().addAll(headers);

        List<Plane> planes = PlaneUtils.getAll();
        ObservableList<Plane> planeObservableList = FXCollections.observableList(planes);
        flightsTable.setItems(planeObservableList);
    }

    private void loadFrame(String fxml) {
        try {
            AnchorPane root = new FXMLLoader(MainApplication.class.getResource(fxml + ".fxml")).load();
            mainFrame.getChildren().clear();
            mainFrame.getChildren().add(root);
            mainFrame = (AnchorPane) mainFrame.getChildren().get(0);
            flightsTable = (TableView<Plane>) mainFrame.lookup("#flightsTable");
            generateInput = (TextField) mainFrame.lookup("#generateInput");
            barChart = (BarChart<String, Number>) mainFrame.lookup("#barChart");
            barChartX = (CategoryAxis) mainFrame.lookup("#barChartX");
            barChartY = (NumberAxis) mainFrame.lookup("#barChartY");
            AnchorPane.setBottomAnchor(mainFrame, 0.0);
            AnchorPane.setTopAnchor(mainFrame, 0.0);
            AnchorPane.setLeftAnchor(mainFrame, 0.0);
            AnchorPane.setRightAnchor(mainFrame, 0.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addFlight(ActionEvent event) {
        loadFrame("addNew");
    }

    @FXML
    private void filterChars(KeyEvent event) {
        TextField textField = (TextField) event.getSource();
        if (!Character.isDigit(event.getCharacter().charAt(0))) {
            textField.deletePreviousChar();
            event.consume();
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        loadFrame("base");
    }

    @FXML
    private void showStatistics(ActionEvent event) {
        loadFrame("stats");
        if (barChart == null) return;
        List<Plane> planes = PlaneUtils.getAll();
        Map<String, Integer> destinationStats = planes.stream()
                .collect(Collectors.groupingBy(Plane::getDestination, Collectors.summingInt(e -> 1)));
        barChartX.setLabel("Country");
        barChartY.setLabel("Flights");
        barChart.setTitle("Flights Statistics Of Number Of Flights");
        for (Map.Entry<String, Integer> entry : destinationStats.entrySet()) {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(entry.getKey());
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
            barChart.getData().add(series);
        }
    }

    @FXML
    private void saveFlight(ActionEvent event) {
        if (flightsTable != null) return;
        String source = sourceInput.getText();
        String destination = destinationInput.getText();
        int seats = seatsInput.getText().isBlank() ? 0 : Integer.parseInt(seatsInput.getText());
        int seatsOccupied = seatsOccupiedInput.getText().isBlank() ? 0 : Integer.parseInt(seatsOccupiedInput.getText());
        double price = priceInput.getText().isBlank() ? 0 : Double.parseDouble(priceInput.getText());

        Date date;
        try {
            date = new Date(dateInput.getValue().toEpochDay());
        } catch (NullPointerException e) {
            return;
        }

        if (Objects.isNull(source) || Objects.isNull(destination) || seats == 0 || price == 0 || seatsOccupied > seats) {
            return;
        }

        PlaneUtils.insert(new Plane(source, destination, date, seats, seatsOccupied, price));
        loadFrame("base");
    }

    private void deleteFlight() {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Are you sure you want to delete the selected row?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Plane plane = flightsTable.getSelectionModel().getSelectedItem();
                flightsTable.getItems().remove(plane);
                PlaneUtils.deletePlane(plane.getId());
            }
        });
        contextMenu.getItems().add(deleteMenuItem);
        flightsTable.setContextMenu(contextMenu);
    }

    @FXML
    private void generateDummyData() {
        if (generateInput.getText().isBlank()) return;
        int genCount = Integer.parseInt(generateInput.getText());
        if (genCount == 0 || genCount > 1000) return;
        PlaneUtils.populateDatabase(genCount);
        loadFrame("base");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (flightsTable != null) {
            populateTable();
            flightsTable.setRowFactory(table -> {
                TableRow<Plane> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.SECONDARY) {
                        deleteFlight();
                    }
                });
                return row;
            });
        }
        mainFrame.setPrefWidth(-1);
    }
}

module com.example.javacourse {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.javacourse;
    exports com.example.javacourse.simple;
    exports com.example.javacourse.calc;
    exports com.example.javacourse.charts;

    opens com.example.javacourse to javafx.fxml;
    opens com.example.javacourse.calc to javafx.fxml;
    opens com.example.javacourse.simple to javafx.fxml;
    opens com.example.javacourse.charts to javafx.fxml;
}
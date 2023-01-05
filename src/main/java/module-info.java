module com.example.java_giorgi_gelashvili {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires javafaker;


    opens com.example.java_giorgi_gelashvili to javafx.fxml;
    exports com.example.java_giorgi_gelashvili;
}
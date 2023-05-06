module com.example.seg12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.seg12 to javafx.fxml;
    exports com.example.seg12;

    opens com.example.seg12.model to javafx.fxml;
    exports com.example.seg12.model;

}
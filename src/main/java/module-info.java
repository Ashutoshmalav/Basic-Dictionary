module com.example.dictionaryashu11dec {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dictionaryashu11dec to javafx.fxml;
    exports com.example.dictionaryashu11dec;
}
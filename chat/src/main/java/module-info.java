module chat.java {
    requires javafx.controls;
    requires javafx.fxml;

    opens chat.java to javafx.fxml;
    exports chat.java;
}

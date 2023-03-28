module chat.java {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens chat.java to javafx.fxml;
    exports chat.java;
}

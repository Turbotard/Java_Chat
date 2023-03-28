module chat.client.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;

    opens chat.client.client to javafx.fxml;
    exports chat.client.client;
}
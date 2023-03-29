package chat.client.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import chat.client.client.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField tf_username;

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String username = tf_username.getText().trim();

        if (!username.isEmpty()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/chat/client/client/Main.fxml"));
                Parent root = loader.load();
                Controller controller = loader.getController();
                controller.setUsername(username);

                Stage stage = (Stage) tf_username.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
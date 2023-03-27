import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ChatInterface extends Application {

    private TextArea chatHistory;
    private TextField messageInput;
    private Button sendButton;

    @Override
    public void start(Stage primaryStage) {
        // create UI components
        chatHistory = new TextArea();
        chatHistory.setEditable(false);

        messageInput = new TextField();

        sendButton = new Button("Send");
        sendButton.setOnAction(e -> sendMessage());

        // layout UI components
        VBox chatBox = new VBox(chatHistory);
        chatBox.setPadding(new Insets(10));
        chatBox.setPrefHeight(400);

        HBox messageBox = new HBox(messageInput, sendButton);
        messageBox.setPadding(new Insets(10));
        messageBox.setSpacing(10);

        BorderPane root = new BorderPane(chatBox, null, null, messageBox, null);

        // create and show scene
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chat Interface");
        primaryStage.show();
    }

    private void sendMessage() {
        String message = messageInput.getText().trim();
        if (!message.isEmpty()) {
            chatHistory.appendText("Me: " + message + "\n");
            messageInput.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

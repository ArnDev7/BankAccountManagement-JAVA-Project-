import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;

class ExitPane extends VBox {
    public ExitPane(Stage stage, Bank bank) { // Add Bank parameter
        Button confirmExitButton = new Button("Confirm Exit");

        confirmExitButton.setOnAction(e -> {
            Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
            exitAlert.setTitle("Exit Confirmation");
            exitAlert.setHeaderText("Are you sure you want to exit?");
            exitAlert.setContentText("Press OK to exit, or Cancel to stay.");

            exitAlert.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    stage.close();
                }
            });
        });

        Button backButton = new Button("Back to Main Menu");
        backButton.setOnAction(e -> stage.setScene(new Scene(new MainMenuPane(stage, bank), 600, 400))); // Pass the bank object

        this.getChildren().addAll(confirmExitButton, backButton);
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.setStyle("-fx-background-color: #f0f0f0;");
    }
}

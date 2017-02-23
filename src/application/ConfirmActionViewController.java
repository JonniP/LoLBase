package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * A window for confirming any action
 */
public class ConfirmActionViewController {
	
	 @FXML
	 private Label messageLabel;
	 
	 @FXML
	 private Button closeButton;
	 
	 @FXML
	 private Button confirmButton;
	 
	 @FXML
	 void onCancelButton_Clicked() {
		 Stage stage = (Stage) closeButton.getScene().getWindow();
		 stage.close();
	 }

	 //ToDo: Initializer or something similar to pass text to messageLabel
}

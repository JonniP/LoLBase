package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller class for aboutView window
 */
public class aboutViewController {
	
    @FXML
    private Button closeButton;

    /**
     * When add skin button is clicked opens ConfirmActionView
     */
    @FXML
    void onAddSkinButton_Clicked() {
    	Utility.openAnchorWindow("ConfirmActionView.fxml", "Warning");
    }
    /**
     * When cancel button is clicked closes window
     */
    @FXML
	 void onCancelButton_Clicked() {
		 Stage stage = (Stage) closeButton.getScene().getWindow();
		 stage.close();
	 }

}



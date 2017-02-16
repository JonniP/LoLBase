package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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

}



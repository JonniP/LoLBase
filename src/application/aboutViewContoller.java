package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class aboutViewContoller {
	
    @FXML
    private Button closeButton;

    @FXML
    void onAddSkinButton_Clicked(MouseEvent event) {
    	Utility.openAnchorWindow("ConfirmActionView.fxml", "Warning");

    }

}



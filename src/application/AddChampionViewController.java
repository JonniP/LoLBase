package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AddChampionViewController {

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button AddSkinButton;

    @FXML
    private Button browseImageButton1;

    @FXML
    private Button browseImageButton2;

    @FXML
    private Button browseImageButton3;

    @FXML
    private Button browseImageButton4;

    @FXML
    private Button browseImageButton5;

	    @FXML
	    void onAddSkinButton_Clicked(MouseEvent event) {
	    	Utility.openAnchorWindow("ConfirmActionView.fxml", "Warning");
	    	
	    }

}



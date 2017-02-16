package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Controller class for AddChampionView
 */
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

	/**
	 *	Open a window for adding skins
	 */
	@FXML
	void onAddSkinButton_Clicked() {
		Utility.openAnchorWindow("ConfirmActionView.fxml", "Warning");
	}
}



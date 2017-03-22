package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller class for AddChampionView
 */
public class AddChampionViewController {

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField roleField;

    @FXML
    private TextField positionField;

    @FXML
    private Button AddSkinButton;

    @FXML
    private TextField passiveName;

    @FXML
    private TextField passiveInfo;

    @FXML
    private TextArea loreField;

    @FXML
    private Button browsePassiveImageButton;

    @FXML
    private TextField qName;

    @FXML
    private TextField qInfo;

    @FXML
    private Button browseQImageButton;

    @FXML
    private TextField wName;

    @FXML
    private TextField wInfo;

    @FXML
    private Button browseWImageButton;

    @FXML
    private TextField eName;

    @FXML
    private TextField eInfo;

    @FXML
    private Button browseEImageButton;

    @FXML
    private TextField rName;

    @FXML
    private TextField rInfo;

    @FXML
    private Button browseRImageButton;

	/**
	 *	Open a window for adding skins
	 */
	@FXML
	void onAddSkinButton_Clicked() {
		Utility.openAnchorWindow("ConfirmActionView.fxml", "Warning");
	}
	
	@FXML
	 void onCancelButton_Clicked() {
		 Stage stage = (Stage) cancelButton.getScene().getWindow();
		 stage.close();
	 }
	@FXML
	void onConfirmClicked() {
		//
	}
	@FXML
	void onAddBrowseImageButton_Clicked(){
		//
	}
	
}



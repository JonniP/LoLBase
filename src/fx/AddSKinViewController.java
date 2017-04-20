package fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import lolbase.*;
/**
 * viewcontroller for addskinview
 */
public class AddSKinViewController {

    @FXML private TextField skinNameField;
    @FXML private Button addButton;
    @FXML private Button cancelButton;
    @FXML private TextField imageURLField;

    private AddChampionViewController addVC;
    /**
     * adds the skin when add button is pressed
     * 
     */
    @FXML
    void addButtonPressed() {
    	//Create new skin and add it to skins
    	Skin skin = new Skin();
    	skin.name = skinNameField.getText();
    	skin.imgURL = imageURLField.getText();
    	boolean inputValid = true;
    	//Make sure neither of these are empty before adding!
    	if (skin.name.isEmpty()) {
    		inputValid = false;
    		skinNameField.setPromptText("Name field cannot be empty!");
    	}
    	if (skin.imgURL.isEmpty()) {
    		inputValid = false;
    		imageURLField.setPromptText("URL field cannot be empty!");
    	}
    	if (inputValid) {
    		addVC.retrieveData(skin);
    		Stage stage = (Stage) addButton.getScene().getWindow();
   		 stage.close();
    	}
    }
    /**
     * corrects the viewcontroller that is used
     * @param vc
     */
    public void setRef(AddChampionViewController vc){
    	this.addVC = vc;
    }
    
    /**
     * closes the window
     */
    @FXML
    void cancelButtonPressed() {
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
    }

}
package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddSKinViewController {

    @FXML
    private TextField skinNameField;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;
    
    @FXML
    private TextField imageURLField;

    /**
     * DOES NOT WORK YET
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
    		// removed Skins.SkinsList.add(skin);
    	}
    }
    
    /*@FXML
    void browseFileButtonPressed() {
    	
		Stage stage = (Stage) browseFileButton.getScene().getWindow();
    	
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Browse for image file...");
    	File source = fileChooser.showOpenDialog(stage);
    	if (source != null) {
    		//Save this file, get its' path and do stuff
    		File dest = new File(Utility.class.getResource("Images/" + source.getName()).toString());
    		try {
    			Utility.copyFile(source, dest);
    		} catch (IOException e) {
    		    e.printStackTrace();
    		}
    	}
    }*/
    /**
     * closes the window
     */
    @FXML
    void cancelButtonPressed() {
    	Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
    }

}
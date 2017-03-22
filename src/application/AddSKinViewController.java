package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddSKinViewController {

    @FXML
    private TextField skinNameField;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;
    
    @FXML
    private Button browseFileButton;

    @FXML
    void addButtonPressed() {
    	//Create new skin and add it to skins
    	Skin skin = new Skin();
    	skin.name = skinNameField.getText();
    	//Make sure neither of these are empty before adding!
    	//Skins.SkinsList.add(skin);
    }
    
    @FXML
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
    }

    @FXML
    void cancelButtonPressed() {

    }

}
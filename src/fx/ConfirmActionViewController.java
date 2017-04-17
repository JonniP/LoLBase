package fx;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lolbase.Skin;

/**
 * A window for confirming any action
 */
public class ConfirmActionViewController {
		
	@FXML private Label messageLabel;
	@FXML private Button closeButton;
	@FXML private Button confirmButton;
	 
	private ViewController vc;
	private String selectedChampion;
	private String task;
	 
	@FXML
	void onCancelButton_Clicked() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	 
	@FXML
	void onConfirmButton_Clicked() {
		if(task == "Delete"){
			if(selectedChampion != null){
				vc.removeChampion(selectedChampion);
			} else {
				System.out.println("Champion name was somehow null");
			}
		} 
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

    public void setRef(ViewController vc, String message, String selectedChampion, String task){
    	this.vc = vc;
    	messageLabel.setText(message + " " + selectedChampion);
    	this.selectedChampion = selectedChampion;
    	this.task = task;
    }
    
    public void setMessage(String message){
    	messageLabel.setText(message);
    }
}

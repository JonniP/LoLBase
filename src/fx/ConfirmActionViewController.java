package fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
	 
	/**
	 * closes the window when cancel is clicked
	 */
	@FXML
	void onCancelButton_Clicked() {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}
	 /**
	  * carries out the given task when confirm is clicked
	  */
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

	/**
	 * sets the references for this class
	 * @param vc viewcontroller
	 * @param message message shown in the window
	 * @param selectedChampion champion to modify/delete
	 * @param task action that is taking place
	 */
    public void setRef(ViewController vc, String message, String selectedChampion, String task){
    	this.vc = vc;
    	messageLabel.setText(message + " " + selectedChampion);
    	this.selectedChampion = selectedChampion;
    	this.task = task;
    }
    
    /**
     * sets a message to the label
     * @param message the message
     */
    public void setMessage(String message){
    	messageLabel.setText(message);
    }
}

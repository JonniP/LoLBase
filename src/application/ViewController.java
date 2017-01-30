package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
	@FXML
    private Button AddChampionButton;

    @FXML
    void AddChampionClicked() {
    	AddChampionButton.setText("Ayy lmao");
    }
}

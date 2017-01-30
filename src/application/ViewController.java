package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class ViewController {

	public static ObservableList<String> ChampionText = FXCollections.observableArrayList();
	public static ObservableList<Object> Data = FXCollections.observableArrayList();
	
    @FXML
    private ListView<String> ChampionsList;

    @FXML
    private Button AddChampionButton;
	
	@FXML
    public void initialize() {
    	ChampionText.addAll("Test1", "Test2", "Test3");
    	Champion champ = new Champion();
    	champ.pos = Position.Adc;
    }

    @FXML
    void AddChampionClicked(MouseEvent event) {
    	
    }

    @FXML
    void ChampionSelected(MouseEvent event) {

    }
}

package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ViewController {

	public static ObservableList<String> ChampionText = FXCollections.observableArrayList();
	public static ObservableList<Object> Data = FXCollections.observableArrayList();
	public ArrayList<Champion> Champs;
	
	@FXML
    private MenuItem AddChampionButton;
	
	@FXML
    private ListView<String> ChampionsList;
	
	@FXML
    private Label ChampionNameLabel;

    @FXML
    private Label ChampionTitleLabel;

    @FXML
    private Label ChampionSkinNameLabel;
    
    @FXML
    private Label AbilityNameLabel;
    
    @FXML
    private TextField ChampionSearchField;
	
    @FXML
    private TextFlow TempTextFlow;
    
    @FXML
    private ImageView SkinRightArrow;

    @FXML
    private ImageView SkinLeftArrow;
    
    @FXML
    private ImageView AbilityRightArrow;

    @FXML
    private ImageView AbilityLeftArrow;
 
    public void addChampExample() {
    	//Example to show how to work with the champ obj
    	Champion champ = new Champion();
    	champ.pos = Position.Adc;
    	champ.name = "Brand";
    	champ.city = "Kuokkala";
    	Ability abil = new Ability();
    	abil.cooldown = 22;
    	abil.title = "+5 OP/s";
    	abil.description = "Increases credits per second for 22 seconds";
    	champ.Abilities.add(abil);
    	Champs.add(champ);
    }
    
	@FXML
    public void initialize() {
		ChampionsList.getItems().addAll("Ashe","Brand","Warwick");
    	
    	//addChampExample();	//Causes null pointer exception
    	
    	//TEMPORARY lore box (for UI)
    	Text t1 = new Text("Champion lore: "
    			+ "Jhin is a meticulous criminal psychopath who believes murder is art. Once an Ionian prisoner, "
    			+ "but freed by shadowy elements within Ionia's ruling council, the serial killer now works as their cabal's assassin. "
    			+ "Using his Whisper gun as his paintbrush, Jhin creates works of artistic brutality, horrifying victims and onlookers. "
    			+ "He gains a cruel pleasure from putting on his gruesome theater, making him the ideal choice to send the most powerful of "
    			+ "messages: terror.");
    	//Adds t1 to TempTextFlow
    	TempTextFlow.getChildren().add(t1);
    }

	@FXML
    void AddChampionClicked(MouseEvent event) {
		//Menu item AddChampion clicked
    }

    @FXML
    void ChampionSelected(MouseEvent event) {

    }
    
    @FXML
    void OnArrowClick(MouseEvent event) {
    	ChampionSearchField.setText("Skin change");
    	//ToDo: Change champion skin/ability icons using arrows
    }
    
    @FXML
    void ArrowOnMouseEnter(MouseEvent event) {
    	ChampionSearchField.setText("Mouse entered arrow area");
    	//ToDo: Change arrow image to show that it is clickable
    }

    @FXML
    void ArrowOnMouseExit(MouseEvent event) {
    	ChampionSearchField.setText("Mouse left arrow area");
    	//ToDo: Change arrow image back to normal
    }
    
    @FXML	//No event added
    void ChampionsListClicked(MouseEvent event) {
    	/*ObservableList<String> selected;
		selected = ChampionsList.getSelectionModel().getSelectedItems();
		ChampionSearchField.setText(selected.get(1));*/
    	
    }

    
}

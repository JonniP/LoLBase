package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ViewController {

	public static ObservableList<String> ChampionText = FXCollections.observableArrayList();
	public static ObservableList<Object> Data = FXCollections.observableArrayList();
	public ArrayList<Champion> Champs;
	
    @FXML
    private ListView<String> ChampionsList;

    @FXML
    private Button AddChampionButton;
	
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
    	ChampionText.addAll("Test1", "Test2", "Test3");
    	
    	addChampExample();
    	
    	//Lore box
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

    }

    @FXML
    void ChampionSelected(MouseEvent event) {

    }
    
    @FXML
    void OnArrowClick(MouseEvent event) {
    	String s = AddChampionButton.getText();
    	s += "1";
    	AddChampionButton.setText(s); //Temporary test
    	
    	//ToDo: Change champion skin/ability icons using arrows
    }

    
}

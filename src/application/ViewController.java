package application;

import java.util.ArrayList;

import com.sun.javafx.tk.Toolkit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ViewController {

	//public static ObservableList<String> ChampionText = FXCollections.observableArrayList();
	//public static ObservableList<Object> Data = FXCollections.observableArrayList();
	
	public ArrayList<Champion> Champs = new ArrayList<Champion>();
	
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
    
    private Image arrowClickedImage;
    private Image arrowDefaultImage;
 
    public void addChampExample() {
    	//Example to show how to work with the champ obj
    	Champion champ = new Champion();
    	champ.name = "Jhin";
    	champ.pos = Position.Adc;
    	champ.lore = "Champion lore: "
    			+ "Jhin is a meticulous criminal psychopath who believes murder is art. Once an Ionian prisoner, "
    			+ "but freed by shadowy elements within Ionia's ruling council, the serial killer now works as their cabal's assassin. "
    			+ "Using his Whisper gun as his paintbrush, Jhin creates works of artistic brutality, horrifying victims and onlookers. "
    			+ "He gains a cruel pleasure from putting on his gruesome theater, making him the ideal choice to send the most powerful of "
    			+ "messages: terror.";
    	
    	Text t1 = new Text(champ.lore);
    	TempTextFlow.getChildren().add(t1);
    	
    	Ability abil = new Ability();
    	abil.title = "+5 OP/s";
    	abil.description = "Increases credits per second for 22 seconds";
    	champ.Abilities.add(abil);
    	
    	Champs.add(champ);
    	ChampionsList.getItems().addAll(champ.name);
    }
    
	@FXML
    public void initialize() {
		arrowClickedImage = new Image(getClass().getResource("Images/temp1.jpg").toString());
		arrowDefaultImage = new Image(getClass().getResource("Images/temp2.png").toString());
		 
    	
    	addChampExample();
    }

	
	@FXML
    void AddChampionClicked(ActionEvent event) {
		openAnchorWindow("AddChampionView.fxml");
    }

	@FXML
	void OnDeleteChampionClicked(ActionEvent event) {
		openAnchorWindow("ConfirmActionView.fxml");
	}
	
	@FXML
	void OnMenuAboutClicked(ActionEvent event) {
		ChampionSearchField.setText("Rekt");
		openAnchorWindow("AboutView.fxml");
	}
	
	//Open any window with AnchorPane as root 'item'
	private void openAnchorWindow(String path){
		try {
			AnchorPane root = FXMLLoader.load(ViewController.class.getResource(path));
			Scene addWindow = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(addWindow); 
			stage.show();		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    void ChampionSelected(MouseEvent event) {

    }
    
    @FXML
    void OnArrowClick(MouseEvent event) {
    	ImageView imgView = (ImageView)event.getSource();
    	String name = Utility.retrieveID(imgView.toString());
    	ChampionSearchField.setText(name);
    	
    	Utility.setImage(imgView, arrowDefaultImage);
    	
    	switch(name){
    		//Note: Utility.setImage will work just fine
    		case "SkinLeftArrow":
    			//ToDo: Change skin to left
    			break;
    			
    		case "SkinRightArrow":
    			//ToDo: Change skin to right
    			break;
    		
    		case "AbilityLeftArrow":
    			//ToDo: Change ability to left
    			break;
    			
    		case "AbilityRightArrow":
    			//ToDo: Change ability to right
    			break;
    	}
    	
    	//ToDO: Change skin image
    }
    
    @FXML
    void ArrowOnMouseEnter(MouseEvent event) {
    	ImageView imgView = (ImageView)event.getSource();    	
    	Utility.setImage(imgView, arrowClickedImage);
    }

    @FXML
    void ArrowOnMouseExit(MouseEvent event) {
    	ImageView imgView = (ImageView)event.getSource();   	
    	Utility.setImage(imgView, arrowDefaultImage);
    }
    
    @FXML	//ToDo: Add event for this (which?)
    void OnChampionsListClicked(MouseEvent event) {
    	/*ObservableList<String> selected;
		selected = ChampionsList.getSelectionModel().getSelectedItems();
		ChampionSearchField.setText(selected.get(0));*/
    	
    }

    
}

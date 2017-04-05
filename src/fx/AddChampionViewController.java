package fx;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Controller class for AddChampionView
 */
public class AddChampionViewController {

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField titleField;

    @FXML
    private ChoiceBox<Champion.Role> roleField;

    @FXML
    private ChoiceBox<Champion.Position> positionField;

    @FXML
    private Button AddSkinButton;

    @FXML
    private TextField passiveName;

    @FXML
    private TextField passiveInfo;

    @FXML
    private TextArea loreField;

    @FXML
    private Button browsePassiveImageButton;

    @FXML
    private TextField qName;

    @FXML
    private TextField qInfo;

    @FXML
    private Button browseQImageButton;

    @FXML
    private TextField wName;

    @FXML
    private TextField wInfo;

    @FXML
    private Button browseWImageButton;

    @FXML
    private TextField eName;

    @FXML
    private TextField eInfo;

    @FXML
    private Button browseEImageButton;

    @FXML
    private TextField rName;

    @FXML
    private TextField rInfo;

    @FXML
    private Button browseRImageButton;

    /**
     * sets the choisebox's options when the window is opened
     */
    @FXML
    public void initialize() {
    	//Set choicebox options
    	Champion.Position[] pvalues = Champion.Position.values();
    	ArrayList<Champion.Position> posses = new ArrayList<Champion.Position>();
    	
    	for(Champion.Position p : pvalues) 
    		posses.add(p);
    	
    	//Pass roles as parameter to observablelist
    	positionField.getItems().setAll(FXCollections.observableList(posses));
    	
    	Champion.Role[] rvalues = Champion.Role.values();
    	ArrayList<Champion.Role> roles = new ArrayList<Champion.Role>();
    	
    	for(Champion.Role p : rvalues) 
    		roles.add(p);
    	
    	//Pass roles as parameter to observablelist
    	roleField.getItems().setAll(FXCollections.observableList(roles));
    	
    }
    
	/**
	 *	Open a window for adding skins
	 */
	@FXML
	void onAddSkinButton_Clicked() {
		Utility.openAnchorWindow("AddSKinView.fxml", "Add Skin");
	}
	/**
	 * closes window when cancel is clicked
	 */
	@FXML
	 void onCancelButton_Clicked() {
		 Stage stage = (Stage) cancelButton.getScene().getWindow();
		 stage.close();
	 }
	/**
	 * when confirm is clicked creates the champion and its skins and abilities, and adds all champion info to their respective dat files
	 */
	@FXML
	void onConfirmClicked() {
		//Create new champion
		Champion champ = new Champion();
		champ.name = nameField.getText();
		champ.title = titleField.getText();
		champ.pos = positionField.getValue();
		champ.lore = loreField.getText();
		champ.role = roleField.getValue();
		
		//And add it to the list
		//Champions.addChampion(champ);
		
		
		
		//Update main list		
		
		//Create new abilities
		Ability newP = new Ability();
		newP.name = passiveName.getText();
		newP.description = passiveInfo.getText();
		newP.school = "Passive";
		//newP.ChampionID = Champions.Champs.size()+1;
		newP.imageURL = "Walla Balla BING BANG";
		
		Ability newQ = new Ability();
		newQ.name = qName.getText();
		newQ.description = qInfo.getText();
		newQ.school = "Q";
		//newQ.ChampionID = Champions.Champs.size()+1;
		newQ.imageURL = "Walla Balla BING BANG";

		Ability newW = new Ability();
		newW.name = wName.getText();
		newW.description = wInfo.getText();
		newW.school = "W";
		//newW.ChampionID = Champions.Champs.size()+1;
		newW.imageURL = "Walla Balla BING BANG";

		Ability newE = new Ability();
		newE.name = eName.getText();
		newE.description = eInfo.getText();
		newE.school = "E";
		//newE.ChampionID = Champions.Champs.size()+1;
		newE.imageURL = "Walla Balla BING BANG";

		Ability newR = new Ability();
		newR.name = rName.getText();
		newR.description = rInfo.getText();
		newR.school = "Ultimate";
		//newR.ChampionID = Champions.Champs.size()+1;
		newR.imageURL = "Walla Balla BING BANG";
		
		
		/*
		Abilities.addAbility(newP);
		Abilities.addAbility(newQ);
		Abilities.addAbility(newW);
		Abilities.addAbility(newE);
		Abilities.addAbility(newR);
		*/
		//TODO: Add skin here

	}
	@FXML
	void onAddBrowseImageButton_Clicked(){
		//
	}
	
}



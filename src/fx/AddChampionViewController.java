package fx;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import lolbase.*;

/**
 * Controller class for AddChampionView
 */
public class AddChampionViewController {

    @FXML private Button confirmButton;
    @FXML private Button cancelButton;
    @FXML private TextField nameField;
    @FXML private TextField titleField;
    @FXML private ChoiceBox<Champion.Role> roleField;
    @FXML private ChoiceBox<Champion.Position> positionField;
    @FXML private Button AddSkinButton;
    @FXML private TextField passiveName;
    @FXML private TextField passiveInfo;
    @FXML private TextArea loreField;
    @FXML private Button browsePassiveImageButton;
    @FXML private TextField qName;
    @FXML private TextField qInfo;
    @FXML private Button browseQImageButton;
    @FXML private TextField wName;
    @FXML private TextField wInfo;
    @FXML private Button browseWImageButton;
    @FXML private TextField eName;
    @FXML private TextField eInfo;
    @FXML private Button browseEImageButton;
    @FXML private TextField rName;
    @FXML private TextField rInfo;
    @FXML private Button browseRImageButton;
    
    private Champion modifiedChampion;
    private String oldChampName;
    private boolean isModifying;
    
    private ViewController vc;
    private ArrayList<Skin> skinList = new ArrayList<Skin>();
    /**
     * sets the choisebox's options when the window is opened
     */
    
    public void setRef(ViewController vc){
    	this.vc = vc;
    }
    
    /**
     * Set champion if modifying one
     * @param champ Champion to be modified
     */
    public void setChamp(Champion champ) {
    	this.modifiedChampion = champ;
    	this.isModifying = true;
    	fillChampData(this.modifiedChampion);
    }
    
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
		//Utility.openAnchorWindow("AddSKinView.fxml", "Add Skin");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddSKinView.fxml"));
			
			final AnchorPane root = (AnchorPane)loader.load();
			Scene addWindow = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(addWindow);
			
			AddSKinViewController controller = loader.<AddSKinViewController>getController();
			if(controller != null){
				controller.setRef(this);
			}
			else System.out.println("null - error!");
			
			stage.show();
			stage.setTitle("Add Skin");
			stage.getIcons().add(new Image(Utility.class.getResource("/Images/Temu.png").toString()));
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	/**
	 * closes window when cancel is clicked
	 */
	@FXML
	 void onCancelButton_Clicked() {
		 Stage stage = (Stage) cancelButton.getScene().getWindow();
		 stage.close();
	 }
	
	void fillChampData(Champion champ) {
		oldChampName = champ.name;
		nameField.setText(champ.name);
		titleField.setText(champ.title);
		positionField.setValue(champ.pos);
		loreField.setText(champ.lore);
		roleField.setValue(champ.role);
		
		//Disable unnecessary fields
		passiveName.setDisable(true);
		passiveInfo.setDisable(true);
		
		qName.setDisable(true);
		qInfo.setDisable(true);
		
		wName.setDisable(true);
		wInfo.setDisable(true);
		
		eName.setDisable(true);
		eInfo.setDisable(true);
		
		rName.setDisable(true);
		rInfo.setDisable(true);
		
		browsePassiveImageButton.setDisable(true);
		browseQImageButton.setDisable(true);
		browseWImageButton.setDisable(true);
		browseEImageButton.setDisable(true);
		browseRImageButton.setDisable(true);
		AddSkinButton.setDisable(true);
	}
	
	/**
	 * when confirm is clicked creates the champion and its skins and abilities, and adds all champion info to their respective dat files
	 */
	@FXML
	void onConfirmClicked() {
		
		if (this.isModifying) {
			Champion champ = new Champion();
			champ.name = nameField.getText();
			champ.title = titleField.getText();
			champ.pos = positionField.getValue();
			champ.lore = loreField.getText();
			champ.role = roleField.getValue();
			
			vc.collectiveWrite(champ,null,null, oldChampName);
			Stage stage = (Stage) confirmButton.getScene().getWindow();
			stage.close();
		} else {
			
			ArrayList<Ability> newAbis = new ArrayList<Ability>();
			
			//Create new champion
			Champion champ = new Champion();
			champ.name = nameField.getText();
			champ.title = titleField.getText();
			champ.pos = positionField.getValue();
			champ.lore = loreField.getText();
			champ.role = roleField.getValue();
			
			//Create new abilities
			Ability newP = new Ability();
			newP.name = passiveName.getText();
			newP.description = passiveInfo.getText();
			newP.school = "Passive";
			//newP.ChampionID = Champions.Champs.size()+1;
			newP.imageURL = "Walla Balla BING BANG";
			if (checkAbility(newP))
				newAbis.add(newP);
			
			Ability newQ = new Ability();
			newQ.name = qName.getText();
			newQ.description = qInfo.getText();
			newQ.school = "Q";
			//newQ.ChampionID = Champions.Champs.size()+1;
			newQ.imageURL = "Walla Balla BING BANG";
			if (checkAbility(newQ))
				newAbis.add(newQ);

			Ability newW = new Ability();
			newW.name = wName.getText();
			newW.description = wInfo.getText();
			newW.school = "W";
			//newW.ChampionID = Champions.Champs.size()+1;
			newW.imageURL = "Walla Balla BING BANG";
			if (checkAbility(newW))
				newAbis.add(newW);

			Ability newE = new Ability();
			newE.name = eName.getText();
			newE.description = eInfo.getText();
			newE.school = "E";
			//newE.ChampionID = Champions.Champs.size()+1;
			newE.imageURL = "Walla Balla BING BANG";
			if (checkAbility(newE))
				newAbis.add(newE);

			Ability newR = new Ability();
			newR.name = rName.getText();
			newR.description = rInfo.getText();
			newR.school = "Ultimate";
			//newR.ChampionID = Champions.Champs.size()+1;
			newR.imageURL = "Walla Balla BING BANG";
			if (checkAbility(newR))
				newAbis.add(newR);
			
			if (newAbis.isEmpty()) newAbis = null; //Set this to null if it's empty, collectiveWrite checks it.
			vc.collectiveWrite(champ,newAbis,skinList, null);

			Stage stage = (Stage) confirmButton.getScene().getWindow();
			stage.close();
		}
	}
	
	private boolean checkAbility(Ability abil) {
		if (!abil.name.isEmpty() && !abil.imageURL.isEmpty() && !abil.description.isEmpty() && !abil.school.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	@FXML
	void onAddBrowseImageButton_Clicked(){
		//
	}
	/**
	 * adds the new skin to the skinlist
	 * @param skin added skin
	 */
	public void retrieveData(Skin skin){
		skinList.add(skin);
	}
	
}



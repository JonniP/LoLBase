package fx;

import java.util.ArrayList;

import javafx.collections.ObservableList;
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
import lolbase.Ability;
import lolbase.Champion;
import lolbase.LoLBase;
import lolbase.Skin;
import lolbase.Utility;

/**
 * Controller class for main view.
 */
public class ViewController {
	
	@FXML private ListView<String> ChampionsList;
    @FXML private ImageView AbilityImageView;
    @FXML private ImageView SkinImageView;
	@FXML private Label ChampionNameLabel;
    @FXML private Label ChampionTitleLabel;
    @FXML private Label RoleLabel;
    @FXML private Label PositionLabel;
    @FXML private Label ChampionSkinNameLabel;
    @FXML private Label AbilityNameLabel;
    @FXML private TextField ChampionSearchField;
    @FXML private TextFlow LoreTextFlow;
    @FXML private Label AbilityDescription;
    @FXML private ImageView SkinRightArrow;
    @FXML private ImageView SkinLeftArrow;
    @FXML private ImageView AbilityRightArrow;
    @FXML private ImageView AbilityLeftArrow;
    @FXML private Label abilitySchoolLabel;
    
    private Image arrowClickedImage;
    private Image arrowDefaultImage;
    
    private Champion selectedChampion;
    
    private LoLBase lolbase;
    
    private ArrayList<Ability> selectedChampionAbilities = new ArrayList<Ability>();
    private ArrayList<Skin> selectedChampionSkins = new ArrayList<Skin>();
    
    private int abilityClicks = 0, skinClicks = 0;
    
	/**
	 * Initializes objects and loads data from files.
	 */
	@FXML
    public void initialize() {
		arrowClickedImage = new Image(getClass().getResource("/Images/Arrow_Clicked.png").toString());
		arrowDefaultImage = new Image(getClass().getResource("/Images/Arrow_Default.png").toString());
		
		ChampionSearchField.textProperty().addListener((obj, oldVal, newVal) -> {
			updateListViewChampions(lolbase.search(newVal.toLowerCase()));
		});
		
		SkinLeftArrow.setScaleX(-1);
		AbilityLeftArrow.setScaleX(-1);
    }
	
	/**
	 * gives this class a reference to our lolbase
	 * @param lol our lolbase
	 */
	public void setLoLBase(LoLBase lol){
		this.lolbase = lol;
	}
	
	/**
	 * @return the ID of the last champion in the champion list
	 */
	public int getChampionID() {
		return this.lolbase.getChampionID();
	}
	
	/**
	 * updates the champions in the UI list with given champions
	 * @param champs given champions
	 */
	public void updateListViewChampions(ArrayList<Champion> champs){
		ChampionsList.getItems().clear();
		for(Champion c : champs){
			ChampionsList.getItems().addAll(c.name);
		}
	}
	
	/**
	 * On add champion button clicked, opens AddChampionView window.
	 */
	@FXML
    void AddChampionClicked() {		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddChampionView.fxml"));
			
			final AnchorPane root = (AnchorPane)loader.load();
			Scene addWindow = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(addWindow);
			
			AddChampionViewController controller = loader.<AddChampionViewController>getController();
			if(controller != null){
				controller.setRef(this);
			}
			else System.out.println("null - error!");
			
			stage.show();
			stage.setTitle("Add Champion");
			stage.setResizable(false);
			stage.getIcons().add(new Image(Utility.class.getResource("/Images/Temu.png").toString()));
		} catch(Exception e) {
			e.printStackTrace();
		}	
    }
	
	/**
	 * Open AddChampionView with data filled in.
	 */
	@FXML
    void ModifyChampionClicked() {
		if (selectedChampion != null) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("AddChampionView.fxml"));
				
				final AnchorPane root = (AnchorPane)loader.load();
				Scene addWindow = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(addWindow);
				
				AddChampionViewController controller = loader.<AddChampionViewController>getController();
				if(controller != null){
					controller.setRef(this);
					controller.setChamp(this.selectedChampion);
				} else {
					System.out.println("null - error!");
				}
				
				stage.show();
				stage.setTitle("Modify Champion");
				stage.setResizable(false);
				stage.getIcons().add(new Image(Utility.class.getResource("/Images/Temu.png").toString()));
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfirmActionView.fxml"));
				
				final AnchorPane root = (AnchorPane)loader.load();
				Scene addWindow = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(addWindow);
					
				ConfirmActionViewController controller = loader.<ConfirmActionViewController>getController();
				if(controller != null){
					controller.setMessage("Warning: No champion selected!");
				} else {
					System.out.println("ConfirmActionViewController is null");
				}
				
				stage.show();
				stage.setTitle("Confirm");
				stage.setResizable(false);
				stage.getIcons().add(new Image(Utility.class.getResource("/Images/Temu.png").toString()));
			} catch(Exception e) {
				e.printStackTrace();
			}	
		}
    }
	
	/**
	 * rounds up the data for file writing
	 * @param champ champion to write
	 * @param abilys champion's abilities
	 * @param skins champion's skins
	 * @param modified boolean whether or not champ is being made or modified
	 */
	public void collectiveWrite(Champion champ, ArrayList<Ability> abilys, ArrayList<Skin> skins, boolean modified){
		if (champ != null) {
			if (modified == true) {
				lolbase.modifyChampion(champ);
			} else {
				lolbase.addChampion(champ);
			}
		}
		if (abilys != null) {
			for(Ability a : abilys){
				lolbase.addAbility(a);
			}
		}
		if (skins != null) {
			for(Skin b : skins){
				lolbase.addSkin(b);
			}
		}
		
		lolbase.writeAll();
		updateListViewChampions(lolbase.getChampionList());
	}

	/**
	 * On delete champion clicked, opens ConfirmActionView window.
	 */
	@FXML
	void OnDeleteChampionClicked() {
		if(selectedChampion != null){
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfirmActionView.fxml"));
				
				final AnchorPane root = (AnchorPane)loader.load();
				Scene addWindow = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(addWindow);
					
				ConfirmActionViewController controller = loader.<ConfirmActionViewController>getController();
				if(controller != null){
					controller.setRef(this, "Are you sure you want to delete", selectedChampion, "Delete");
				} else {
					System.out.println("ConvirmActionViewController is null");
				}
				
				stage.show();
				stage.setTitle("Confirm");
				stage.setResizable(false);
				stage.getIcons().add(new Image(Utility.class.getResource("/Images/Temu.png").toString()));
			} catch(Exception e) {
				e.printStackTrace();
			}	
		} else {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ConfirmActionView.fxml"));
				
				final AnchorPane root = (AnchorPane)loader.load();
				Scene addWindow = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(addWindow);
					
				ConfirmActionViewController controller = loader.<ConfirmActionViewController>getController();
				if(controller != null){
					controller.setMessage("Warning: No champion selected!");
				} else {
					System.out.println("ConvirmActionViewController is null");
				}
				
				stage.show();
				stage.setTitle("Confirm");
				stage.setResizable(false);
				stage.getIcons().add(new Image(Utility.class.getResource("/Images/Temu.png").toString()));
			} catch(Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	/**
	 * removes a champion from the list
	 * @param name - the name of the champion that is to be deleted
	 */
	void removeChampion(int id) {
		lolbase.removeChampion(id);
		lolbase.writeAll();
		updateListViewChampions(lolbase.getChampionList());
	}
	
	/**
	 * On menu button About clicked. Opens AboutView window.
	 */
	@FXML
	void OnMenuAboutClicked() {
		Utility.openAnchorWindow("AboutView.fxml", "About");
	}
    
    /**
     * On arrow click, determines which arrow was clicked and
     * does something.
     * @param event - Contains information about the mouse event.
     */
    @FXML
    void OnArrowClick(MouseEvent event) {
    	if(selectedChampionSkins.size() == 0 || selectedChampionAbilities.size() == 0) return;
    	ImageView imgView = (ImageView)event.getSource();
    	String name = Utility.retrieveID(imgView.toString());
    	
    	switch(name){
    		case "SkinLeftArrow":
    			if(skinClicks == 0) { 
    				skinClicks = selectedChampionSkins.size() - 1;
    			} else {
    				skinClicks--;
    			}
    			updateSkin();
    			break;
    			
    		case "SkinRightArrow":
    			if(skinClicks == selectedChampionSkins.size() - 1) {
    				skinClicks = 0;
    			} else {
    				skinClicks++;
    			}
    			updateSkin();
    			break;
    		
    		case "AbilityLeftArrow":
    			if(abilityClicks == 0) {
    				abilityClicks = selectedChampionAbilities.size() - 1;
    			} else { 
    				abilityClicks--;
    			}
    			updateAbility();
    			break;
    			
    		case "AbilityRightArrow":
    			if(abilityClicks == selectedChampionAbilities.size() - 1) {
    				abilityClicks = 0;
    			} else {
    				abilityClicks++;
    			}
    			updateAbility();
    			break;
        default:
            break;
    	}
    }
    
    /**
     * On mouse enter arrow area changes image.
     * @param event - Information about mouse event.
     */
    @FXML
    void ArrowOnMouseEnter(MouseEvent event) {
    	ImageView imgView = (ImageView)event.getSource();    	
    	Utility.setImage(imgView, arrowClickedImage);
    }

    /**
     * On mouse exit arrow area changes image.
     * @param event - Information about mouse event.
     */
    @FXML
    void ArrowOnMouseExit(MouseEvent event) {
    	ImageView imgView = (ImageView)event.getSource();   	
    	Utility.setImage(imgView, arrowDefaultImage);
    }
    
    /**
     * On champion list clicked, shows the clicked value in search field.
     */
    @FXML
    void OnChampionsListClicked() {
    	
    	ObservableList<String> selected;
		selected = ChampionsList.getSelectionModel().getSelectedItems();
		String champName = selected.get(0);
		if (selected.get(0) != null) {
		
		Champion champ = null;
		for(int i = 0; i<lolbase.getChampionsAmount(); i++){
			if(lolbase.getChampion(i).name == champName){
				champ = lolbase.getChampion(i);
			}
		}
		selectedChampion = champ;
		ChangeChampion(champ);
		}
    }
    
    /**
     * changes the information in the window to the new champion's
     * @param champ the champion
     */
    void ChangeChampion(Champion champ){
    	selectedChampionAbilities = lolbase.getChampionAbilities(champ.id);    	
    	selectedChampionSkins = lolbase.getChampionSkins(champ.id);

		ChampionNameLabel.setText(champ.name);
		ChampionTitleLabel.setText(champ.title);
		PositionLabel.setText(champ.pos.toString());
		RoleLabel.setText(champ.role.toString());
		LoreTextFlow.getChildren().clear();
		LoreTextFlow.getChildren().add(new Text(champ.lore));
		
		if(selectedChampionSkins.size() == 0){
	    		try{
				Utility.setImage(SkinImageView, "/Images/notfound.png");
				ChampionSkinNameLabel.setText("No skins have been added to this champion");
	    		} catch(Exception e){
	    		    //
	    		}
		}else if(selectedChampionSkins.get(skinClicks) != null) {
			updateSkin();
		}
		
		if(selectedChampionAbilities.size() == 0){
			try{
				Utility.setImage(AbilityImageView, "/Images/notfound.png");
				abilitySchoolLabel.setText("");
				AbilityNameLabel.setText("No abilities have been added to this champion");
				AbilityDescription.setText("");
	    		} catch(Exception e){
	    			//
	    		}
			} else if(selectedChampionAbilities.get(skinClicks) != null) {
			updateAbility();
		} 
    }
    
    /**
     * updates information of a skin targeted for editing
     */
    private void updateSkin() {
    	Skin currentSkin = selectedChampionSkins.get(skinClicks);
		ChampionSkinNameLabel.setText(currentSkin.name);
		
		try {
			Utility.setImage(SkinImageView, currentSkin.imgURL);
		} catch(Exception e) {
			System.out.println("ViewController: Invalid skin URL!");
		} 
    }
    
    /**
     * updates information of an ability targeted for editing
     */
    private void updateAbility() {
    	Ability currentAbility = selectedChampionAbilities.get(abilityClicks);
    	abilitySchoolLabel.setText(currentAbility.school);
		AbilityNameLabel.setText(currentAbility.name);
		AbilityDescription.setText(currentAbility.description);
		try {
			Utility.setImage(AbilityImageView, currentAbility.imageURL);
		} catch(Exception e) {
			System.out.println("ViewController: Invalid ability URL!");
		}
    }
}

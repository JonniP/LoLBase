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
import lolbase.Champions;
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
    @FXML private TextFlow AbilityDescription;
    @FXML private ImageView SkinRightArrow;
    @FXML private ImageView SkinLeftArrow;
    @FXML private ImageView AbilityRightArrow;
    @FXML private ImageView AbilityLeftArrow;
    
    private Image arrowClickedImage;
    private Image arrowDefaultImage;
    
    private Champion selectedChampion;
    
    private LoLBase lolbase;
    
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
	
	public void setLoLBase(LoLBase lol){
		this.lolbase = lol;
	}
	
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
			stage.getIcons().add(new Image(Utility.class.getResource("/Images/Temu.png").toString()));
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * rounds up the data for file writing
	 */
	public void collectiveWrite(Champion champ, Ability[] abilys, ArrayList<Skin> skins){
		if (champ != null) {
			lolbase.addChampion(champ);
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
					controller.setRef(this, "Are you sure you want to delete", selectedChampion.name, "Delete");
				} else {
					System.out.println("ConvirmActionViewController is null");
				}
				
				stage.show();
				stage.setTitle("Confirm");
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
				stage.getIcons().add(new Image(Utility.class.getResource("/Images/Temu.png").toString()));
			} catch(Exception e) {
				e.printStackTrace();
			}	
		}
	}
	
	void removeChampion(String name) {
		lolbase.removeChampion(name);
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
    	ImageView imgView = (ImageView)event.getSource();
    	String name = Utility.retrieveID(imgView.toString());
    	ChampionSearchField.setText(name);
    	
    	//Temporary
    	//DataReader.searchKey("src/application/Data/Abilities.dat", "Nautilus");
    	
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
    	//ChampionSearchField.setText(champ.name);
		ChampionNameLabel.setText(champ.name);
		ChampionTitleLabel.setText(champ.title);
		PositionLabel.setText(champ.pos.toString());
		RoleLabel.setText(champ.role.toString());
		LoreTextFlow.getChildren().clear();
		LoreTextFlow.getChildren().add(new Text(champ.lore));
		LoreTextFlow.getChildren().add(new Text(champ.lore)); // it's a feature!!
		
		if(lolbase.getSkin(0) != null) {
			Skin currentSkin = lolbase.getSkin(0);
			ChampionSkinNameLabel.setText(currentSkin.name);
			//Utility.setImage(SkinImageView, currentSkin.imgURL);
		}
		
		if(lolbase.getAbility(0) != null) {
			Ability currentAbility = lolbase.getAbility(0);
			AbilityNameLabel.setText(currentAbility.name);
			AbilityDescription.getChildren().clear();
			AbilityDescription.getChildren().add(new Text(currentAbility.description));
			AbilityDescription.getChildren().add(new Text(currentAbility.description));
			//Utility.setImage(AbilityImageView, currentAbility.imageURL); // no paths yet
		}
    }
}

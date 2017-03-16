package application;


import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Controller class for main view.
 */
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
    private Label RoleLabel;

    @FXML
    private Label PositionLabel;

    @FXML
    private Label ChampionSkinNameLabel;
    
    @FXML
    private Label AbilityNameLabel;
    
    @FXML
    private TextField ChampionSearchField;
	
    @FXML
    private TextFlow LoreTextFlow;
    
    @FXML
    private TextFlow AbilityDescription;
    
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
    
	/**
	 * Initializes objects and loads data from files.
	 */
	@FXML
    public void initialize() {
		arrowClickedImage = new Image(getClass().getResource("Images/Arrow_Clicked.png").toString());
		arrowDefaultImage = new Image(getClass().getResource("Images/Arrow_Default.png").toString());
		
		SkinLeftArrow.setScaleX(-1);
		AbilityLeftArrow.setScaleX(-1);
		
		//Temporary lore text
		Text tempLore = new Text("This area is reserved for lore");
		LoreTextFlow.getChildren().add(tempLore);
		
		//fill champion list with names
		for(Champion c : Champs){
			ChampionsList.getItems().addAll(c.name);
		}
    }
	
	/**
	 * On add champion button clicked, opens AddChampionView window.
	 */
	@FXML
    void AddChampionClicked() {
		Utility.openAnchorWindow("AddChampionView.fxml", "Add Champion");
    }

	/**
	 * On delete champion clicked, opens ConfirmActionView window.
	 */
	@FXML
	void OnDeleteChampionClicked() {
		Utility.openAnchorWindow("ConfirmActionView.fxml", "Confirm Action");
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
		ChampionSearchField.setText(selected.get(0));
		
		//ToDo: Change data according to the clicked champion.
    }    
}

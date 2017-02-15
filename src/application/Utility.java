package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Utility {

	//Expects form "...[id=SkinLeftArrow, ...]",
	//returns string between id= and ,
	public static String retrieveID(String name){
		int start = -1, end = -1;
	
		for(int i = 0; i<name.length(); i++){
			//start
			if(name.charAt(i) == '='){
				if(name.charAt(i-1) == 'd' && name.charAt(i-2) == 'i'){
					start = i+1;
				}
			}
			//end
			if(name.charAt(i) == ',') end = i; 
		}
		if(start == -1) return "Invalid input";
		return name.substring(start, end);
	}
	
	//Sets image to ImageView
	public static void setImage(ImageView imgView, Image image){
		imgView.setImage(image);
    	//imgView.setFitWidth(100);	//resize
    	imgView.setPreserveRatio(true);
    	imgView.setSmooth(true);
    	imgView.setCache(true); //improves performance apparently
	}
	
	
	//Open any window with AnchorPane as root 'item'
	public static void openAnchorWindow(String path, String title){
		try {
			AnchorPane root = FXMLLoader.load(ViewController.class.getResource(path));
			Scene addWindow = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(addWindow); 
			stage.show();
			stage.setTitle(title);
			stage.getIcons().add(new Image(Utility.class.getResource("Images/Temu.png").toString()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Class that contains helpful methods
 */
public class Utility {

	/**
	 * Returns ID from a string. Expected form: ...id=ID,...
	 * @param name - String that contains the ID
	 * @return Returns the ID
	 */
	public static String retrieveID(String name){
		int start = -1, end = -1;

		for(int i = 0; i < name.length(); i++){
			//start index
			if(name.charAt(i) == '='){
				if(name.charAt(i-1) == 'd' && name.charAt(i-2) == 'i'){
					start = i+1;
				}
			}
			//end index
			if(name.charAt(i) == ',') end = i;
		}
		if(start == -1) return "Invalid input";
		return name.substring(start, end);
	}

	/**
	 * Reads a specified file and stores all non-comment lines to a list.
	 * @param filePath - Path to file
	 * @return - Returns a list of all the lines in the specified file.
	 */
	static ArrayList<String> readFile(String filePath){
		try{
			InputStream in = Champions.class.getResourceAsStream(filePath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    ArrayList<String> data = new ArrayList<String>();
	    String line;

	    while ((line = reader.readLine()) != null) {
	    	//null and comment lines
	      if(line.length() > 1){
	      if(!line.contains("//")){
	      	data.add(line);
	        }
				}
			}
	    reader.close();
	    return data;
		} catch(Exception e){
			e.printStackTrace();
			return null;
			}
		}

	/***
	 * Empties a given file
	 */
	public static void clearFile(String filepath) {
		try {
			FileWriter fwOb = new FileWriter(filepath, false);
	        PrintWriter pwOb = new PrintWriter(fwOb, false);
	        pwOb.flush();
	        pwOb.close();
	        fwOb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * Stores all Abilities, Champions and Skins to file
	 */
	public static void writeAll() {
		//Store Abilities
		Abilities.writeToFile(Abilities.Abilities);
		
		//Store Champions
		Champions.writeToFile(Champions.Champs);
		
		//Store Skins
		Skins.writeToFile(Skins.Skins);
	}

	/**
	 * Sets ImageView image with default settings
	 * @param imgView - Object containing the image
	 * @param image - Image file
	 */
	public static void setImage(ImageView imgView, Image image){
		imgView.setImage(image);
    	imgView.setPreserveRatio(true);
    	imgView.setSmooth(true);
    	imgView.setCache(true); //improves performance apparently
	}

	/**
	 * Opens any window with AnchorPane as root object
	 * @param filePath - Path to fxml file
	 * @param title - Title of the window
	 */
	public static void openAnchorWindow(String filePath, String title){
		try {
			AnchorPane root = FXMLLoader.load(ViewController.class.getResource(filePath));
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

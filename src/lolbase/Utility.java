package lolbase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
	 *
	 * @example
     * <pre name="test">
     * retrieveID("Testsomethingid=5,Testsomething") === "id=5";
     * retrieveID("|dd|id=5,<|") === "id=5";
     * </pre>
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
	public static ArrayList<String> readFile(String filePath){
		ArrayList<String> data = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if(line.length() > 1){
		    		if(!line.contains("#")){
		    			data.add(line);
		    		}
		    	}
		    }
		    return data;
		    
		} catch (Exception e) {
			System.out.println("Fatal error in Utility.readFile: "+e);
			return null;
		}
	}

	/***
	 * Empties a given file
	 */
	public void clearFile(String filepath) {
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
	
	//Known bug: Sometimes displayes invisible images
	//Potential reason: JPG appears to work, not jpg, png etc.
	public void setImage(ImageView imgView, String image){
		setImage(imgView, new Image(image));
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
	
	
	/***
	 * Copy one file to a new file
	 * @param sourceFile
	 * @param destFile
	 * @throws IOException
	 */
	/*
	public static void copyFile(File sourceFile, File destFile)
	        throws IOException {
	    if (!sourceFile.exists()) {
	        return;
	    }
	    if (!destFile.exists()) {
	        destFile.createNewFile();
	    }
	    FileChannel source = null;
	    FileChannel destination = null;
	    source = new FileInputStream(sourceFile).getChannel();
	    destination = new FileOutputStream(destFile).getChannel();
	    if (destination != null && source != null) {
	        destination.transferFrom(source, 0, source.size());
	    }
	    if (source != null) {
	        source.close();
	    }
	    if (destination != null) {
	        destination.close();
	    }

	}*/
}
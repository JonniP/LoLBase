package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Utility {

	//Excepts form "...[id=SkinLeftArrow, ...]",
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
}

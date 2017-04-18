package lolbase;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Skins {
	public ArrayList<Skin> SkinsList = new ArrayList<Skin>();
	private String filePath = "Data/Skins.dat";
	private final String dataDirectory = "Data/";

	/**
	 * reads the skin file
	 * @return the file as an arraylist
	 */
	public ArrayList<String> readFile(){
		try{
			File dir = new File(dataDirectory);
			dir.mkdir();
			File tmp = new File(dir, "Skins.dat");
			tmp.createNewFile();
			return Utility.readFile(filePath);
		}catch(Exception e){
			System.out.println("Fatal error file could not be created: "+e);
			return null;
		}
	}
	/**
	 * adds a skin to the skin file
	 * @param skin
	 */
	public void addSkin(Skin skin) {
		SkinsList.add(skin);
		// removed Utility.writeAll();
	}
	/**
	 * writes the skins to the skin datafile
	 */
	public void writeToFile(){
		try{
			String championFilePath = dataDirectory+"/Skins.dat";
			PrintWriter writer = new PrintWriter(championFilePath);
			
			// id, name, respected champ, imagepath
			String temp;
			int id = 0;
			for (Skin skin : SkinsList) {
				temp = id++ + "|" + skin.name + "|" + skin.skinsChamp + "|" + skin.imgURL;
				writer.println(temp);
			}
			writer.close();			
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * returns the list of skins
	 * @return the list of skins
	 */
	public ArrayList<Skin> getSkinsList(){
		return SkinsList;
	}
	
	/**
	 * Reads Skins.dat file and returns a list of all skins.
	 * @return Returns a list of skins.
	 */
	public void readSkinsToList(){
		List<String> data = readFile();
		Skin skin;

		for(String s : data){ //each line
			//Note: | is a reserved character and needs \\ to "escape"
			String[] parts = s.split("\\|");

			//id |skin name     |respected champion	|image URL     
			if(parts.length > 1){
				skin = new Skin();
				skin.name = parts[1].trim();
				skin.imgURL = parts[3].trim();
				SkinsList.add(skin);
			}
		}
	}

	/**
	 * searches for skins that have a specific champion id
	 * @param ID champion's id
	 * @return skins that belong to the champion
	 */
	public ArrayList<String> searchSkinWithChampionID(int ID){
		//ToDo: Read the file and return only skins with specific champion ID
		List<String> data = readFile();
		ArrayList<String> results = new ArrayList<String>();

		String key = Integer.toString(ID);
		for(String s : data){
			if(s.contains(key)){
				results.add(s);
			}

		}
		return results;
	}
}

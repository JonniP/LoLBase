package application;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Skins {
	public static ArrayList<Skin> SkinsList = new ArrayList<Skin>();
	private static String filePath = "Data/Skins.dat";
	private static final String dataDirectory = "Data/";

	/**
	 * reads the skin file
	 * @return the file as an arraylist
	 */
	public static ArrayList<String> readFile(){
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
	public static void addSkin(Skin skin) {
		SkinsList.add(skin);
		Utility.writeAll();
	}
	/**
	 * writes the skins to the skin datafile
	 */
	public static void writeToFile(ArrayList<Skin> skins){
		try{
			String championFilePath = dataDirectory+"/Skin.dat";
			PrintWriter writer = new PrintWriter(championFilePath);
			
			// id, name, respected champ, imagepath
			String temp;
			int id = 0;
			for (Skin skin : skins) {
				temp = id++ + "|" + skin.name + "|" + skin.skinsChamp + "|" + skin.imgURL;
				writer.write(temp);
			}
			writer.close();			
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Reads Skins.dat file and returns a list of all skins.
	 * @return Returns a list of skins.
	 */
	public static ArrayList<Skin> getSkins(){
		List<String> data = readFile();
		ArrayList<Skin> skins = new ArrayList<Skin>();
		Skin skin;

		for(String s : data){ //each line
			//Note: | is a reserved character and needs \\ to "escape"
			String[] parts = s.split("\\|");

			//id |skin name     |respected champion	|image URL     
			if(parts.length > 1){
				skin = new Skin();
				skin.name = parts[1].trim();
				skin.imgURL = parts[3].trim();
				skins.add(skin);
			}
		}
		return skins;
	}

	/**
	 * searches for skins that have a specific champion id
	 * @param ID champion's id
	 * @return skins that belong to the champion
	 */
	public static ArrayList<String> searchSkinWithChampionID(int ID){
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

package lolbase;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Johnny
 * @version 21 Apr 2017
 * class that handles the skins
 */
public class Skins {
	/**
	 * the arraylist of skins
	 */
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
	 * @param skin skin that is to be added
	 * @example
	 * <pre name="test">
	 * Skin testskin = new Skin();
	 * int size = SkinsList.size();
	 * addSkin(testskin);
	 * SkinsList.size() === size + 1;
	 * </pre>
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
            try(PrintWriter writer = new PrintWriter(championFilePath)){
	
    			String temp;
    			int id = 0;
    			for (Skin skin : SkinsList) {
    				temp = id++ + "|" + Utility.removePipes(skin.name) + "|" + skin.champID + "|" + Utility.removePipes(skin.imgURL);
    				writer.println(temp);
    			}
    			writer.close();
            }			
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
	 * @param id id of the champ whose skins are to be removed
	 */
	public void removeSkins(int id){
		if(SkinsList.size() > 0) {
			for(int i = 0; i < SkinsList.size(); i++) {
				if(SkinsList.get(i).champID == id) {
					SkinsList.remove(i);
				}
			}
		}
	}
	
	
	/**
	 * Reads Skins.dat file and returns a list of all skins.
	 */
	public void readSkinsToList(){
		List<String> data = readFile();
		Skin skin;

		for(String s : data){ //each line
			//Note: | is a reserved character and needs \\ to "escape"
			String[] split = s.split("\\|");

			//id |skin name     |respected champion	|image URL     
			if(split.length > 1){
				skin = new Skin();
				skin.name = split[1].trim();
				skin.champID = Utility.stringToInt(split[2].trim());
				skin.imgURL = split[3].trim();
				SkinsList.add(skin);
			}
		}
	}

	/**
	 * searches for skins that have a specific champion id
	 * @param id champion's id
	 * @return skins that belong to the champion
	 */
	public ArrayList<Skin> getChampionSkins(int id){
		//ToDo: Search skins from existing list rather than reading file
		ArrayList<String> data = readFile();
		ArrayList<Skin> filteredData = new ArrayList<Skin>();
		for(String s : data){
			String[] split = s.split("\\|");
			if(Utility.stringToInt(split[2].trim()) == id) {
				Skin skin = new Skin();
				skin.name = split[1].trim();
				skin.champID = Utility.stringToInt(split[2].trim());
				skin.imgURL = split[3].trim();
				filteredData.add(skin);
			}
		}
		return filteredData;
	}
	
	/**
	 * searches for skins that are owned by champion (name)
	 * @param name Champion name
	 * @return skins owned by champion
	 */
	public ArrayList<Skin> getChampionSkins(String name){
		//ToDo: Search skins from existing list rather than reading file
		ArrayList<String> data = readFile();
		ArrayList<Skin> filteredData = new ArrayList<Skin>();
		for(String s : data){
			String[] split = s.split("\\|");
			if(split[2].contains(name)) {
				Skin skin = new Skin();
				skin.name = split[1].trim();
				skin.champID = Utility.stringToInt(split[2].trim());
				skin.imgURL = split[3].trim();
				filteredData.add(skin);
			}
		}
		return filteredData;
	}
}

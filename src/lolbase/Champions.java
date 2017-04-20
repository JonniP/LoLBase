package lolbase;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains static methods for reading champion data from files.
 */
public class Champions {

	private ArrayList<Champion> Champs = new ArrayList<Champion>();

	private final String dataDirectory = "Data/";
	private final String filePath = "Data/Champions.dat";
	

	private ArrayList<String> readFile() {
		try{
			File dir = new File(dataDirectory);
			dir.mkdir();
			File tmp = new File(dir, "Champions.dat");
			tmp.createNewFile();
			return Utility.readFile(filePath);
		}catch(Exception e){ 
			System.out.println("Fatal error file could not be created: "+e);
			return null;
		}
	}
	
	/**
	 * removes a champion from the championlist
	 * @param name the champion
	 */
	public void removeChampion(String name){
		if(Champs.size() > 0) {
			for(int i = 0; i < Champs.size(); i++) {
				if(Champs.get(i).name == name) {
					Champs.remove(i);
				}
			}
		} else {
			System.out.println("Champs.size == 0");
		}
	}
	
	/**
	 * writes championlist to the champion datafile
	 */
	public void writeToFile(){
		try{
			String championFilePath = dataDirectory+"/Champions.dat";
			
			PrintWriter writer = new PrintWriter(championFilePath);
			
			//ID, Name, Title, Position, Lore
			String temp;
			int id = 0;
			for (Champion champ : this.Champs){
				if(champ != null){
					temp = id++ + "|" + Utility.removePipes(champ.name) + "|" + Utility.removePipes(champ.title) + "|" + champ.pos + "|" + champ.role + "|" + Utility.removePipes(champ.lore);
					writer.println(temp);
				}
			}
			writer.close();			
		} catch(Exception e){
			System.out.println(e);
		}
	}


	/**
	 * Reads Champions.dat file and returns a list of all champions.
	 * @return Returns a list of champions.
	 */
	
	public void readChampionsToList(){
		//ToDo: Get all info about all champions
		//ToDo: No error checking for missing files
		ArrayList<String> data = readFile();
		Champion champ;

		for(String s : data){ //each line
			//Note: | is a reserved character and needs \\ to "escape"
			String[] parts = s.split("\\|");			

			if(parts.length > 1){
				champ = new Champion();
				champ.name = parts[1].trim();
				champ.title = parts[2].trim();;
				champ.pos = selectPos(parts[3].trim());
				champ.role = selectRole(parts[4].trim());
				champ.lore = parts[5].trim();
				Champs.add(champ);
			}
		}
		
	}
	
	/**
	 * returns the list of champions
	 * @return the list of champions
	 */
	public ArrayList<Champion> getChampionsList(){
		return Champs;
	}
	
	/**
	 * returns a champion from a given index
	 * @param i given index
	 * @return the champion from the index
	 */
	public Champion getChampion(int i){
		return Champs.get(i);
	}
	
	/**
	 * @returns a position enum based on the input string
	 */
	public static Champion.Position selectPos(String a){
		switch(a){
		case "Support": return Champion.Position.Support;
		case "Adc": return Champion.Position.Adc;
		case "Mid": return Champion.Position.Mid;
		case "Jungle": return Champion.Position.Jungle;
		case "Top": return Champion.Position.Top;
		default: return null;
		}
	}
	/**
	 * @return a role based on the input string
	 */
	public static Champion.Role selectRole(String a){
		switch(a){
		case "Support": return Champion.Role.Support;
		case "Mage": return Champion.Role.Mage;
		case "Marksman": return Champion.Role.Marksman;
		case "Tank": return Champion.Role.Tank;
		case "Fighter": return Champion.Role.Fighter;
		case "Assassin": return Champion.Role.Assassin;
		default: return null;
		}
	}

	/**
	 * Add new Champion to the champions list
	 * @example
	 * <pre name="test">
	 * Champion testme = new Champion();
	 * int size = Champs.size();
	 * addChampion(testme);
	 * Champs.size() === size + 1;
	 * </pre>
	 */
	public void addChampion(Champion champ) {
		Champs.add(champ);
	}
	
	/**
	 * returns the size of the championlist
	 * @return the size of the championlist
	 */
	public int getSize() {
		return Champs.size();
	}

	/**
	 * Reads specified file and searches for lines that contain key value.
	 * @param filePath - Path to file
	 * @param key - Word we are looking for
	 */
	public boolean championExistsSearchKey(String key){
		//ToDo: Find with name/ID ?
		List<String> data = readFile();

		for(String s : data){
			String[] parts = s.split("\\|");
			if (parts[1].contains(key)) return true;
		}
		return false;
	}
	
	/**
	 * searches the champion list for champions with name, title, role or position matching the given search key
	 * @param key the search key
	 * @return results as a list
	 */
	public ArrayList<Champion> search(String key){
		ArrayList<Champion> results = new ArrayList<Champion>();
		ArrayList<Champion> target = getChampionsList();
		if (key == null || key == "") return target;
		for (Champion a : target){
			if(a.name.toLowerCase().contains(key) || a.title.toLowerCase().contains(key) || a.pos.toString().toLowerCase().contains(key) || a.role.toString().toLowerCase().contains(key) ){
				results.add(a);
				continue;
			}
		}
		return results;
	}
}

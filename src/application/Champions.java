package application;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains static methods for reading champion data from files.
 */
public class Champions {

	// Global champions array
	public static ArrayList<Champion> Champs = new ArrayList<Champion>();

	private static final String filePath = "Data/Champions.dat";
	private static final String dataDirectory = "Data/";

	public static ArrayList<String> readFile() {
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
	
	
	
	public static void writeToFile(ArrayList<Champion> champs){
		try{
			String championFilePath = dataDirectory+"/Champions.dat";
			
			PrintWriter writer = new PrintWriter(championFilePath);
			
			//ID, Name, Title, Position, Lore
			String temp;
			int id = 0;
			for (Champion champ : champs){
				if(champ != null){
					temp = id++ + "|" + champ.name + "|" + champ.title + "|" + champ.pos + "|" + champ.lore;
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
	
	public static ArrayList<Champion> getChampions(){
		//ToDo: Get all info about all champions
		//ToDo: No error checking for missing files
		List<String> data = readFile();
		ArrayList<Champion> champions = new ArrayList<Champion>();
		Champion champ;

		for(String s : data){ //each line
			//Note: | is a reserved character and needs \\ to "escape"
			String[] parts = s.split("\\|");			

			if(parts.length > 1){
				champ = new Champion();
				champ.name = parts[1].trim();
				champ.title = parts[2].trim();;
				champ.pos = selectPos(parts[3].trim());
				champ.lore = parts[4].trim();
				champions.add(champ);
			}
		}
		return champions;
	}
	
	/**
	 * @returns a position enum based on the input string
	 */
	/* @example
    * <pre name="test">
    * enum Position {
	*	Top,
	*	Mid,
	*	Jungle,
	*	Adc,
	*	Support;
	*}
    * 
    * selectPos("Adc") ===  Position.Adc;
    * selectPos("Support") ===  Position.Support;
    * selectPos("Thunder") ===  Position.null
    * </pre>
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

	/***
	 * Add new Champion to the champions list
	 */
	public static void addChampion(Champion champ) {
		Champs.add(champ);
		//Utility.writeAll();
		Champions.writeToFile(Champs);
	}

	/**
	 * Reads specified file and searches for lines that contain key value.
	 * @param filePath - Path to file
	 * @param key - Word we are looking for
	 */
	public static boolean championExistsSearchKey(String key){
		//ToDo: Find with name/ID ?
		List<String> data = readFile();

		for(String s : data){
			if(s.contains(key)){
				return true;
			}
		}
		return false;
	}
}

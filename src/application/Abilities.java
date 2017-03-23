package application;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Abilities {

	private static final String filePath = "Data/abilities.dat";

	public static ArrayList<Ability> AbilitiesList = new ArrayList<Ability>();

	//ToDo: Write method for writing new abilities
	public static ArrayList<String> readFile(){
		return Utility.readFile(filePath);
	}
	
	public static void addAbility(Ability ability) {
		AbilitiesList.add(ability);
		Utility.writeAll();
	}

	//ToDo: Write method for reading abilities
	public static void writeToFile(ArrayList<Ability> abilities) {
		//ToDo: Clear file (Utility class) and write all abilities to i
		try{
			PrintWriter writer = new PrintWriter(filePath, "UTF-8");
			ArrayList<String> data = readFile();

			if(data.size() != 0){
				Utility.clearFile(filePath);
			}
			//ID, Ability name, Ability school(??), Respected champion, Image path, Description
			String temp;
			int id = 0;
			for(Ability a : abilities){
				temp = id++ + "|" + a.name + "|" + a.school + "|" + a.ChampionID + "|" +
					a.imageURL + "|" + a.description;
				writer.write(temp);
			}
			writer.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads Abilities.dat file and returns a list of all abilities.
	 * @return Returns a list of abilities.
	 */
	public static ArrayList<Ability> getAbilities(){
		//ToDo: Get all info about all abilities
		//ToDo: No error checking for missing files
		List<String> data = readFile();
		ArrayList<Ability> abilities = new ArrayList<Ability>();
		Ability abil;

		for(String s : data){ //each line
			//Note: | is a reserved character and needs \\ to "escape"
			String[] parts = s.split("\\|");

			if(parts.length > 1){
				abil = new Ability();
				abil.name = parts[1];
				abil.imageURL = parts[4];
				abilities.add(abil);
			}
		}
		return abilities;
	}

	//ToDo: Search abilities with champion ID
	public static ArrayList<String> searchAbilitiesWithChampionID(int ID){
		//ToDo: Read the file and return only abilities with specific champion ID
		String key = Integer.toString(ID);
		ArrayList<String> data = readFile();
		ArrayList<String> filteredData = new ArrayList<String>();
		for(String s : data){
			//ToDo: Check if ability is respected champion ID (?)
			if(s.contains(key)) data.add(s);
		}
		return filteredData;
	}

}

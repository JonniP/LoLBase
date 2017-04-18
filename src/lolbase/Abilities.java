package lolbase;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Abilities {

	private final String dataDirectory = "Data/";
	private final String filePath = "Data/Abilities.dat";

	private GenericArray<Ability> AbilitiesList = new GenericArray<Ability>(Ability.class);

	/**
	 * reads the ability datafile
	 * @return the file as an arraylist
	 */
	private ArrayList<String> readFile(){
		try{
			File dir = new File(dataDirectory);
			dir.mkdir();
			File tmp = new File(dir, "Abilities.dat");
			tmp.createNewFile();
			return Utility.readFile(filePath);
		}catch(Exception e){ 
			System.out.println("Fatal error file could not be created: "+e);
			return null;
		}
	}
	/**
	 * adds an ability to the abilitylist
	 * @param ability the ability that is to be added
	 * @example
	 * <pre name="test">
	 * Ability ability = new Ability();
	 * int size = AbilitiesList.size();
	 * addAbility(ability);
	 * AbilitiesList.size() === size + 1;
	 * </pre>
	 */
	public void addAbility(Ability ability) {
		AbilitiesList.add(Ability.class, ability);
	}
	
	public int abilitiesAmount(){
		return AbilitiesList.size();
	}
	/**
	 * writes abilities to the data file
	 * @param abilitiesList2 the list that is to be written
	 */
	 public void writeToFile(){
		try{
			String championFilePath = dataDirectory+"/Abilities.dat";
			PrintWriter writer = new PrintWriter(championFilePath);
			
			//ID, Ability name, Ability school(??), Respected champion, Image path, Description
			String temp;
			int id = 0;
			Ability[] abils = AbilitiesList.toArray(Ability.class);
			for(Ability a : abils){
				temp = id++ + "|" + Utility.removePipes(a.name) + "|" + a.school + "|" + a.ChampionID + "|" +
						Utility.removePipes(a.imageURL) + "|" + Utility.removePipes(a.description);
				writer.println(temp);
			}
			writer.close();			
		} catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * Reads Abilities.dat file and returns a list of all abilities.
	 * @return Returns a list of abilities.
	 */
	public GenericArray<Ability> getAbilities(){
		return AbilitiesList;
	}
	 
	public void getAbilitiesToList(){
		List<String> data = readFile();
		//GenericArray<Ability> abilities = new GenericArray<Ability>(Ability.class);
		Ability abil;

		for(String s : data){ //each line
			//Note: | is a reserved character and needs \\ to "escape"
			String[] parts = s.split("\\|");

			if(parts.length > 1){
				abil = new Ability();
				abil.name = parts[1].trim();
				abil.description = parts[4].trim();
				abil.imageURL = parts[5].trim();
				AbilitiesList.add(Ability.class, abil);
			}
		}
	}
	
	public Ability getAbility(int i){
		return AbilitiesList.get(i);
	}

	/**
	 * searches abilities from the ability file based on a champion id
	 * @param ID champion's id
	 * @return arraylist of the abilities that meet the required id
	 */
	public ArrayList<String> searchAbilitiesWithChampionID(int ID){
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

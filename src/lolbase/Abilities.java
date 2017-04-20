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
	
	/**
	 * returns the size of the abilitylist
	 * @return the size
	 */
	public int abilitiesAmount(){
		return AbilitiesList.size();
	}
	
	/*
	public void removeAbilities(int id){
		if(AbilitiesList.size() > 0) {
			for(int i = 0; i < AbilitiesList.size(); i++) {
				if(AbilitiesList.get(i).ChampionID == id) {
					AbilitiesList.delete(Ability.class, i);
				}
			}
		} else {
			System.out.println("Abilities.size == 0");
		}
	}
	*/
	
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
				temp = id++ + "|" + a.name + "|" + a.school + "|" + a.ChampionID + "|" +
					a.imageURL + "|" + a.description;
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
	 
	/**
	 * reads abilities from the data file and puts them to the abilitylist
	 */
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
				abil.school = parts[2].trim();
				abil.ChampionID = Utility.stringToInt(parts[3].trim());
				abil.imageURL = parts[4].trim();
				abil.description = parts[5].trim();
				AbilitiesList.add(Ability.class, abil);
			}
		}
	}
	
	/**
	 * finds an ability from a given index from the list
	 * @param i the index
	 * @return the ability from the index
	 */
	public Ability getAbility(int i){
		return AbilitiesList.get(i);
	}

	/**
	 * searches abilities from the ability file based on a champion id
	 * @param id champion's id
	 * @return arraylist of the abilities that meet the required id
	 */
	public ArrayList<Ability> getChampionAbilities(int id){
		//ToDo: Read the file and return only abilities with specific champion ID
		ArrayList<String> data = readFile();
		ArrayList<Ability> filteredData = new ArrayList<Ability>();
		for(String s : data){
			String[] parts = s.split("\\|");
			if(Utility.stringToInt(parts[3].trim()) == id) {
				Ability abil = new Ability();
				abil.name = parts[1].trim();
				abil.school = parts[2].trim();
				abil.ChampionID = Utility.stringToInt(parts[3].trim());
				abil.imageURL = parts[4].trim();
				abil.description = parts[5].trim();
				filteredData.add(abil);
			}
		}
		return filteredData;
	}
	
	
	/**
	 * searches the abilitylist for abilities belonging to a certain champion
	 * @param name champion's name
	 * @return a list of his abilities
	 */
	public ArrayList<Ability> getChampionAbilities(String name){
		//ToDo: Optimize search from existing abilities list
		ArrayList<String> data = readFile();
		ArrayList<Ability> filteredData = new ArrayList<Ability>();
		for(String s : data){
			String[] parts = s.split("\\|");
			if(parts[3].contains(name)) {
				Ability abil = new Ability();
				abil.name = parts[1].trim();
				abil.school = parts[2].trim();
				abil.ChampionID = Utility.stringToInt(parts[3].trim());
				abil.imageURL = parts[4].trim();
				abil.description = parts[5].trim();
				filteredData.add(abil);
			}
		}
		return filteredData;
	}

}

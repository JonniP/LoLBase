package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains static methods for reading champion data from files.
 */
public class Champions {

	// Global champions array
	public static ArrayList<Champion> Champs = new ArrayList<Champion>();

	private static final String filePath = "Data/Champions.dat";

	public static ArrayList<String> readFile(){
		return Utility.readFile(filePath);
	}

	public static void writeToFile(ArrayList<Champion> champs) {
		try {
			PrintWriter writer = new PrintWriter(filePath, "UTF-8");
			ArrayList<String> data = readFile();

			if (data.size() != 0) {
				Utility.clearFile(filePath);
			}
			//ID, Name, Title, Position, Lore
			String temp;
			int id = 0;
			for (Champion champ : champs){
				temp = id++ + "|" + champ.name + "|" + champ.title + "|" + champ.pos + "|" + champ.lore;
				writer.write(temp);
			}
			writer.close();
		} catch(Exception e){
			e.printStackTrace();
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
				champ.name = parts[1];
				champions.add(champ);
			}
		}
		return champions;
	}

	/***
	 * Add new Champion to the champions list
	 */
	public static void addChampion(Champion champ) {
		Champs.add(champ);
		Utility.writeAll();
	}

	/**
	 * Reads specified file and searches for lines that contain key value.
	 * @param filePath - Path to file
	 * @param key - Word we are looking for
	 */
	public static void searchKey(String key){
		//ToDo: Find with name/ID ?
		List<String> data = readFile();

		for(String s : data){
			if(s.contains(key)){
				System.out.println(s);
			}
		}
	}
}

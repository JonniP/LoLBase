package application;

import java.util.ArrayList;

public class Abilities {

	private static final String filePath = "Data/abilities.dat";

	private static ArrayList<Ability> abilities;

	//ToDo: Write method for writing new abilities
	public static ArrayList<Ability> readFile(){
		return Utility.readFile(filePath);
	}

	//ToDo: Write method for reading abilities
	public static void writeFile(ArrayList<Ability> abilities) throws FileNotFoundException{
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
				temp = id++ + "|" + a.name + "|" + a.school + "|" + a.respectedChampionID + "|" +
					a.imagepath + "|" + a.description;
				writer.write(temp);
			}
			writer.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	//ToDo: Search abilities with champion ID
	public static ArrayList<Ability> searchAbilitiesWithChampionID(int ID){
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

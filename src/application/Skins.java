package application;

import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Skins {
	public static ArrayList<Skin> SkinsList = new ArrayList<Skin>();
	private static String filePath = "Data/Skins.dat";

	//ToDo: Write method for writing new skins
	public static ArrayList<String> readFile(){
		return Utility.readFile(filePath);
	}
	
	public static void addSkin(Skin skin) {
		SkinsList.add(skin);
		Utility.writeAll();
	}

	//ToDo: Write method for reading skins
	public static void writeToFile(ArrayList<Skin> skins) {
		try {
			//ArrayList<String> data = readFile();
			//PrintWriter writer = new PrintWriter(filePath, "UTF-8");
			ClassLoader loader = Skins.class.getClassLoader();
			File file = new File(loader.getResource(filePath).getFile());
			PrintWriter writer = new PrintWriter(file);

			//if (data.size() != 0) {
				Utility.clearFile(filePath);
			//}
			// id, name, respected champ, imagepath
			String temp;
			int id = 0;
			for (Skin skin : skins) {
				temp = id++ + "|" + skin.name + "|" + skin.skinsChamp + "|" + skin.imgURL;
				writer.write(temp);
			}
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
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
				System.out.println("Added skin");
			}
		}
		return skins;
	}

	//ToDo: Search skins with champion ID
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

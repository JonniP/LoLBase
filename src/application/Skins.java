package application;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Skins {
	public static ArrayList<Skin> SkinsList = new ArrayList<Skin>();
	private static String filePath = "Data/Skins.dat";

	//ToDo: Write method for writing new skins
	public static ArrayList<String> readFile(){
		return Utility.readFile(filePath);
	}
	
	public void addSkin(Skin skin) {
		SkinsList.add(skin);
		Utility.writeAll();
	}

	//ToDo: Write method for reading skins
	public static void writeToFile(ArrayList<Skin> skins) {
		try {
			PrintWriter writer = new PrintWriter(filePath, "UTF-8");
			ArrayList<String> data = readFile();

			if (data.size() != 0) {
				Utility.clearFile(filePath);
			}
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

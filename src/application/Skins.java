package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Skins {
	private static ArrayList<Skin> skins;
	private static String filePath = "Data/Skins.dat";
	
	//ToDo: Write method for writing new skins
	public static ArrayList<String> readFile(){
		try{
			InputStream in = Skins.class.getResourceAsStream(filePath);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        ArrayList<String> data = new ArrayList<String>();
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	        	//null and comment lines
	        	if(line.length() > 1){
	        		if(!line.contains("//")){
	        			data.add(line);
	        		}
	        	}	
	        }
	        reader.close();
	        return data;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//ToDo: Write method for reading skins
	public static void writeFile(ArrayList<Skin> skins) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter(filePath, "UTF-8");
		ArrayList<String> data = readFile();
		
		if (data.size() != 0) {
			Utility.clearFile(filePath);
		}
		// id, name, respected champ, imagepath
		String temp;
		int id = 0;
		for (Skin skin : skins){
			temp = id++ + "|" + skin.name + "|" + skin.skinsChamp + "|" + skin.imgName;
			writer.write(temp);
		}
		writer.close();
	}
	
	//ToDo: Search skins with champion ID
	public static ArrayList<String> searchSkin(int ID){
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


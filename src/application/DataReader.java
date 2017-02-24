package application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains static methods for reading champion data from files.
 */
public class DataReader {
	
	/**
	 * Reads a specified file and stores all non-comment lines to a list.
	 * @param filePath - Path to file
	 * @return - Returns a list of all the lines in the specified file.
	 */
	private static List<String> readFile(String filePath){
		try{
			InputStream in = DataReader.class.getResourceAsStream(filePath);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        List<String> data = new ArrayList<String>();
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
	
	/**
	 * Reads Champions.dat file and returns a list of all champions.
	 * @return Returns a list of champions.
	 */
	public static ArrayList<Champion> getChampions(){
		//ToDo: Get all info about all champions
		//ToDo: No error checking for missing files
		List<String> data = readFile("Data/Champions.dat");
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
	
	
	/**
	 * Reads specified file and searches for lines that contain key value.
	 * @param filePath - Path to file
	 * @param key - Word we are looking for
	 */
	public static void searchKey(String filePath, String key){
		List<String> data = readFile(filePath);
		
		for(String s : data){
			if(s.contains(key)){
				System.out.println(s);
			}
		}
	}

}

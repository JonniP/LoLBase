package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
	
	private static List<String> readFile(String filePath){
		
		try{
			InputStream in = new FileInputStream(new File(filePath));
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        List<String> data = new ArrayList<String>();
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	//Comment and null lines
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
			System.out.println(e);
			return null;
		}
	}
	
	//Temporary to create a list of champions with only their name
	//ToDo: Add other information or find a better way to do this
	public static ArrayList<Champion> getChampions(){
		List<String> data = readFile("src/application/Data/Champions.dat");
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
	
	public static void searchKey(String filePath, String key){
		List<String> data = readFile(filePath);
		
		for(String s : data){
			if(s.contains(key)){
				System.out.println(s);
			}
		}
	}

}

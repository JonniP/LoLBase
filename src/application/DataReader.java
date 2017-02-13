package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
	
	private static List<String> readFile(String path){
		
		try{
			InputStream in = new FileInputStream(new File(path));
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        List<String> data = new ArrayList<String>();
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	data.add(line);
	        }
	        reader.close();
	        return data;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void searchKey(String path, String key){
		List<String> data = readFile(path);
		
		for(String s : data){
			if(s.contains(key)){
				System.out.println(s);
			}
		}
	}

}

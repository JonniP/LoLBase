package application;

import java.util.ArrayList;

public class Roles {
	private static ArrayList<Role> roles;

	//ToDo: Write method for reading roles
	public static ArrayList<Role> readFile(){
		return Utility.readFile(filePath);
	}

	//ToDo: Search roles??? ---IS this needed???--- !! !!
	public static ArrayList<Role> searchRoleWithChampionID(int ID){
		ArrayList<String> data = readFile();
		ArrayList<String> filteredData = new ArrayList<String>();

		String key = Integer.toString(ID);
		for(String s : data){
			if(s.contains(key)) results.add(s);
		}
		return results;
	}

}

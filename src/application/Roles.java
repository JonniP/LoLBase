package application;

import java.util.ArrayList;

public class Roles {
	private static ArrayList<Role> roles;
	private static final String filePath = "Data/Toles.dat";

	//ToDo: Write method for reading roles
	public static ArrayList<String> readFile(){
		return Utility.readFile(filePath);
	}

	//ToDo: Search roles??? ---IS this needed???--- !! !!
	public static ArrayList<String> searchRoleWithChampionID(int ID){
		ArrayList<String> data = readFile();
		ArrayList<String> filteredData = new ArrayList<String>();

		String key = Integer.toString(ID);
		for(String s : data){
			if(s.contains(key)) filteredData.add(s);
		}
		return filteredData;
	}

}

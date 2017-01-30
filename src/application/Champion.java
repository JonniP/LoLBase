package application;

import java.util.ArrayList;

enum Position {
	Top,
	Mid,
	Jungle,
	Adc,
	Support
}

public class Champion {

	public String name;
	public String title;
	public ArrayList<String> roles;
	public Position pos;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

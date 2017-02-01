package application;

import java.util.ArrayList;

enum Position {
	Top,
	Mid,
	Jungle,
	Adc,
	Support
}

class Ability {
	public String title;
	public String description;
	public int cooldown;
	
	public Ability() {
		this.title = "";
		this.description = "";
		this.cooldown = -1;
	}
}

class Skin {
	public String name;
	public String imgName;
}

public class Champion {

	public String name;
	public String title;
	public ArrayList<String> roles;
	public Position pos;
	public ArrayList<Ability> Abilities;
	public String city;
	public ArrayList<Champion> relatedChampions;
	public String Profession;
	public ArrayList<Skin> Skins;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

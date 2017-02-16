package application;

import java.util.ArrayList;

/**
 * Enum of champion lanes
 */
enum Position {
	Top,
	Mid,
	Jungle,
	Adc,
	Support
}

/**
 * Class object for abilities
 */
class Ability {
	public String title;
	public String description;
	
	public Ability() {
		this.title = "";
		this.description = "";
	}
}

/**
 * Class object for skins
 */
class Skin {
	public String name;
	public String imgName;
}

/**
 * Class object for champions, uses abilities and skins.
 */
public class Champion {
	
	public String name;
	public String title;
	public ArrayList<String> roles;
	public Position pos;
	public ArrayList<Ability> Abilities;
	public String city;
	public ArrayList<Champion> relatedChampions;
	public String profession;
	public String lore;
	public ArrayList<Skin> skins;
	
	//Constructor to initialize values
	public Champion(){
		this.name = "DefaultName";
		this.title = "DefaultTitle";
		this.pos = null;
		this.city = "DefaultCity";
		this.profession = "DefaultProfession";
		
		this.roles = new ArrayList<String>();
		this.Abilities = new ArrayList<Ability>();
		this.relatedChampions = new ArrayList<Champion>();
		this.skins = new ArrayList<Skin>();
	}

}

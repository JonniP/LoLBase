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
	public Position pos;
	public String lore;
	
	//Constructor to initialise values
	public Champion(){
		this.name = "DefaultName";
		this.title = "DefaultTitle";
		this.pos = null;

	}

}

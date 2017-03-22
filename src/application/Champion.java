package application;

import java.util.ArrayList;


/**
 * Class object for champions, uses abilities and skins.
 */
public class Champion {
	/**
	 * Enum of champion lanes
	 */
	enum Position {
		Top,
		Mid,
		Jungle,
		Adc,
		Support;
		
		@Override
		public String toString() {
			return super.toString();
		}
	}
	
	public String name;
	public String title;
	public Position pos;
	public String lore;
	
	//Constructor to initialise values
	public Champion(){
		this.name = "DefaultName";
		this.title = "DefaultTitle";
		this.lore = "DefaultLore";
		this.pos = null;

	}

}

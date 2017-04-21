package lolbase;

/**
 * Class object for champions, uses abilities and skins.
 */
public class Champion {
	/**
	 * Enum of champion lanes
	 */
	public enum Position {
		/**
		 * Top lane, the lane in the top of the map, usually the lane for fighters and tanks
		 */
		Top,
		/**
		 * Mid lane, the shortest and arguably the most meaningful lane in the game. Usually the lane for mages and assassins
		 */
		Mid,
		/**
		 * The forest areas around the lanes packed with creeps. Junglers kill creeps for money and xp, and help other lanes with ganks
		 */
		Jungle,
		/**
		 * Bot lane damage dealer that traditionally requires a good early game to proceed into carrying the late game
		 */
		Adc,
		/**
		 * Bot lane character that helps the adc to stay alive and get fed
		 */
		Support;
		
		@Override
		public String toString() {
			return super.toString();
		}
	}
	/**
	 * Enum of roles
	 */
	public enum Role {
		/**
		 * Mages are hard hitting spellcasters
		 */
		Mage,
		/**
		 * Marksmen deal their damage with autoattacks
		 */
		Marksman,
		/**
		 * Supports provide CC and sustain for the team
		 */
		Support,
		/**
		 * Tanks are high-health frontliners that soak damage and protect teammates
		 */
		Tank,
		/**
		 * Fighters are moderately durable front line damage dealers
		 */
		Fighter,
		/**
		 * High burst damage dealers that exell in quick get in, get out -type of combat
		 */
		Assassin,
	}
	
	/**
	 * champ's id in the list
	 */
	public int id;
	/**
	 * champ's name
	 */
	public String name;
	/**
	 * champ's title
	 */
	public String title;
	/**
	 * champ's position
	 */
	public Position pos;
	/**
	 * champ's lore
	 */
	public String lore;
	/**
	 * champ's role
	 */
	public Role role;
	
	/**
	 * constructor to initialize values
	 */
	public Champion(){
		this.id = -1;
		this.name = "DefaultName";
		this.title = "DefaultTitle";
		this.lore = "DefaultLore";
		this.pos = null;
		this.role = null;

	}

}

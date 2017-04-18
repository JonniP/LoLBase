package lolbase;

/**
 * Class object for abilities
 */
public class Ability {
	public String name;
	public String school; //passive, Q, W, E, R...
	public String ChampionName;
	public String imageURL;
	public String description;

	/**
	 * constructor for an ability
	 */
	public Ability() {
		this.name = "";
		this.description = "";
		this.school = "";
		this.ChampionName = "DefaultOwner";
		this.imageURL = "";
	}
}

package lolbase;

/**
 * Class object for abilities
 */
public class Ability {
	/**
	 * ability's name
	 */
	public String name;
	/**
	 * ability's school
	 */
	public String school; //passive, Q, W, E, R...
	/**
	 * champion's id
	 */
	public int ChampionID;
	/**
	 * ability's image's URL
	 */
	public String imageURL;
	/**
	 * short description about the ability
	 */
	public String description;

	/**
	 * constructor for an ability
	 */
	public Ability() {
		this.name = "";
		this.description = "";
		this.school = "";
		this.ChampionID = -1;
		this.imageURL = "";
	}
}

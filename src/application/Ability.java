package application;

/**
 * Class object for abilities
 */
class Ability {
	public String name;
	public String school; //passive, Q, W, E, R...
	public int ChampionID;
	public String imageURL;
	public String description;


	public Ability() {
		this.name = "";
		this.description = "";
		this.school = "";
		this.ChampionID = -1;
		this.imageURL = "";
	}
}

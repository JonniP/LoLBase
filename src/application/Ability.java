package application;

/**
 * Class object for abilities
 */
class Ability {
	public String name;
	public String school; //passive, Q, W, E, R...
	public int respectedChampionID;
	public String imagePath;
	public String description;

	public Ability() {
		this.name = "";
		this.description = "";
		this.abilitySchool = "";
		this.respectedChampionID = -1;
		this.imagepath = "";
	}
}

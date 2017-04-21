package lolbase;

/**
 * Class object for skins
 */
public class Skin {
	/**
	 * skin's name
	 */
	public String name;
	/**
	 * skin's respective champion
	 */
	public int champID;
	/**
	 * skin's image's URL
	 */
	public String imgURL;
	
	/**
	 * constructor for skins
	 */
	public Skin(){
		this.champID = -1;
	}
}

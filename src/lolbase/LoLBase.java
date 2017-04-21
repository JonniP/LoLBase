package lolbase;

import java.util.ArrayList;
/**
 * the Base of our LoLBase, if you will
 */
public class LoLBase {
	
	private Champions champions = new Champions();
	private Abilities abilities = new Abilities();
	private Skins skins = new Skins();
	
	/**
	 * reads all files
	 */
	public void readAll(){
		champions.readChampionsToList();
		abilities.getAbilitiesToList();
		skins.readSkinsToList();
	}
	/**
	 * writes to all files
	 */
	 public void writeAll(){
		champions.writeToFile();
		abilities.writeToFile();
		skins.writeToFile();
	}
	
	//Champions
	 /**
	  * returns the amount of champions in the championlist
	  * @return the amount
	  */
	public int getChampionsAmount() {
		return champions.getSize();
	}
	/**
	 * adds a champion
	 * @param champ the champion
	 */
	public void addChampion(Champion champ) {
		champions.addChampion(champ);
	}
	
	
	/**
	 * @return the last id in the championlist
	 */
	public int getChampionID() {
		return champions.getChampionID();
	}
	
	/**
	 * modifies the information of a chamoion
	 * @param champ the champ
	 */
	public void modifyChampion(Champion champ) {
		if (champions.championExists(champ.id)) {
			champions.removeChampion(champ.id);
		}
		champions.addChampion(champ);
	}
	/**
	 * removes a champ
	 * @param name the hamp
	 */
	public void removeChampion(String name) {
		champions.removeChampion(name);
	}
	
	/**
	 * @param id id of the champ that is to be removed
	 */
	public void removeChampion(int id) {
		champions.removeChampion(id);
		//abilities.removeAbilities(id);
		skins.removeSkins(id);
	}
	
	/**
	 * gets the i:th champion from the list
	 * @param i - champions index
	 * @return the champion from the given index
	 */
	public Champion getChampion(int i){
		try{
			return champions.getChampion(i);
		} catch(Exception e){
			return null;
		}
	}
	
	/**
	 * searches for champions with given search key in their name, title, role or position
	 * @param key search value
	 * @return champions found
	 */
	public ArrayList<Champion> search(String key){
		return champions.search(key);
	}
	
	/**
	 * @param id id of a champ
	 * @return champions found with id
	 */
	public ArrayList<Champion> search(int id){
		return champions.search(id);
	}
	
	/**
	 * returns the current list of champions
	 * @return the current list of champions
	 */
	public ArrayList<Champion> getChampionList(){
		return champions.getChampionsList();
	}
	/**
	 * tells if champion lives or not
	 * @param name the name of the champ
	 * @return yes or no
	 */
	public boolean championExists(String name){
		return champions.championExists(name);
	}
	
	/**
	 * @param id id of the supposed champion
	 * @return yes if the champion exists
	 */
	public boolean championExists(int id) {
		return champions.championExists(id);
	}
	
	//Abilities		
	/**
	 * searches for abilities that belong to a given champion
	 * @param name name of the champion
	 * @return list of the champion's abilities
	 */
	public ArrayList<Ability> getChampionAbilities(String name) {
		return abilities.getChampionAbilities(name);
	}
	
	/**
	 * @param id id of the champion
	 * @return abilities of the given champion
	 */
	public ArrayList<Ability> getChampionAbilities(int id) {
		return abilities.getChampionAbilities(id);
	}
	
	/**
	 * returns the amount of abilities in the abilitylist
	 * @return the amount
	 */
	public int getAbilitiesAmount(){
		return abilities.abilitiesAmount();
	}
	/**
	 * adds an ability to the list
	 * @param ability that is to be added
	 */
	public void addAbility(Ability ability){
		abilities.addAbility(ability);
	}
	/**
	 * it feels goofy making up these comments
	 * @param i well, its cool alrite?
	 * @return whatever you dream of
	 */
	public Ability getAbility(int i){
		try{
			return abilities.getAbility(i);
		} catch(Exception e){
			return null;
		}
	}
	/**
	 * this is not fun
	 * @return something that is fun
	 */
	public GenericArray<Ability> getAbiltiesList(){
		return abilities.getAbilities();
	}
	
	//Skins
	/**
	 * @param name champion whose skins are looked for
	 * @return the skins of the given champ
	 */
	public ArrayList<Skin> getChampionSkins(String name) {
		return skins.getChampionSkins(name);
	}
	
	/**
	 * @param id id of the champion whose skins we want
	 * @return the skins of the given champ
	 */
	public ArrayList<Skin> getChampionSkins(int id) {
		return skins.getChampionSkins(id);
	}
	
	/**
	 * reeturns the amount of skins in the skinlist
	 * @return the amount
	 */
	public int getSkinsAmount(){
		return skins.SkinsList.size();
	}
	/**
	 * adds skin to list
	 * @param skin skin
	 */
	public void addSkin(Skin skin){
		skins.SkinsList.add(skin);
	}
	/**
	 * gives the list
	 * @return list
	 */
	public ArrayList<Skin> getSkinList(){
		return skins.getSkinsList();
	}
	/**
	 * the last one, yeaah
	 * @param i one more time
	 * @return we gonna celebrate
	 */
	public Skin getSkin(int i){
		try{
			return skins.SkinsList.get(i);
		} catch(Exception e){
			return null;
		}
	}
	
}

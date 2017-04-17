package lolbase;

import java.util.ArrayList;
/*
 * the Base of our LoLBase, if you will
 */
public class LoLBase {
	
	private Champions champions = new Champions();
	private Abilities abilities = new Abilities();
	private Skins skins = new Skins();
	
	public void readAll(){
		champions.readChampionsToList();
		abilities.getAbilitiesToList();
		skins.readSkinsToList();
	}
	
	 public void writeAll(){
		champions.writeToFile();
		abilities.writeToFile();
		skins.writeToFile();
	}
	
	//Champions
	public int getChampionsAmount() {
		return champions.getSize();
	}
	
	public void addChampion(Champion champ) {
		champions.addChampion(champ);
	}
	
	public void removeChampion(String name) {
		champions.removeChampion(name);
	}
	
	
	public Champion getChampion(int i){
		try{
			return champions.getChampion(i);
		} catch(Exception e){
			return null;
		}
	}
	
	public ArrayList<Champion> getChampionList(){
		return champions.getChampionsList();
	}
	
	public boolean championExists(String name){
		return champions.championExistsSearchKey(name);
	}
	
	//Abilities
	public int getAbilitiesAmount(){
		return abilities.abilitiesAmount();
	}
	
	public void addAbility(Ability ability){
		abilities.addAbility(ability);
	}
	
	public Ability getAbility(int i){
		try{
			return abilities.getAbility(i);
		} catch(Exception e){
			return null;
		}
	}
	public GenericArray<Ability> getAbiltiesList(){
		return abilities.getAbilities();
	}
	
	//Skins
	public int getSkinsAmount(){
		return skins.SkinsList.size();
	}
	
	public void addSkin(Skin skin){
		skins.SkinsList.add(skin);
	}
	
	public ArrayList<Skin> getSkinList(){
		return skins.getSkinsList();
	}
	
	public Skin getSkin(int i){
		try{
			return skins.SkinsList.get(i);
		} catch(Exception e){
			return null;
		}
	}
	
}

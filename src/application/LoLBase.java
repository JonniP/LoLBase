package application;

import java.util.ArrayList;

public class LoLBase {
	
	private final Champions champions = new Champions();
	private final Skins skins = new Skins();
	private final Abilities abilities = new Abilities();

	/***
	 * Stores all Abilities, Champions and Skins to file
	 */
	public void writeAll() {
		//Store Abilities
		//Abilities.writeToFile(abilities.AbilitiesList);
		
		//Store Champions
		champions.writeToFile();
		
		//Store Skins
		//Skins.writeToFile(Skins.SkinsList);
	}
	
	//Champions
	public int getChampionsAmount() {
		return champions.getSize();
	}
	
	public void addChampion(Champion champ){
		champions.addChampion(champ);
	}
	
	public Champion getChampion(int i){
		try{
			return champions.getChampion(i);
		} catch(Exception e){
			return null;
		}
	}
	
	public ArrayList<Champion> getChampionList(){
		return champions.getChampions();
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
	
	//Skins
	public int getSkinsAmount(){
		return skins.SkinsList.size();
	}
	
	public void addSkin(Skin skin){
		skins.SkinsList.add(skin);
	}
	
	public Skin getSkin(int i){
		try{
			return skins.SkinsList.get(i);
		} catch(Exception e){
			return null;
		}
	}
	
}

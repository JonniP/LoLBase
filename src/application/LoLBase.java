package application;

public class LoLBase {
	
	private final Champions champions = new Champions();
	private final Skins skins = new Skins();
	private final Abilities abilities = new Abilities();

	/***
	 * Stores all Abilities, Champions and Skins to file
	 */
	public void writeAll() {
		//Store Abilities
		Abilities.writeToFile(abilities.AbilitiesList);
		
		//Store Champions
		Champions.writeToFile();
		
		//Store Skins
		//Skins.writeToFile(Skins.SkinsList);
	}
	
	//Champions
	public int getChampionsAmount() {
		return champions.getSize();
	}
	
	public void addChampion(Champion champ){
		champions.Champs.add(champ);
	}
	
	public Champion getChampion(int i){
		try{
			return champions.Champs.get(i);
		} catch(Exception e){
			return null;
		}
	}
	
	public boolean championExists(String name){
		return champions.championExistsSearchKey(name);
	}
	
	//Abilities
	public int getAbilitiesAmount(){
		return abilities.AbilitiesList.size();
	}
	
	public void addAbility(Ability ability){
		abilities.AbilitiesList.add(Ability.class, ability);
	}
	
	public Ability getAbility(int i){
		try{
			return abilities.AbilitiesList.get(i);
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

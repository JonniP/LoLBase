package application;

public class LoLBase {

	//Champions
	public int getChampionsAmount() {
		return Champions.Champs.size();
	}
	
	public void addChampion(Champion champ){
		Champions.Champs.add(champ);
	}
	
	public Champion getChampion(int i){
		try{
			return Champions.Champs.get(i);
		} catch(Exception e){
			return null;
		}
	}
	
	public boolean championExists(String name){
		return Champions.championExistsSearchKey(name);
	}
	
	//Abilities
	public int getAbilitiesAmount(){
		return Abilities.AbilitiesList.size();
	}
	
	public void addAbility(Ability ability){
		Abilities.AbilitiesList.add(ability);
	}
	
	public Ability getAbility(int i){
		try{
			return Abilities.AbilitiesList.get(i);
		} catch(Exception e){
			return null;
		}
	}
	
	//Skins
	public int getSkinsAmount(){
		return Skins.SkinsList.size();
	}
	
	public void addSkin(Skin skin){
		Skins.SkinsList.add(skin);
	}
	
	public Skin getSkin(int i){
		try{
			return Skins.SkinsList.get(i);
		} catch(Exception e){
			return null;
		}
	}
	
}

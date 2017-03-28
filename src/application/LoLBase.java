package application;

public class LoLBase {

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
}

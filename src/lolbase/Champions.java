package lolbase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Contains static methods for reading champion data from files.
 */
public class Champions {

	private ArrayList<Champion> Champs = new ArrayList<Champion>();

	private Database dbase;
	private static Champion helpChamp = new Champion();
	
	public Champions(String name) {
		dbase = Database.formatDatabase(name);
		try (Connection dbConn = dbase.giveRootConnection()) {
			DatabaseMetaData meta = dbConn.getMetaData();
			
			try (ResultSet table = meta.getTables(null, null, "Champions", null)) {
				if (!table.next()) {
					//Create new table
					try (PreparedStatement sql = dbConn.prepareStatement(helpChamp.createChampionsDataBase())) {
						sql.execute();
					}
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Fäck");
		}
	}
	
	public void addChamp(Champion champ) throws SQLException {
		try ( Connection dbConn = dbase.giveRootConnection(); PreparedStatement sql = helpChamp.formatCreate(dbConn) ) {
			sql.executeUpdate();
			try ( ResultSet rs = sql.getGeneratedKeys() ) {
				helpChamp.checkID(rs);
		    } catch (SQLException e) {
		    	System.out.println("Crash");
		    }
		}
	}
	
	public void addAllChampions() throws SQLException {
		for(Champion champ : Champs) {
			addChamp(champ);
		}
	}
	
	public void getAllChampions() throws SQLException {
		try ( Connection dbConn = dbase.giveRootConnection(); PreparedStatement sql = dbConn.prepareStatement("SELECT * FROM Champions")) {
			try ( ResultSet results = sql.executeQuery() ) {
				while ( results.next() ) {
					Champion champ = new Champion();
					champ.parse(results);
					Champs.add(champ);
				}
			} catch(SQLException e) {
				System.out.println("error retrieving all champions");
			}
		}
	}
	
	// Todo: Format properly
	public Collection<Champion> search(String searchCondition, int attributeNumber) {
		String condition = searchCondition;
		String question = helpChamp.getAttribute(attributeNumber);
		if ( attributeNumber < 0 ) { question = helpChamp.getAttribute(0); condition = ""; {
		    try ( Connection con = dbase.giveRootConnection(); PreparedStatement sql = con.prepareStatement("SELECT * FROM Champions WHERE " + question + " LIKE ?") ) {
		    	ArrayList<Champion> found = new ArrayList<Champion>();
		             
		    	sql.setString(1, "%" + condition + "%");
		    	try ( ResultSet results = sql.executeQuery() ) {
		    		while ( results.next() ) {
		    			Champion j = new Champion();
		    			j.parse(results);
		                found.add(j);
		    		}
		    	}
		        return found;
		    } catch ( SQLException e ) {
		    	System.out.println("eeeeee");
		    }
		}
		}
		return null;
	}
		
	/**
	 * @return the last id of the championlist
	 */
	public int getChampionID() {
		int id = Champs.size();
		while(championExists(id)){
			id++;
		}
		return id;
	}
	
	public boolean championExists(int id) {
		for(Champion champ : Champs) {
			if(champ.id == id) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * removes a champion from the championlist
	 * @param name the champion
	 */
	public void removeChampion(String name){
		if(Champs.size() > 0) {
			for(int i = 0; i < Champs.size(); i++) {
				if(Champs.get(i).name == name) {
					Champs.remove(i);
				}
			}
		} else {
			System.out.println("Champs.size == 0");
		}
	}
	
	/**
	 * @param id removes a champion from the list
	 */
	public void removeChampion(int id){
		if(Champs.size() > 0) {
			for(int i = 0; i < Champs.size(); i++) {
				if(Champs.get(i).id == id) {
					Champs.remove(i);
				}
			}
		} else {
			System.out.println("Champs.size == 0");
		}
	}
		
	/**
	 * returns the list of champions
	 * @return the list of champions
	 */
	public ArrayList<Champion> getChampionsList(){
		return Champs;
	}
	
	/**
	 * returns a champion from a given index
	 * @param i given index
	 * @return the champion from the index
	 */
	public Champion getChampion(int i){
		return Champs.get(i);
	}
	
	/**
	 * @param a position as a string
	 * @return  position as an enum
	 */
	public static Champion.Position selectPos(String a){
		switch(a){
		case "Support": return Champion.Position.Support;
		case "Adc": return Champion.Position.Adc;
		case "Mid": return Champion.Position.Mid;
		case "Jungle": return Champion.Position.Jungle;
		case "Top": return Champion.Position.Top;
		default: return null;
		}
	}
	/**
	 * @param a role as a string
	 * @return a role based on the input string
	 */
	public static Champion.Role selectRole(String a){
		switch(a){
		case "Support": return Champion.Role.Support;
		case "Mage": return Champion.Role.Mage;
		case "Marksman": return Champion.Role.Marksman;
		case "Tank": return Champion.Role.Tank;
		case "Fighter": return Champion.Role.Fighter;
		case "Assassin": return Champion.Role.Assassin;
		default: return null;
		}
	}

	/**
	 * Add new Champion to the champions list
	 * @param champ champion that is to be added
	 * @example
	 * <pre name="test">
	 * Champion testme = new Champion();
	 * int size = Champs.size();
	 * addChampion(testme);
	 * Champs.size() === size + 1;
	 * </pre>
	 */
	public void addChampion(Champion champ) {
		Champs.add(champ);
	}
	
	/**
	 * returns the size of the championlist
	 * @return the size of the championlist
	 */
	public int getSize() {
		return Champs.size();
	}
		
	/**
	 * searches the champion list for champions with name, title, role or position matching the given search key
	 * @param key the search key
	 * @return results as a list
	 */
	public ArrayList<Champion> search(String key){
		ArrayList<Champion> results = new ArrayList<Champion>();
		ArrayList<Champion> target = getChampionsList();
		if (key == null || key == "") return target;
		for (Champion a : target){
			if(a.name.toLowerCase().contains(key) || a.title.toLowerCase().contains(key) || a.pos.toString().toLowerCase().contains(key) || a.role.toString().toLowerCase().contains(key) ){
				results.add(a);
				continue;
			}
		}
		return results;
	}
	
	/**
	 * Returns champion with specific id
	 * @param id champion unique identifier
	 * @return champion that contains id
	 */
	public ArrayList<Champion> search(int id){
		ArrayList<Champion> results = new ArrayList<Champion>();
		ArrayList<Champion> target = getChampionsList();
		for (Champion a : target){
			if(a.id == id) {
				results.add(a);
				continue;
			}
		}
		return results;
	}
}

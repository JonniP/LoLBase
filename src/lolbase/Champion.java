package lolbase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class object for champions, uses abilities and skins.
 */
public class Champion {
	/**
	 * Enum of champion lanes
	 */
	public enum Position {
		/**
		 * Top lane, the lane in the top of the map, usually the lane for fighters and tanks
		 */
		Top,
		/**
		 * Mid lane, the shortest and arguably the most meaningful lane in the game. Usually the lane for mages and assassins
		 */
		Mid,
		/**
		 * The forest areas around the lanes packed with creeps. Junglers kill creeps for money and xp, and help other lanes with ganks
		 */
		Jungle,
		/**
		 * Bot lane damage dealer that traditionally requires a good early game to proceed into carrying the late game
		 */
		Adc,
		/**
		 * Bot lane character that helps the adc to stay alive and get fed
		 */
		Support;
		
		@Override
		public String toString() {
			return super.toString();
		}
	}
	/**
	 * Enum of roles
	 */
	public enum Role {
		/**
		 * Mages are hard hitting spellcasters
		 */
		Mage,
		/**
		 * Marksmen deal their damage with autoattacks
		 */
		Marksman,
		/**
		 * Supports provide CC and sustain for the team
		 */
		Support,
		/**
		 * Tanks are high-health frontliners that soak damage and protect teammates
		 */
		Tank,
		/**
		 * Fighters are moderately durable front line damage dealers
		 */
		Fighter,
		/**
		 * High burst damage dealers that exell in quick get in, get out -type of combat
		 */
		Assassin,
	}
	
	/**
	 * champ's id in the list
	 */
	public int id;
	/**
	 * champ's name
	 */
	public String name;
	/**
	 * champ's title
	 */
	public String title;
	/**
	 * champ's position
	 */
	public Position pos;
	/**
	 * champ's lore
	 */
	public String lore;
	/**
	 * champ's role
	 */
	public Role role;
	
	/**
	 * constructor to initialize values
	 */
	public Champion(){
		this.id = -1;
		this.name = "DefaultName";
		this.title = "DefaultTitle";
		this.pos = null;
		this.lore = "DefaultLore";
		this.role = null;

	}
	
	/*
	champ.id = Utility.stringToInt(parts[0].trim());
	champ.name = parts[1].trim();
	champ.title = parts[2].trim();;
	champ.pos = selectPos(parts[3].trim());
	champ.role = selectRole(parts[4].trim());
	champ.lore = parts[5].trim();
 */
	
	public String createChampionsDataBase() {
		return "CREATE TABLE Champions (" +
				"id INTEGER PRIMARY KEY AUTOINCREMENT , " +
				"name VARCHAR(100) NOT NULL , " +
				"title VARCHAR(100) NOT NULL , " +
				"pos VARCHAR NOT NULL, " +
				"role VARCHAR NOT NULL, " +
				"lore VARCHAR(255) NOT NULL , " +
				")";
	}
	
	public PreparedStatement formatCreate(Connection con) throws SQLException {
		PreparedStatement sql = con.prepareStatement("INSERT INTO Champions" +
				"(id, name, title, pos, role, lore, " +
				"VALUES (?, ?, ?, ?, ?, ?)");
		
		if(id != 0) sql.setInt(1,  id);
		else sql.setString(1,  null);
		sql.setString(2, name);
		sql.setString(3, title);
		sql.setString(4, pos.name() );
		sql.setString(5, role.name() );
		sql.setString(6, lore);
		
		return sql;
	}
	
	public void tarkistaID(ResultSet rs) throws SQLException {
		if(!rs.next() ) return;
		int id = rs.getInt(1);
		if (id == this.id) return;
		this.id = id;
	}
	
	public void parse(ResultSet results) throws SQLException {
		this.id = results.getInt("id");
		this.name = results.getString("name");
		this.title = results.getString("title");
		this.pos = selectPos(results.getString("pos"));
		this.role = selectRole(results.getString("role"));
		this.lore = results.getString("lore");
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

	

}

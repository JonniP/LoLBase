package lolbase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class object for abilities
 */
public class Ability {
	
	/**
	 * id
	 */
	public int id;
	/**
	 * ability's name
	 */
	public String name;
	/**
	 * ability's school
	 */
	public String school; //passive, Q, W, E, R...
	/**
	 * champion's id
	 */
	public int ChampionID;
	/**
	 * ability's image's URL
	 */
	public String imageURL;
	/**
	 * short description about the ability
	 */
	public String description;

	/**
	 * constructor for an ability
	 */
	public Ability() {
		this.name = "";
		this.description = "";
		this.school = "";
		this.ChampionID = -1;
		this.imageURL = "";
	}
	
	public String createAbilitiesDataBase() {
		return "CREATE TABLE Abilities (" +
				"id INTEGER PRIMARY KEY AUTOINCREMENT , " +
				"name VARCHAR(100) NOT NULL , " +
				"school VARCHAR(100) NOT NULL , " +
				"ChampionID INTEGER NOT NULL, " +
				"imageURL VARCHAR(200) NOT NULL, " +
				")";
	}
	
	public PreparedStatement formatCreate(Connection con) throws SQLException {
		PreparedStatement sql = con.prepareStatement("INSERT INTO Abilities" +
				"(id, name, description, school, ChampionID, imageURL, " +
				"VALUES (?, ?, ?, ?, ?, ?)");
		
		if(id != 0) sql.setInt(1,  id);
		else sql.setString(1,  null);
		sql.setString(2, name);
		sql.setString(3, description);
		sql.setString(4, school );
		sql.setInt(5, ChampionID );
		sql.setString(6, imageURL);
		
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
		this.description = results.getString("description");
		this.school = results.getString("school");
		this.ChampionID = results.getInt("ChampionID");
		this.imageURL = results.getString("imageURL");
	}
	
}

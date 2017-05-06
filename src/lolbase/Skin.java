package lolbase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class object for skins
 */
public class Skin {
	
	/**
	 * id
	 */
	public int id;
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
	
	public String createSkinsDataBase() {
		return "CREATE TABLE Skins (" +
				"id INTEGER PRIMARY KEY AUTOINCREMENT , " +
				"name VARCHAR(100) NOT NULL , " +
				"champID INTEGER NOT NULL , " +
				"imgURL VARCHAR(200) NOT NULL, " +
				")";
	}
	
	public PreparedStatement formatCreate(Connection con) throws SQLException {
		PreparedStatement sql = con.prepareStatement("INSERT INTO Skins" +
				"(id, name, champID, imgURL, " +
				"VALUES (?, ?, ?, ?)");
		
		if(id != 0) sql.setInt(1,  id);
		else sql.setString(1,  null);
		sql.setString(2, name);
		sql.setInt(3, champID);
		sql.setString(4, imgURL );
		
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
		this.champID = results.getInt("champID");
		this.imgURL = results.getString("imgURL");

	}
}

package lolbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class Database {
	private static HashMap<String, Database> databases = new HashMap<String, Database>();
	private String defaultFileName = "";
	
	private Database(String name){
		setFile(name);
	}
	
	public static Database formatDatabase(String name){
		if ( databases.containsKey(name)) return databases.get(name);
		Database newBase = new Database(name);
		databases.put(name, newBase);
		return newBase;
	}
	
	public void setFile(String name){
		defaultFileName = name;
	}
	
	public String getFileName(){
		return defaultFileName + ".db";
	}
	
	public Connection giveRootConnection() throws SQLException {
		String sDriver = "org.sqlite.JDBC";
		try {
			Class.forName(sDriver);
		} catch (ClassNotFoundException e){
			System.out.println("error while loading class");
		}
		return DriverManager.getConnection("jdbc:sqlite:" + getFileName());
	}
}

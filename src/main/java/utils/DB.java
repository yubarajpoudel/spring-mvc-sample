package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	public static Connection  getDbcon() {
		Connection con = null;
		
		try {
			  Class.forName("com.mysql.jdbc.Driver");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kantipur", "root", "root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return con;
	}

}



import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtility {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}
	
	public static int generateID(String mob)
	{   
		int p = Integer.parseInt(mob.substring(1, 5));
		return  (int) Math.round(Math.random()*p);
		
		}
	
}

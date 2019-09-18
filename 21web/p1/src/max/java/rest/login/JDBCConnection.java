package max.java.rest.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCConnection {
	private JDBCConnection()
	{
		
	}
	static Connection con=null;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rahul", "postgres", "postgres");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnn()
	{
		return con;
	}
}

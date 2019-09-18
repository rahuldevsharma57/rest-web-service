import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONArray;
import org.json.JSONObject;


public class JSONWriterClass {
	public  static JSONArray fatchData()
	{ JSONArray ja=new JSONArray();
		try {
			Connection con = JDBCUtility.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from adhar_master");
		    ResultSet rs = ps.executeQuery();
		
		    while(rs.next())
		    {
		    	JSONObject jb=new JSONObject();
		    	  jb.put("adhar", rs.getString("adhar"));
		    	  jb.put("name", rs.getString("name"));
		    	  jb.put("dob", rs.getString("dob"));
		    	  jb.put("status", rs.getString("status"));
		    	  ja.put(jb);
		    	
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ja;
	}

}

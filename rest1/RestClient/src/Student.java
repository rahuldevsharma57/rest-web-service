import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class Student {
	public static void main(String[] args) {
		Client client = Client.create();
		
		JSONObject jb=new JSONObject();
		try {
			jb.put("name", "w");
			jb.put("dob", "11-1-1990");
			jb.put("rollno", "1110");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		WebResource wr = client.resource("http://localhost:8080/RestServer/services/rhr/studentRecords/");
	      ClientResponse res = wr.accept("application/text").post(ClientResponse.class,jb.toString());
	    
	          String rst = res.getEntity(String.class);
	          System.out.println("client add "+rst);
	      
	}
}

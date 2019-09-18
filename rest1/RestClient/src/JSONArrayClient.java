import org.json.JSONArray;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class JSONArrayClient {
	public static void main(String[] args) {
		Client client = Client.create();
		JSONArray ja = JSONWriterClass.fatchData();
		System.out.println(ja);
		
		WebResource wr = client.resource("http://localhost:8080/RestServer/services/rhr/adharRecords/");
	      ClientResponse res = wr.accept("application/text").post(ClientResponse.class,ja.toString());
	    
	          String rst = res.getEntity(String.class);
	          System.out.println("client rest "+rst);
	      
	}
}

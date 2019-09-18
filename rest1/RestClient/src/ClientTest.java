import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class ClientTest {
	public static void main(String[] args) {
		Client client = Client.create();
		WebResource wr = client.resource("http://localhost:8080/RestServer/services/rhr/hello/");
	      ClientResponse res = wr.accept("application/text").post(ClientResponse.class,"max");
	    
	          String rst = res.getEntity(String.class);
	          System.out.println("client rest "+rst);
	      
	}

}

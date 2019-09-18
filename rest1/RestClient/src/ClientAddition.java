import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class ClientAddition {
	public static void main(String[] args) {
		Client client = Client.create();
		int x=3;
		int y=2;
		WebResource wr = client.resource("http://localhost:8080/RestServer/services/rhr/addition?a="+x+"&b="+y+"");
	      ClientResponse res = wr.accept("application/text").post(ClientResponse.class,"max");
	    
	          String rst = res.getEntity(String.class);
	          System.out.println("client add "+rst);
	      
	}

}

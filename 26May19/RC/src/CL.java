import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class CL {
	public  void get1() {
		try {
			while(true)
			{
   		 String n1="9"; String n2="8";
			   Client client = Client.create();
String url="http://localhost:8080/RestServer/services/rh/addition?n1="+n1+"&n2="+n2+"";		   
WebResource wr = client.resource(url);
ClientResponse cr = wr.accept("application/text").post(ClientResponse.class);
 		String rslt = cr.getEntity(String.class);
 		System.out.println("rslt in "+rslt);
 		Thread.sleep(10);
			}
			
			
			
			
 		
 		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public  void get() {
		try {
			while(true)
			{
   		 String n1="1"; String n2="8";
			   Client client = Client.create();
String url="http://localhost:8080/RestServer/services/rh/addition?n1="+n1+"&n2="+n2+"";		   
WebResource wr = client.resource(url);
ClientResponse cr = wr.accept("application/text").post(ClientResponse.class);
 		String rslt = cr.getEntity(String.class);
 		System.out.println("rslt in "+rslt);
 		Thread.sleep(1000);
			}
			
			
			
			
 		
 		
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
	
	}



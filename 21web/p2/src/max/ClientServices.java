package max;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientServices {
	public String getServices(String uid, String mob)
	{
	//http://localhost:8080/p1/abc/usrLogin/otp	
		try {
			
			Client client = Client.create();
			WebResource wr = client.resource("http://localhost:8080/p1/abc/usrLogin/otp?uid="+uid+"&mob="+mob+"");
			    ClientResponse r = wr.accept("application/html").post(ClientResponse.class);
			           String t = r.getEntity(String.class);		
			                 
			    
			    return t;
			    
					} catch (Exception e) {
						e.printStackTrace();
					}
		return null; 
					
				}
	
	
	
	
	
	public String getServices(String uDetail)
	{
	
		try {
			
			Client client = Client.create();
			WebResource wr = client.resource("http://localhost:8080/p1/abc/usrLogin/login");
			    ClientResponse r = wr.accept("application/json").post(ClientResponse.class,uDetail);
			           String t = r.getEntity(String.class);		
			                 
			        return t;
			    
					} catch (Exception e) {
						e.printStackTrace();
					}
		return null; 
					
				}
	
	/*public static void main(String[] args) {
		ClientServices b=new	ClientServices();
		String r = b.getServices("raja11", "7404456456");
		System.out.println("c "+r);
	}*/

	}



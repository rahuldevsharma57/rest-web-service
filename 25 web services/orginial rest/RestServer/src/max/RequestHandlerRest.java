package max;

import java.awt.PageAttributes.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONException;
import org.json.JSONObject;
//http://localhost:8080/25RestServer/ses/rhr/otp
@Path("rhr")
public class RequestHandlerRest {
	 JSONObject jsonResponse = new JSONObject();
 /* @POST
   @Path("/otp")
  //http://localhost:8070/RestServer/ses/rhr/p
 
public String getOTP(String mobile)
{
	   RHBO rhbo=new RHBO();
	   
	  return rhbo.getOTPDetails(mobile);
}
*/  @GET
   @Path("p")
 // @Produces(MediaType.TEXT_PLAIN)
   public String got() throws JSONException
   {
	  String s="hello";
	 jsonResponse.put("s1", s);
	 return jsonResponse.toString();
   }
}

package max;

import javax.websocket.server.PathParam;
import javax.ws.rs.DefaultValue;
//import java.awt.PageAttributes.MediaType;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.json.JSONException;
import org.json.JSONObject;
//http://localhost:8080/25RestServer/ses/rhr/otp
@Path("rhr")
public class RequestHandlerRest {
	 
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
 //@Produces(MediaType.
   public String got(@DefaultValue("Amit")@QueryParam("d")String d, @QueryParam("f")String f) throws JSONException
   {
	JSONObject jsonResponse = new JSONObject();
	  String s="hello"+d+f;
	 jsonResponse.put("s1", s);
	 return jsonResponse.toString();
   }

@POST
@Path("post")
public String recieve(@QueryParam("d")String d, @QueryParam("f")String f) throws JSONException
{
	JSONObject jsonResponse = new JSONObject();
	  String s="rahul sharma"+d+f;
	 jsonResponse.put("s1", s);
	 return jsonResponse.toString();
	
}
}

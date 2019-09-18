package max;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
//http://localhost:8080/25RestServer/ses/rhr/otp
@Path("/rhr")
public class RequestHandlerRest {
   @POST
   @Path("/otp")
public String getOTP(String mobile)
{
	   RHBO rhbo=new RHBO();
	   
	  return rhbo.getOTPDetails(mobile);
}
}

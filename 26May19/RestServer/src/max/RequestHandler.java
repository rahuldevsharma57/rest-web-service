package max;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
     //http://localhost:8080/RestServer/services/rh/addition?n1=var&n2=var
@Path("/rh")
public class RequestHandler {
	@POST
	@Path("/addition")
	public String add(@QueryParam("userid") String userid,@QueryParam("pass") String pass,@Context HttpServletRequest req)
	{
		/*System.out.println("ip "+req.getLocalAddr());
		System.out.println("iiiii");
		int i=Integer.parseInt(n1);
		int j=Integer.parseInt(n2);*/
		
		System.out.println(userid + " "+pass);
		
		UserList ob = new UserList();
		if(ob.checkUserDetail(userid, pass))
		{
			
			
			return "Successs ";
		}
		else
		{
			return " IN Valid User";
		}
		
	}
	{
		
	}

}
